package UIhandler.Shop;

import java.util.List;
import ClientToServer.ManageClientToServerThread;
import DAO.Shop.Product;
import User.Admin;
import User.Student;
import message.Message;
import message.MessageType;
import utils.MyObjectOutputStream;

public class Client_shop {

    public static String id;    //区分 1：学生  2：老师  3：管理员

    public static String idcard;                   //当前已登录账号的那个对象一卡通

    public static List<Product> products;          //存放所有商品

    public static String sign_delete;             //商品是否删除成功的标志 1 正在删除  2 成功  3 失败
    public static Boolean sign_zero ;              //查找了但数据库有-1 或者没有-0

    public static String sign_find_type;          //商品找到的标志 1 正在找  2 成功  3 失败
    public static List<Product> checkproducts;     //查找得到的商品

    public static List<Product> checkproductsType;   //按照类型查找得到的商品


    //////////////////记得每次点击按钮先reset null

    public static void resetSign_delete(){
        sign_find_type="1";
    }

    public static void resetSign_find_tpye(){
        sign_delete="1";
    }

    public static void resetSign_zero(){
        sign_zero=true;
    }

    public static void resetAllProducts(){
        products.clear();
    }

    public static void resetCheckedProducts(){
        checkproducts.clear();
    }

    public static void resetCheckedtypeProducts(){
        checkproductsType.clear();
    }

    public static String getSign_find_type() {
        return sign_find_type;
    }

    public static void setSign_find_type(String sign_find_type) {
        Client_shop.sign_find_type = sign_find_type;
    }

    public static List<Product> getCheckproductsType() {
        return checkproductsType;
    }

    public static void setCheckproductsType(List<Product> checkproductsType) {
        Client_shop.checkproductsType = checkproductsType;
    }

    public static Boolean getSign() {
        return sign_zero;
    }

    public static void setSign(Boolean sign) {
        Client_shop.sign_zero = sign;
    }

    public static String getSign_delete() {
        return sign_delete;
    }

    public static void setSign_delete(String sign_delete) {
        Client_shop.sign_delete = sign_delete;
    }

    public static List<Product> getCheckproducts() {
        return checkproducts;
    }

    public static void setCheckproducts(List<Product> checkproducts) {
        Client_shop.checkproducts = checkproducts;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Client_shop.id = id;
    }

    public static String getIdcard() {
        return idcard;
    }

    public static void setIdcard(String idcard) {
        Client_shop.idcard = idcard;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        Client_shop.products = products;
    }

    public static List<Product> returnAllProduct() throws Exception {
        setSign(true);
        setSign_delete("1");
        setSign_find_type("1");
        Message message = new Message();
        message.setType(MessageType.RETURN_ALL_PRODUCT);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (products.size() == 0) Thread.onSpinWait();
        return products;
    }

    public static List<Product> checkProduct(String name) throws Exception {
        Message message = new Message();
        message.setType(MessageType.FIND_PRODUCT);
        message.setSender(name);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (checkproducts.size() == 0 && sign_zero) Thread.onSpinWait();
        return checkproducts;
    }

    //商品Product_id唯一
    public static Boolean deleteProduct(String id) throws Exception {
        Message message = new Message();
        message.setType(MessageType.DELETE_PRODUCT);
        message.setSender(id);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_delete.equals("1")) Thread.onSpinWait();
        return sign_delete.equals("2");
    }

    public static List<Product> checktypeProduct(String type_name) throws Exception {
        Message message = new Message();
        message.setType(MessageType.FIND_TYPE_PRODUCT);
        message.setSender(type_name);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_find_type.equals("1")) Thread.onSpinWait();
        return checkproductsType;
    }

}
