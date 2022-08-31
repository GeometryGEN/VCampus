package UIviewer.SelectCourse;

import UIhandler.Currirulum.Client_curriculum;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConsultCourse_Info extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
    public static volatile String[][] search_result=null;
    public ConsultCourse_Info()
    {
        setLayout(null);
        setVisible(true);
        //查询按钮
        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程信息:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds(250, 295, 275, 35);
        add(lblNewLabel);

        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 25));
        textField.setBounds(455, 295, 325, 35);
        add(textField);
        textField.setColumns(10);
        //五个按钮

        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.setBounds(870, 295, 150, 40);
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
                textField.setText("");
            }
        });
        add(btnNewButton_9);
    }
}