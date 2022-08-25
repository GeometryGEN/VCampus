package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllBooks extends JPanel {
    public AllBooks(){
        setLayout(null);

        String[] tableTitle = {"书名", "作者", "价格", "是否可借","借出日期","国家","借书人","归还日期","馆藏地","书籍编号","出版社"};
        //数据
        String[][] tableDate = {
                {"三国演义","罗贯中","125.00","可借","/","中国","/","/","图书馆204室","4","高等教育出版社"}
        };
        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动


        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);


        //这一块是南边的按钮区域




    }

}