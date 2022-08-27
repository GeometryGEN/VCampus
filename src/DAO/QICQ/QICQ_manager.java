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
    public HashMap<String,HashSet<Friend>> get_friends() throws SQLException {
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
    public void add_friend(Message message) throws IOException, SQLException {
        Message msg=new Message();
        Application app=(Application)message.getData();
        String sql="select * from students,teachers where Student_idcard=? or Teacher_idcard=?";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,app.to_id);
        st.setString(2,app.to_id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            msg.setGetter(app.to_id);
            msg.setSendTime(myTime.getCurrentTime());
            msg.setType(MessageType.MESSAGE_QICQ_ADD_FRIEND);
            if(ServerToClient.isOnline(app.to_id)!=-1){
                send_online_message(msg);
            }
            else {
                send_offline_message(msg);
            }
        }
        else{
            msg.setType(MessageType.MESSAGE_QICQ_ADD_FRIEND_FAIL_CANNOT_FIND_USER);
            ObjectOutputStream oos=new ObjectOutputStream(ManageServerToClientThread.getThread(id).getSocket().getOutputStream());
            oos.writeObject(msg);
        }

    }
    public ArrayList<Application> list_my_application(){
        ArrayList<Application>app=ServerToClient.getQQapplication(id);
        return app;
    }
    public void admin_add_announcement(Message m) {
        ServerToClient.addBulletin(m);
    }
    public void list_announcement() throws IOException {
        Message message=new Message();
        message.setData(ServerToClient.getBulletin());
        message.setType(MessageType.MESSAGE_QICQ_GET_ANNOUNCEMENT_RET);
        Socket socket=ManageServerToClientThread.getThread(id).getSocket();
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
    }
    public void accept_new_friend(Application application) throws SQLException {
        ArrayList<Application>applications=ServerToClient.getQQapplication(application.from_id);
        for(Application i :applications){
            if(i.to_id.equals(application.to_id)&&i.to_name.equals(application.to_name)){
                i.status=2;
                String sql="insert into friends(user_id,friend_id,relation,nickname) values(?,?,?,?);";
                PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1,i.from_id);
                st.setString(2,i.to_id);
                st.setString(3,i.group);
                st.setString(4,i.to_name);
                st.executeUpdate();
                break;
            }
        }
    }
    public void deny_new_friend(Application application){
        ArrayList<Application>applications=ServerToClient.getQQapplication(application.from_id);
        for(Application i :applications){
            if(i.to_id.equals(application.to_id)&&i.to_name.equals(application.to_name)){
                i.status=1;
                break;
            }
        }
    }
    public void list_my_mailbox() throws IOException {
        ArrayList<Message>messages=ServerToClient.getQQbox(id);
        Message sendback=new Message();
        sendback.setData(messages);
        sendback.setType(MessageType.MESSAGE_QICQ_OFFLINE_MESSAGE_RET);
        Socket socket=ManageServerToClientThread.getThread(id).getSocket();
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(sendback);
    }

}
