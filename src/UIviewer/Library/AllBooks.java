package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

import java.awt.Robot;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import UIhandler.Library.Client_library;

public class AllBooks extends JPanel {

    public static volatile String[][] tableDate=null;
    public AllBooks(){
       setLayout(null);
       //System.out.println(tableDate[1][1]);
        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","价格", "是否可借","借出日期","借书人","归还日期","馆藏地"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        JTable table_want = new JTable(dtm)
        {
         public boolean isCellEditable(int row, int column) {
          return false;
         }
        };
        table_want.setRowHeight(30);
        Font myfont1 = new Font("宋体", Font.PLAIN, 14);
        table_want.setFont(myfont1);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        jsp.setBackground(new Color(255, 240, 245, 180));
        add(jsp);




        //jsp.setOpaque(false);
        //jsp.getViewport().setOpaque(false);



        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/main4.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);
        add(p11);
        System.out.println("all books listed");
    }
}