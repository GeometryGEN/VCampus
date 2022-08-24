package ServerToClient;

import DAO.Curriculum.Course;
import DAO.Curriculum.Course_manager;
import DAO.Curriculum.Opencourse;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import DAO.Library.Library_manager;
import DAO.Library.Punishment;
import message.Message;
import message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;

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
                //图书馆
                if(m.getType()== MessageType.MESSAGE_LIBRARY_ENTER){
                    Library_manager lib_manager = new Library_manager(userid);
                    HashSet<Book_borrower> mybooks=lib_manager.list_my_book();
                    sendback.setSender(userid);
                    sendback.setData(mybooks);
                    sendback.setType(MessageType.MESSAGE_LIBRARY_ENTER_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(m.getSender()+"退出系统");
                    ManageServerToClientThread.removeServerToClientThread(m.getSender());
//                    socket.close();
                    break;
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
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_EXTEND){
                    Book_borrower b=(Book_borrower)m.getData();
                    sendback=new Library_manager(userid).extend(b);
                    oos.writeObject(sendback);
                }
                else if(m.getType()== MessageType.MESSAGE_LIBRARY_ADMIN_ENTER)
                {
                    Library_manager lib_manager = new Library_manager(userid);
                    sendback.setData(lib_manager.list_all_book());
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_LIBRARY_ADMIN_RECEIVE){
                    sendback.setData(ServerToClient.getPunish());
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
                    sendback.setData(new Course_manager(userid).schedule((String) m.getData()));
                    sendback.setType(MessageType.MESSAGE_CURRICULUM_SHOW_SCHEDULE_RET);
                    oos.writeObject(sendback);
                }
                else if(m.getType()==MessageType.MESSAGE_CURRICULUM_DELETE){
                    new Course_manager(userid).schedule((String) m.getData());
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
                //商店
                //学籍管理

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
