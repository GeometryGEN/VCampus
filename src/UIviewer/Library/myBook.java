package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myBook extends JPanel {
    public static String[][] myBook;
    public myBook(){
        setLayout(null);

        String[] tableTitle = {"书籍编号","书名", "作者","出版社","国家","馆藏地","借出日期","应还日期","归还","续借"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(myBook, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);
        table_want.getColumnModel().getColumn(8).setCellRenderer(new MyButtonRender());
        table_want.getColumnModel().getColumn(9).setCellRenderer(new MyButtonRender1());
    }
}