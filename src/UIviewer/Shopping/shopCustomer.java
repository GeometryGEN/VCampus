package UIviewer.Shopping;
import ClientToServer.ClientToServer;
import UIhandler.Library.Client_library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.myInfo;

import static UIviewer.Shopping.ShoppingHall.setShoptable;

public class shopCustomer extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static JPanel panel = new JPanel();;
    static String name;
    public static JButton b1=new JButton("主商城");
    public static JButton b2=new JButton("我的购物车");
    public static JButton b3=new JButton("订单记录");
    static void getName(String a)
    {
        name=a;
    }
    public static CardLayout cardLayout=new CardLayout();

    public shopCustomer(){
        String name=myInfo.getName();
        getName(name);
        setBounds(0,0, (int) (1273*width_r), (int) (784*height_r));
        setLayout(null);


        //cardLayout.show(panel, "f1");

        panel.setBounds(0, (int) (150*height_r), (int) (1273*width_r), (int) (634*height_r));
        panel.setBackground(new Color(0,0,0));
        add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
//		创建相应面板类的对象
        ShoppingHall f1=new ShoppingHall();
        panel.add(f1,"f1");

        //文字
        JLabel l1 = new JLabel("你好！"+name);
        l1.setBounds((int) (1100*width_r), (int) (30*height_r), (int) (200*width_r), (int) (55*height_r));
        l1.setForeground(new Color(248, 248, 255));
        Font font = new Font("楷体", Font.BOLD, (int) (20*width_r));
        l1.setFont(font);
        add(l1);

        //上方面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, (int) (1280*width_r), (int) (100*height_r));
        p1.setBackground(new Color(255,127,80));
        add(p1);

        //按钮

        b1.setBounds((int) (100*width_r), (int) (100*height_r), (int) (250*width_r), (int) (50*height_r));
        Font myfont1 = new Font("微软雅黑", Font.BOLD, (int) (18*width_r));
        b1.setFont(myfont1);
        b1.setContentAreaFilled(false);//设置按钮透明
        b1.setFocusPainted(false);
        b1.setForeground(new Color(248, 248, 255));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String[][]temp={{"2222"}};
                setShoptable(temp);
                ShoppingHall f11=new ShoppingHall();
                panel.add(f11,"f11");
                cardLayout.show(panel, "f11");
            }
        });
        add(b1);


        b2.setBounds((int) (370*width_r), (int) (100*height_r), (int) (250*width_r), (int) (50*height_r));
        b2.setFont(myfont1);
        b2.setContentAreaFilled(false);//设置按钮透明
        b2.setFocusPainted(false);
        b2.setForeground(new Color(248, 248, 255));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
              shopCar f2=new shopCar();
              panel.add(f2,"f2");
              cardLayout.show(panel,"f2");
            }
        });
        add(b2);

        b3.setBounds((int) (640*width_r), (int) (100*height_r), (int) (250*width_r), (int) (50*height_r));
        b3.setFont(myfont1);
        b3.setContentAreaFilled(false);//设置按钮透明
        b3.setFocusPainted(false);
        b3.setForeground(new Color(248, 248, 255));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                OrderHistory f3=new OrderHistory();
                panel.add(f3,"f3");
                cardLayout.show(panel,"f3");
            }
        });
        add(b3);

        JButton b4=new JButton("退出图书馆");
        b4.setBounds((int) (910*width_r), (int) (100*height_r), (int) (250*width_r), (int) (50*height_r));
        b4.setFont(myfont1);
        b4.setContentAreaFilled(false);//设置按钮透明
        b4.setFocusPainted(false);
        b4.setForeground(new Color(248, 248, 255));
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                cardLayout.show(panel, "f1");
            }
        });
        add(b4);

        //按钮面板
        JPanel p2 = new JPanel();
        p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
        p2.setBackground(new Color(255,160,122));
        add(p2);

        setVisible(true);
    }

}