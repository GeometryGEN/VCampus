import connection.JDBC_Connector;
import net.coobird.thumbnailator.Thumbnails;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Save_image {
    public static void main(String[] args) throws FileNotFoundException {
        String id=null;
        for(int i=1;i<=9;i++)
        {
            try {
                Thumbnails.of(new File("src/image/head/"+i+".png"))
                        .size(800, 800)
                        .toFile(new File("src/image/head/"+i+"_min.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String path = "src/image/head/"+ i +"_min.png";
            System.out.println(path);
            File file = new File(path);
            FileInputStream fis=new FileInputStream(file);
            try {
                Connection conn = JDBC_Connector.ConnectMySQL();
                String sql = "insert into userphotos(photo_id,photo) values(?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, null);
                ps.setBinaryStream(2,fis,(int)file.length());
                int change=ps.executeUpdate();
                System.out.println(change);
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
