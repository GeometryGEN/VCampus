package UIviewer.Shopping;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class shoppingcar extends JPanel{

    public static volatile String[][] shopping_res=null;
    public shoppingcar()
    {
        setLayout(null);
        String[] tableTitle={"图片","商品信息","价格","数量","购买","删除"};
        DefaultTableModel dtm=new DefaultTableModel(shopping_res,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table_want.getColumnModel().getColumn(0).setPreferredWidth(300);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(260);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(180);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(180);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(100);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(120);

        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,940,900);
        add(jsp);
        table_want.setRowHeight(30);
        setVisible(true);

    }
}
