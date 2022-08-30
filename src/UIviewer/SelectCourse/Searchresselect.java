package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Searchresselect extends JPanel{
     public static volatile String[][] searchresult=null;
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
         //支持滚动
         JScrollPane jsp=new JScrollPane(table_want);
         jsp.setBounds(0,0,1280,680);
         add(jsp);

         table_want.setFont(new Font("宋体",Font.BOLD,16));
         try {
             DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                 @Override
                 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                     setBackground(Color.white);
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
