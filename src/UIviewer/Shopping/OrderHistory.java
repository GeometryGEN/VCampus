package UIviewer.Shopping;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class OrderHistory extends JPanel{
    public static volatile String [][] con_bought={{"旺仔牛奶","1","5"}};
    public OrderHistory()
    {
        setLayout(null);
        String[] tableTitle={"商品名称","商品编号","购买价格"};
        DefaultTableModel dtm=new DefaultTableModel(con_bought,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,940,900);
        add(jsp);
        table_want.setRowHeight(30);
        setVisible(true);
    }
}