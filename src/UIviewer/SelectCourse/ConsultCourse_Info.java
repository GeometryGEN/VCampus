package UIviewer.SelectCourse;

import DAO.Curriculum.Course;
import UIhandler.Currirulum.Client_curriculum;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 咨询课程信息
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class ConsultCourse_Info extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
    public static volatile String[][] search_result=null;

    /**
     * 咨询课程信息
     */
    public ConsultCourse_Info()
    {
        setLayout(null);
        setVisible(true);
        //查询按钮
        //文本编辑框（输入课程编号或课程名字）
        JLabel lblNewLabel = new JLabel("  请输入课程信息：");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
        lblNewLabel.setBounds((int)(475*width_r), (int)(100*height_r), (int)(350*width_r), (int)(75*height_r));
        add(lblNewLabel);
        lblNewLabel.setForeground(new Color(255,255,255));
        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 30));
        textField.setBounds((int)(475*width_r), (int)(200*height_r), (int)(325*width_r), (int)(75*height_r));
        add(textField);
        textField.setColumns(10);
        //五个按钮
        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.setBounds((int)(550*width_r), (int)(325*height_r), (int)(150*width_r), (int)(75*height_r));
        Font myfont = new Font("微软雅黑", Font.BOLD, 25);
        btnNewButton_9.setFont(myfont);
        btnNewButton_9.setBackground(new Color(68,84,105));
        btnNewButton_9.setForeground(new Color(248,240,245));
        btnNewButton_9.setOpaque(true);
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
        JPanel p = new JPanel();
        p.setBounds((int) (425 * width_r), (int) (75 * height_r), (int) (400 * width_r), (int) (425* height_r));
        p.setBackground(new Color(106, 113, 122,100 ));
        add(p);
        JPanel p11 = new JPanel();
        p11.setBounds(0, 0, (int) width, (int) height);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/xuankebg_2.jpg");
        int icon1_width = 1280;
        int icon1_height = 600;
        try {
            Thumbnails.of(new File("src/image/xuankebg_2.png"))
                    .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/xuankebg_2_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/xuankebg_2_min.png"));
        pic1.setBounds(0, -10, (int) (icon1_width * width_r), (int) (icon1_height * height_r));
        p11.add(pic1);
        add(p11);
    }
}