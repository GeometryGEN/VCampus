package UIviewer.Shopping;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import UIhandler.Library.Client_library;

public class AllGoods extends JPanel {
    public static volatile String[][] tableDate;

    public static String[][] getTableDate() {
        return tableDate;
    }

    public static void setTableDate(String[][] tableDate) {
        AllGoods.tableDate = tableDate;
    }

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public AllGoods(){
        setLayout(null);
        String[] tableTitle = {"商品名称","商品编号","商品价格","商品剩余数量","商品种类"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        JTable table_want = new JTable(dtm)
        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.setRowHeight((int) (30*height_r));
        Font myfont1 = new Font("宋体", Font.PLAIN, (int) (14*width_r));
        table_want.setFont(myfont1);

        //支持滚动
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(table_want);
        jsp.setBounds(0,0, (int) (1280*width_r), (int) (680*height_r));
        jsp.setBackground(new Color(255, 240, 245, 80));
        add(jsp);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, (int) (1280*width_r), (int) (650*height_r));
        p1.setBackground(new Color(255, 240, 245, 10));
        add(p1);

        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setOpaque(false); //将渲染器设置为透明
        table_want.setDefaultRenderer(Object.class,render);
    }
}