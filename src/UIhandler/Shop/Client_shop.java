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

import javax.swing.*;

/**
 * 客户车间
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
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

    /**
     * 设置oos
     *
     * @param mos 金属氧化物半导体
     */
    public static void setOos(MyObjectOutputStream mos) {
        Client_shop.oos = mos;
    }

    //////////////////记得每次点击按钮先reset null

    /**
     * 现在重新购买产品
     */
    public static void resetNow_Buy_product(){
        Now_Buy_product="正在买";
    }

    /**
     * 重置特定产品标志
     */
    public static void resetCertainProduct_sign(){
        sign_Certain="1";
    }

    /**
     * 重置符号加
     */
    public static void resetSign_add(){
        sign_add="1";
    }

    /**
     * 重置符号删除
     */
    public static void resetSign_delete(){
        sign_delete="1";
    }

    /**
     * 重置符号找到打字
     */
    public static void resetSign_find_tpye(){
        sign_find_type="1";
    }

    /**
     * 重新购买
     */
    public static void resetBuyed(){
        Buyed=null;
    }

    /**
     * 重置准备买
     */
    public static void resetReadytoBuy(){
        ReadyToBuy=null;
    }

    /**
     * 重置符号零
     */
    public static void resetSign_zero(){
        sign_zero=true;
    }

    /**
     * 重置某些产品
     */
    public static void resetCertainProducts(){
        CertainProducts=null;
    }

    /**
     * 重置所有产品
     */
    public static void resetAllProducts(){
        products=null;
    }

    /**
     * 重新检查产品
     */
    public static void resetCheckedProducts(){
            checkproducts=null;
    }

    /**
     * 重置checkedtype产品
     */
    public static void resetCheckedtypeProducts(){
        checkproductsType=null;
    }

    /**
     * 得到某些产品
     *
     * @return {@link Product}
     */
    public static Product getCertainProducts() {
        return CertainProducts;
    }

    /**
     * 得到当前钱
     *
     * @return double
     */
    public static double getCurrent_money() {
        return current_money;
    }

    /**
     * 设置当前钱
     *
     * @param current_money 现在钱
     */
    public static void setCurrent_money(double current_money) {
        Client_shop.current_money = current_money;
    }

    /**
     * 设置某些产品
     *
     * @param certainProducts 某些产品
     */
    public static void setCertainProducts(Product certainProducts) {
        CertainProducts = certainProducts;
    }

    /**
     * 得到某些迹象
     *
     * @return {@link String}
     */
    public static String getSign_Certain() {
        return sign_Certain;
    }

    /**
     * 设置某些迹象
     *
     * @param sign_Certain 某些迹象
     */
    public static void setSign_Certain(String sign_Certain) {
        Client_shop.sign_Certain = sign_Certain;
    }

    /**
     * 获得购买
     *
     * @return {@link List}<{@link ProductPair}>
     */
    public static List<ProductPair> getBuyed() {
        return Buyed;
    }

    /**
     * 设置买
     *
     * @param buyed 买
     */
    public static void setBuyed(List<ProductPair> buyed) {
        Buyed = buyed;
    }

    /**
     * 准备买
     *
     * @return {@link List}<{@link ProductPair}>
     */
    public static List<ProductPair> getReadyToBuy() {
        return ReadyToBuy;
    }

    /**
     * 设置准备买
     *
     * @param readyToBuy 准备买
     */
    public static void setReadyToBuy(List<ProductPair> readyToBuy) {
        ReadyToBuy = readyToBuy;
    }

    /**
     * 得到信号添加
     *
     * @return {@link String}
     */
    public static String getSign_add() {
        return sign_add;
    }

    /**
     * 设置标志添加
     *
     * @param sign_add 标志添加
     */
    public static void setSign_add(String sign_add) {
        Client_shop.sign_add = sign_add;
    }

    /**
     * 得到信号找到类型
     *
     * @return {@link String}
     */
    public static String getSign_find_type() {
        return sign_find_type;
    }

    /**
     * 设置标志找到类型
     *
     * @param sign_find_type 找到信号类型
     */
    public static void setSign_find_type(String sign_find_type) {
        Client_shop.sign_find_type = sign_find_type;
    }

    /**
     * 得到checkproducts类型
     *
     * @return {@link List}<{@link Product}>
     */
    public static List<Product> getCheckproductsType() {
        return checkproductsType;
    }

    /**
     * 设置checkproducts类型
     *
     * @param checkproductsType checkproducts类型
     */
    public static void setCheckproductsType(List<Product> checkproductsType) {
        Client_shop.checkproductsType = checkproductsType;
    }

    /**
     * 得到签
     *
     * @return {@link Boolean}
     */
    public static Boolean getSign() {
        return sign_zero;
    }

    /**
     * 设置标志
     *
     * @param sign 标志
     */
    public static void setSign(Boolean sign) {
        Client_shop.sign_zero = sign;
    }

    /**
     * 得到删除标志
     *
     * @return {@link String}
     */
    public static String getSign_delete() {
        return sign_delete;
    }

    /**
     * 设置删除标志
     *
     * @param sign_delete 删除标志
     */
    public static void setSign_delete(String sign_delete) {
        Client_shop.sign_delete = sign_delete;
    }

    /**
     * 得到checkproducts
     *
     * @return {@link List}<{@link Product}>
     */
    public static List<Product> getCheckproducts() {
        return checkproducts;
    }

    /**
     * 设置checkproducts
     *
     * @param checkproducts checkproducts
     */
    public static void setCheckproducts(List<Product> checkproducts) {
        Client_shop.checkproducts = checkproducts;
    }

    /**
     * 得到id
     *
     * @return {@link String}
     */
    public static String getId() {
        return id;
    }

    /**
     * 组id
     *
     * @param id id
     */
    public static void setId(String id) {
        Client_shop.id = id;
    }

    /**
     * 有经办人身份证
     *
     * @return {@link String}
     */
    public static String getIdcard() {
        return idcard;
    }

    /**
     * 设置经办人身份证
     *
     * @param idcard 经办人身份证
     */
    public static void setIdcard(String idcard) {
        Client_shop.idcard = idcard;
    }

    /**
     * 得到信号零
     *
     * @return {@link Boolean}
     */
    public static Boolean getSign_zero() {
        return sign_zero;
    }

    /**
     * 设置信号零
     *
     * @param sign_zero 0标志
     */
    public static void setSign_zero(Boolean sign_zero) {
        Client_shop.sign_zero = sign_zero;
    }

    /**
     * 获得产品
     *
     * @return {@link List}<{@link Product}>
     */
    public static List<Product> getProducts() {
        return products;
    }

    /**
     * 现在买产品
     *
     * @return {@link String}
     */
    public static String getNow_Buy_product() {
        return Now_Buy_product;
    }

    /**
     * 现在设置购买产品
     *
     * @param now_Buy_product 现在购买产品
     */
    public static void setNow_Buy_product(String now_Buy_product) {
        Now_Buy_product = now_Buy_product;
    }

    /**
     * 集产品
     *
     * @param products 产品
     */
    public static void setProducts(List<Product> products) {
        Client_shop.products = products;
    }

    /**
     * 返回所有产品
     *
     * @return {@link List}<{@link Product}>
     * @throws Exception 异常
     *///刚开始登录界面就显示所有的商品
    public static List<Product> returnAllProduct() throws Exception {
        setSign(true);
        resetAllProducts();
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

    /**
     * 检查产品
     *
     * @param name 名字
     * @return {@link List}<{@link Product}>
     * @throws Exception 异常
     */
    public static List<Product> checkProduct(String name) throws Exception {
        resetSign_find_tpye();
        Message message = new Message();
        message.setType(MessageType.FIND_PRODUCT);
        message.setSender(name);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送对象
        oos.writeObject(message);
        //等待接受
        while (sign_find_type.equals("1")) Thread.onSpinWait();
        return checkproducts;
    }

    /**
     * 检查特定产品
     *
     * @param id_product 标识产品
     * @return {@link Product}
     * @throws Exception 异常
     *///返回的Product 可能为null!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

    /**
     * 删除产品
     *
     * @param id id
     * @return {@link Boolean}
     * @throws Exception 异常
     *///商品Product_id唯一
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

    /**
     * checktype产品
     *
     * @param type_name 类型名称
     * @return {@link List}<{@link Product}>
     * @throws Exception 异常
     */
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

    /**
     * 添加产品
     *
     * @param p p
     * @return boolean
     * @throws Exception 异常
     */
    public static boolean addProduct(Product p) throws Exception{
        resetSign_add();
        Message message = new Message();
        message.setType(MessageType.ADD_PRODUCT);
        message.setData(p);
        oos.writeObject(message);
        //等待接受学生
        while (sign_add.equals("1")) Thread.onSpinWait();
        return sign_add.equals("2");
    }

    /**
     * 购买产品
     *
     * @param user_idcard 用户经办人身份证
     * @param id          id
     * @param num         全国矿工工会
     * @param money       钱
     * @return boolean
     * @throws Exception 异常
     *///购买商品  ui里先进行判断够不够，余额够不够，这里只更改信息 money为修改之后的钱
    public static boolean buyProduct(String user_idcard, String id, int num, double money) throws Exception {
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
        if(Now_Buy_product.equals("数量不够"))
            JOptionPane.showMessageDialog(null,"数量不够！");
        return Now_Buy_product.equals("购买成功");
    }

    /**
     * 购买产品老师
     *
     * @param user_idcard 用户经办人身份证
     * @param id          id
     * @param num         全国矿工工会
     * @param money       钱
     * @return boolean
     * @throws Exception 异常
     */
    public static boolean buyProduct_Teacher(String user_idcard, String id, int num, double money) throws Exception {
        resetNow_Buy_product();
        Message message = new Message();
        message.setType(MessageType.BUY_CERTAIN_PRODUCT_TEACHER);
        message.setGetter(user_idcard); //用户id
        message.setSender(id);  //商品id
        message.setCode(num);   //商品数量
        message.setMoney(money); //商品总价格
        oos.writeObject(message);
        while (Now_Buy_product.equals("正在买")) Thread.onSpinWait();
        if(Now_Buy_product.equals("数量不够"))
            JOptionPane.showMessageDialog(null,"数量不够！");
        return Now_Buy_product.equals("购买成功");
    }


    /**
     * 增加商店车
     *
     * @param user_idcard 用户经办人身份证
     * @param id          id
     * @param num         全国矿工工会
     * @return {@link Boolean}
     * @throws Exception 异常
     */
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

    /**
     * 检查购买
     *
     * @param idcard 经办人身份证
     * @return {@link List}<{@link ProductPair}>
     * @throws IOException ioexception
     */
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

    /**
     * 检查准备买
     *
     * @param idcard 经办人身份证
     * @return {@link List}<{@link ProductPair}>
     * @throws IOException ioexception
     */
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

    /**
     * 删除准备买
     *
     * @param idcard 经办人身份证
     * @param id     id
     * @param num    全国矿工工会
     * @return boolean
     * @throws IOException ioexception
     */
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
        return sign_delete.equals("2");
    }

    /**
     * 得到钱
     *
     * @param idcard 经办人身份证
     * @return double
     * @throws IOException ioexception
     */
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

    /**
     * 得到钱老师
     *
     * @param idcard 经办人身份证
     * @return double
     * @throws IOException ioexception
     */
    public static double getMoney_Teacher(String idcard) throws IOException {
        resetSign_delete();
        Message message = new Message();
        message.setType(MessageType.GET_MONEY_TEACHER);
        message.setSender(idcard);
        //得到Object对象
        //MyObjectOutputStream oos = new MyObjectOutputStream(ManageClientToServerThread.getThread(idcard).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //等待接受学生
       // System.out.println("@@@@@");
        while (sign_delete.equals("1")) Thread.onSpinWait();
       // System.out.println("22222222");
        return current_money;
    }

//    public static void main(String[]a) throws IOException {
//        System.out.println(getMoney("09020201"));
//    }

}
