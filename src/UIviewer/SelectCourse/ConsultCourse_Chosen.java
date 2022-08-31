package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultCourse_Chosen extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
    public static volatile String[][] consultCourse_chosen=null;
    public ConsultCourse_Chosen()
    {
        setLayout(null);
        JPanel p11=new JPanel();
        p11.setBounds(0,0,(int)(1273*width_r),(int)(790*height_r));


        String[] tableTitle={"课程编号","课程名","时间","学分","任课老师","地点"};
        DefaultTableModel dtm=new DefaultTableModel(consultCourse_chosen,tableTitle);
        JTable table_want=new JTable(dtm);
        table_want.setFont(new Font("宋体",Font.BOLD,20));
        table_want.getColumnModel().getColumn(0).setPreferredWidth(120);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(450);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(110);

        table_want.setRowHeight(50);
        //支持滚动
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,(int)(1280*width_r),(int)(480*height_r));
        add(jsp);


        add(p11);


    }

}
