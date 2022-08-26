package ServerToClient;

import DAO.Curriculum.Course;
import DAO.Curriculum.Course_manager;
import DAO.Curriculum.Opencourse;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import DAO.Library.Library_manager;
import DAO.Library.Punishment;
import DAO.StatusManagement.User_SM_utils;
import User.Student;
import message.Message;
import message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;

import DAO.StatusManagement.Image_SM_utils;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [该类的一个对象和某个客户端保持通信]
 * @createTime : [2022.08.14 21:05]
 */
public class ServerToClientThread extends Thread{
    private Socket socket;
    private String userid;//连接到服务器的用户id

    public ServerToClientThread(Socket socket,String userid){
        this.socket=socket;
        this.userid=userid;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void run(){
        while (true){
            System.out.println("客户端和服务端 "+userid+" 保持通信，读取数据...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message m = (Message) ois.readObject();
                Message sendback = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //退出系统
                if(m.getType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(m.getSender()+"退出系统");
                    ManageServerToClientThread.removeServerToClientThread(m.getSender());
                    ServerToClient.removeOnline(m.getSender());
//                    socket.close();
                    break;
                }
                //图书馆
                if(m.getType()== MessageType.MESSAGE_LIBRARY_ENTER){

                    sendback=new Library_manager(userid).enter_info();
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_BORROW)
                {
                    Book_borrower book=(Book_borrower)m.getData();
                    Library_manager lib_manager = new Library_manager(userid);
                    sendback=lib_manager.borrow(book);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_RET)
                {
                    Book_borrower book=(Book_borrower)m.getData();
                    Library_manager lib_manager = new Library_manager(userid);
                    sendback=lib_manager.ret(book);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_QUERY)
                {
                    String s=(String)m.getData();
                    Library_manager lib_manager = new Library_manager(userid);
                    sendback.setData(lib_manager.query_book(s));
                    sendback.setType(MessageType.MESSAGE_LIBRARY_QUERY_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_EXTEND){
                    Book_borrower b=(Book_borrower)m.getData();
                    sendback=new Library_manager(userid).extend(b);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_LIST_MY_BOOK){
                    sendback.setData(new Library_manager(userid).list_my_book());
                    sendback.setType(MessageType.MESSAGE_LIBRARY_LIST_MY_BOOK_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_ADMIN_LIST)
                {
                    Library_manager lib_manager = new Library_manager(userid);
                    sendback.setData(lib_manager.list_all_book(""));
                    sendback.setType(MessageType.MESSAGE_LIBRARY_ADMIN_LIST_RET);
                    oos.writeObject(sendback);
                }
                else if (m.getType()== MessageType.MESSAGE_LIBRARY_ADMIN_QUERY) {
                    sendback.setData(new Library_manager(userid).list_all_book((String)m.getData()));
                    sendback.setType(MessageType.MESSAGE_LIBRARY_ADMIN_QUERY_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_LIBRARY_ADMIN_LIST_TICKETS){
                    sendback.setData(new Library_manager(userid).admin_list_tickets());
                    sendback.setType(MessageType.MESSAGE_LIBRARY_ADMIN_LIST_TICKETS_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_ADMIN_HANDLE)
                {
                    Punishment p=(Punishment) m.getData();
                    new Library_manager(userid).handle(p);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_APPLICATION)
                {
                    Book_borrower b=(Book_borrower)m.getData();
                    ServerToClient.addPunish(new Library_manager(userid).apply(b));
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_LIST_MY_TICKET){
                    sendback.setData(new Library_manager(userid).list_my_tickets());
                    sendback.setType(MessageType.MESSAGE_LIBRARY_LIST_MY_TICKET_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_PAY){
                    Punishment p=(Punishment) m.getData();
                    sendback=(new Library_manager(userid).pay(p));
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_ADMIN_ADD){
                    Book_admin book=(Book_admin)m.getData();
                    new Library_manager(userid).addbook(book);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_ADMIN_DELETE){
                    String id=(String)m.getData();
                    new Library_manager(userid).deletebook(id);
                }


                //选课
                if(m.getType()==MessageType.MESSAGE_CURRICULUM_LIST_ALL){
                    sendback.setData(new Course_manager(userid).list_all_courses());
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_LIST_ALL_RET);
                    oos.writeObject(sendback);
                }
                else if (m.getType()==MessageType.MESSAGE_CURRICULUM_LIST_MINE) {
                    sendback.setData(new Course_manager(userid).list_my_courses());
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_LIST_MINE_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_CHOOSE){
                    Course c=(Course)m.getData();
                    sendback=new Course_manager(userid).choose(c);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_APPLY){
                    new Course_manager(userid).apply((Opencourse)m.getData());
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_SHOW_STU) {
                    sendback.setData(new Course_manager(userid).get_student((String) m.getData()));
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_SHOW_STU_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_SHOW_SCHEDULE){
                    sendback.setData(new Course_manager(userid).schedule());
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_SHOW_SCHEDULE_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_DELETE){
                    new Course_manager(userid).delete((String) m.getData());
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_LIST_APPLICATION){
                    sendback.setData(new Course_manager(userid).list_tea_opencourse((String) m.getData()));
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_LIST_APPLICATION_RET);
                    oos.writeObject(sendback);
                }
                else if (m.getType()==MessageType.MESSAGE_CURRICULUM_QUERY) {
                    String q=(String)m.getData();
                    sendback.setData(new Course_manager(userid).query_courses(q));
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_QUERY_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_LIST_ADMIN_APPLICATION){
                    sendback=new Course_manager(userid).admin_list_application();
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_APPLICATION_REFUSE){
                    String reason=(String) m.getData();
                    new Course_manager(userid).refuse(m.getGetter(),reason);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_APPLICATION_APPROVE){
                    Course c=(Course) m.getData();
                    new Course_manager(userid).approve(m.getGetter(),c);
                }
                //站内通信
                if(m.getType()==MessageType.MESSAGE_QICQ_SEND_MSG){

                }
                else if(m.getType()==MessageType.MESSAGE_QICQ_SEND_FILE){

                }
                //商店
                else if(m.getType().equals(MessageType.RETURN_STUDENT_INFO)){
                    Student stu  = User_SM_utils.returnStudentAllInfo(((Student) m.getData()).getStudent_idcard());
                    if(stu!=null){
                        sendback.setData(stu);
                        sendback.setType(MessageType.RETURN_STUDENT_INFO_SUCCEED);
                        oos.writeObject(sendback);             //将message对象回复客户端
                    } else{
                        sendback.setType(MessageType.RETURN_STUDENT_INFO_FAILED);  //登录失败
                        oos.writeObject(sendback);                        //将message对象回复客户端
                        socket.close();
                    }
                }

                //学籍管理
                else if(m.getType().equals(MessageType.RETURN_PHOTO)){
                    boolean sign = Image_SM_utils.readDBImage(m.getSender());
                    if(sign){
                        sendback.setType(MessageType.RETURN_PHOTO_SUCCEED);
                        oos.writeObject(sendback);             //将message对象回复客户端
                    } else{
                        sendback.setType(MessageType.RETURN_PHOTO_FAILED);  //失败
                        oos.writeObject(sendback);                        //将message对象回复客户端
                        socket.close();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
