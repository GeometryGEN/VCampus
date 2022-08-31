package ClientToServer;
import DAO.Login.Admin_utils;
import DAO.Login.Teachers_utils;
import UIhandler.Currirulum.Client_curriculum;
import UIhandler.Library.Client_library;
import UIhandler.QICQ.Client_qicq;
import UIhandler.Shop.Client_shop;
import User.*;
import message.Message;
import message.MessageType;
import utils.MyObjectInputStream;
import utils.MyObjectOutputStream;

import java.io.IOException;
import java.net.Socket;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.14 20:01]
 */

public class ClientToServer {

    private String ID;  //1-学生 2-老师 3-管理员
    private Student s = new Student();
    private Teacher t = new Teacher();
    private Admin a = new Admin();
    private static Socket socket;
    public static MyObjectOutputStream oos=null;
    public MyObjectInputStream ois=null;
    public String serverIP = Message.returnIP();
    //public String serverIP = "10.19.123.88";

    public String getIDcard() {
        return switch (ID) {
            case "1" -> s.getStudent_idcard();
            case "2" -> t.getTeacher_idcard();
            case "3" -> a.getAdmin_idcard();
            default -> null;
        };
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public Teacher getT() {
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean checkStudent(String id, String pwd) throws Exception {
        s.setStudent_idcard(id);
        s.setStudent_pwd(pwd);
        socket = new Socket(serverIP, MessageType.PORT);
        oos = new MyObjectOutputStream(socket.getOutputStream());     //得到Object对象
        Message send = new Message();
        send.setType(MessageType.MESSAGE_STUDENT_LOGIN);
        send.setData(s);
        oos.writeObject(send);                                                         //发送学生对象
        ois = new MyObjectInputStream(socket.getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
            ID = "1";
            Student a = (Student) ms.getData();
            myInfo.setall(a.getStudent_idcard(), 1, a.getStudent_name());
            myInfo.setMoney(a.getStudent_money());
            ClientToServerThread ctst = new ClientToServerThread(ois,socket);        //创建一个和服务器端保持通信的线程
            ctst.start();                                                        //启动线程
            ManageClientToServerThread.addThread(id, ctst);
           // System.out.println(ManageClientToServerThread.getThread(id));
            Client_curriculum.setOos(oos);
            Client_library.setOos(oos);
            Client_qicq.setOps(oos);
            Client_shop.setOos(oos);
            return true;
        } else {
            socket.close();
            return false;
        }
    }

    public boolean checkTeacher(String id, String pwd) throws Exception {
        t.setTeacher_idcard(id);
        t.setTeacher_pwd(pwd);
//        t.setTeacher_name(Teachers_utils.returnTeacherName(id,pwd));
        socket = new Socket(serverIP, MessageType.PORT);
        //得到Object对象
        oos = new MyObjectOutputStream(socket.getOutputStream());
        //发送老师对象
        Message send = new Message();
        send.setType(MessageType.MESSAGE_TEACHER_LOGIN);
        send.setData(t);
        oos.writeObject(send);
        ois = new MyObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
            ID = "2";
            Teacher a = (Teacher) ms.getData();
            myInfo.setall(a.getTeacher_idcard(), 2, a.getTeacher_name());
            myInfo.setMoney(a.getTeacher_money());
            //创建一个和服务器端保持通信的线程
            ClientToServerThread ctst = new ClientToServerThread(ois,socket);
            //启动线程
            ctst.start();
            Client_curriculum.setOos(oos);
            Client_library.setOos(oos);
            Client_qicq.setOps(oos);
            Client_shop.setOos(oos);
            ManageClientToServerThread.addThread(id, ctst);
            return true;
        } else {
            socket.close();
            return false;
        }
    }

    public boolean checkAdmin(String id, String pwd) throws Exception {
        a.setAdmin_idcard(id);
        a.setAdmin_pwd(pwd);
        //     a.setAdmin_name(Admin_utils.returnAdminName(id,pwd));
        socket = new Socket(serverIP, MessageType.PORT);
        //得到Object对象
        oos = new MyObjectOutputStream(socket.getOutputStream());
        //发送管理员对象
        Message send = new Message();
        send.setType(MessageType.MESSAGE_ADMIN_LOGIN);
        send.setData(a);
        oos.writeObject(send);
        //读取从服务端回复的Message对象
        ois = new MyObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
            ID = "3";
            Admin a=(Admin)ms.getData();
            myInfo.setall(a.getAdmin_idcard(), 3, a.getAdmin_name());
            //创建一个和服务器端保持通信的线程
            ClientToServerThread ctst = new ClientToServerThread(ois,socket);
            //启动线程
            ctst.start();
            Client_curriculum.setOos(oos);
            Client_library.setOos(oos);
            Client_qicq.setOps(oos);
            Client_shop.setOos(oos);
            ManageClientToServerThread.addThread(id, ctst);
            return true;
        } else {
            socket.close();
            return false;
        }
    }

