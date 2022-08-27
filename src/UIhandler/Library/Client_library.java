package UIhandler.Library;

import ClientToServer.ManageClientToServerThread;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import DAO.Library.Punishment;
import UIviewer.Library.AddDeleteBook;
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

    //管理员查看所有图书的请求和处理
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

    //增加书籍的请求和处理
    public static void RequireAddBook(Book_admin b)throws IOException{
        Message message=new Message();
        message.setData(b);
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_ADD);
        oos.writeObject(message);
    }

    //删除书籍的请求和处理
    public static void RequireDeleteBook(String deleteID) throws IOException {
        Message message=new Message();
        message.setData(deleteID);
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_DELETE);
        oos.writeObject(message);
    }

    //管理员新开一个罚单
    public static void RequireNewPunishment(Punishment p)throws IOException{
        Message message=new Message();
        message.setData(p);
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_HANDLE);
        oos.writeObject(message);
    }

    //用户查看自己图书
    public static void RequireMyBooks()throws IOException{
        Message message=new Message();
        message.setType(MessageType.MESSAGE_LIBRARY_LIST_MY_BOOK);
        oos.writeObject(message);
    }

    public static String[][] showMyBooks(HashSet<Book_borrower>books)throws IOException{
        int n= books.size();
        String[][]a=new String[n][9];
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
            a[count][6]=book.getPlace();
            a[count][7]=book.getDate_borrow();
            a[count][8]=book.getDate_expire();
            count++;
        }
        return a;
    }
}

