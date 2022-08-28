package UIviewer.Library;
import DAO.Library.Book_borrower;
import UIhandler.Library.Client_library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class myBook extends JPanel {

    public static volatile String[][] myBook=null;
    public myBook(){
        setLayout(null);
        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","借出日期","应还日期","归还","续借"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(myBook, tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table_want.getSelectedColumn()==7){
                    Book_borrower book=new Book_borrower();
                    try {
                        String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                        System.out.println(id);
                        Client_library.reqireReturn(book);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if(table_want.getSelectedColumn()==8){
                    Book_borrower book=new Book_borrower();
                    try {
                        String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                        System.out.println(id);
                        Client_library.reqireExtend(book);
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
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);
    }
    public void list_books(){
        setLayout(null);
        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","借出日期","应还日期","归还","续借"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(Client_library.ret_my_books, tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    if(table_want.getSelectedColumn()==7){
                        Book_borrower book=new Book_borrower();
                        try {
                            String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                            Client_library.reqireReturn(book);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        System.out.println(table_want.getSelectedRow());
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

        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);



        table_want.setRowHeight(30);
        //table_want.getColumnModel().getColumn(7).setCellRenderer(new MyButtonRender("10010"));
        //table_want.getColumnModel().getColumn(8).setCellRenderer(new MyButtonRender1());
    }
}