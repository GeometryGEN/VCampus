package UIhandler.Library;

import ClientToServer.ManageClientToServerThread;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import DAO.Library.Punishment;
import UIviewer.Library.*;
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
    public static volatile String[][] ret_show_all_books=null;
    public static volatile String[][] ret_my_books=null;
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
        AllBooks.tableDate=null;
        Message message=new Message();
        System.out.println("ok");
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_LIST);
        oos.writeObject(message);
    }
    
    public static String[][] showAllBooks(HashSet<Book_admin>books)throws IOException{
        int n= books.size();
        System.out.println(n);
        ret_show_all_books=new String[n][11];
        Iterator b= books.iterator();
        int count=0;
        while(b.hasNext())
        {
            Book_admin book=(Book_admin) b.next();
            ret_show_all_books[count][0]=book.getID();
            ret_show_all_books[count][1]=book.getName();
            ret_show_all_books[count][2]=book.getAuthor();
            ret_show_all_books[count][3]=book.getPublisher();
            ret_show_all_books[count][4]=book.getCountry();
            ret_show_all_books[count][5]=String.valueOf(book.getPrice());
            if(book.getAvailable()==1) {
                ret_show_all_books[count][6]="可借";
            }
            else{
                ret_show_all_books[count][6]="借出";
            }
            ret_show_all_books[count][7]=book.getDate_borrow();
            ret_show_all_books[count][8]=book.getBorrow_to();
            ret_show_all_books[count][9]=book.getDate_expire();
            ret_show_all_books[count][10]=book.getPlace();
            count++;
        }
        System.out.println("returned books");
        return ret_show_all_books;
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
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_GIVE_TICKET);
        oos.writeObject(message);
    }

    //用户查看自己图书
    public static void RequireMyBooks()throws IOException{
        ret_my_books=null;
        Message message=new Message();
        message.setType(MessageType.MESSAGE_LIBRARY_LIST_MY_BOOK);
        oos.writeObject(message);
        System.out.println("my books:");
    }

    public static void showMyBooks(HashSet<Book_borrower>books) throws IOException, InterruptedException {
        int n= books.size();
        ret_my_books=new String[n][10];
        System.out.println(n);
        Iterator b= books.iterator();
        int count=0;
        while(b.hasNext())
        {
            Book_borrower book=(Book_borrower) b.next();
            ret_my_books[count][0]=book.getId();
            ret_my_books[count][1]=book.getName();
            ret_my_books[count][2]=book.getAuthor();
            ret_my_books[count][3]=book.getPublisher();
            ret_my_books[count][4]=book.getCountry();
            ret_my_books[count][5]=book.getDate_borrow();
            ret_my_books[count][6]=book.getDate_expire();
            ret_my_books[count][7]="";
            ret_my_books[count][8]="";
            count++;
        }
    }

//查看自己的罚单
    public static void RequireMyPunishments()throws IOException{
        applyTicket.myPunish=null;
        Message message=new Message();
        message.setType(MessageType.MESSAGE_LIBRARY_LIST_MY_TICKET);
        oos.writeObject(message);
    }


    public static void showMyPunishments(HashSet<Punishment>myPunishments)throws IOException{
        int n= myPunishments.size();
        System.out.println(n);
        applyTicket.myPunish=new String[n][5];
        Iterator b= myPunishments.iterator();
        int count=0;
        while(b.hasNext())
        {
            Punishment punishment=(Punishment) b.next();
            applyTicket.myPunish[count][0]=punishment.getPunishmentID();
            applyTicket.myPunish[count][1]=String.valueOf(punishment.getPrice());
            applyTicket.myPunish[count][2]=punishment.getBook_id();
            applyTicket.myPunish[count][3]=punishment.getNotice();
            applyTicket.myPunish[count][4]="";
            count++;
        }

    }

    //搜索书籍
    public static void RequireSearchResult(String searchInfo)throws IOException{
        searchResult.searchresult=null;
        Message message=new Message();
        message.setData(searchInfo);
        message.setType(MessageType.MESSAGE_LIBRARY_QUERY);
        oos.writeObject(message);
        System.out.println("search  "+searchInfo);
    }

    public static void showSearchResult(HashSet<Book_borrower>books)throws IOException{
        int n= books.size();
        System.out.println(n);
        searchResult.searchresult=new String[n][10];
        Iterator b= books.iterator();
        int count=0;
        while(b.hasNext())
        {
            Book_borrower book=(Book_borrower) b.next();
            searchResult.searchresult[count][0]=book.getId();
            searchResult.searchresult[count][1]=book.getName();
            searchResult.searchresult[count][2]=book.getAuthor();
            searchResult.searchresult[count][3]=book.getPublisher();
            searchResult.searchresult[count][4]=book.getCountry();
            if(book.getAvailable()==1)
            {
                searchResult.searchresult[count][5]="可借";
            }
            else {
                searchResult.searchresult[count][5]="借出";
            }
            searchResult.searchresult[count][6]=book.getDate_expire();
            searchResult.searchresult[count][7]=book.getPlace();
            searchResult.searchresult[count][8]="";
            count++;
        }
    }

    public static void reqireReturn(Book_borrower rBook)throws IOException{
        Message message=new Message();
        message.setData(rBook);
        message.setType(MessageType.MESSAGE_LIBRARY_RET);
        oos.writeObject(message);
        System.out.println("search  "+rBook);
    }
}


