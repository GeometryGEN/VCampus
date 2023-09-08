package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 检查coustatus
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class Check_Coustatus extends JPanel{
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
    public static volatile String[][] checkcourse_status=null;

    /**
     * 检查coustatus
     */
    public Check_Coustatus()
    {
        setLayout(null);
        String[] tableTitle={"申报课程编号","课程名","课程学时","状态","审核信息"};
        DefaultTableModel dtm=new DefaultTableModel(checkcourse_status,tableTitle);
        JTable table_want=new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTableHeader jTableHeader=table_want.getTableHeader();
        jTableHeader.setFont(new Font("楷体",Font.BOLD,18));
        jTableHeader.setBackground(new Color(68,84,105));
        jTableHeader.setForeground(new Color(255,248,250));
        table_want.setFont(new Font("楷体",Font.BOLD, (int) (18*width_r)));
        JScrollPane jsp=new JScrollPane(table_want);
        table_want.setRowHeight((int)(30*height_r));
        Font myfont1 = new Font("宋体", Font.BOLD, (int) (16*width_r));
        table_want.setFont(myfont1);
        table_want.setBackground(new Color(237,253,254));
        table_want.setOpaque(false);
        setBackground(new Color(237,253,254));
        jsp.setBounds(0,0,(int)(1280*width_r),(int)(520*height_r));
        add(jsp);
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (row % 2 == 0) {
                        setBackground(new Color(237,253,254));
                    } else {
                        setBackground(new Color(169,189,205));
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
