package DAO.Login;

import User.Admin;
import User.Teacher;
import connection.JDBC_Connector;

import java.sql.*;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.16 22:36]
 */
public class Teachers_utils {
    public static boolean checkTeacherAccount(String username, String userpassword) {
        try {
            Connection connection= JDBC_Connector.ConnectMySQL();                  //连接数据库
            Statement state = connection.createStatement();
            String sql="select * from teachers where Teacher_idcard='"+username+"' and Teacher_pwd='"+userpassword+"'";
            ResultSet resultSet= state.executeQuery(sql);            //执行sql
            String passWord = "";
            while (resultSet.next()) {
                passWord = resultSet.getString("Teacher_pwd").trim();
                if (passWord == userpassword || passWord.equals(userpassword)) {
                    resultSet.close();
                    state.close();
                    connection.close();
                    return true;
                } else{
                    resultSet.close();
                    state.close();
                    connection.close();
                    return false;
                }

            }
            resultSet.close();
            state.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Teacher returninfo(String id)throws SQLException {
        String sql="select * from teachers where Teacher_idcard=?;";
        Connection connection=JDBC_Connector.ConnectMySQL();
        PreparedStatement st= connection.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        Teacher tea=new Teacher();
        while(rs.next()){
            tea.setTeacher_idcard(id);
            tea.setTeacher_name(rs.getString("Teacher_name"));
            tea.setTeacher_money(rs.getDouble("Teacher_money"));
        }
        rs.close();
        st.close();
        connection.close();
        return tea;
    }

    public static boolean addTeacher(Teacher s) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();                  //连接数据库
        if(checkTeacherAccount(s.getTeacher_idcard(),s.getTeacher_pwd())){
            System.out.println("教师已存在！");
            return false;
        }
        String sql = "insert into teachers values(?,?,?,?,?,?,?,null,null,null)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,s.getTeacher_idcard());
        ps.setString(2,s.getTeacher_id());
        ps.setString(3,s.getTeacher_pwd());
        ps.setString(4,s.getTeacher_name());
        ps.setInt(5,s.getTeacher_age());
        ps.setString(6,s.getTeacher_gender());
        ps.setString(7,s.getTeacher_email());
        boolean re = ps.executeUpdate()>0;
        if(re)
            System.out.println("教师"+s.getTeacher_name()+"添加成功！");
        else
            System.out.println("教师添加失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

    public static boolean findForgetpwdTeacher(Teacher s) throws SQLException {
        try {
            Connection connection= JDBC_Connector.ConnectMySQL();                  //连接数据库
            Statement state = connection.createStatement();
            String sql="select * from teachers where Teacher_idcard='"+s.getTeacher_idcard()+"' and Teacher_email='"+s.getTeacher_email()+"'";
            ResultSet resultSet= state.executeQuery(sql);            //执行sql
            while (resultSet.next()) {
                String Teacher_idcard = resultSet.getString("Teacher_idcard").trim();
                String Teacher_email = resultSet.getString("Teacher_email").trim();
                resultSet.close();
                state.close();
                connection.close();
                return Teacher_idcard.equals(s.getTeacher_idcard()) && Teacher_email.equals(s.getTeacher_email());
            }
            resultSet.close();
            state.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean changeTeacherPwd(String username, Teacher t) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();
        String sql = "update teachers SET Teacher_pwd =? WHERE Teacher_idcard =" +username;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,t.getTeacher_pwd());
        boolean re = ps.executeUpdate()>0;
        JDBC_Connector.close(null, ps, connection);
        if(re)
            System.out.println("教师"+username+"密码修改成功！");
        else
            System.out.println("教师"+username+"密码修改失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

    public static String  returnTeacherName(String username, String userpassword) {
        try {
            Connection connection=JDBC_Connector.ConnectMySQL();                  //连接数据库
            Statement state = connection.createStatement();
            String sql="select * from teachers where Teacher_idcard='"+username+"' and Teacher_pwd='"+userpassword+"'";
            ResultSet resultSet= state.executeQuery(sql);            //执行sql
            String passWord = "";
            while (resultSet.next()) {
                passWord = resultSet.getString("Teacher_pwd").trim();
                if (passWord == userpassword || passWord.equals(userpassword)) {
                    resultSet.close();
                    state.close();
                    connection.close();
                    return resultSet.getString("Teacher_name");

                } else{
                    resultSet.close();
                    state.close();
                    connection.close();
                    return null;
                }

            }
            resultSet.close();
            state.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
