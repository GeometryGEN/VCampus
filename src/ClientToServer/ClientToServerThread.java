package ClientToServer;

import DAO.Library.Book_borrower;
import DAO.Library.Library_manager;
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
    private String ID;
    public ClientToServerThread(String id,Socket socket){
        this.socket=socket;
        this.ID=id;
    }

    public Socket getSocket(){
        return socket;
    }

    public void run(){
        while (true){
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

                Message send = new Message();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
