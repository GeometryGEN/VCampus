package UIviewer.SelectCourse;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_Course extends JPanel{
public static volatile String[][] checkcourse=null;
    public Check_Course()
    {
        setLayout(null);
        String[] tableTitle={"课程编号","课程名","任课老师","课程学分","课容量","通过","退回"};
        DefaultTableModel dtm=new DefaultTableModel(checkcourse,tableTitle);
        JTable table_want=new JTable(dtm);
        table_want.setFont(new Font("宋体",Font.BOLD,20));
        table_want.getColumnModel().getColumn(0).setPreferredWidth(150);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(190);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(170);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(170);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(150);
        table_want.getColumnModel().getColumn(6).setPreferredWidth(150);

        table_want.setRowHeight(50);
        //支持滚动
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,580);
        add(jsp);

        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (column!=5&&column!=6) {
                        setBackground(Color.white);
                    }else if(column==5)
                    {
                        setBackground(new Color(60,179,113));
                    }
                    else {
                        setBackground(new Color(176,23,31));
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            };

            for (int i = 0; i < table_want.getColumnCount(); i++)
            {
                table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }









    }

}
