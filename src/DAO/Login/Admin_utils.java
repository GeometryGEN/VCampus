package DAO.Login;

import ClientToServer.myInfo;
import User.Admin;
import connection.JDBC_Connector;

import java.sql.*;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.16 22:36]
 */
public class Admin_utils {

    public static boolean checkAdminAccount(String username, String userpassword) {
        try {
            Connection connection= JDBC_Connector.ConnectMySQL();                  //连接数据库
            Statement state = connection.createStatement();
            String sql="select * from admins where Admin_idcard='"+username+"' and Admin_pwd='"+userpassword+"'";
            ResultSet resultSet= state.executeQuery(sql);            //执行sql
            String passWord = "";
            while (resultSet.next()) {
                passWord = resultSet.getString("Admin_pwd").trim();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String  returnAdminName(String username, String userpassword) {
        try {
            Connection connection=JDBC_Connector.ConnectMySQL();                  //连接数据库
            Statement state = connection.createStatement();
            String sql="select * from admins where Admin_idcard='"+username+"' and Admin_pwd='"+userpassword+"'";
            ResultSet resultSet= state.executeQuery(sql);            //执行sql
            String passWord = "";
            while (resultSet.next()) {
                passWord = resultSet.getString("Admin_pwd").trim();
                if (passWord == userpassword || passWord.equals(userpassword)) {
                    resultSet.close();
                    state.close();
                    connection.close();
                    return resultSet.getString("Admin_name");
                } else{
                    resultSet.close();
                    state.close();
                    connection.close();
                    return null;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Admin returninfo(String id) throws SQLException {
        String sql="select * from admins where Admin_idcard=?;";
        Connection connection=JDBC_Connector.ConnectMySQL();
        PreparedStatement st= connection.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        Admin admin=new Admin();
        while(rs.next()){
            admin.setAdmin_idcard(id);
            admin.setAdmin_name(rs.getString("Admin_name"));
        }
        rs.close();
        st.close();
        connection.close();
        return admin;
    }
}
