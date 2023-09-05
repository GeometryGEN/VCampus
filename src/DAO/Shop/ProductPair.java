package DAO.Shop;

import java.io.Serializable;

/**
 * The type Product pair.
 * @description : [商店已购信息以及准备购买物品信息类]
 */
public class ProductPair implements Serializable {

    public int id; //商品id
    public int num; //商品购买数量

    public int getId() { //返回商品id
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getNum() { //返回商品购买数量
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}