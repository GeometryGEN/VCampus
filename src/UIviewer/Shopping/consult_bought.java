package UIviewer.Shopping;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class consult_bought extends JPanel{
    public static volatile String [][] con_bought=null;
    public consult_bought()
    {
        setLayout(null);
        String[] tableTitle={"图片","商品信息","价格","数量"};
        DefaultTableModel dtm=new DefaultTableModel(con_bought,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.getColumnModel().getColumn(0).setPreferredWidth(355);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(315);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(235);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(235);

        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,940,900);
        add(jsp);
        table_want.setRowHeight(30);
        setVisible(true);


    }

}
