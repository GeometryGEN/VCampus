package UIhandler.StatusManagement;

import ClientToServer.ManageClientToServerThread;
import User.Admin;
import User.Student;
import message.Message;
import message.MessageType;
import utils.MyObjectInputStream;
import utils.MyObjectOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Client_status {

    public static volatile Student s = null;   //当前已登录账号的那个学生对象
    public static volatile Student s_s = null; //管理员查找的那个学生
    public static volatile Admin a;
    public static String id;
    public static String getId() {
        return id;
    }
    public static void setId(String id) {
        Client_status.id = id;
    }

    public Student getS() {
        return s;
    }

    public static void setS(Student s) {
        Client_status.s = s;
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        Client_status.a = a;
    }

    public static void getphoto(String idcard) throws Exception {
        Message message = new Message();
        message.setType(MessageType.RETURN_PHOTO);
        message.setSender(idcard);
        MyObjectOutputStream oos= new MyObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(message);

    }

    public static Student returnStatusInfo(String idcard) throws Exception {
        Message message = new Message();
        message.setType(MessageType.RETURN_STUDENT_INFO);
        message.setSender(idcard);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (s == null) Thread.onSpinWait();
        return s;
    }

    //记得查找另一个学生时让对象为null
    public static Student returnStatus_Admin(String idcard) throws Exception {
        Message message = new Message();
        message.setType(MessageType.RETURN_STUDENT_INFO);
        message.setSender(idcard);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (s_s == null) Thread.onSpinWait();
        return s_s;
    }

}
