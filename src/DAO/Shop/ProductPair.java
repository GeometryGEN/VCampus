package DAO.Shop;

import java.io.Serializable;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.30 20:30]
 */
public class ProductPair implements Serializable {

    public int id;   //商品id
    public int num;  //商品数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
