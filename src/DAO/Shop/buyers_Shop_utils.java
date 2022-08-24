package DAO.Shop;

import connection.JDBC_Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [商店与数据库连接类]
 * @createTime : [2022.08.19 15:31]
 */
public class buyers_Shop_utils {

    public static List<Product> checkProduct(String product_name) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Statement state = connection.createStatement();
        String sql="select * from products";
        ResultSet rs= state.executeQuery(sql);            //执行sql
        while(rs.next()) {
            Product temp = new Product();
            String name = rs.getString("Product_name");
            if(name.equals(product_name)){
                temp.setProduct_name(product_name);
                temp.setProduct_id(rs.getInt("Product_id"));
                temp.setProduct_price(rs.getDouble("Product_price"));
                temp.setProduct_currentNumbers(rs.getInt("Product_currentNumbers"));
                temp.setProduct_takeaway(rs.getBoolean("Product_takeaway"));
                temp.setProduct_sumNumbers(rs.getInt("Product_sumNumbers"));
                temp.setProduct_type(rs.getString("Product_type"));
                temp.setProduct_toshop(rs.getInt("Product_toshop"));
                list.add(temp);
            }
        }
        return list;
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
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        List<Product> list = returnAllProduct();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getProduct_name());
        }
    }
}
