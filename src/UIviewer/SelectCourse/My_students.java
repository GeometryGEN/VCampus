package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class My_students extends JPanel{
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
    public static volatile String[][] students=null;

    public My_students() {
        String[] tableTitle={"学生姓名","一卡通号"};
        DefaultTableModel dtm2=new DefaultTableModel(students,tableTitle);
        JTable table_want=new JTable(dtm2);
        JScrollPane jsp2=new JScrollPane(table_want);
        jsp2.setBounds(0,(int)(260*height_r),(int)(1280*width_r),(int)(280*height_r));
        add(jsp2);
        table_want.setRowHeight(70);
    }
}