package UIviewer.SelectCourse;

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
public class Search_result extends JPanel{
    public static volatile String[][] search_result=null;
    public Search_result()
    {
        setLayout(null);
        String[] tableTitle = {"课程编号","课程名","时间", "学分","老师","地点"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(search_result, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);

    }
}
