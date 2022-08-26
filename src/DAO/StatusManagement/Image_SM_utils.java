package DAO.StatusManagement;

import connection.JDBC_Connector;
import utils.Image_utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Image_SM_utils {
    // 将图片插入数据库
    public static void sendImageDB(String path,String id,String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = Image_utils.readImage(path);
            conn = JDBC_Connector.ConnectMySQL();
            String sql = "insert into userphotos (Photo_id,Photo_name,photo) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2,name);
            ps.setBinaryStream(3, in, in.available());
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC_Connector.close(null,ps,conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // 读取数据库中图片
    public static boolean readDBImage(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBC_Connector.ConnectMySQL();
            String sql = "select * from userphotos where Photo_id =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                InputStream in = rs.getBinaryStream("photo");
                Image_utils.readBin2Image(in,id);
                System.out.println("图片读取成功！");
                JDBC_Connector.close(rs,ps,conn);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) throws SQLException {
        sendImageDB("C:\\Users\\28468\\Desktop\\11.png","213202128","name");
//        readDBImage("111111");
    }
}