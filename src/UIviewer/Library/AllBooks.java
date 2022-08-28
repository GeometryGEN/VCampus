package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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




        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","价格", "是否可借","借出日期","借书人","归还日期","馆藏地"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        JTable table_want = new JTable(dtm)
        {
         public boolean isCellEditable(int row, int column) {
          return false;
         }
        };
        table_want.setOpaque(false);
        table_want.setRowHeight(30);
        Font myfont1 = new Font("宋体", Font.PLAIN, 14);
        table_want.setFont(myfont1);
        //table_want.setForeground(new Color(255,255,255));

        //支持滚动
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(table_want);
        jsp.getViewport().setOpaque(false);//将JScrollPane设置为透明
        jsp.setOpaque(false);//将中间的viewport设置为透明
        jsp.setBounds(0,0,1280,680);
        jsp.setBackground(new Color(255, 240, 245, 80));

        add(jsp);



        //左侧面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1280, 650);
        //p1.setBackground(null);
        p1.setBackground(new Color(255, 240, 245, 10));
        //panel1.BackColor = Color.FromArgb(80, 255, 0, 0);
        //p1.setOpaque(false);
        add(p1);
/*
     JPanel p11=new JPanel();
     p11.setBounds(0,0,1280,650);
     JLabel pic1 = new JLabel();
     ImageIcon icon1 = new ImageIcon("src/image/background4.jpg");
     pic1.setIcon(icon1);
     pic1.setBounds(0,0 , 1300, 650);
     p11.add(pic1);
     add(p11);

 */



     DefaultTableCellRenderer render = new DefaultTableCellRenderer();
     render.setOpaque(false); //将渲染器设置为透明
     //将这个渲染器设置到fileTable里。这个设置在没有另外专门对column设置的情况下有效
     //若你对某个column特殊指定了渲染器，则对于这个column，它将不调用render渲染器
     //因此为了保证透明，如果你对column额外指定了渲染器，那么在额外的渲染器里也应该设置透明
     table_want.setDefaultRenderer(Object.class,render);



        //jsp.setOpaque(false);
        //jsp.getViewport().setOpaque(false);




    }
}