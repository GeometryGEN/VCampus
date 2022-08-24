package DAO.Library;

import ServerToClient.ManageServerToClientThread;
import ServerToClient.ServerToClientThread;
import connection.JDBC_Connector;
import message.Message;
import message.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.SimpleTimeZone;

public class Library_manager {
    private String ID;
    private Connection conn;
    public Library_manager(String ID){

        this.ID = ID;
        try {
            Connection conn= JDBC_Connector.ConnectMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashSet<Book_borrower> list_my_book() throws SQLException {
        HashSet<Book_borrower> books = new HashSet<Book_borrower>();
        String sql="select * from library where borrow_to =?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,ID);
        ResultSet rs=st.executeQuery();
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
        while(rs.next())
        {
            Book_borrower x=new Book_borrower();
            x.borrow_to=ID;
            x.name=rs.getString("name");
            x.author=rs.getString("author");
            x.date_borrow=sformat.format(rs.getDate("borrow_date"));
            x.date_expire=sformat.format(rs.getDate("expire_date"));
            books.add(x);
        }
        return books;
    }
    public HashSet<Book_borrower> query_book(String s) throws SQLException {
        HashSet<Book_borrower> books = new HashSet<Book_borrower>();
        String sql="select * from library where name like \'%?%\' " +
                "or country like \'%?%\' or author like \'%?%\' or publisher like \'%?%\';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.setString(2,s);
        st.setString(3,s);
        st.setString(4,s);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Book_borrower x=new Book_borrower();
            x.name=rs.getString("name");
            x.author=rs.getString("author");
            x.availble=rs.getInt("available");
            x.publisher=rs.getString("publisher");
            x.place=rs.getString("place");
            x.country=rs.getString("country");
            books.add(x);
        }

        return books;
    }
    public HashSet<Book_admin> list_all_book() throws SQLException {
        HashSet<Book_admin> books = new HashSet<Book_admin>();
        String sql="select * from library ";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,ID);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Book_admin x=new Book_admin();
            x.borrow_to=ID;
            x.name=rs.getString("name");
            x.author=rs.getString("author");
            x.date_borrow=rs.getDate("borrow_date").toString();
            x.date_expire=rs.getDate("expire_date").toString();
            x.borrow_to=rs.getString("borrow_to");
            x.price=rs.getDouble("price");
            x.ID=rs.getString("ID");
            x.place=rs.getString("place");
            x.publisher=rs.getString("publisher");
            x.country=rs.getString("country");
            books.add(x);
        }
        return books;
    }
    public Message borrow(Book_borrower b) throws SQLException {
        String sql="select * from library where borrow_to =?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,ID);
        ResultSet rs=st.executeQuery();
        Date today=new Date();
        Message msg=new Message();
        int cnt=0;
        int flag=1;
        while(rs.next())
        {
            cnt++;
            if(rs.getDate("expire_date").compareTo(today)==-1)
            {
                msg.setType(MessageType.MESSAGE_LIBRARY_BORROW_FAIL_RETURN_FIRST);
                flag=0;
            }
        }
        if(cnt==5)
        {
            msg.setType(MessageType.MESSAGE_LIBRARY_BORROW_FAIL_TOO_MANY);
            flag=0;
        }
        if(flag==1)
        {
            msg.setType(MessageType.MESSAGE_LIBRARY_BORROW_SUCCEED);
            sql="update set library available = 0 where name= '?';";
            st=conn.prepareStatement(sql);
            st.setString(1,b.name);
            st.executeUpdate();
            sql="update set library borrow_date = ? where name= '?';";
            st=conn.prepareStatement(sql);
            st.setString(1,today.toString());
            st.setString(2,b.name);
            st.executeUpdate();
            sql="update set library expire_date = ? where name= '?';";
            st=conn.prepareStatement(sql);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(today);
            rightNow.add(Calendar.DAY_OF_YEAR,30);//日期加30天
            Date expire=rightNow.getTime();
            st.setString(1,expire.toString());
            st.setString(2,b.name);
            st.executeUpdate();
            sql="update set library borrow_to = ? where name= '?';";
            st=conn.prepareStatement(sql);
            st.setString(1,ID);
            st.setString(2,b.name);
            st.executeUpdate();
        }
        return msg;
    }
    public Message ret(Book_borrower b) throws SQLException{

        String sql;
        Message msg=new Message();
        msg.setType(MessageType.MESSAGE_LIBRARY_RET_SUCCEED);
        sql="update library set available = 1 where name= '?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,b.name);
        st.executeUpdate();
        sql="update library set borrow_date = null where name= '?';";
        st=conn.prepareStatement(sql);
        st.setString(1,b.name);
        st.executeUpdate();
        sql="update library set expire_date = null where name= '?';";
        st=conn.prepareStatement(sql);
        st.setString(1,b.name);
        st.executeUpdate();
        sql="update library set borrow_to = null where name= '?';";
        st=conn.prepareStatement(sql);
        st.setString(1,b.name);
        st.executeUpdate();
        return msg;
    }
    public void handle(Punishment p) throws SQLException, IOException {
        ServerToClientThread thread= ManageServerToClientThread.getThread(p.Customer_iD);
        ObjectOutputStream oos = new ObjectOutputStream(thread.getSocket().getOutputStream());
        Message sendback=new Message();
        sendback.setType(MessageType.MESSAGE_LIBRARY_TICKET_BACK);
        String sql="select * from library where ID= '?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,p.Book_id);
        ResultSet rs=st.executeQuery();
        p.notice="因为丢失/损坏图书 <<"+rs.getString("name")+">>无法按时归还，处罚金"+String.valueOf(p.price);
        sendback.setData(p);
        oos.writeObject(sendback);
    }
    public Message extend(Book_borrower b) throws SQLException, ParseException {
        String sql="select * from library where name= '?' and author='?'and borrow_to='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,b.name);
        st.setString(2,b.author);
        st.setString(3,ID);
        ResultSet rs=st.executeQuery();
        Message message=new Message();
        if(rs.getInt("extended")==1)
        {
            message.setType(MessageType.MESSAGE_LIBRARY_EXTEND_FAIL);
            return message;
        }
        while(rs.next()){
            String ex=rs.getDate("expire_date").toString();
            String bookid=rs.getString("id");
            Date next=new SimpleDateFormat("yyyy-MM-dd").parse(ex);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(next);
            rightNow.add(Calendar.DAY_OF_YEAR,30);//日期加30天
            Date new_expire=rightNow.getTime();
            sql="update library set expire_date=?, extended=1 where id='?'";
            st=conn.prepareStatement(sql);
            st.setString(1,new_expire.toString());
            st.setString(2,bookid);
            st.executeUpdate();
        }
        message.setType(MessageType.MESSAGE_LIBRARY_EXTEND_SUCCEED);
        return message;
    }
    public Punishment apply(Book_borrower b) throws SQLException {
        Punishment pp=new Punishment();
        String sql="select * from library where name= '?' and author='?'and borrow_to='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,b.name);
        st.setString(2,b.author);
        st.setString(3,ID);
        ResultSet rs=st.executeQuery();
        while (rs.next())
        {
            pp.Book_id=rs.getString("ID");
            pp.Customer_iD= ID;
            pp.price=rs.getDouble("price");
        }
        return pp;
    }
    public Message pay(Punishment p) throws SQLException{
        String sql="select * from Students where Student_name= '?';";
        Message msg=new Message();
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,p.Customer_iD);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            double curmoney=rs.getDouble("Student_money")-p.price;
            if(curmoney>=0){
                sql="update students set Student_money=? where name= '?';";
                st.setDouble(1,curmoney);
                st.setString(2,p.Customer_iD);
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_SUCCEED);
            }
            else {
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_FAIL);
            }
        }
        else {
            sql="select * from Teachers where Teacher_name= '?'";
            st=conn.prepareStatement(sql);
            st.setString(1,p.Customer_iD);
            rs=st.executeQuery();
            double curmoney=rs.getDouble("Teacher_money")-p.price;
            if(curmoney>=0){
                sql="update teachers set Teacher_money=? where name= '?';";
                st.setDouble(1,curmoney);
                st.setString(2,p.Customer_iD);
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_SUCCEED);
            }
            else {
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_FAIL);
            }
        }
        if(msg.getType()==MessageType.MESSAGE_LIBRARY_PAY_SUCCEED)
        {
            sql="delete from library where id= '?';";
            st=conn.prepareStatement(sql);
            st.setString(1,p.Book_id);
            st.executeUpdate();
        }
        return msg;
    }
    public void addbook(Book_admin book) throws SQLException{
        String sql="insert into library(name,author,ID,place,price,publisher,country,available) values(?,?,?,?,?,?,?,1);";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,book.name);
        st.setString(2,book.author);
        st.setString(3,book.ID);
        st.setString(4,book.place);
        st.setString(6,book.publisher);
        st.setString(7,book.country);
        st.setDouble(5,book.price);
        st.executeUpdate();
    }
    public void deletebook(String id) throws SQLException{
        String sql="delete from library where ID='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        st.executeUpdate();
    }
}
