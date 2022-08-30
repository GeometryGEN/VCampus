package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//可以修改课程的时间、地点、课容量
public class Stu_Info extends JPanel {

    public static volatile String[][] student_inf=null;
    public Stu_Info()
    {
        setLayout(null);

       String[] tableTitle={"课程编号","课程名","课容量","时间","任课老师","地点"};
        DefaultTableModel dtm=new DefaultTableModel(student_inf,tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        table_want.getColumnModel().getColumn(0).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(260);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(220);

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
