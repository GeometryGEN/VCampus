package connection;
import java.sql.*;

public class JDBC_Connector {

    static Connection connection;        //创建java程序与数据库的连接对象
    public static Connection ConnectMySQL1(){
        return connection;
    }
    static int start=0;
    public static Connection ConnectMySQL() throws SQLException{
        //

        String driver = "com.mysql.cj.jdbc.Driver";         //将MySQL数据库驱动名称封装在字符串中
        //指定使用数据库的路径、编码格式、时区，并以字符串进行封装
        String url = "jdbc:mysql://localhost:3306/gzy_vcampus?useUnicode=true&characterEncoding=utf8&" +
                "serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";          //指定登录账户
        String pin = "100905";         //指定账户密码
        //加载数据库驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(start==0) connection = DriverManager.getConnection(url,user,pin);        //连接数据库
        start=1;
        return connection;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
}
