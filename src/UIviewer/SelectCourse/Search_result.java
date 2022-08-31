package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
public class Search_result extends JPanel{
    public static volatile String[][] search_result=null;
    public Search_result()
    {
        setLayout(null);
        String[] tableTitle = {"课程编号","课程名","时间", "学分","老师","地点"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(search_result, tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.setFont(new Font("宋体",Font.BOLD,24));
        table_want.getColumnModel().getColumn(0).setPreferredWidth(120);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(400);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(70);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(220);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(130);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,420);
        add(jsp);

        table_want.setRowHeight(40);
        setVisible(true);

        table_want.setFont(new Font("宋体",Font.BOLD,16));
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                        setBackground(Color.white);
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            };

            for (int i = 0; i < table_want.getColumnCount(); i++)
            {
                table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