    public boolean registerStudent(Student st) throws Exception {
        socket = new Socket(serverIP, MessageType.PORT);
        oos = new MyObjectOutputStream(socket.getOutputStream());     //得到Object对象
        Message send = new Message();
        send.setType(MessageType.MESSAGE_STUDENT_REGISTER);
        send.setData(st);
        oos.writeObject(send);                                                         //发送学生对象
        ois = new MyObjectInputStream(socket.getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.MESSAGE_STUDENT_REGISTER_SUCCEED))
            return true;
        else {
            socket.close();
            return false;
        }
    }

    public boolean registerTeacher(Teacher te) throws Exception {
        socket = new Socket(serverIP, MessageType.PORT);
        oos = new MyObjectOutputStream(socket.getOutputStream());     //得到Object对象
        Message send = new Message();
        send.setType(MessageType.MESSAGE_TEACHER_REGISTER);
        send.setData(te);
        oos.writeObject(send);                                                         //发送学生对象
        ois = new MyObjectInputStream(socket.getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.MESSAGE_TEACHER_REGISTER_SUCCEED))
            return true;
        else {
            socket.close();
            return false;
        }
    }

    public boolean forgetpwd(String card, String email, String select) throws Exception {
        socket = new Socket(serverIP, MessageType.PORT);
        oos = new MyObjectOutputStream(socket.getOutputStream());     //得到Object对象
        Message send = new Message();
        send.setType(MessageType.TO_FIND_CERTAIN);
        if (select.equals("教师")) {
            Teacher te = new Teacher();
            te.setTeacher_email(email);
            te.setTeacher_idcard(card);
            send.setData(te);
            send.setSender("教师");
        } else {
            Student st = new Student();
            st.setStudent_email(email);
            st.setStudent_idcard(card);
            send.setData(st);
            send.setSender("学生");
        }
        oos.writeObject(send);                                                         //发送学生对象
        ois = new MyObjectInputStream(socket.getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.HAVE_FIND_CERTAIN))
            return true;
        else {
            socket.close();
            return false;
        }
    }

    public boolean resetPwd(String card, String new_pwd, String select) throws Exception {
        socket = new Socket(serverIP, MessageType.PORT);
        oos = new MyObjectOutputStream(socket.getOutputStream());     //得到Object对象
        Message send = new Message();
        send.setType(MessageType.RESET_PASSWORD);
        if (select.equals("教师")) {
            Teacher te = new Teacher();
            te.setTeacher_idcard(card);
            te.setTeacher_pwd(new_pwd);
            send.setData(te);
            send.setSender("教师");
        } else {
            Student st = new Student();
            st.setStudent_idcard(card);
            st.setStudent_pwd(new_pwd);
            send.setData(st);
            send.setSender("学生");
        }
        oos.writeObject(send);                                                         //发送学生对象
        ois = new MyObjectInputStream(socket.getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if (ms.getType().equals(MessageType.RESET_PASSWORD_SUCCEED))
            return true;
        else {
            socket.close();
            return false;
        }
    }

    public static void logout() throws IOException {
        Message message = new Message();
        message.setType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(myInfo.getId());
             //得到Object对象
        oos.writeObject(message);
        ManageClientToServerThread.getThread(myInfo.getId()).exit = true;
        ManageClientToServerThread.getThread(myInfo.getId()).interrupt();
        ManageClientToServerThread.removeClientToServerThread(myInfo.getId());
        if(myInfo.getType()==1)
            System.out.println("学生：" + myInfo.getName() + " " + myInfo.getId() + "退出系统");
        if(myInfo.getType()==2)
            System.out.println("老师：" + myInfo.getName() + " " + myInfo.getId() + "退出系统");
        if(myInfo.getType()==3)
            System.out.println("管理员：" + myInfo.getName() + " " + myInfo.getId() + "退出系统");
    }
}
