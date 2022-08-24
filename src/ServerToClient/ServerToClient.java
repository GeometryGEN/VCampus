package ServerToClient;
import DAO.Curriculum.Opencourse;
import DAO.Library.Punishment;
import DAO.Login.Admin_utils;
import DAO.Login.Students_utils;
import DAO.Login.Teachers_utils;
import User.Admin;
import User.Student;
import User.Teacher;
import message.Message;
import message.MessageType;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [服务器，监听8080，等待客户端连接，保持通信]
 * @createTime : [2022.08.14 19:36]
 */
public class ServerToClient extends Thread{
    private ServerSocket ss = null;
    private static HashSet<Punishment> punish=new HashSet<Punishment>();
    private static HashSet<Online>online=new HashSet<Online>();
    private static HashSet<Opencourse>opencourses=new HashSet<Opencourse>();

    public static HashSet<Opencourse> getOpencourses() {
        return opencourses;
    }

    public static void add_opencourse(Opencourse open) {
        ServerToClient.opencourses.add(open);
    }

    public static HashSet<Punishment> getPunish() {
        return punish;
    }
    public static String getOnline_admin () {
        Iterator value = online.iterator();
        while(value.hasNext()){
            Online ol=(Online)value.next();
            if(ol.getType()==2) return ol.getId();
        }
        return null;
    }
    public static void addOnline(String id,int ty){
        online.add(new Online(id,ty));
    }
    public static void addPunish(Punishment p) {
        ServerToClient.punish.add(p);
    }
    public void send_ticket(String admin) throws IOException {
        Socket socket=ManageServerToClientThread.getThread(admin).getSocket();
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        Iterator value = punish.iterator();
        while(value.hasNext()){
            Punishment p=(Punishment)value.next();
            Message m=new Message();
            m.setType(MessageType.MESSAGE_LIBRARY_ADMIN_RECEIVE);
            m.setData(p);
            oos.writeObject(m);
            punish.remove(p);
        }
    }
    public ServerToClient() throws IOException {
        try{
            System.out.println("服务器在9988端口监听中...");
            ss=new ServerSocket(9988);
            while (true){
               // if(punish.size()!=0&&getOnline_admin()!=null) send_ticket(getOnline_admin());
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //读取客户端发送的老师/同学/管理员对象
                Message s = (Message) ois.readObject();
                //创建Message对象，准备回复客户端
                Message m=new Message();
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                if(s.getType().equals(MessageType.MESSAGE_STUDENT_LOGIN))
                {
                    Student stu = (Student) s.getData();
                    if(Students_utils.checkStudentAccount(stu.getStudent_idcard(),stu.getStudent_pwd())){
                        m.setType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        //创建一个线程，和客户端通信，该线程持有socket对象
                        ServerToClientThread stct = new ServerToClientThread(socket,stu.getStudent_idcard());
                        stct.start();
                        //放入线程集合中
                        ManageServerToClientThread.addThread(stu.getStudent_idcard(),stct);
                        addOnline(stu.getStudent_id(),0);
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_LOGIN_FAIL);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
                else if(s.getType().equals(MessageType.MESSAGE_TEACHER_LOGIN))
                {
                    Teacher t = (Teacher) s.getData();
                    if(Teachers_utils.checkTeacherAccount(t.getTeacher_idcard(), t.getTeacher_pwd())){
                        m.setType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        //创建一个线程，和客户端通信，该线程持有socket对象
                        ServerToClientThread stct = new ServerToClientThread(socket,t.getTeacher_idcard());
                        addOnline(t.getTeacher_id(),1);
                        stct.start();
                        //放入线程集合中
                        ManageServerToClientThread.addThread(t.getTeacher_idcard(),stct);
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_LOGIN_FAIL);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
                else if(s.getType().equals(MessageType.MESSAGE_ADMIN_LOGIN))
                {
                    Admin a = (Admin) s.getData();
                    if(Admin_utils.checkAdminAccount(a.getAdmin_idcard(), a.getAdmin_pwd())){
                        m.setType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        //创建一个线程，和客户端通信，该线程持有socket对象
                        ServerToClientThread stct = new ServerToClientThread(socket,a.getAdmin_idcard());
                        stct.start();
                        //放入线程集合中
                        ManageServerToClientThread.addThread(a.getAdmin_idcard(),stct);
                        addOnline(a.getAdmin_id(),2);
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_LOGIN_FAIL);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //服务器退出while，服务器不再监听
            ss.close();
        }
    }
    public static void main(String[] args) throws IOException {
        new ServerToClient();
    }
}
