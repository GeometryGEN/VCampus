package UIhandler.Library;

import ClientToServer.ManageClientToServerThread;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import message.Message;
import message.MessageType;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class Client_library {
    String id;
    public static void borrow() throws IOException {
        Message message = new Message();
        Book_borrower b;

        //message.setData(b);
        message.setType(MessageType.MESSAGE_LIBRARY_BORROW);
        ObjectOutputStream oos= new ObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(message);
    }

    public static void RequireshowAllBooks()throws IOException{
        Message message=new Message();


        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_LIST);
        ObjectOutputStream oos= new ObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(message);
    }
    public static void showAllBooks(HashSet<Book_admin>books){
        int n= books.size();

    }
}
