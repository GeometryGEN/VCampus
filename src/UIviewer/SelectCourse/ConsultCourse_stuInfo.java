package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultCourse_stuInfo extends JPanel {

    public static volatile String[][] consult_stu=null;

    public ConsultCourse_stuInfo()
    {
        setLayout(null);

        String[] tableTitle={"一卡通号","学生姓名"};
        DefaultTableModel dtm=new DefaultTableModel(consult_stu,tableTitle);
        JTable table_want=new JTable(dtm);
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,420);
        add(jsp);
        table_want.setRowHeight(40);

       /* JButton btnNewButton_6 = new JButton("安全返回");
        btnNewButton_6.setBounds(530, 525, 200, 40);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 18);
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明

        add(btnNewButton_6);*/

    }

}
