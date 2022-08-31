package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class My_students extends JPanel{
    public static volatile String[][] students=null;

    public My_students() {
        String[] tableTitle={"学生姓名","一卡通号"};
        DefaultTableModel dtm2=new DefaultTableModel(students,tableTitle);
        JTable table_want=new JTable(dtm2);
        JScrollPane jsp2=new JScrollPane(table_want);
        jsp2.setBounds(0,260,1280,280);
        add(jsp2);
        table_want.setRowHeight(70);
    }
}
