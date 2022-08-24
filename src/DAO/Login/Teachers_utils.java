package DAO.Login;

import connection.JDBC_Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                    return true;
                } else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
