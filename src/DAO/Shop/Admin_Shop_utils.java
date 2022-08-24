package DAO.Shop;

import connection.JDBC_Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.19 15:31]
 */
public class Admin_Shop_utils {

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

    public static boolean addProduct(Product p) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();                  //连接数据库
        String sql = "insert into products values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,p.getProduct_name());
        ps.setInt(2,p.getProduct_id());
        ps.setDouble(3,p.getProduct_price());
        ps.setInt(4,p.getProduct_currentNumbers());
        ps.setInt(5,p.getProduct_sumNumbers());
        ps.setBoolean(6,p.getProduct_takeaway());
        ps.setInt(7,p.getProduct_toshop());
        ps.setString(8,p.getProduct_type());
        boolean re = ps.executeUpdate()>0;
        if(re)
            System.out.println("商品"+p.getProduct_name()+"添加成功！");
        else
            System.out.println("商品添加失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

//    public static boolean deleteProduct(Product p) throws SQLException {
//        Connection connection=JDBC_Connector.ConnectMySQL();
//        String sql = "delete from products where Product_idcard=?";
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setString(1,username);
//        boolean re = ps.executeUpdate()>0;
//        JDBC_Connector.close(null, ps, connection);
//        if(re)
//            System.out.println("学生"+username+"删除成功！");
//        else
//            System.out.println("学生删除失败！");
//        JDBC_Connector.close(null, ps, connection);
//        return re;
//    }


    public static void main(String[] args) throws Exception {
//        List<Product> list = checkProduct();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getProduct_name());
//        }
//        Product p = new Product();
//        p.setProduct_id(11);
//        p.setProduct_takeaway(false);
//        p.setProduct_name("冰绿茶");
//        addProduct(p);
    }

}
