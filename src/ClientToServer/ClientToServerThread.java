package ClientToServer;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import DAO.Library.Punishment;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.AllBooks;
import UIviewer.Library.myBook;
import UIviewer.Library.applyTicket;
import UIviewer.Library.searchResult;
import User.Student;
import message.Message;
import message.MessageType;
import utils.MyObjectInputStream;
import utils.MyObjectOutputStream;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
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
    private static MyObjectInputStream ois=null;
    public ClientToServerThread(Socket socket){
        this.socket=socket;
    }

    public Socket getSocket(){
        return socket;
    }

    public void run(){
        try {
            //MyObjectOutputStream oos = new MyObjectOutputStream(socket.getOutputStream());
            ois = new MyObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!exit){
            try {
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
                else if (message.getType().equals(MessageType.MESSAGE_LIBRARY_LIST_MY_BOOK_RET)) {
                    HashSet<Book_borrower>mybook=(HashSet<Book_borrower>) message.getData();
                    myBook.myBook=Client_library.showMyBooks(mybook);
                }
                else if(message.getType().equals(MessageType.MESSAGE_LIBRARY_LIST_MY_TICKET_RET)){
                    HashSet<Punishment>myPunishments=(HashSet<Punishment>) message.getData();
                    applyTicket.myPunish=Client_library.showMyPunishments(myPunishments);
                }
                else if(message.getType().equals(MessageType.MESSAGE_LIBRARY_QUERY_RET)){
                    HashSet<Book_borrower> searchResult=(HashSet<Book_borrower>) message.getData();
                    UIviewer.Library.searchResult.searchResult=Client_library.showSearchResult(searchResult);
                }
                //商店具体操作
                Message send = new Message();

                if(message.getType().equals(MessageType.RETURN_ALL_PRODUCT_SUCCEED)){
                    List<Product> ps = ((List<Product>) message.getData());
                    Client_shop.setProducts(ps);
                }
                else if(message.getType().equals(MessageType.FIND_PRODUCT_SUCCEED)){
                    List<Product> ps = ((List<Product>) message.getData());
                    Client_shop.setCheckproducts(ps);
                }
                else if(message.getType().equals(MessageType.FIND_TYPE_PRODUCT_SUCCEED)){
                    List<Product> ps = ((List<Product>) message.getData());
                    Client_shop.setCheckproductsType(ps);
                }
                else if(message.getType().equals(MessageType.FIND_PRODUCT_SUCCEED_ZERO)){
                    List<Product> ps = ((List<Product>) message.getData());
                    Client_shop.setSign(false);
                }
                else if(message.getType().equals(MessageType.DELETE_PRODUCT_SUCCEED)){
                    Client_shop.setSign_delete("2");
                }
                else if(message.getType().equals(MessageType.DELETE_PRODUCT_FAILED)){
                    Client_shop.setSign_delete("3");
                }
                else if(message.getType().equals(MessageType.RETURN_STUDENT_INFO_SUCCEED)){
                    Student stu = ((Student) message.getData());
                    Client_status.setS(stu);
                }
               else if(message.getType().equals(MessageType.ADMIN_RETURN_STUDENT_INFO_SUCCEED)){
                    Student stu = ((Student) message.getData());
                    Client_status.setS_s(stu);
                }
            } catch (InterruptedIOException e){
                break;
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
