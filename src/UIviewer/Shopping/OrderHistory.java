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
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static volatile String [][] con_bought;

    public static String[][] getCon_bought() {
        return con_bought;
    }

    public static void setCon_bought(String[][] con_bought) {
        OrderHistory.con_bought = con_bought;
    }

    public OrderHistory()
    {
        setLayout(null);
        String[] tableTitle={"商品编号","商品名称","商品数量","购买数量","购买价格"};
        DefaultTableModel dtm=new DefaultTableModel(con_bought,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0, (int) (1280*width_r), (int) (650*height_r));
        add(jsp);
        table_want.setRowHeight(30);
        setVisible(true);
    }
}