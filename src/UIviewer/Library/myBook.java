package UIviewer.Library;
import UIhandler.Library.Client_library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myBook extends JPanel {
    public volatile String[][] myBook=null;
    public myBook(){
        /*setLayout(null);
        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","借出日期","应还日期","归还","续借"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(Client_library.ret_my_books, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);
        table_want.getColumnModel().getColumn(7).setCellRenderer(new MyButtonRender());
        table_want.getColumnModel().getColumn(8).setCellRenderer(new MyButtonRender1());*/
    }
    public void list_books(){
        setLayout(null);
        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","借出日期","应还日期","归还","续借"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(Client_library.ret_my_books, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);
        table_want.getColumnModel().getColumn(7).setCellRenderer(new MyButtonRender());
        table_want.getColumnModel().getColumn(8).setCellRenderer(new MyButtonRender1());
    }
}