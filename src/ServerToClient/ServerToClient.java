package ServerToClient;
import DAO.Login.Admin_utils;
import DAO.Login.Students_utils;
import DAO.Login.Teachers_utils;
import DAO.StatusManagement.User_SM_utils;
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

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [服务器，监听Port，等待客户端连接，保持通信]
 * @createTime : [2022.08.14 19:36]
 */
public class ServerToClient extends Thread{
    private ServerSocket ss = null;
    private Student s1;
    private Teacher t1;

    public ServerToClient() throws IOException {
        try{
            System.out.println("服务器在"+MessageType.PORT+"端口监听中，"+"IP地址为"+Message.returnIP());
            ss=new ServerSocket(MessageType.PORT);
            while (true){
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //读取客户端发送的老师/同学/管理员对象
                Message s = (Message) ois.readObject();
                //创建Message对象，准备回复客户端
                Message m=new Message();
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                if(s.getType().equals(MessageType.MESSAGE_STUDENT_LOGIN)) {
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
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_LOGIN_FAIL);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
                else if(s.getType().equals(MessageType.MESSAGE_TEACHER_LOGIN)) {
                    Teacher t = (Teacher) s.getData();
                    if(Teachers_utils.checkTeacherAccount(t.getTeacher_idcard(), t.getTeacher_pwd())){
                        m.setType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        //创建一个线程，和客户端通信，该线程持有socket对象
                        ServerToClientThread stct = new ServerToClientThread(socket,t.getTeacher_idcard());
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
                else if(s.getType().equals(MessageType.MESSAGE_ADMIN_LOGIN)) {
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
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_LOGIN_FAIL);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
                else if(s.getType().equals(MessageType.MESSAGE_STUDENT_REGISTER)) {
                    Student stu = (Student) s.getData();
                    if(Students_utils.addStudent(stu)){
                        m.setType(MessageType.MESSAGE_STUDENT_REGISTER_SUCCEED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        //创建一个线程，和客户端通信，该线程持有socket对象
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_STUDENT_REGISTER_FAILED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
                else if(s.getType().equals(MessageType.MESSAGE_TEACHER_REGISTER)) {
                    Teacher tea = (Teacher) s.getData();
                    if(Teachers_utils.addTeacher(tea)){
                        m.setType(MessageType.MESSAGE_TEACHER_REGISTER_SUCCEED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        //创建一个线程，和客户端通信，该线程持有socket对象
                    }else {  //登录失败
                        m.setType(MessageType.MESSAGE_TEACHER_REGISTER_FAILED);
                        //将message对象回复客户端
                        oos.writeObject(m);
                        socket.close();
                    }
                }
                else if(s.getType().equals(MessageType.TO_FIND_CERTAIN)) {
                    if(s.getSender().equals("教师")){
                        t1 = (Teacher) s.getData();
                        if(Teachers_utils.findForgetpwdTeacher(t1)){
                            m.setType(MessageType.HAVE_FIND_CERTAIN);
                            oos.writeObject(m);
                        }else {  //登录失败
                            m.setType(MessageType.NOT_FIND_CERTAIN);
                            oos.writeObject(m);
                            socket.close();
                        }
                    } else {
                        s1 = (Student) s.getData();
                        if(Students_utils.findForgetpwdStudent(s1)){
                            m.setType(MessageType.HAVE_FIND_CERTAIN);
                            oos.writeObject(m);
                        }else {  //登录失败
                            m.setType(MessageType.NOT_FIND_CERTAIN);
                            oos.writeObject(m);
                            socket.close();
                        }
                    }
                }
                else if(s.getType().equals(MessageType.RESET_PASSWORD)){
                    if(s.getSender().equals("教师")){
                        t1 = (Teacher) s.getData();
                        if(Teachers_utils.changeTeacherPwd(t1.getTeacher_idcard(),t1)){
                            m.setType(MessageType.RESET_PASSWORD_SUCCEED);
                            oos.writeObject(m);
                        }else {  //登录失败
                            m.setType(MessageType.RESET_PASSWORD_FAILED);
                            oos.writeObject(m);
                            socket.close();
                        }
                    } else {
                        s1 = (Student) s.getData();
                        if(Students_utils.changeStudentPwd(s1.getStudent_idcard(),s1)){
                            m.setType(MessageType.RESET_PASSWORD_SUCCEED);
                            oos.writeObject(m);
                        }else {  //登录失败
                            m.setType(MessageType.RESET_PASSWORD_FAILED);
                            oos.writeObject(m);
                            socket.close();
                        }
                    }
                }
                else if(s.getType().equals(MessageType.RETURN_STUDENT_INFO)){
                    Student stu  = User_SM_utils.returnStudentAllInfo(((Student) s.getData()).getStudent_idcard());
                    if(stu!=null){
                        m.setData(stu);
                        m.setType(MessageType.RETURN_STUDENT_INFO_SUCCEED);
                        oos.writeObject(m);             //将message对象回复客户端
                    } else{
                        m.setType(MessageType.RETURN_STUDENT_INFO_FAILED);  //登录失败
                        oos.writeObject(m);                        //将message对象回复客户端
                        socket.close();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ss.close();            //服务器退出while，服务器不再监听
        }
    }
    public static void main(String[] args) throws IOException {
        new ServerToClient();
    }
}
