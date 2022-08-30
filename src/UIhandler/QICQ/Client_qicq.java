package UIhandler.QICQ;

import ClientToServer.ManageClientToServerThread;
import DAO.QICQ.Application;
import DAO.QICQ.Filetrans;
import DAO.QICQ.Friend;
import UIviewer.QQ.friend_list;
import UIviewer.QQ.friend_slice;
import message.Message;
import message.MessageType;
import utils.MyObjectInputStream;
import utils.MyObjectOutputStream;
import utils.myTime;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Client_qicq {
    static String id;
    static MyObjectOutputStream oos=null;
    public static void setSocket(Socket socket) throws IOException {
        oos=new MyObjectOutputStream(socket.getOutputStream());
    }

    public static void setId(String id) {
        Client_qicq.id = id;
    }

    public void send_file(String src, String sender, String getter, String filename){
        Message message=new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setSendTime(myTime.getCurrentTime());
        message.setType(MessageType.MESSAGE_QICQ_SEND_FILE);
        FileInputStream fileInputStream=null;
        byte[] filebytes=new byte[(int)new File(src).length()];
        try {
            fileInputStream =new FileInputStream(src);
            fileInputStream.read(filebytes);
            Filetrans file=new Filetrans();
            file.setContent(filebytes);
            file.setName(filename);
            message.setData(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(ManageClientToServerThread.getThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void get_file(Message message,String dest) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        Filetrans file=(Filetrans)message.getData();
        fileOutputStream.write(file.getContent());
    }
    public void send_message(String content,String sender,String getter){
        Message message=new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setSendTime(myTime.getCurrentTime());
        message.setType(MessageType.MESSAGE_QICQ_SEND_MSG);
        message.setData(content);
        try {
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void get_message(String id) throws IOException {
        Message message=new Message();
        message.setData(id);
        message.setType(MessageType.MESSAGE_QICQ_GET_MESSAGE);
        oos.writeObject(message);
    }
    public static void show_message(ArrayList<Message> messages){

    }
    public void add_friend(String myid,String myname,String number,String nickname) throws IOException {
        Application app=new Application(myid,myname);
        Message message=new Message();
        message.setData(app);
        app.setTo_id(number);
        app.setTo_name(nickname);
        message.setType(MessageType.MESSAGE_QICQ_ADD_FRIEND_START);
        oos.writeObject(message);
    }
    public static void Require_friend_list() throws IOException {
        System.out.println(2);
        Message message=new Message();
        message.setType(MessageType.MESSAGE_QICQ_LIST_FRIENDS);
        oos.writeObject(message);
    }
    public static void show_friend(HashMap<String, ArrayList<Friend>>friend){
        System.out.println(1);
        for(String tag: friend.keySet()){
            friend_list.add(tag,friend.get(tag));
        }
    }

}
