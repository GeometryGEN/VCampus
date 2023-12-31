package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * searchresselect
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class Searchresselect extends JPanel{
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
     public static volatile String[][] searchresult=null;

    /**
     * searchresselect
     */
    public Searchresselect()
     {
         setLayout(null);
         String[]tableTitle={"课程编号","课程名","时间","学分","地点","选择"};
         //数据
         DefaultTableModel dtm = new DefaultTableModel(searchresult, tableTitle);
         JTable table_want = new JTable(dtm){
             public boolean isCellEditable(int row, int column) {
                 return false;
             }
         };
         JTableHeader jTableHeader=table_want.getTableHeader();
         jTableHeader.setFont(new Font("楷体",Font.BOLD,18));
         jTableHeader.setBackground(new Color(68,84,105));
         jTableHeader.setForeground(new Color(255,248,250));
         table_want.setCellSelectionEnabled(true);
         table_want.setFont(new Font("宋体",Font.BOLD,24));
         //支持滚动
         JScrollPane jsp=new JScrollPane(table_want);
         jsp.setBounds(0,0,(int)(1280*width_r),(int)(680*height_r));
         add(jsp);

         table_want.setFont(new Font("宋体",Font.BOLD,16));
         try {
             DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                 @Override
                 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                     if (row % 2 == 0) {
                         setBackground(new Color(237, 253, 254));
                     } else {
                         setBackground(new Color(169, 189, 205));
                     }

                     return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 }
             };
             tcr.setHorizontalAlignment(JLabel.CENTER);
             table_want.setDefaultRenderer(Object.class, tcr);
             for (int i = 0; i < table_want.getColumnCount(); i++)
             {
                 table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
             @Override
             public boolean isVisible() {
                 return true;
             }
         };
         jsp.setVerticalScrollBar(scrollBar);
         jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
         scrollBar.setUnitIncrement(30);
     }

}
