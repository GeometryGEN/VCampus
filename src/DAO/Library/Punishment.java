package DAO.Library;

import java.io.Serializable;

public class Punishment implements Serializable {
    String punishmentID;
    String Customer_iD;  //处罚用户id

    String Book_id;

    String notice;  //处罚通知
    double price;// 赔偿金额
    int status;//status=0没处理 status=1已处理



    public String getBook_id() {
        return Book_id;
    }

    public void setBook_id(String book_id) {
        Book_id = book_id;
    }

    public String getPunishmentID() {
        return punishmentID;
    }

    public void setPunishmentID(String punishmentID) {
        this.punishmentID = punishmentID;
    }

    public String getCustomer_iD() {
        return Customer_iD;
    }

    public void setCustomer_iD(String customer_iD) {
        Customer_iD = customer_iD;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
