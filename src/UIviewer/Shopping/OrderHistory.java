package UIviewer.Shopping;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 订单历史
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class OrderHistory extends JPanel{
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static volatile String [][] con_bought;

    /**
     * 得到反对买
     *
     * @return {@link String[][]}
     */
    public static String[][] getCon_bought() {
        return con_bought;
    }

    /**
     * 设置骗买了
     *
     * @param con_bought 缺点买了
     */
    public static void setCon_bought(String[][] con_bought) {
        OrderHistory.con_bought = con_bought;
    }

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(243,248,242);

    /**
     * 订单历史
     */
    public OrderHistory()
    {
        setLayout(null);
        setBackground(color5);
        String[] tableTitle={"商品编号","商品名称","购买数量","价格"};
        DefaultTableModel dtm=new DefaultTableModel(con_bought,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTableHeader jTableHeader=table_want.getTableHeader();
        jTableHeader.setFont(new Font("等线", Font.BOLD, 25));
        jTableHeader.setBackground(color3);
        jTableHeader.setForeground(Color.white);

        //文字
        JLabel l1 = new JLabel("//我的历史订单//");
        l1.setBounds(0,10, (int) (1248*width_r), (int) (55*height_r));
        l1.setHorizontalAlignment(JLabel.CENTER); // 将文本居中
        l1.setForeground(color2);
        Font font = new Font("微软雅黑", Font.BOLD, (int) (23*width_r));
        l1.setFont(font);
        add(l1);

        JScrollPane jsp=new JScrollPane(table_want);
        //jsp.setBounds(0,0, (int) (1280*width_r), (int) (650*height_r));
        jsp.setBounds(40,100, (int) (1207*width_r), (int) (480*height_r));
        add(jsp);
        jsp.setBackground(color5);
        jsp.getViewport().setOpaque(false);
        table_want.setRowHeight((int) (30*height_r));
        setVisible(true);

        table_want.setFont(new Font("宋体",Font.BOLD, (int) (16*width_r)));
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (row % 2 == 0) {
                        setBackground(color5);
                    } else {
                        setBackground(color6);
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            };
            //居中
            tcr.setHorizontalAlignment(JLabel.CENTER);
            table_want.setDefaultRenderer(Object.class, tcr);
            for (int i = 0; i < table_want.getColumnCount(); i++)
            {
                table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}