package UIviewer.Library;
import UIhandler.Library.Client_library;
import UIviewer.Library.readLib;
import net.coobird.thumbnailator.Thumbnails;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static UIviewer.Library.readLib.cardLayout;
import static UIviewer.Library.readLib.panel;

/**
 * 图书搜索
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class bookSearch extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    Font myfont2 = new Font("微软雅黑", Font.BOLD, (int) (25*width_r));

    /**
     * 图书搜索
     */
    public bookSearch(){


        setLayout(null);
        //setBackground(Color.BLUE);
        //馆藏查询
        JPanel p11=new JPanel();
        //p11.setBackground(Color.green);
        p11.setBounds(0,-5, (int) (1273*width_r), (int) (650*height_r));
        JLabel pic1 = new JLabel();
        int icon1_width= 1280;
        int icon1_height=660;
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/图书馆/2.jpg"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/图书馆/2_min.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        pic1.setIcon(new ImageIcon("src/image/图书馆/2_min.jpg"));
        pic1.setBounds(0,0 , (int) (1280*width_r), (int) (660*height_r));
        p11.add(pic1);

        JPanel p21=new JPanel();
        p21.setBounds((int) (445*width_r), (int) (100*height_r), (int) (730*width_r), (int) (300*height_r));
        p21.setBackground(new Color(42,52,65,200));
        JPanel p31=new JPanel();
        p31.setBounds(0,-5, (int) (330*width_r), (int) (1900*height_r));
        p31.setBackground(new Color(42,52,65,200));

        //文字
        JLabel l1 = new JLabel(" 请在下方输入你想搜索的内容 !");
        l1.setBounds((int) (500*width_r), (int) (120*height_r), (int) (290*width_r), (int) (80*height_r));
        Font font = new Font("微软雅黑", Font.PLAIN, (int) (20*width_r));
        l1.setForeground(new Color(255,255,255));
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);

        //文字
        JLabel l2 = new JLabel("您正在对书籍名、作者名、书籍编号等进行检索 ");
        l2.setBounds((int) (760*width_r), (int) (300*height_r), (int) (800*width_r), (int) (80*height_r));
        Font font1 = new Font("楷体", Font.PLAIN, (int) (18*width_r));
        l2.setForeground(new Color(255,255,255));
        l2.setFont(font1);
        //l1.setForeground(new Color(111,222,0));
        add(l2);

        //输入搜索内容的文本框
        JTextField textField=new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, (int) (18*width_r)));
        textField.setBounds((int) (550*width_r), (int) (220*height_r), (int) (420*width_r), (int) (50*height_r));
        add(textField);
        textField.setColumns((int) (10*height_r));

        //搜索按钮
        JButton b11=new JButton("检索");
        b11.setBounds((int) (1000*width_r), (int) (220*height_r), (int) (80*width_r), (int) (50*height_r));
        Font myfont = new Font("楷体", Font.BOLD, (int) (20*width_r));
        b11.setFont(myfont);
        b11.setBackground(new Color(42,52,65,200));
        b11.setForeground(new Color(255,255,255));
        b11.setFocusPainted(false);
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String searchInfo=textField.getText();
                    Client_library.RequireSearchResult(searchInfo);
                    textField.setText("");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //按书名搜索
        JButton b12=new JButton("按书名检索");
        b12.setBounds((int) (55*width_r), (int) (120*height_r), (int) (220*width_r), (int) (50*height_r));
        b12.setFont(myfont2);
        b12.setContentAreaFilled(false);//设置按钮透明
        b12.setFocusPainted(false);//把选中后出现的小方框去掉
        b12.setForeground(new Color(255,255,255));
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    //按书名搜索
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //按作者搜索
        JButton b13=new JButton("按作者检索");
        b13.setBounds((int) (55*width_r), (int) (220*height_r), (int) (220*width_r), (int) (50*height_r));
        b13.setFont(myfont2);
        b13.setContentAreaFilled(false);//设置按钮透明
        b13.setFocusPainted(false);//把选中后出现的小方框去掉
        b13.setForeground(new Color(255,255,255));
        b13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    //按作者搜索
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //按书籍编号
        JButton b14=new JButton("按书籍编号检索");
        b14.setBounds((int) (55*width_r), (int) (320*height_r), (int) (220*width_r), (int) (50*height_r));
        b14.setFont(myfont2);
        b14.setContentAreaFilled(false);//设置按钮透明
        b14.setFocusPainted(false);//把选中后出现的小方框去掉
        b14.setForeground(new Color(255,255,255));
        b14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    //按书籍编号搜索
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(p31);
        add(p21);
        add(p11);

    }
}