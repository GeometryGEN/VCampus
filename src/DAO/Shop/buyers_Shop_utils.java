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

    public static List<ProductPair> getBuyedandNum(String idcard) throws SQLException {
        List<ProductPair> s = new ArrayList<>();
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Statement state = connection.createStatement();
        String sql= "select * from buyedproducted where Stu_Tea_id= "+idcard;
        ResultSet rs= state.executeQuery(sql);            //执行sql
        while(rs.next()) {
            ProductPair p = new ProductPair();
            p.setId(rs.getInt("buyedProductedid"));
            p.setNum(rs.getInt("buyedproductedNum"));
            s.add(p);
        }
        JDBC_Connector.close(rs, null, connection);
        return s;
    }

    public static List<ProductPair> getReadytoBuyandNum(String idcard) throws SQLException {
        List<ProductPair> s = new ArrayList<>();
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        Statement state = connection.createStatement();
        String sql= "select * from readytobuyproducts where Stu_Tea_id= "+idcard;
        ResultSet rs= state.executeQuery(sql);            //执行sql
        while(rs.next()) {
            ProductPair p = new ProductPair();
            p.setId(rs.getInt("product_id"));
            p.setNum(rs.getInt("product_num"));
            s.add(p);
        }
        JDBC_Connector.close(rs, null, connection);
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
        String sql="select * from products WHERE Product_name LIKE '%" + type + "%' ";
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

    //UI界面先直接判断钱够不够，这里判断数量够不够，假设可以买 更新用户余额，更新商品num
    public static String buyCertainProduct(String idcard, int id, int num, double money) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="select * from products where Product_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        int current = 0;
        if (rs.next()) {
            current=rs.getInt("Product_currentNumbers");
        }
        if(current<num)
            return "数量不够";
        else{
            sql = "update students SET Student_money =? WHERE Student_idcard =" + idcard;
            ps = connection.prepareStatement(sql);
            ps.setDouble(1,money);
            boolean re = ps.executeUpdate()>0;
            if(re){
                sql = "update products SET Product_currentNumbers =? WHERE Product_id =" + id;
                ps = connection.prepareStatement(sql);
                ps.setInt(1,current-num);
                re = ps.executeUpdate()>0;
                if(re){
                    System.out.println("商品数量更新成功");
                }else {
                    System.out.println("商品数量更新失败");
                    return "商品数量更新失败";
                }
            }else{
                System.out.println("更新钱失败");
                return "更新钱失败";
            }
        }
        addToHaveShopped(idcard,id,num);
        JDBC_Connector.close(null, ps, connection);
        return "购买成功";
    }

    public static Boolean addToShopCar(String idcard, int id, int num) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="insert into readytobuyproducts values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ps.setInt(2,id);
        ps.setInt(3,num);
        boolean re = ps.executeUpdate()>0;
        if(re)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

    public static Boolean addToHaveShopped(String idcard, int id, int num) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="insert into buyedproducted values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idcard);
        ps.setInt(2,id);
        ps.setInt(3,num);
        boolean re = ps.executeUpdate()>0;
        if(re)
            System.out.println("添加成功！");
        else
            System.out.println("添加失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }

    public static Boolean deleteShopCar(String idcard, int id, int num) throws SQLException {
        Connection connection= JDBC_Connector.ConnectMySQL();    //连接数据库
        String sql="delete from readytobuyproducts where (Stu_Tea_id=? and product_id=?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,idcard);
        ps.setInt(2,id);
        boolean re = ps.executeUpdate()>0;
        JDBC_Connector.close(null, ps, connection);
        if(re)
            System.out.println("删除成功！");
        else
            System.out.println("删除失败！");
        JDBC_Connector.close(null, ps, connection);
        return re;
    }



    public static double getMoney(String idcard) throws SQLException {
        Connection connection=JDBC_Connector.ConnectMySQL();
        String sql="select * from students where Student_idcard=? ";
        PreparedStatement st= connection.prepareStatement(sql);
        st.setString(1, idcard);
        ResultSet rs=st.executeQuery();
        double money = 0;
        while(rs.next()){
            money=rs.getDouble("Student_money");
        }
        return money;
    }

    public static void main(String[] args) throws Exception {
//        if(checkCertainProduct(111)!=null)
        System.out.println(deleteShopCar("09020201",1,1));
//        else
//            System.out.println("checkCertainProduct(1).getProduct_name()");
//        List<Product> list = findTypeProduct("饮料");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getProduct_name());
//        }
    }
}
