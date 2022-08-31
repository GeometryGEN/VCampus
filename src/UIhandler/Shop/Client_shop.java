package UIhandler.Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ClientToServer.ManageClientToServerThread;
import DAO.Shop.Product;
import DAO.Shop.ProductPair;
import User.Admin;
import User.Student;
import message.Message;
import message.MessageType;
import utils.MyObjectOutputStream;

public class Client_shop {

    public static String id;    //区分 1：学生  2：老师  3：管理员

    public static double current_money;
    public static String idcard;         //当前已登录账号的那个对象一卡通
    public static List<ProductPair> Buyed;               //商品 1 正在找  2 成功  3 失败
    public static List<ProductPair> ReadyToBuy;          //商品 1 正在找  2 成功  3 失败
    public static List<Product> products;          //存放所有商品
    public static Product CertainProducts;          //存放特定商品

    public static String Now_Buy_product;     //要买的商品
    public static String sign_Certain;              //商品 1 正在找  2 成功  3 失败

    public static String sign_delete;             //商品是否删除成功的标志 1 正在删除  2 成功  3 失败
    public static Boolean sign_zero ;              //查找了但数据库有-1 或者没有-0

    public static String sign_add;             //商品是否add成功的标志 1 正在add  2 成功  3 失败
    public static String sign_find_type;          //商品找到的标志 1 正在找  2 成功  3 失败
    public static List<Product> checkproducts;     //查找得到的商品

    public static List<Product> checkproductsType;   //按照类型查找得到的商品

    static MyObjectOutputStream oos=null;

    public static void setOos(MyObjectOutputStream mos) {
        Client_shop.oos = mos;
    }

    //////////////////记得每次点击按钮先reset null

    public static void resetNow_Buy_product(){
        Now_Buy_product="正在买";
    }
    public static void resetCertainProduct_sign(){
        sign_Certain="1";
    }
    public static void resetSign_add(){
        sign_add="1";
    }
    public static void resetSign_delete(){
        sign_delete="1";
    }

    public static void resetSign_find_tpye(){
        sign_delete="1";
    }

    public static void resetBuyed(){
        Buyed=null;
    }

    public static void resetReadytoBuy(){
        ReadyToBuy=null;
    }

    public static void resetSign_zero(){
        sign_zero=true;
    }

    public static void resetCertainProducts(){
        CertainProducts=null;
    }
    public static void resetAllProducts(){
        products=null;
    }
    public static void resetCheckedProducts(){
            checkproducts=null;
    }

    public static void resetCheckedtypeProducts(){
        checkproductsType=null;
    }

    public static Product getCertainProducts() {
        return CertainProducts;
    }

    public static double getCurrent_money() {
        return current_money;
    }

    public static void setCurrent_money(double current_money) {
        Client_shop.current_money = current_money;
    }

    public static void setCertainProducts(Product certainProducts) {
        CertainProducts = certainProducts;
    }

    public static String getSign_Certain() {
        return sign_Certain;
    }

    public static void setSign_Certain(String sign_Certain) {
        Client_shop.sign_Certain = sign_Certain;
    }

    public static List<ProductPair> getBuyed() {
        return Buyed;
    }

    public static void setBuyed(List<ProductPair> buyed) {
        Buyed = buyed;
    }

    public static List<ProductPair> getReadyToBuy() {
        return ReadyToBuy;
    }

    public static void setReadyToBuy(List<ProductPair> readyToBuy) {
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

    public static Boolean getSign_zero() {
        return sign_zero;
    }

    public static void setSign_zero(Boolean sign_zero) {
        Client_shop.sign_zero = sign_zero;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static String getNow_Buy_product() {
        return Now_Buy_product;
    }

    public static void setNow_Buy_product(String now_Buy_product) {
        Now_Buy_product = now_Buy_product;
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
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送对象
        oos.writeObject(message);
        //等待接受
        while (products==null) Thread.onSpinWait();
        return products;
    }

    public static List<Product> checkProduct(String name) throws Exception {
        Message message = new Message();
        message.setType(MessageType.FIND_PRODUCT);
        message.setSender(name);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
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
        message.setCode(id_product);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
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
        // oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
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
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
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
        // oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_add.equals("1")) Thread.onSpinWait();
        return sign_add.equals("2");
    }

    //购买商品  ui里先进行判断够不够，余额够不够，这里只更改信息 money为修改之后的钱
    public static Boolean buyProduct(String user_idcard, String id, int num, double money) throws Exception {
        resetNow_Buy_product();
        Message message = new Message();
        message.setType(MessageType.BUY_CERTAIN_PRODUCT);
        message.setGetter(user_idcard); //用户id
        message.setSender(id);  //商品id
        message.setCode(num);   //商品数量
        message.setMoney(money); //商品总价格
        //得到Object对象
        // oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (Now_Buy_product.equals("正在买")) Thread.onSpinWait();

        return Now_Buy_product.equals("购买成功");
    }

    public static Boolean addToShopCar(String user_idcard, int id, int num) throws Exception {
        resetSign_add();
        resetNow_Buy_product();
        Message message = new Message();
        ProductPair t = new ProductPair();
        t.setId(id);t.setNum(num);
        message.setType(MessageType.ADD_TO_SHOPCAR);
        message.setSender(user_idcard);  //用户id
        message.setData(t);   //商品数量
        //得到Object对象
        // oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_add.equals("1")) Thread.onSpinWait();
        return sign_add.equals("2");
    }

    public static List<ProductPair> checkBuyed(String idcard) throws IOException {
        resetBuyed();
        resetSign_zero();
        Message message = new Message();
        message.setType(MessageType.CHECK_BUYED_PRODUCT);
        message.setSender(idcard);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_zero) Thread.onSpinWait();
        return Buyed;
    }

    public static List<ProductPair> checkReadyToBuy(String idcard) throws IOException {
        resetReadytoBuy();
        resetSign_zero();
        Message message = new Message();
        message.setType(MessageType.CHECK_READYTOBUY_PRODUCT);
        message.setSender(idcard);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_zero) Thread.onSpinWait();
        return ReadyToBuy;
    }

    public static boolean deleteReadyToBuy(String idcard, int id, int num) throws IOException {
        resetSign_delete();
        ProductPair p = new ProductPair();p.setNum(num);p.setId(id);
        Message message = new Message();
        message.setType(MessageType.DELETE_READYTPBUY_PRODUCT);
        message.setData(p);
        message.setSender(idcard);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_delete.equals("1")) Thread.onSpinWait();
        return false;
    }

    public static double getMoney(String idcard) throws IOException {
        resetSign_delete();
        Message message = new Message();
        message.setType(MessageType.GET_MONEY);
        message.setSender(idcard);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
        while (sign_delete.equals("1")) Thread.onSpinWait();
        return current_money;
    }

//    public static void main(String[]a) throws IOException {
//        System.out.println(getMoney("09020201"));
//    }

}
