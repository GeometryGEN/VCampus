package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultCourse_Chosen extends JPanel {

    public static volatile String[][] consultCourse_chosen=null;
    public ConsultCourse_Chosen()
    {
        setLayout(null);
        JPanel p11=new JPanel();
        p11.setBounds(0,0,1273,790);


        String[] tableTitle={"课程编号","课程名","时间","学分","任课老师","地点"};
        DefaultTableModel dtm=new DefaultTableModel(consultCourse_chosen,tableTitle);
        JTable table_want=new JTable(dtm);
        //支持滚动
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,480);
        add(jsp);


        add(p11);


    }

}
