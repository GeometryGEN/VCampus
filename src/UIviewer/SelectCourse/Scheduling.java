package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

//可以修改课程的时间、地点、课容量   排课功能
public class Scheduling extends JPanel {

    public static volatile String[][] courses=null;
    public Scheduling()
    {
        setLayout(null);

       String[] tableTitle={"课程编号","课程名","任课老师","时间","课容量","地点"};
        DefaultTableModel dtm=new DefaultTableModel(courses,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        table_want.getColumnModel().getColumn(0).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(60);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(450);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(150);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(120);

        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,420);
        add(jsp);
        table_want.setRowHeight(40);
        setVisible(true);

        JButton btnNewButton_6 = new JButton("确认修改");
        btnNewButton_6.setBounds(530, 525, 200, 40);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 18);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        add(btnNewButton_6);

    }

}
