package UIhandler.Library;

import ClientToServer.ManageClientToServerThread;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import message.Message;
import message.MessageType;
import utils.MyObjectOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import utils.MyObjectInputStream;
import utils.MyObjectOutputStream;

public class Client_library {
    static String id;
    static Socket socket;
    static MyObjectOutputStream oos;

    public static Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) throws IOException {
        Client_library.socket = socket;
        oos=new MyObjectOutputStream(socket.getOutputStream());
    }

    public static void setId(String id) {
        Client_library.id = id;
    }

    public static void borrow() throws IOException {
        Message message = new Message();
        Book_borrower b;

        //message.setData(b);
        message.setType(MessageType.MESSAGE_LIBRARY_BORROW);
        MyObjectOutputStream oos= new MyObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(message);
    }

    public static void RequireshowAllBooks()throws IOException{
        Message message=new Message();
        System.out.println("ok");
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_LIST);
        oos.writeObject(message);
    }
    
    public static String[][] showAllBooks(HashSet<Book_admin>books)throws IOException{
        int n= books.size();
        System.out.println(n);
        String[][]a=new String[n][11];
        Iterator b= books.iterator();
        int count=0;
        while(b.hasNext())
        {
            Book_admin book=(Book_admin) b.next();
                a[count][0]=book.getID();
                a[count][1]=book.getName();
                a[count][2]=book.getAuthor();
                a[count][3]=book.getPublisher();
                a[count][4]=book.getCountry();
                a[count][5]=String.valueOf(book.getPrice());
            if(book.getAvailable()==1) {
                a[count][6]="可借";
            }
            else{
                a[count][6]="借出";
            }
                a[count][7]=book.getDate_borrow();
                a[count][8]=book.getBorrow_to();
                a[count][9]=book.getDate_expire();
                a[count][10]=book.getPlace();
            count++;
        }
        return a;
    }

/*
    public static void AddBook()throws IOException
    {
        new String[]=UIviewer.Library.AddDeleteBook

    }

 */
}

