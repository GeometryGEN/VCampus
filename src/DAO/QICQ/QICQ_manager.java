package DAO.QICQ;

import ServerToClient.ManageServerToClientThread;
import ServerToClient.Online;
import message.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class QICQ_manager {
    String id;

    public QICQ_manager(String id) {
        this.id = id;
    }
    public HashSet<Friend>get_online_friends(){
        HashSet<Friend>friends=new HashSet<>();
        return friends;
    }
    public HashSet<Friend>get_offline_friend(){
        HashSet<Friend>friends=new HashSet<>();
        return friends;
    }
    public void send_online_file(Message msg) throws IOException {
        String to=msg.getGetter();
        ObjectOutputStream oos=new ObjectOutputStream(ManageServerToClientThread.getThread(to).getSocket().getOutputStream());
        oos.writeObject(msg);
    }
}
