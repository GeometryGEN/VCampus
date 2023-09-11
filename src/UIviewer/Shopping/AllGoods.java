package UIviewer.Shopping;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.*;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import UIhandler.Library.Client_library;

/**
 * 所有商品
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class AllGoods extends JPanel {
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(243,248,242);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 20);

    public static String[][] tableDate;

    /**
     * 得到表日期
     *
     * @return {@link String[][]}
     */
    public static String[][] getTableDate() {
        return tableDate;
    }

    /**
     * 设置表日期
     *
     * @param tableDate 表日期
     */
    public static void setTableDate(String[][] tableDate) {
        AllGoods.tableDate = tableDate;
    }

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    /**
     * 所有商品
     */
    public AllGoods(){
        setLayout(null);
        setBackground(color5);
        String[] tableTitle = {"商品编号","商品名称","商品价格","商品剩余数量","商品种类"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        //System.out.println("tableDate.length="+tableDate.length);
        JTable table_want = new JTable(dtm)
        {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //将表格数据数组放入表格模型,并重写getColumnClass方法
        table_want.setModel(dtm);
        JTableHeader jTableHeader=table_want.getTableHeader();
        jTableHeader.setFont(new Font("等线", Font.BOLD, 25));
        jTableHeader.setBackground(color3);
        jTableHeader.setForeground(Color.white);
        table_want.setRowHeight((int) (30*height_r));
        Font myfont1 = new Font("宋体", Font.PLAIN, (int) (14*width_r));
        table_want.setFont(myfont1);
        //调整美化
        table_want.setFont(new Font("宋体",Font.BOLD, (int) (16*width_r)));
        table_want.setBackground(color5);
        table_want.setOpaque(false);
        setBackground(color5);

        //文字
        JLabel l1 = new JLabel("//商品信息//");
        l1.setBounds(0,10, (int) (1248*width_r), (int) (55*height_r));
        l1.setHorizontalAlignment(JLabel.CENTER); // 将文本居中
        l1.setForeground(color2);
        Font font = new Font("微软雅黑", Font.BOLD, (int) (23*width_r));
        l1.setFont(font);
        add(l1);

        //支持滚动
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(table_want);
        jsp.setBounds(40,100, (int) (1207*width_r), (int) (480*height_r));
        jsp.setBackground(color5);
        jsp.getViewport().setOpaque(false);
        add(jsp);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setOpaque(false); //将渲染器设置为透明
        table_want.setDefaultRenderer(Object.class,render);
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