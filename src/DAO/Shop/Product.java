package DAO.Shop;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [商店中的商品类]
 * @createTime : [2022.08.19 15:55]
 */
public class Product {
    String Product_name;
    int Product_id;
    double Product_price;
    int Product_currentNumbers;
    int Product_sumNumbers;
    Boolean Product_takeaway;
    int Product_toshop;
    String Product_type;

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    public double getProduct_price() {
        return Product_price;
    }

    public void setProduct_price(double product_price) {
        Product_price = product_price;
    }

    public int getProduct_currentNumbers() {
        return Product_currentNumbers;
    }

    public void setProduct_currentNumbers(int product_currentNumbers) {
        Product_currentNumbers = product_currentNumbers;
    }

    public int getProduct_sumNumbers() {
        return Product_sumNumbers;
    }

    public void setProduct_sumNumbers(int product_sumNumbers) {
        Product_sumNumbers = product_sumNumbers;
    }

    public Boolean getProduct_takeaway() {
        return Product_takeaway;
    }

    public void setProduct_takeaway(Boolean product_takeaway) {
        Product_takeaway = product_takeaway;
    }

    public int getProduct_toshop() {
        return Product_toshop;
    }

    public void setProduct_toshop(int product_toshop) {
        Product_toshop = product_toshop;
    }

    public String getProduct_type() {
        return Product_type;
    }

    public void setProduct_type(String product_type) {
        Product_type = product_type;
    }
}
