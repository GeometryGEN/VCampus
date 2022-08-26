package UIhandler.Library;

import ClientToServer.ManageClientToServerThread;
import DAO.Library.Book_admin;
import DAO.Library.Book_borrower;
import message.Message;
import message.MessageType;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;

public class Client_library {
    static String id;

    public static void setId(String id) {
        Client_library.id = id;
    }

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
        System.out.println("ok");
        message.setType(MessageType.MESSAGE_LIBRARY_ADMIN_LIST);
        ObjectOutputStream oos= new ObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(message);
    }
    public static String[][] showAllBooks(HashSet<Book_admin>books){
        int n= books.size();
        System.out.println(n);
        String[][]a=new String[n][11];
        Iterator b= books.iterator();
        int count=1;
        while(b.hasNext())
        {
            Book_admin book=(Book_admin) b.next();

                a[count][1]=book.getName();
                a[count][2]=book.getAuthor();
                a[count][3]=String.valueOf(book.getPrice());
                if(book.getAvailable()==1) {
                    a[count][4]="可借";
                }
                else{
                    a[count][4]="借出";
                }
                a[count][5]=book.getDate_borrow();
                a[count][6]=book.getCountry();
                a[count][7]=book.getBorrow_to();
                a[count][8]=book.getDate_expire();
                a[count][9]=book.getPlace();
                a[count][10]=book.getID();
                a[count][11]=book.getPublisher();
            count++;
        }
        return a;
    }
}
