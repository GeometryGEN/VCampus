package DAO.QICQ;

import DAO.Library.Info;
import ServerToClient.ManageServerToClientThread;
import ServerToClient.ServerToClient;
import connection.JDBC_Connector;
import message.Message;
import message.MessageType;
import utils.myTime;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class QICQ_manager {
    String id;
    private Connection conn;

    public QICQ_manager(String id) {
        this.id = id;
        try {
            Connection conn= JDBC_Connector.ConnectMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HashMap<String,HashSet<Friend>> get_friends() throws SQLException {
        HashMap<String, HashSet<Friend>> friends = new HashMap<>();
        String sql="select * from friends where user_id='?';";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs= st.executeQuery();
        while(rs.next()){
            Friend friend=new Friend();
            String group=rs.getString("relation");
            friend.name=rs.getString("nickname");
            friend.id=rs.getString("friend_id");
            if(friends.containsKey(group)){
                friends.get(group).add(friend);
            }
            else {
                HashSet<Friend> f = new HashSet<>();
                f.add(friend);
                friends.put(group,f);
            }
        }
        return friends;
    }
    public void send_online_file(Message msg) throws IOException {
        String to=msg.getGetter();
        ObjectOutputStream oos=new ObjectOutputStream(ManageServerToClientThread.getThread(to).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
    public void send_offline_file(Message msg) throws IOException {
        String to=msg.getGetter();
        ServerToClient.addQQfile(to,(Filetrans)msg.getData());
    }
    public void send_online_message(Message msg) throws IOException{
        String to=msg.getGetter();
        ObjectOutputStream oos=new ObjectOutputStream(ManageServerToClientThread.getThread(to).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
    public void send_offline_message(Message msg) throws IOException{
        String to=msg.getGetter();
        ServerToClient.addQQbox(to,msg);
    }
    public void add_friend(Friend friend) throws IOException, SQLException {
        Message msg=new Message();
        msg.setGetter(friend.id);
        msg.setSendTime(myTime.getCurrentTime());
        msg.setType(MessageType.MESSAGE_QICQ_ADD_FRIEND);
        String sql="select * from students where id='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();

        if(rs.next()){
            Application app=new Application(id,rs.getString("student_name"));
            msg.setData(app);
        }
        else {
            sql="select * from teachers where id='?';";
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            rs=st.executeQuery();
            if(rs.next()){
                Application app=new Application(id,rs.getString("teacher_name"));
                msg.setData(app);
            }
        }
        if(ServerToClient.isOnline(friend.id)){
            send_online_message(msg);
        }
        else {
            send_offline_message(msg);
        }
    }
    public ArrayList<Application> list_my_application(){
        ArrayList<Application>app=ServerToClient.getQQapplication(id);
        return app;
    }
    public void admin_announcement(Message m) {
        ServerToClient.addBulletin(m);
    }
    public void list_announcement(){

    }
    public void accept_new_friend(Friend friend){

    }
    public void deny_new_friend(Friend friend){

    }
    public void list_my_mailbox(){

    }

}
