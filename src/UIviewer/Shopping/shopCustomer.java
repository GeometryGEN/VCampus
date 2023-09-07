package UIviewer.Shopping;
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

import UIhandler.QICQ.Client_qicq;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.readLib;
import UIviewer.QQ.main_panel;
import UIviewer.SelectCourse.Selcourse;
import UIviewer.SelectCourse.Selcourse_director;
import UIviewer.SelectCourse.Selcourse_teacher;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.manage_status;
import net.coobird.thumbnailator.Thumbnails;
import ClientToServer.myInfo;

import static UIviewer.Shopping.ShoppingHall.resetshoptable;
import static UIviewer.Shopping.ShoppingHall.setShoptable;

/**
 * 店客户
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class shopCustomer extends JPanel {
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(243,211,160);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);
    Color white=Color.white;

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static JPanel panel = new JPanel();
    public static JPanel panel2 = new JPanel();
    static String name;
    public static List<Product> t;
    public static JButton b1=new JButton("主商城");
    public static JButton b2=new JButton("我的购物车");
    public static JButton b3=new JButton("订单记录");
    public static JButton b4=new JButton("充值");

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

    /**
     * 刷新
     */
    public void refresh()
    {

    }

    /**
     * 店客户
     *
     * @throws Exception 异常
     */
    public shopCustomer() throws Exception {
        //功能跳转
        //panel2.setOpaque(false);
        //panel2.setBackground(new Color(0, 0, 0, 0)); // 设置透明背景颜色
        setBackground(color6);
        panel2.setLayout(null);
        JButton swtich=new JButton("功能");
        swtich.setBackground(color2);
        swtich.setForeground(Color.white);
        swtich.setFont(myfont1);
        swtich.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        new FuctionJump();
                                        //panel.repaint();
                                    }
                                });
        swtich.setBounds(0,0,80,40);
        swtich.setFocusPainted(false);
        panel2.setSize(180,150);
        panel2.setBounds(width-80,height/2-75,180,150);
        panel2.add(swtich);
        add(panel2);

        String name="1";
        double money = 0;
        name=myInfo.getName();
        getName(name);
        if(myInfo.getType()==1)
             money=Client_shop.getMoney(myInfo.getId());
        else
             money=Client_shop.getMoney_Teacher(myInfo.getId());

        System.out.println("after creat11111");

        setBounds(0,0, (int) (1273*width_r), (int) (784*height_r));
        setLayout(null);

        panel.setBounds(0, (int) (150*height_r), (int) (1273*width_r), (int) (634*height_r));
        panel.setBackground(color5);
        add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
//		创建相应面板类的对象
        System.out.println("after creat2222222222");

        //t = Client_shop.returnAllProduct();
        //测试的时候先让列表为空
        t =new ArrayList<>();
        String[][] temp = new String[t.size()][];
        for(int i =0;i<t.size();i++){
            String[] tt =new String[7];
            tt[0]=String.valueOf(t.get(i).getProduct_id());
            tt[1]=t.get(i).getProduct_name();
            tt[2]=String.valueOf(t.get(i).getProduct_price());
            tt[3]=String.valueOf(t.get(i).getProduct_currentNumbers());
            tt[4]="1";
            tt[5]="加入购物车";
            tt[6]="购买";
            temp[i]=tt;
        }
        ShoppingHall.setShoptable(temp);

        //测试各个界面
        ShoppingHall f1=new ShoppingHall();
        panel.add(f1,"f1");
