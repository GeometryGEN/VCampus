package DAO.Library;

import ServerToClient.ManageServerToClientThread;
import ServerToClient.ServerToClient;
import ServerToClient.ServerToClientThread;
import User.Admin;
import User.Student;
import User.Teacher;
import connection.JDBC_Connector;
import message.Message;
import message.MessageType;
import utils.myTime;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.io.Serializable;

public class Library_manager implements Serializable{
    private String ID;
    private static Connection conn;
    public Library_manager(String ID){

        this.ID = ID;
        try {
            conn= JDBC_Connector.ConnectMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Message enter_info() throws SQLException {
        Message message=new Message();
        message.setType(MessageType.MESSAGE_LIBRARY_ENTER_RET);
        Info information=new Info();
        String sql="select * from students where Student_idcard=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,ID);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            information.id=rs.getString("Student_idcard");
            information.name=rs.getString("Student_name");
            message.setData(information);
        }
        else {
            sql="select * from teachers where Teacher_idcard=?;";
            st=conn.prepareStatement(sql);
            st.setString(1,ID);
            rs=st.executeQuery();
            if(rs.next()) {
                information.id=rs.getString("Teacher_idcard");
                information.name=rs.getString("Teacher_name");
                message.setData(information);
            }
            else{
                sql="select * from teachers where Teacher_idcard=?;";
                st=conn.prepareStatement(sql);
                st.setString(1,ID);
                rs=st.executeQuery();
                if(rs.next()){
                    information.id=rs.getString("Admin_idcard");
                    information.name=rs.getString("Admin_name");
                    message.setData(information);
                }
            }
        }
        return message;
    }
    public HashSet<Book_borrower> list_my_book() throws SQLException {
        HashSet<Book_borrower> books = new HashSet<Book_borrower>();
        String sql="select * from library where borrow_to=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,ID);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Book_borrower x=new Book_borrower();
            x.borrow_to=ID;
            x.id=rs.getString("id");;
            x.name=rs.getString("name");
            x.author=rs.getString("author");
            x.date_borrow=myTime.dateToString(rs.getDate("borrow_date"));
            x.date_expire=myTime.dateToString(rs.getDate("expire_date"));
            books.add(x);
        }
        return books;
    }
    public HashSet<Book_borrower> query_book(String s) throws SQLException {
        HashSet<Book_borrower> books = new HashSet<>();
        String sql="select * from library where name like ? " +
                "or country like ? or author like ? or publisher like ?;";
        String parse="%"+s+"%";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,parse);
        st.setString(2,parse);
        st.setString(3,parse);
        st.setString(4,parse);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Book_borrower x=new Book_borrower();
            x.name=rs.getString("name");
            x.author=rs.getString("author");
            x.available=rs.getInt("available");
            x.publisher=rs.getString("publisher");
            x.place=rs.getString("place");
            x.country=rs.getString("country");
            x.available=rs.getInt("available");
            if(x.available==1){
                x.date_expire=myTime.dateToString(rs.getDate("expire_date"));
            }
            books.add(x);
        }

        return books;
    }
    public HashSet<Book_admin> list_all_book(String s) throws SQLException {
        HashSet<Book_admin> books = new HashSet<Book_admin>();
        String sql="select * from library where id like ? or name like ? or author like ?" +
                "or place like ? or publisher like ? or country like ? or borrow_to like ?;";
        String parse="%"+s+"%";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,parse);
        st.setString(2,parse);
        st.setString(3,parse);
        st.setString(4,parse);
        st.setString(5,parse);
        st.setString(6,parse);
        st.setString(7,parse);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Book_admin x=new Book_admin();
            x.borrow_to=ID;
            x.name=rs.getString("name");
            x.author=rs.getString("author");
            x.borrow_to=rs.getString("borrow_to");
            x.price=rs.getDouble("price");
            x.ID=rs.getString("ID");
            x.place=rs.getString("place");
            x.publisher=rs.getString("publisher");
            x.country=rs.getString("country");
            x.available=rs.getInt("available");
            if(x.available==0){
                x.date_borrow=myTime.dateToString(rs.getDate("borrow_date"));
                x.date_expire=myTime.dateToString(rs.getDate("expire_date"));
            }
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
            sql="update set library available = 0 where name= ?;";
            st=conn.prepareStatement(sql);
            st.setString(1,b.name);
            st.executeUpdate();
            sql="update set library borrow_date = ? where name= ?;";
            st=conn.prepareStatement(sql);
            st.setString(1,today.toString());
            st.setString(2,b.name);
            st.executeUpdate();
            sql="update set library expire_date = ? where name= ?;";
            st=conn.prepareStatement(sql);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(today);
            rightNow.add(Calendar.DAY_OF_YEAR,30);//日期加30天
            Date expire=rightNow.getTime();
            st.setString(1, myTime.dateToString(expire));
            st.setString(2,b.name);
            st.executeUpdate();
            sql="update set library borrow_to = ? where name=?;";
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
        sql="select expire_date from library where id=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,b.id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            Date today=new Date();
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if(rs.getDate("expire_date").compareTo(today)==-1){
                msg.setType(MessageType.MESSAGE_LIBRARY_RET_SUCCEED);
            }else{
                msg.setType(MessageType.MESSAGE_LIBRARY_RET_LATE);
            }
        }
        sql="update library set available = 1 where id=?;";
        st=conn.prepareStatement(sql);
        st.setString(1,b.id);
        st.executeUpdate();
        sql="update library set borrow_date = null where id=?;";
        st=conn.prepareStatement(sql);
        st.setString(1,b.id);
        st.executeUpdate();
        sql="update library set expire_date = null where id=?;";
        st=conn.prepareStatement(sql);
        st.setString(1,b.id);
        st.executeUpdate();
        sql="update library set borrow_to = null where id=?;";
        st=conn.prepareStatement(sql);
        st.setString(1,b.id);
        st.executeUpdate();
        return msg;
    }
    public void handle(Punishment punishment) throws SQLException, IOException {
        Iterator it=ServerToClient.getPunish().iterator();
        while(it.hasNext()){
            Punishment p=(Punishment)it.next();
            if(punishment.Book_id.equals(p.Book_id)&&punishment.Customer_iD.equals(p.Customer_iD)) {
                ServerToClient.getPunish().remove(p);
                p.status=1;
                ServerToClient.getPunish().add(p);
                return;
            }
        }
    }
    public Message extend(Book_borrower b) throws SQLException, ParseException {
        String sql="select * from library where id=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,b.id);
        ResultSet rs=st.executeQuery();
        Message message=new Message();
        if(rs.getInt("extended")==1)
        {
            message.setType(MessageType.MESSAGE_LIBRARY_EXTEND_FAIL);
            return message;
        }
        while(rs.next()){
            String ex=myTime.dateToString(rs.getDate("expire_date"));
            String bookid=rs.getString("id");
            Date next=new SimpleDateFormat("yyyy-MM-dd").parse(ex);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(next);
            rightNow.add(Calendar.DAY_OF_YEAR,30);//日期加30天
            Date new_expire=rightNow.getTime();
            sql="update library set expire_date=?, extended=1 where id=?";
            st=conn.prepareStatement(sql);
            st.setString(1,myTime.dateToString(new_expire));
            st.setString(2,bookid);
            st.executeUpdate();
        }
        message.setType(MessageType.MESSAGE_LIBRARY_EXTEND_SUCCEED);
        return message;
    }
    public Punishment apply(Book_borrower b) throws SQLException {
        Punishment pp=new Punishment();
        String sql="select * from library where name=? and author=? and borrow_to=?;";
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
        String sql="select * from Students where Student_name=?;";
        Message msg=new Message();
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,p.Customer_iD);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            double curmoney=rs.getDouble("Student_money")-p.price;
            if(curmoney>=0){
                sql="update students set Student_money=? where name=?;";
                st=conn.prepareStatement(sql);
                st.setDouble(1,curmoney);
                st.setString(2,p.Customer_iD);
                st.executeUpdate();
                sql="update ticket set status=1 where id=?";
                st=conn.prepareStatement(sql);
                st.setString(1,p.punishmentID);
                st.executeUpdate();
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_SUCCEED);
            }
            else {
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_FAIL);
            }
        }
        else {
            sql="select * from Teachers where Teacher_name=?";
            st=conn.prepareStatement(sql);
            st.setString(1,p.Customer_iD);
            rs=st.executeQuery();
            double curmoney=rs.getDouble("Teacher_money")-p.price;
            if(curmoney>=0){
                sql="update teachers set Teacher_money=? where name=?;";
                st=conn.prepareStatement(sql);
                st.setDouble(1,curmoney);
                st.setString(2,p.Customer_iD);
                st.executeUpdate();
                sql="update ticket set status=1 where id=?";
                st=conn.prepareStatement(sql);
                st.setString(1,p.punishmentID);
                st.executeUpdate();
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_SUCCEED);
            }
            else {
                msg.setType(MessageType.MESSAGE_LIBRARY_PAY_FAIL);
            }
        }
        if(msg.getType().equals(MessageType.MESSAGE_LIBRARY_PAY_SUCCEED))
        {
            sql="delete from library where id=?;";
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
        String sql="delete from library where ID=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        st.executeUpdate();
    }
    public HashSet<Punishment>admin_list_tickets(){
        HashSet<Punishment>punishments=new HashSet<>();
        Iterator it=ServerToClient.getPunish().iterator();
        while(it.hasNext()){
            Punishment p=(Punishment)it.next();
            if(p.status==0) punishments.add(p);
        }
        return punishments;
    }
    public HashSet<Punishment>list_my_tickets() throws SQLException {
        String sql="select * from ticket where customer=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,ID);
        ResultSet rs=st.executeQuery();
        HashSet<Punishment>punishments=new HashSet<>();
        while(rs.next()){
            Punishment p = new Punishment();
            p.status=rs.getInt("status");
            p.notice=rs.getString("notice");
            p.price=rs.getDouble("price");
            p.punishmentID=rs.getString("id");
            p.Customer_iD=ID;
            punishments.add(p);
        }
        return punishments;
    }
    public void admin_give_ticket(Punishment p) throws SQLException {
        String sql="insert into ticket(id,customer,notice,price,status) values(?,?,?,?,0);";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,p.punishmentID);
        st.setString(2,p.Customer_iD);
        st.setString(3,p.notice);
        st.setDouble(4,p.price);
        st.executeUpdate();
    }

}
