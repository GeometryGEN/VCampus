package utils;

import connection.JDBC_Connector;
import net.coobird.thumbnailator.Thumbnails;

import java.io.*;
import java.sql.*;

public class Save_image {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
     //   JDBC_Connector.first_connect();
        String p="src/image/cartoon/";
        for(int i=1;i<=30;i++)
        {
            /*try {
                Thumbnails.of(new File(p+i+".jpg"))
                        .size(250, 250)
                        .toFile(new File(p+i+"_min.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/
            String path = p+ i+".jpg";
            System.out.println(path);
            File file = new File(path);
            FileInputStream fis=new FileInputStream(file);
            try {
                Connection conn = JDBC_Connector.ConnectMySQL();
                String sql = "insert into userphotos(photo_id,photo) values(?,?);";
                PreparedStatement ps = JDBC_Connector.ConnectMySQL().prepareStatement(sql);
                ps.setString(1, null);
                ps.setBinaryStream(2,fis,(int)file.length());
                int change=ps.executeUpdate();
                System.out.println(change);
              //  ps.close();
              //  JDBC_Connector.ConnectMySQL().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
