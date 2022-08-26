package DAO.Library;

import java.io.Serializable;

public class Punishment implements Serializable {
    String Customer_iD;  //处罚用户id
    String Book_id;  //赔偿书目id
    String notice;  //处罚通知
    double price;// 赔偿金额
    int status;//status=0没处理 status=1已处理
}
