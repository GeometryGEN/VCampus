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

    public static String getBuyedNum(String idcard) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="select * from buyedproducted where Stu_Tea_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ResultSet rs = ps.executeQuery();
        String s = null;
        if (rs.next()) {
            s=rs.getString("buyedproductedNum");
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

    public static String getReadytoBuyNum(String idcard) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="select * from buyedproducted where Stu_Tea_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ResultSet rs = ps.executeQuery();
        String s = null;
        if (rs.next()) {
            s=rs.getString("readytoBuyProductsNum");
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

    //更新用户余额，更新商品num,更新物品ready buy
    public static Boolean buyCertainProduct(String idcard, int id,int num, double money) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql = "update students set Student_money= ? where Student_idcard=? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1,money);
        ps.setString(2,idcard);
        boolean re = ps.executeUpdate()>0;
        if(re){
            sql="update products set Product_currentNumbers= ? where Product_id=? ";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, num);
            ps.setInt(2, id);
            re = ps.executeUpdate()>0;
            if (re) {
                sql="select * from buyedproducted where Stu_Tea_id=?";
                ps = connection.prepareStatement(sql);
                ps.setString(1, idcard);
                ResultSet rs = ps.executeQuery();
                String s1=null;
                String s2=null;
                if (rs.next()) {
                    s1=rs.getString("buyedProducted");
                    s2=rs.getString("buyedproductedNum");
                }
                sql="update buyedproducted set buyedProducted= ?, buyedproductedNum= ? where Stu_Tea_id=? ";
                ps = connection.prepareStatement(sql);
                ps.setString(1,s1+"@"+id );
                ps.setString(2, s2+"@"+num);
                ps.setString(3, idcard);
                re = ps.executeUpdate()>0;
                if(re){
                    JDBC_Connector.close(null, ps, connection);
                    return true;
                }
            }else {
                JDBC_Connector.close(null, ps, connection);
                return false;
            }
        }
        JDBC_Connector.close(null, ps, connection);
        return false;
    }

    public static Boolean addToShopCar(String idcard, int id,int num) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="select * from buyedproducted where Stu_Tea_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ResultSet rs = ps.executeQuery();
        String s1=null;
        String s2=null;
        if (rs.next()) {
            s1=rs.getString("readytoBuyProducts");
            s2=rs.getString("readytoBuyProductsNum");
        }
        sql="update buyedproducted set readytoBuyProducts= ?, readytoBuyProductsNum= ? where Stu_Tea_id=? ";
        ps = connection.prepareStatement(sql);
        ps.setString(1,s1+"#"+id );
        ps.setString(2, s2+"#"+num);
        ps.setString(3, idcard);
        Boolean re = ps.executeUpdate()>0;
        if(re){
            JDBC_Connector.close(rs, ps, connection);
            return true;
        }
        else {
            JDBC_Connector.close(rs, ps, connection);
            return false;
        }
    }

//    public static void main(String[] args) throws Exception {
////        if(checkCertainProduct(111)!=null)
//            System.out.println(addToShopCar("09020201",1,2));
////        else
////            System.out.println("checkCertainProduct(1).getProduct_name()");
////        List<Product> list = findTypeProduct("饮料");
////        for (int i = 0; i < list.size(); i++) {
////            System.out.println(list.get(i).getProduct_name());
////        }
//    }
}
