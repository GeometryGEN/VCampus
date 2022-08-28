package DAO.Shop;

import User.Student;
import connection.JDBC_Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.Shop.image_Shop_utils.readDBImage;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [商店与数据库连接类]
 * @createTime : [2022.08.19 15:31]
 */
public class buyers_Shop_utils {

    //模糊查找
    public static List<Product> checkProduct(String product_name) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Statement state = connection.createStatement();
        String sql="select * from products WHERE Product_name LIKE '%" + product_name + "%' ";
        ResultSet rs= state.executeQuery(sql);            //执行sql
        while(rs.next()) {
            Product temp = new Product();
            temp.setProduct_name(rs.getString("product_name"));
            temp.setProduct_id(rs.getInt("Product_id"));
            temp.setProduct_price(rs.getDouble("Product_price"));
            temp.setProduct_currentNumbers(rs.getInt("Product_currentNumbers"));
            temp.setProduct_takeaway(rs.getBoolean("Product_takeaway"));
            temp.setProduct_sumNumbers(rs.getInt("Product_sumNumbers"));
            temp.setProduct_type(rs.getString("Product_type"));
            temp.setProduct_toshop(rs.getInt("Product_toshop"));
            list.add(temp);
        }
        return list;
    }

    public static String getBuyed(String idcard) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="select * from buyedproducted where Stu_Tea_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ResultSet rs = ps.executeQuery();
        String s = null;
        if (rs.next()) {
            s=rs.getString("buyedProducted");
        }
        JDBC_Connector.close(rs, ps, connection);
        return s;
    }

    public static String getReadytoBuy(String idcard) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="select * from buyedproducted where Stu_Tea_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ResultSet rs = ps.executeQuery();
        String s = null;
        if (rs.next()) {
            s=rs.getString("readytoBuyProducts");
        }
        JDBC_Connector.close(rs, ps, connection);
        return s;
    }

    public static List<Product> returnAllProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Statement state = connection.createStatement();
        String sql="select * from products";
        ResultSet rs= state.executeQuery(sql);            //执行sql
        while(rs.next()) {
            Product temp = new Product();
            temp.setProduct_name(rs.getString("Product_name"));
            temp.setProduct_id(rs.getInt("Product_id"));
            temp.setProduct_price(rs.getDouble("Product_price"));
            temp.setProduct_currentNumbers(rs.getInt("Product_currentNumbers"));
            temp.setProduct_takeaway(rs.getBoolean("Product_takeaway"));
            temp.setProduct_sumNumbers(rs.getInt("Product_sumNumbers"));
            temp.setProduct_type(rs.getString("Product_type"));
            temp.setProduct_toshop(rs.getInt("Product_toshop"));
            list.add(temp);
            readDBImage(rs.getInt("Product_id"));
        }
        return list;
    }

    public static List<Product> findTypeProduct(String type) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Statement state = connection.createStatement();
        String sql="select * from products WHERE Product_type LIKE '%" + type + "%' ";
        ResultSet rs= state.executeQuery(sql);            //执行sql
        while(rs.next()) {
            Product temp = new Product();
            temp.setProduct_name(rs.getString("product_name"));
            temp.setProduct_id(rs.getInt("Product_id"));
            temp.setProduct_price(rs.getDouble("Product_price"));
            temp.setProduct_currentNumbers(rs.getInt("Product_currentNumbers"));
            temp.setProduct_takeaway(rs.getBoolean("Product_takeaway"));
            temp.setProduct_sumNumbers(rs.getInt("Product_sumNumbers"));
            temp.setProduct_type(rs.getString("Product_type"));
            temp.setProduct_toshop(rs.getInt("Product_toshop"));
            list.add(temp);
        }
        return list;
    }

    public static Product checkCertainProduct(int id) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Product temp = new Product();
        String sql="select * from products where Product_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            temp.setProduct_name(rs.getString("Product_name"));
            temp.setProduct_id(rs.getInt("Product_id"));
            temp.setProduct_price(rs.getDouble("Product_price"));
            temp.setProduct_currentNumbers(rs.getInt("Product_currentNumbers"));
            temp.setProduct_takeaway(rs.getBoolean("Product_takeaway"));
            temp.setProduct_sumNumbers(rs.getInt("Product_sumNumbers"));
            temp.setProduct_type(rs.getString("Product_type"));
            temp.setProduct_toshop(rs.getInt("Product_toshop"));
        }else {
            JDBC_Connector.close(rs, ps, connection);
            return null;
        }
        JDBC_Connector.close(rs, ps, connection);
        return temp;
    }


//    public static void main(String[] args) throws Exception {
//        if(checkCertainProduct(111)!=null)
//            System.out.println(checkCertainProduct(1).getProduct_name());
//        else
//            System.out.println("checkCertainProduct(1).getProduct_name()");
////        List<Product> list = findTypeProduct("饮料");
////        for (int i = 0; i < list.size(); i++) {
////            System.out.println(list.get(i).getProduct_name());
////        }
//    }
}
