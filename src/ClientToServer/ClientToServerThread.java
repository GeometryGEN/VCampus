package ClientToServer;

import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import DAO.Library.Library_manager;
import UIhandler.Library.Client_library;
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
        while (!exit){
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //如果服务器没有发送Message对象，线程会一直堵塞在这里
                if(message.getType()==MessageType.MESSAGE_LIBRARY_BORROW_SUCCEED){

                }
                else if(message.getType()==MessageType.MESSAGE_LIBRARY_BORROW_FAIL_RETURN_FIRST){

                }
                else if(message.getType()==MessageType.MESSAGE_LIBRARY_BORROW_FAIL_TOO_MANY){

                }
                else if(message.getType()==MessageType.MESSAGE_LIBRARY_RET_SUCCEED){

                }
                else if(message.getType()==MessageType.MESSAGE_LIBRARY_ADMIN_LIST_RET){
                    HashSet<Book_admin>books=(HashSet<Book_admin>)message.getData();
                    Client_library.showAllBooks(books);
                }
                //商店具体操作

                Message send = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
