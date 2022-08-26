package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UIhandler.Library.Client_library;

public class AllBooks extends JPanel {
    public static String[][] tableDate;
    public AllBooks(){
        setLayout(null);
        String[] tableTitle = {"书名", "作者", "价格", "是否可借","借出日期","国家","借书人","归还日期","馆藏地","书籍编号","出版社"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
    }
}