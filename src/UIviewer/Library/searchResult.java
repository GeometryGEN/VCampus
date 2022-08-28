package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.*;

import java.awt.Robot;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import DAO.Library.Book_borrower;
import UIhandler.Library.Client_library;

public class searchResult extends JPanel {

    public static volatile String[][] searchresult=null;
    public searchResult(){
        setLayout(null);
        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家", "是否可借","归还日期","馆藏地","借阅"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(searchresult, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table_want.getSelectedColumn()==8){
                    Book_borrower book=new Book_borrower();
                    try {
                        String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                        book.setId(id);
                        System.out.println(id);
                        Client_library.reqireBorrow(book);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        table_want.setRowHeight(30);
    }
}