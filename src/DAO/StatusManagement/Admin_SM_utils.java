package DAO.StatusManagement;

import User.Student;
import connection.JDBC_Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.23 15:33]
 */
public class Admin_SM_utils {

    public static boolean changeStudentInfo(String useridcard, Student s) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();
        String sql = "update students SET Student_idcard =? Student_id =? Student_pwd =? Student_name =? Student_age =? " +
                "Student_gender =? Student_email =? Student_class =? Student_money =? Student_nation =? Student_birthday =? " +
                "Student_native_place =? Student_major =? WHERE Student_idcard =" +useridcard;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,s.getStudent_idcard());
        ps.setString(2,s.getStudent_id());
        ps.setString(3,s.getStudent_pwd());
        ps.setString(4,s.getStudent_name());
        ps.setInt(5,s.getStudent_age());
        ps.setString(6,s.getStudent_gender());
        ps.setString(7,s.getStudent_email());
        ps.setString(8,s.getStudent_class());
        ps.setDouble(9,s.getStudent_money());
        ps.setString(10,s.getNation());
        ps.setString(11,s.getBirthday());
        ps.setString(12,s.getNative_place());
        ps.setString(13,s.getMajor());
        boolean re = ps.executeUpdate()>0;
        JDBC_Connector.close(null, ps, connection);
        if(re)
            System.out.println("学生"+useridcard+"信息修改成功！");
        else
            System.out.println("学生"+useridcard+"信息修改失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }


}
