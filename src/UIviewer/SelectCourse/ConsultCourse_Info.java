package UIviewer.SelectCourse;

import UIhandler.Currirulum.Client_curriculum;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ConsultCourse_Info extends JPanel {

    public static volatile String[][] search_result=null;
    public ConsultCourse_Info()
    {
        setLayout(null);


        String[] tableTitle={"课程编号","课程名","时间","学分","老师","地点"};
        DefaultTableModel dtm=new DefaultTableModel(search_result,tableTitle);
        JTable table_want=new JTable(dtm);
        table_want.getColumnModel().getColumn(0).setPreferredWidth(120);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(340);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(220);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(100);

        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,420);
        add(jsp);
        table_want.setRowHeight(40);
        setVisible(true);
        //add(table_want);


        //左侧面板
       /* JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        add(p1);*/

        //查询按钮

        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程信息:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(300, 495, 275, 35);
        add(lblNewLabel);

        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 25));
        textField.setBounds(495, 495, 325, 35);
        add(textField);
        textField.setColumns(10);
        //五个按钮

        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.setBounds(920, 495, 150, 40);
        Font myfont = new Font("微软雅黑", Font.BOLD, 20);
        btnNewButton_9.setFont(myfont);
        btnNewButton_9.setBackground(new Color(220, 220, 220));
        btnNewButton_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String consult_info = textField.getText();
                    Client_curriculum.RequireConsultResult(consult_info);
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        add(btnNewButton_9);
        //右下面板
       /* JPanel p3 = new JPanel();
        p3.setBounds(310, 0, 950, 685);
        p3.setBackground(new Color(211, 211, 211, 100));
        add(p3);*/

        //右侧面板
       /* JPanel p2 = new JPanel();
        p2.setBounds(310, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        add(p2);*/

        //横向图片
        /*JLabel l15 = new JLabel();
        ImageIcon icon6 = new ImageIcon("src/image/background4.jpg");
        l15.setIcon(icon6);
        l15.setBounds(0, 0, 1273, 790);
        p17.add(l15);*/



        //setLocationRelativeTo(null);


    }
}