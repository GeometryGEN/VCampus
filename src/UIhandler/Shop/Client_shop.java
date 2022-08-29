package UIhandler.Shop;

import java.io.IOException;
import java.util.ArrayList;
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

    public static String idcard;         //当前已登录账号的那个对象一卡通

    public static String Buyed;          //商品 1 正在找  2 成功  3 失败

    public static String Now_Buy_product;  //商品 1 正在找  2 成功  3 失败

    public static String sign_Now_Buy_money_enough;  //商品 1 正在找  2 成功  3 失败
    public static String Buyed_num;      //商品 1 正在找  2 成功  3 失败
    public static String ReadyToBuy;          //商品 1 正在找  2 成功  3 失败

    public static String ReadyToBuy_num;      //商品 1 正在找  2 成功  3 失败
    public static List<Product> products;          //存放所有商品

    public static Product CertainProducts;          //存放特定商品
    public static String sign_Certain;              //商品 1 正在找  2 成功  3 失败

    public static String sign_delete;             //商品是否删除成功的标志 1 正在删除  2 成功  3 失败
    public static Boolean sign_zero ;              //查找了但数据库有-1 或者没有-0

    public static String sign_add;             //商品是否add成功的标志 1 正在add  2 成功  3 失败
    public static String sign_find_type;          //商品找到的标志 1 正在找  2 成功  3 失败
    public static List<Product> checkproducts;     //查找得到的商品

    public static List<Product> checkproductsType;   //按照类型查找得到的商品


    //////////////////记得每次点击按钮先reset null

    public static void resetCertainProduct_sign(){
        sign_Certain="1";
    }
    public static void resetSign_add(){
        sign_add="1";
    }
    public static void resetSign_delete(){
        sign_find_type="1";
    }

    public static void resetNow_Buy_money_enough(){
        sign_Now_Buy_money_enough="1";
    }
    public static void resetNowBuyProduct(){
        Now_Buy_product="1";
    }
    public static void resetBuyedNum(){
        Buyed_num="1";
    }

    public static void resetReadyToBuyNum(){
        ReadyToBuy_num="1";
    }

    public static void resetSign_find_tpye(){
        sign_delete="1";
    }

    public static void resetBuyed(){
        Buyed="1";
    }

    public static void resetReadytoBuy(){
        ReadyToBuy="1";
    }

    public static void resetSign_zero(){
        sign_zero=true;
    }

    public static void resetCertainProducts(){
        products=null;
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

    public static Product getCertainProducts() {
        return CertainProducts;
    }

    public static void setCertainProducts(Product certainProducts) {
        CertainProducts = certainProducts;
    }

    public static String getBuyed_num() {
        return Buyed_num;
    }

    public static void setBuyed_num(String buyed_num) {
        Buyed_num = buyed_num;
    }

    public static String getSign_Now_Buy_money_enough() {
        return sign_Now_Buy_money_enough;
    }

    public static void setSign_Now_Buy_money_enough(String sign_Now_Buy_money_enough) {
        Client_shop.sign_Now_Buy_money_enough = sign_Now_Buy_money_enough;
    }

    public static String getReadyToBuy_num() {
        return ReadyToBuy_num;
    }

    public static void setReadyToBuy_num(String readyToBuy_num) {
        ReadyToBuy_num = readyToBuy_num;
    }

    public static String getNow_Buy_product() {
        return Now_Buy_product;
    }

    public static void setNow_Buy_product(String now_Buy_product) {
        Now_Buy_product = now_Buy_product;
    }

    public static String getSign_Certain() {
        return sign_Certain;
    }

    public static void setSign_Certain(String sign_Certain) {
        Client_shop.sign_Certain = sign_Certain;
    }

    public static String getBuyed() {
        return Buyed;
    }

    public static void setBuyed(String buyed) {
        Buyed = buyed;
    }

    public static String getReadyToBuy() {
        return ReadyToBuy;
    }

    public static void setReadyToBuy(String readyToBuy) {
        ReadyToBuy = readyToBuy;
    }

    public static String getSign_add() {
        return sign_add;
    }

    public static void setSign_add(String sign_add) {
        Client_shop.sign_add = sign_add;
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

    //刚开始登录界面就显示所有的商品
    public static List<Product> returnAllProduct() throws Exception {
        setSign(true);
        setSign_delete("1");
        setSign_find_type("1");
        setSign_add("1");
        Message message = new Message();
        message.setType(MessageType.RETURN_ALL_PRODUCT);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送对象
        oos.writeObject(message);
        //等待接受
        while (products.size() == 0) Thread.onSpinWait();
        return products;
    }

    public static List<Product> checkProduct(String name) throws Exception {
        Message message = new Message();
        message.setType(MessageType.FIND_PRODUCT);
        message.setSender(name);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送对象
        oos.writeObject(message);
        //等待接受
        while (checkproducts.size() == 0 && sign_zero) Thread.onSpinWait();
        return checkproducts;
    }

    //返回的Product 可能为null!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static Product checkCertainProduct(int id_product) throws Exception {
        resetCertainProducts();
        resetCertainProduct_sign();
        Message message = new Message();
        message.setType(MessageType.CHECK_CERTAIN_PRODUCT);
        message.setSender(String.valueOf(id_product));
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送对象
        oos.writeObject(message);
        //等待接受
        while ( sign_Certain.equals("1")) Thread.onSpinWait();
        return CertainProducts;
    }

    //商品Product_id唯一
    public static Boolean deleteProduct(String id) throws Exception {
        resetSign_delete();
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
        resetCheckedProducts();
        resetSign_find_tpye();
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

    public static Boolean addProduct(Product p) throws Exception{
        resetSign_add();
        Message message = new Message();
        message.setType(MessageType.ADD_PRODUCT);
        message.setData(p);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_add.equals("1")) Thread.onSpinWait();
        return sign_add.equals("2");
    }

    //购买商品  ui里先进行判断够不够，余额够不够，这里只更改信息 money为修改之后的钱, num为当前数量，修改后的!!!!!
    public static Boolean buyProduct(String user_idcard, String id, int num, double money) throws Exception {
        Message message = new Message();
        message.setType(MessageType.BUY_CERTAIN_PRODUCT);
        message.setGetter(user_idcard); //用户id
        message.setSender(id);  //商品id
        message.setCode(num);   //商品数量
        message.setMoney(money); //商品总价格
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (Now_Buy_product.equals("1")) Thread.onSpinWait();

        return Now_Buy_product.equals("2");
    }


    public static String checkBuyed(String idcard) throws IOException {
        resetBuyed();
        Message message = new Message();
        message.setType(MessageType.CHECK_BUYED_PRODUCT);
        message.setSender(idcard);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (Buyed.equals("1")) Thread.onSpinWait();
        return Buyed;
    }

    public static String checkBuyedNum(String idcard) throws IOException {
        resetBuyed();
        Message message = new Message();
        message.setType(MessageType.CHECK_BUYED_PRODUCT_NUM);
        message.setSender(idcard);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (Buyed.equals("1")) Thread.onSpinWait();
        return Buyed;
    }

    public static String readyToBuy(String idcard) throws IOException {
        resetReadytoBuy();
        Message message = new Message();
        message.setType(MessageType.CHECK_READYTOBUY_PRODUCT);
        message.setSender(idcard);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (ReadyToBuy.equals("1")) Thread.onSpinWait();
        return ReadyToBuy;
    }

    public static String readyToBuyNum(String idcard) throws IOException {
        resetReadyToBuyNum();
        Message message = new Message();
        message.setType(MessageType.CHECK_READYTOBUY_PRODUCT_NUM);
        message.setSender(idcard);
        //得到Object对象
        MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (ReadyToBuy.equals("1")) Thread.onSpinWait();
        return ReadyToBuy;
    }



}
