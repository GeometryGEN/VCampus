package UIviewer.Shopping;
import javax.swing.*;
import ClientToServer.ClientToServer;
import DAO.Shop.Product;
import DAO.Shop.ProductPair;
import UIhandler.Library.Client_library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import UIhandler.Shop.Client_shop;
import UIviewer.Library.bookSearch;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.myInfo;

import static UIviewer.Shopping.ShoppingHall.resetshoptable;
import static UIviewer.Shopping.ShoppingHall.setShoptable;
public class Shopping_Center extends JPanel{
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    //public static JPanel panel = new JPanel();;
    static String name;
    public static List<Product> t;
    public static JButton b1=new JButton("商城");
    public static JButton b2=new JButton("购物车");
    public static JButton b3=new JButton("我的订单");
    public static CardLayout cardLayout=new CardLayout();
    public static JPanel panel = new JPanel();;
    static void getName(String a)
    {
        name=a;
    }

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color white=Color.white;

    public Shopping_Center() {
        //测试UI时先不获取名字。将其设为空
        name=myInfo.getName();
        name=null;
        getName(name);

        setSize(width,height);
        setVisible(true);
        //setBackground(color5);
        setBounds(0,0, (int) (1273*width_r), (int) (784*height_r));
        setLayout(null);
        //设置布局
        panel.setBounds(0, (int) (150*height_r), (int) (1273*width_r), (int) (634*height_r));
        //panel.setBackground(new Color(0,0,0));
        add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
//		创建相应面板类的对象
        Item_Rearch_Customer f1=new Item_Rearch_Customer();
//		将面板添加到住面板中，注意:add()方法里有两个参数，第一个是要添加的对象，第二个给这个对象所放置的卡片
//		起个名字，后面调用显示的时候要用到这个名字
        panel.add(f1,"f1");//查找书

        //商店标志与背景
        JLabel logo = new JLabel();
        int icon1_width=  (int) (850*width_r);
        int icon1_height=(int) (90*height_r);
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/商店/Store_logo.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/商店/Store_logo_fit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/商店/Store_logo_fit.png"));
        logo.setBounds((int) (10*width_r), (int) (0*height_r), (int) (600*width_r), (int) (100*height_r));
        add(logo);

        //文字
        JLabel l1 = new JLabel("你好！"+name);
        l1.setBounds((int) (1100*width_r), (int) (30*height_r), (int) (200*width_r), (int) (55*height_r));
        l1.setForeground(white);
        Font font = new Font("微软雅黑", Font.BOLD, (int) (20*width_r));
        l1.setFont(font);
        add(l1);

        //上方面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, (int) (1280*width_r), (int) (100*height_r));
        p1.setBackground(color2);
        add(p1);

        //按钮
        //b1馆藏查询
        b1.setBounds((int) (0*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        Font myfont1 = new Font("微软雅黑", Font.BOLD, (int) (18*width_r));
        b1.setFont(myfont1);
        b1.setContentAreaFilled(false);//设置按钮透明
        b1.setFocusPainted(false);//把选中后出现的小方框去掉
        b1.setForeground(white); //字体颜色设置为白色
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f1");
            }
        });
        add(b1);

        b2.setBounds((int) (200*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        b2.setFont(myfont1);
        b2.setContentAreaFilled(false);//设置按钮透明
        b2.setFocusPainted(false);
        b2.setForeground(white);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Client_library.RequireMyBooks();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(b2);

        b3.setBounds((int) (400*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        b3.setFont(myfont1);
        b3.setContentAreaFilled(false);//设置按钮透明
        b3.setFocusPainted(false);
        b3.setForeground(white);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Client_library.RequireMyPunishments();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        add(b3);

        JButton b4=new JButton("退出商城");
        b4.setBounds((int) (1100*width_r), (int) (100*height_r), (int) (173*width_r), (int) (50*height_r));
        b4.setFont(myfont1);
        b4.setContentAreaFilled(false);//设置按钮透明
        b4.setFocusPainted(false);
        b4.setForeground(white);
        b4.setBorder(null);
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
        p2.setBackground(color3);
        //p2.setBackground(new Color(125,182,191));
        add(p2);
        setVisible(true);

        add(panel);
    }

    public static void main(String[] args) {
        // 创建并显示 JFrame
        JFrame jf=new JFrame();
        jf.setContentPane(new Shopping_Center());
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screensize2=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int ) screensize2.getWidth(); //得到宽度
        int height=(int ) screensize2.getHeight();//获得高度
        jf.setSize(width,height);
    }


}
