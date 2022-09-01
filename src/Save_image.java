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
        for(int i=14;i<=17;i++)
        {
            try {
                Thumbnails.of(new File("src/image/QQ/"+String.valueOf(i)+".jpg"))
                        .size(200, 200)
                        .toFile(new File("src/image/QQ/"+String.valueOf(i)+"_min.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String path = "src/image/QQ/"+String.valueOf(i)+"_min.jpg";
            File file = new File(path);
            FileInputStream fis=new FileInputStream(file);
            try {
                Connection conn = JDBC_Connector.ConnectMySQL();
                String sql = "insert into qqimage(id,image) values(?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                ps.setBinaryStream(2,fis,(int)file.length());
                ps.executeUpdate();
                ps.close();
                conn.close();
            } catch (Exception e) {
            }
        }

    }
}
