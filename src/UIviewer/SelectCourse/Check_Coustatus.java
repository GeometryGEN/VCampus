package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Check_Coustatus extends JPanel{
    public static volatile String[][] checkcourse_status=null;
    public Check_Coustatus()
    {
        setLayout(null);
        String[] tableTitle={"课程编号","课程名","课程学分","状态","信息"};
        DefaultTableModel dtm=new DefaultTableModel(checkcourse_status,tableTitle);
        JTable table_want=new JTable(dtm);
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,520);
        add(jsp);
        table_want.setRowHeight(40);


    }
}
