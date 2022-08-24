package DAO.Login;
import java.io.IOException;
import java.sql.*;
import User.Student;
import connection.JDBC_Connector;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.16 22:35]
 */
public class Students_utils {

    public static boolean checkStudentAccount(String username, String userpassword) {
        try {
            Connection connection=JDBC_Connector.ConnectMySQL();                  //连接数据库
            Statement state = connection.createStatement();
            String sql="select * from students where Student_idcard='"+username+"' and Student_pwd='"+userpassword+"'";
            ResultSet resultSet= state.executeQuery(sql);            //执行sql
            String passWord = "";
            while (resultSet.next()) {
                passWord = resultSet.getString("Student_pwd").trim();
                if (passWord == userpassword || passWord.equals(userpassword)) {
                    return true;
                } else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean findStudentAccount(String username) {
        Boolean re = null;
        try {
            Connection connection = JDBC_Connector.ConnectMySQL();
            String sql = "select * from students where Student_idcard=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            JDBC_Connector.close(rs, ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean addStudent(Student s) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();                  //连接数据库
        if(checkStudentAccount(s.getStudent_idcard(),s.getStudent_pwd())){
            System.out.println("学生已存在！");
            return false;
        }
        String sql = "insert into students values(?,null,?,null,?,null,null,null,null)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,s.getStudent_idcard());
        ps.setString(2,s.getStudent_pwd());
        ps.setInt(3,s.getStudent_age());
        boolean re = ps.executeUpdate()>0;
         if(re)
            System.out.println("学生"+s.getStudent_idcard()+"添加成功！");
        else
            System.out.println("学生添加失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

    public static boolean deleteStudent(String username) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();
        if(findStudentAccount(username)){
            System.out.println("学生不存在！");
            return false;
        }
        String sql = "delete from students where Student_idcard=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,username);
        boolean re = ps.executeUpdate()>0;
        JDBC_Connector.close(null, ps, connection);
        if(re)
            System.out.println("学生"+username+"删除成功！");
        else
            System.out.println("学生删除失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

    public static boolean changeStudentInfo(String username,Student s) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();
        String sql = "update students where Student_idcard=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"11112222");
        boolean re = ps.executeUpdate()>0;
        JDBC_Connector.close(null, ps, connection);
        if(re)
            System.out.println("学生"+username+"删除成功！");
        else
            System.out.println("学生删除失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }


    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.setStudent_idcard("11112222");
        s.setStudent_pwd("22221111");
        s.setStudent_age(11111);
        addStudent(s);
        deleteStudent("11112222");
        System.out.println(findStudentAccount("213202128"));;
    }
}
