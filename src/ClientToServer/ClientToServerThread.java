package ClientToServer;
import DAO.Library.Book_admin;
import UIhandler.Library.Client_library;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.AllBooks;
import User.Student;
import message.Message;
import message.MessageType;
import utils.MyObjectInputStream;
import utils.MyObjectOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [客户端连接服务端线程]
 * @createTime : [2022.08.14 20:23]
 */
public class ClientToServerThread extends Thread {
    private Socket socket;

    //volatile修饰符用来保证其它线程读取的总是该变量的最新的值
    public volatile boolean exit = false;

    public ClientToServerThread(Socket socket){
        this.socket=socket;
    }

    public Socket getSocket(){
        return socket;
    }

    public void run(){
        try {
            MyObjectOutputStream oos = new MyObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!exit){
            try {
                MyObjectInputStream ois = new MyObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //如果服务器没有发送Message对象，线程会一直堵塞在这里
                if(message.getType().equals(MessageType.MESSAGE_LIBRARY_BORROW_SUCCEED)){

                }
                else if(message.getType().equals(MessageType.MESSAGE_LIBRARY_BORROW_FAIL_RETURN_FIRST)){

                }
                else if(message.getType().equals(MessageType.MESSAGE_LIBRARY_BORROW_FAIL_TOO_MANY)){

                }
                else if(message.getType().equals(MessageType.MESSAGE_LIBRARY_RET_SUCCEED)){

                }
                else if(message.getType().equals(MessageType.MESSAGE_LIBRARY_ADMIN_LIST_RET)){
                    HashSet<Book_admin>books=(HashSet<Book_admin>)message.getData();
                    AllBooks.tableDate=Client_library.showAllBooks(books);
                }
                //商店具体操作
                Message send = new Message();


                if(message.getType().equals(MessageType.RETURN_STUDENT_INFO_SUCCEED)){
                    Student stu = ((Student) message.getData());
                    Client_status.setS(stu);
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

        }
    }

}
