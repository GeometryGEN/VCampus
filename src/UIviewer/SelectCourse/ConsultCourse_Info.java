package UIviewer.SelectCourse;

import ClientToServer.myInfo;
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
        JLabel lblNewLabel = new JLabel("  请在下方输入要查询的课程信息！");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, (int) (20*width_r)));
        lblNewLabel.setBounds((int) (500*width_r), (int) (120*height_r), (int) (500*width_r), (int) (80*height_r));
        add(lblNewLabel);
        lblNewLabel.setForeground(new Color(255,255,255));
        JTextField textField = new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, (int)(20*width_r)));
        textField.setBounds((int) (550*width_r), (int) (220*height_r), (int) (420*width_r), (int) (50*height_r));
        add(textField);
        textField.setColumns(10);
        //五个按钮
        JButton btnNewButton_9 = new JButton("查询");
        btnNewButton_9.setBounds((int) (1000*width_r), (int) (220*height_r), (int) (120*width_r), (int) (50*height_r));
        Font myfont = new Font("微软雅黑", Font.BOLD, 20);
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

        //信息面板
        JLabel l4 = new JLabel("基本信息");
        l4.setBounds((int)(90*width_r), (int)(225*height_r), (int)(250*width_r), (int)(60*height_r));
        Font font2 = new Font("楷体", Font.BOLD, 30);
        l4.setFont(font2);
        l4.setForeground(new Color(255,255,248));
        add(l4);
        JLabel l5 = new JLabel("您正在对课程信息进行检索！ ");
        l5.setBounds((int) (800*width_r), (int) (300*height_r), (int) (800*width_r), (int) (80*height_r));
        Font font1 = new Font("楷体", Font.PLAIN, (int) (18*width_r));
        l5.setForeground(new Color(255,255,255));
        l5.setFont(font1);
        add(l5);
        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + myInfo.getName());
        l2.setBounds((int)(60*width_r), (int)(320*height_r), (int)(250*width_r), (int)(60*height_r));
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        l2.setFont(font);
        l2.setForeground(new Color(255,255,248));
        add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + myInfo.getId());
        l3.setBounds((int)(60*width_r), (int)(410*height_r), (int)(250*width_r), (int)(60*height_r));
        l3.setFont(font);
        l3.setForeground(new Color(255,255,248));
        add(l3);
        JLabel touxiang = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/默认头像.png");
        int icon_width=160;
        int icon_height=160;
        try {
            Thumbnails.of(new File("src/image/默认头像.png"))
                    .size((int)(icon_width*width_r), (int)(icon_height*height_r))
                    .toFile(new File("src/image/头像_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        touxiang.setIcon(new ImageIcon("src/image/头像_min.png"));
        touxiang.setBounds((int) (80*width_r), (int) (60*height_r), (int) (160*width_r), (int) (160*height_r));
        add(touxiang);

        //信息面板
        JPanel p1 = new JPanel();
        p1.setBounds(0,-5, (int) (330*width_r), (int) (1900*height_r));
        p1.setBackground(new Color(42,52,65,200));
        add(p1);

        JPanel p = new JPanel();
        p.setBounds((int) (445*width_r), (int) (100*height_r), (int) (730*width_r), (int) (300*height_r));
        p.setBackground(new Color(42,52,65,200 ));
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