//        shopCar f2=new shopCar();
//        //panel.add(f2,"f2");
//        OrderHistory f3=new OrderHistory();
//        panel.add(f3,"f3");

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
        JLabel l1 = new JLabel("你好！"+name+"。您的余额为"+String.format("%.2f", money)+"元。");
        l1.setBounds((int) (930*width_r), (int) (30*height_r), (int) (400*width_r), (int) (55*height_r));
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
        //b1查询
        b1.setBounds((int) (0*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        Font myfont1 = new Font("微软雅黑", Font.BOLD, (int) (18*width_r));
        b1.setFont(myfont1);
        b1.setContentAreaFilled(false);//设置按钮透明
        b1.setFocusPainted(false);//把选中后出现的小方框去掉
        b1.setForeground(white); //字体颜色设置为白色
        //b1.setBorder(BorderFactory.createLineBorder(Color.white));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f1");
            }
        });
        add(b1);

        //b2购物车
        b2.setBounds((int) (200*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        b2.setFont(myfont1);
        b2.setContentAreaFilled(false);//设置按钮透明
        b2.setFocusPainted(false);
        b2.setForeground(white);
        //b2.setBorder(BorderFactory.createLineBorder(Color.white));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    resetshoptable();
                    List<ProductPair> p = Client_shop.checkReadyToBuy(myInfo.getId());
                    HashMap<Integer, Integer> all = new HashMap<>();
                    if(p!=null){
                        for (ProductPair productPair : p) {
                            if (all.get(productPair.getId()) != null) {
                                int t = all.get(productPair.getId()) + productPair.getNum();
                                all.put(productPair.getId(), t);
                            } else {
                                all.put(productPair.getId(), productPair.getNum());
                            }
                        }
                        List<Product> book = new ArrayList<>();
                        for (Integer i : all.keySet()) {
                            Product tempt = Client_shop.checkCertainProduct(i);
                            if(tempt!=null)
                                book.add(tempt);
                        }
                        if(book.size()!=0){
                            String[][] temp = new String[book.size()][];
                            for(int i =0;i<book.size();i++){
                                String[] tt =new String[6];
                                tt[0]=String.valueOf(book.get(i).getProduct_id());
                                tt[1]=book.get(i).getProduct_name();
                                tt[2]=String.valueOf(all.get(book.get(i).getProduct_id()));  //数量
                                tt[3]=String.valueOf(book.get(i).getProduct_price()*all.get(book.get(i).getProduct_id()));
                                tt[4]="购买";
                                tt[5]="删除";
                                temp[i]=tt;
                            }
                            shopCar.setMyBook(temp);
                        }
                    }
                    else {
                        shopCar.setMyBook(null);
                    }
                    shopCar f2=new shopCar();
                    panel.add(f2,"f2");
                    cardLayout.show(panel,"f2");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(b2);

        //b3我的订单
        b3.setBounds((int) (400*width_r), (int) (100*height_r), (int) (200*width_r), (int) (50*height_r));
        b3.setFont(myfont1);
        b3.setContentAreaFilled(false);//设置按钮透明
        b3.setFocusPainted(false);
        b3.setForeground(white);
        //b3.setBorder(BorderFactory.createLineBorder(Color.white));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    resetshoptable();
                    List<ProductPair> p = Client_shop.checkBuyed(myInfo.getId());
                    HashMap<Integer, Integer> all = new HashMap<Integer, Integer>();
                    if (p != null) {
                        for (ProductPair productPair : p) {
                            if (all.get(productPair.getId()) != null) {
                                int t = all.get(productPair.getId()) + productPair.getNum();
                                all.put(productPair.getId(), t);
                            } else {
                                all.put(productPair.getId(), productPair.getNum());
                            }
                        }
                        List<Product> book = new ArrayList<>();
                        for (Integer i : all.keySet()) {
                            Product tempt = Client_shop.checkCertainProduct(i);
                            if (tempt != null)
                                book.add(tempt);
                        }
                        if (book.size() != 0) {
                            String[][] temp = new String[book.size()][];
                            for (int i = 0; i < book.size(); i++) {
                                String[] tt = new String[5];
                                tt[0] = String.valueOf(book.get(i).getProduct_id());
                                tt[1] = book.get(i).getProduct_name();
                                tt[2] = String.valueOf(all.get(book.get(i).getProduct_id()));  //数量
                                tt[3] = String.valueOf(book.get(i).getProduct_price() * all.get(book.get(i).getProduct_id()));
                                temp[i] = tt;
                            }
                            OrderHistory.setCon_bought(temp);
                        }
                    } else {
                        //System.out.println("空");
                    }
                    OrderHistory f3=new OrderHistory();
                    panel.add(f3,"f3");
                    cardLayout.show(panel,"f3");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        add(b3);

        JButton b4=new JButton("退出商店");
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

    }
    public static void main(String[] args) throws Exception {
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) screensize.getWidth(); //得到宽度
        int height=(int) screensize.getHeight();//获得高度
        System.out.println(width);
        System.out.println(height);
        JFrame jf=new JFrame("shopCustomer");
        //jf = new JFrame("欢迎使用VCampus虚拟校园系统，请选择您的服务！");
        jf.setSize(width,height);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println("before creat");
        jf.setContentPane(new shopCustomer());
        System.out.println("after creat");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    };
}