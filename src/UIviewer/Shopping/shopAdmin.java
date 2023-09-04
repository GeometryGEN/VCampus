package UIviewer.Shopping;
import ClientToServer.ClientToServer;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;
import UIviewer.Shopping.AddDeleteGoods;
import UIviewer.Shopping.AllGoods;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ClientToServer.myInfo;

import static UIviewer.Shopping.ShoppingHall.setShoptable;

/**
 * 店管理
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class shopAdmin extends JPanel {
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color white=Color.white;

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    static String name;
    public static JPanel panel = new JPanel();

    /**
     * 得到名字
     *
     * @param a 一个
     */
    static void getName(String a)
    {
        name=a;
    }
    public static CardLayout cardLayout=new CardLayout();

    public static JButton b1=new JButton("查看商品");
    public static JButton b2=new JButton("商品管理");
    public static JButton b3=new JButton("退出商店");

    /**
     * 店管理
     *
     * @throws Exception 异常
     */
    public shopAdmin() throws Exception {
        String name=null;
        //String name=myInfo.getName();
        //getName(name);
        setBounds(0,0, (int) (1273*width_r), (int) (790*height_r));
        setLayout(null);
        panel.setBounds(0, (int) (150*height_r), (int) (1273*width_r), (int) (790*height_r));
        add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
//		创建相应面板类的对象

        //测试的时候先让列表为空
        List<Product> t =new ArrayList<>();
        //List<Product> t = Client_shop.returnAllProduct();
        String[][] temp = new String[t.size()][];
        for(int i =0;i<t.size();i++){
            String[] tt =new String[5];
            tt[0]=String.valueOf(t.get(i).getProduct_id());
            tt[1]=t.get(i).getProduct_name();
            tt[2]=String.valueOf(t.get(i).getProduct_price());
            tt[3]=String.valueOf(t.get(i).getProduct_currentNumbers());
            tt[4]=t.get(i).getProduct_type();
            temp[i]=tt;
        }
        //System.out.println("temp="+temp.length);
        Client_shop.setId(String.valueOf(myInfo.getType()));
        Client_shop.setIdcard(myInfo.getId());
        AllGoods.setTableDate(temp);

        //测试页面！！！
        AllGoods f11=new AllGoods();
        //panel.add(f11,"f11");
        AddDeleteGoods f12=new AddDeleteGoods();
        panel.add(f12,"f12");

        //商店标志与背景
        JLabel logo = new JLabel();

        int icon1_width=  (int) (850*width_r);
        int icon1_height=(int) (90*height_r);
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/商店/3.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/商店/3_fit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logo.setIcon(new ImageIcon("src/image/商店/3_fit.png"));
        logo.setBounds((int) (10*width_r), (int) (0*height_r), (int) (1000*width_r), (int) (100*height_r));
        add(logo);
        //文字
        JLabel l1 = new JLabel("你好！"+name);
        l1.setBounds((int) (1100*width_r), (int) (30*height_r), (int) (200*width_r), (int) (55*height_r));
        l1.setForeground(new Color(248, 248, 255));
        Font font = new Font("微软雅黑", Font.BOLD, (int) (20*width_r));
        l1.setFont(font);
        add(l1);

        //上方面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, (int) (1280*width_r), (int) (100*height_r));
        p1.setBackground(color2);
        add(p1);

        //按钮
        b1.setBounds((int) (0*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        Font myfont1 = new Font("微软雅黑", Font.BOLD, (int) (18*width_r));
        b1.setFont(myfont1);
        b1.setContentAreaFilled(false);//设置按钮透明
        b1.setFocusPainted(false);//把选中后出现的小方框去掉
        b1.setForeground(white); //字体颜色设置为白色
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Product> t = null;
                AllGoods.setTableDate(null);
                try {
                    t = Client_shop.returnAllProduct();
                    String[][] temp = new String[t.size()][];
                    for(int i =0;i<t.size();i++){
                        String[] tt =new String[5];
                        tt[0]=String.valueOf(t.get(i).getProduct_id());
                        tt[1]=t.get(i).getProduct_name();
                        tt[2]=String.valueOf(t.get(i).getProduct_price());
                        tt[3]=String.valueOf(t.get(i).getProduct_currentNumbers());
                        tt[4]=t.get(i).getProduct_type();
                        temp[i]=tt;
                    }
                   // System.out.println("temp.length="+temp.length);
                    AllGoods.setTableDate(temp);
                    AllGoods f11=new AllGoods();
                    panel.add(f11,"f11");
                    cardLayout.show(panel,"f11");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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
                AddDeleteGoods f12=new AddDeleteGoods();
                panel.add(f12,"f12");
                cardLayout.show(panel,"f12");
            }
        });
        add(b2);

        b3.setBounds((int) (1100*width_r), (int) (100*height_r), (int) (173*width_r), (int) (50*height_r));
        b3.setFont(myfont1);
        b3.setContentAreaFilled(false);//设置按钮透明
        b3.setFocusPainted(false);
        b3.setForeground(white);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                //cardLayout.show(panel, "f1");
            }
        });
        add(b3);

        //按钮面板
        JPanel p2 = new JPanel();
        p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
        p2.setBackground(color3);
        //p2.setBackground(new Color(125,182,191));
        add(p2);

        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) screensize.getWidth(); //得到宽度
        int height=(int) screensize.getHeight();//获得高度
        System.out.println(width);
        System.out.println(height);
        JFrame jf=new JFrame("shopAdmin");
        //jf = new JFrame("欢迎使用VCampus虚拟校园系统，请选择您的服务！");
        jf.setSize(width,height);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println("before creat");
        jf.setContentPane(new shopAdmin());
        System.out.println("after creat");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    };
}