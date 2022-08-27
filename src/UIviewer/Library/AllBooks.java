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

    public static String[][] tableDate;
    public AllBooks(){
        setLayout(null);
                //System.out.println(tableDate[1][1]);
                String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","价格", "是否可借","借出日期","借书人","归还日期","馆藏地"};
                //数据
                DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
                JTable table_want = new JTable(dtm);
                //支持滚动
                JScrollPane jsp = new JScrollPane(table_want);
                jsp.setBounds(0,0,1280,680);
                add(jsp);
    }
}