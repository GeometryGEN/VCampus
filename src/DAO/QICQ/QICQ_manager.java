package DAO.QICQ;

import DAO.Library.Info;
import ServerToClient.ManageServerToClientThread;
import ServerToClient.ServerToClient;
import connection.JDBC_Connector;
import message.Message;
import message.MessageType;
import utils.MyObjectOutputStream;
import utils.myTime;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class QICQ_manager {
    String id;
    private static Connection conn;

    public QICQ_manager(String id) {
        this.id = id;
        try {
            conn= JDBC_Connector.ConnectMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void get_friends() throws SQLException, IOException {
        HashMap<String, HashSet<Friend>> friends = new HashMap<>();
        String sql="select * from friends where user_id=?;";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs= st.executeQuery();
        while(rs.next()){
            Friend friend=new Friend();
            String group=rs.getString("relation");
            friend.name=rs.getString("nickname");
            friend.id=rs.getString("friend_id");
            sql="select * from message where sender=? and getter=? and isread=0;";
            st= conn.prepareStatement(sql);
            st.setString(1, friend.id);
            st.setString(2,id);
            rs= st.executeQuery();
            if(rs.next()) friend.unread=1;
            if(friends.containsKey(group)){
                friends.get(group).add(friend);
            }
            else {
                HashSet<Friend> f = new HashSet<>();
                f.add(friend);
                friends.put(group,f);
            }
        }
        Message msg=new Message();
        msg.setType(MessageType.MESSAGE_QICQ_LIST_FRIENDS_RET);
        msg.setData(friends);
        MyObjectOutputStream oos=new MyObjectOutputStream(ManageServerToClientThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
    public void send_online_file(Message msg) throws IOException {
        String to=msg.getGetter();
        msg.setType(MessageType.MESSAGE_QICQ_RECERIVE_FILE);
        MyObjectOutputStream oos=new MyObjectOutputStream(ManageServerToClientThread.getThread(to).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
    public void send_offline_file(Message msg) throws IOException, SQLException {
        String to=msg.getGetter();
        ServerToClient.addQQfile(to,(Filetrans)msg.getData());
    }
    public void send_online_message(Message msg) throws IOException, SQLException {
        String to=msg.getGetter();
        msg.setType(MessageType.MESSAGE_QICQ_RECERIVE_MESSAGE);
        ObjectOutputStream oos=new ObjectOutputStream(ManageServerToClientThread.getThread(to).getSocket().getOutputStream());
        String sql="insert into message(sender,getter,sendtime,content,isread) values(?,?,?,?,0);";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,msg.getSender());
        st.setString(2,msg.getGetter());
        st.setString(3,msg.getSendTime());
        st.setString(4,(String)msg.getData());
        st.executeUpdate();
        oos.writeObject(msg);
    }
    public void send_offline_message(Message msg) throws IOException, SQLException {
        String to=msg.getGetter();
        String sql="insert into message(sender,getter,sendtime,content,isread) values(?,?,?,?,0);";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,msg.getSender());
        st.setString(2,msg.getGetter());
        st.setString(3,msg.getSendTime());
        st.setString(4,(String)msg.getData());
        st.executeUpdate();
        ServerToClient.addQQbox(to,msg);
    }
    public void add_friend(Message message) throws IOException, SQLException {
        Application app=(Application)message.getData();
        String sql="select * from teachers where Student_idcard=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,app.to_id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            String sql1="insert into new_friend(sender,getter,sendtime,status) values(?,?,?,0);";
            PreparedStatement st1=conn.prepareStatement(sql1);
            st1.setString(1,app.from_id);
            st1.setString(2,app.to_id);
            st1.setString(3,message.getSendTime());
            st1.executeUpdate();
        }
        else{
            sql="select * from teachers where Teacher_idcard=?;";
            st=conn.prepareStatement(sql);
            st.setString(1,app.to_id);
            rs=st.executeQuery();
            if(rs.next()){
                String sql1="insert into new_friend(sender,getter,sendtime,status) values(?,?,?,0);";
                PreparedStatement st1=conn.prepareStatement(sql1);
                st1.setString(1,app.from_id);
                st1.setString(2,app.to_id);
                st1.setString(3,message.getSendTime());
                st1.executeUpdate();
            }
            else {
                Message msg=new Message();
                msg.setType(MessageType.MESSAGE_QICQ_ADD_FRIEND_FAIL_CANNOT_FIND_USER);
                MyObjectOutputStream oos=new MyObjectOutputStream(ManageServerToClientThread.getThread(id).getSocket().getOutputStream());
                oos.writeObject(msg);
            }

        }

    }
    public void list_my_application() throws SQLException, IOException {
        ArrayList<Application>app=new ArrayList<>();
        String sql="select * from new_friend order by sendtime where sender=?";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            Application a=new Application();
            a.status=rs.getInt("status");
            a.to_id=rs.getString("getter");
            app.add(a);
        }
        Message msg=new Message();
        msg.setData(app);
        msg.setType(MessageType.MESSAGE_QICQ_LIST_APPLICATION_RET);
        MyObjectOutputStream oos=new MyObjectOutputStream(ManageServerToClientThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
    public void list_my_application_handled() throws SQLException, IOException {
        ArrayList<Application>app=new ArrayList<>();
        String sql="select * from new_friend order by sendtime where getter=?";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            Application a=new Application();
            a.status=rs.getInt("status");
            a.from_id=rs.getString("sender");
            app.add(a);
        }
        Message msg=new Message();
        msg.setData(app);
        msg.setType(MessageType.MESSAGE_QICQ_LIST_APPLICATION_HANDLE_RET);
        MyObjectOutputStream oos=new MyObjectOutputStream(ManageServerToClientThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
    public void admin_add_announcement(Message m) throws SQLException {
        String sql="insert into message(sender,getter,sendtime,content) values(?,'all',?,?);";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,m.getSender());
        st.setString(2,m.getSendTime());
        st.setString(3,(String)m.getData());
        st.executeUpdate();
    }
    public void list_announcement() throws IOException, SQLException {
        Message message=new Message();
        String sql="select * from message where getter='all';";
        PreparedStatement st=conn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        ArrayList<Message>bulletin=new ArrayList<>();
        while(rs.next())
        {
            Message m=new Message();
            m.setData(rs.getString("content"));
            m.setSendTime(myTime.datetimeToString(rs.getTimestamp("sendtime")));
            bulletin.add(m);
        }
        message.setType(MessageType.MESSAGE_QICQ_GET_ANNOUNCEMENT_RET);
        message.setData(bulletin);
        Socket socket=ManageServerToClientThread.getThread(id).getSocket();
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
    }
    public void accept_new_friend(Application application) throws SQLException {
        String sql="update new_friend set status=2 where sender=? and getter=? and status=0;";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,application.from_id);
        st.setString(2,application.to_id);
        st.executeUpdate();
        sql="insert into friends(user_id,friend_id,relation,nickname) values(?,?,?,?);";
        st.setString(1,application.from_id);
        st.setString(2,application.to_id);
        st.setString(3,application.group);
        st.setString(4,application.to_name);
        st.executeUpdate();
    }
    public void deny_new_friend(Application application) throws SQLException {
        String sql="update new_friend set status=1 where sender=? and getter=? and status=0;";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,application.from_id);
        st.setString(2,application.to_id);
        st.executeUpdate();
    }
    public void list_my_message_with(String to_id) throws IOException, SQLException {
        String sql="select * from message order by sendtime where (sender=? and getter=?) or (sender=? and getter=?);";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,id);
        st.setString(2,to_id);
        st.setString(4,id);
        st.setString(3,to_id);
        ResultSet rs=st.executeQuery();
        ArrayList<Message>messages=new ArrayList<>();
        while(rs.next()){
            Message x=new Message();
            x.setData(rs.getString("content"));
            x.setSender(rs.getString("sender"));
            x.setGetter(rs.getString("getter"));
            x.setSendTime(myTime.datetimeToString(rs.getTimestamp("sendtime")));
            messages.add(x);
        }
        Message sendback=new Message();
        sendback.setType(MessageType.MESSAGE_QICQ_GET_MESSAGE_RET);
        sendback.setData(messages);
        Socket socket=ManageServerToClientThread.getThread(id).getSocket();
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(sendback);
        sql="update message set isread=1 where (sender=? and getter=?);";
        st= conn.prepareStatement(sql);
        st.setString(1,to_id);
        st.setString(2,id);
        st.executeUpdate();
    }

}
