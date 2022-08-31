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
        String[] tableTitle={"课程编号","课程名","时间","学分","老师","地点"};
        DefaultTableModel dtm=new DefaultTableModel(search_result,tableTitle);
        JTable table_want=new JTable(dtm);
        table_want.setFont(new Font("宋体",Font.BOLD,24));
        table_want.getColumnModel().getColumn(0).setPreferredWidth(120);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(400);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(70);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(220);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(130);

        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,(int)(1280*width_r),(int)(420*height_r));
        add(jsp);

        try {
            Client_curriculum.RequireConsultResult("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        table_want.setRowHeight(40);
        setVisible(true);
        //add(table_want);


        //查询按钮

        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("课程信息:");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds((int)(300*width_r), (int)(495*height_r), (int)(275*width_r), (int)(35*height_r));
        add(lblNewLabel);

        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 25));
        textField.setBounds((int)(495*width_r), (int)(495*height_r), (int)(325*width_r), (int)(35*height_r));
        add(textField);
        textField.setColumns(10);
        //五个按钮

        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.setBounds((int)(920*width_r), (int)(495*height_r), (int)(150*width_r), (int)(40*height_r));
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