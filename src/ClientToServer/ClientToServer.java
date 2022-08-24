package ClientToServer;
import User.*;
import message.Message;
import message.MessageType;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.14 20:01]
 */

public class ClientToServer {

    private Student s = new Student();
    private Teacher t = new Teacher();
    private Admin a = new Admin();
    private Socket socket;

    public boolean checkStudent(String id, String pwd) throws Exception {
        s.setStudent_idcard(id);
        s.setStudent_pwd(pwd);
        socket = new Socket("192.168.43.103",9988);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());     //得到Object对象
        Message send=new Message();
        send.setType(MessageType.MESSAGE_STUDENT_LOGIN);
        send.setData(s);
        oos.writeObject(send);                                                         //发送学生对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if(ms.getType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
            ClientToServerThread ctst = new ClientToServerThread(id,socket);        //创建一个和服务器端保持通信的线程
            ctst.start();                                                        //启动线程
            ManageClientToServerThread.addThread(id,ctst);
            return true;
        }
        else{
            socket.close();
            return false;
        }
    }

    public boolean checkTeacher(String id, String pwd) throws Exception {
        t.setTeacher_idcard(id);
        t.setTeacher_pwd(pwd);
        socket = new Socket(InetAddress.getByName("192.168.43.103"),9988);
        //得到Object对象
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        //发送老师对象
        Message send=new Message();
        send.setType(MessageType.MESSAGE_TEACHER_LOGIN);
        send.setData(t);
        oos.writeObject(send);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();
        if(ms.getType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
            //创建一个和服务器端保持通信的线程
            ClientToServerThread ctst = new ClientToServerThread(id,socket);
            //启动线程
            ctst.start();
            ManageClientToServerThread.addThread(id,ctst);
            return true;
        }
        else{
            socket.close();
            return false;
        }
    }

    public boolean checkAdmin(String id, String pwd) throws Exception {
        a.setAdmin_idcard(id);
        a.setAdmin_pwd(pwd);
        socket = new Socket(InetAddress.getByName("192.168.43.103"),9988);
        //得到Object对象
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        //发送管理员对象
        Message send=new Message();
        send.setType(MessageType.MESSAGE_ADMIN_LOGIN);
        send.setData(a);
        oos.writeObject(send);
        //读取从服务端回复的Message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();
        if(ms.getType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
            //创建一个和服务器端保持通信的线程
            ClientToServerThread ctst = new ClientToServerThread(id,socket);
            //启动线程
            ctst.start();
            ManageClientToServerThread.addThread(id,ctst);
            return true;
        }
        else{
            socket.close();
            return false;
        }
    }

}
