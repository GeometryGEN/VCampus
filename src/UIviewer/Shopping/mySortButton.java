package UIviewer.Shopping;
import UIhandler.Shop.Client_shop;
import DAO.Shop.Product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import static UIviewer.Shopping.shopCustomer.cardLayout;
import static UIviewer.Shopping.shopCustomer.panel;
import ClientToServer.myInfo;
import UIhandler.Library.Client_library;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import static UIhandler.Shop.Client_shop.checktypeProduct;
import static UIviewer.login.forgetPWD.forgetPWDUI;

public class mySortButton extends JButton {

    private String text;
    private Color backgroundColor;
    private Color foregroundColor;
    private Font font;
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static String[][] shoptable;
    public static void resetshoptable(){
        shoptable=null;
    }

    public static String[][] getShoptable() {
        return shoptable;
    }

    public static void setShoptable(String[][] shoptable) {
        ShoppingHall.shoptable = shoptable;
    }

    //将t2的元素添加到t1中
    public static List <Product> additem(List <Product> t1,List <Product> t2) {
        if(t2!=null){
            t1.addAll(t2);
        }
        return t1;
    }

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(72,115,78,20);
    Color color7=new Color(23,58,26,20);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);

    public mySortButton(String text,int x,int y) {
        this.text = text;
        this.font = new Font("微软雅黑", Font.BOLD, 24);
        setBounds((int) (x * width_r), (int) (y * height_r), (int) (330 * width_r), (int) (70 * height_r));
        this.backgroundColor = color6;
        this.foregroundColor = Color.WHITE;
        setBorder(BorderFactory.createLineBorder(color6));
        setFocusPainted(false);
        init();

        //JLabel labelnote=new JLabel("抱歉，暂无符合条件的商品。");


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setContentAreaFilled(false);//设置按钮透明
                setBackground(color5);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setContentAreaFilled(true);//设置按钮透明
                setBackground(color4);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                //setFont(myfont2);
                setBackgroundColor(color2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //setFont(myfont1);
                setBackgroundColor(color4);
            }
        });
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List <Product> t =new ArrayList<>();
                    if(text=="食品/酒水"){
                        //tn!=null时才能addall
                        List <Product> t1=(Client_shop.checktypeProduct("零食"));
                        t=additem(t,t1);
                        List <Product> t2=(Client_shop.checktypeProduct("饼干"));
                        t=additem(t,t2);
                        System.out.println("additem(t,t2); !!!!");
                        List <Product> t3=(Client_shop.checktypeProduct("茶"));
                        t=additem(t,t3);
                        List <Product> t4=(Client_shop.checktypeProduct("生鲜"));
                        t=additem(t,t4);
                        //记得把下面的都改了！！！不能加空的！！！！！！
                        //！！！！
                    } else if (text=="医药/保健") {
                        List <Product> t1=(Client_shop.checktypeProduct("医药"));
                        t=additem(t,t1);
                        List <Product> t2=(Client_shop.checktypeProduct("保健"));
                        t=additem(t,t2);
                    }else if (text=="电子数码") {
                        List <Product> t1=(Client_shop.checktypeProduct("手机"));
                        t=additem(t,t1);
                        List <Product> t2=(Client_shop.checktypeProduct("数码"));
                        t=additem(t,t2);
                        List <Product> t3=(Client_shop.checktypeProduct("电器"));
                        t=additem(t,t3);
                    }else if (text=="图书/文娱") {
                        List <Product> t1=(Client_shop.checktypeProduct("手机"));
                        t=additem(t,t1);
                        List <Product> t2=(Client_shop.checktypeProduct("书籍"));
                        t=additem(t,t2);
                    }else if (text=="服饰/运动") {
                        List <Product> t1=(Client_shop.checktypeProduct("饰品"));
                        t=additem(t,t1);
                        List <Product> t2=(Client_shop.checktypeProduct("男装"));
                        t=additem(t,t2);
                        List <Product> t3=(Client_shop.checktypeProduct("运动"));
                        t=additem(t,t3);
                    }
                    else if (text=="生活百货") {
                        List <Product> t1=(Client_shop.checktypeProduct("百货"));
                        t=additem(t,t1);
                        List <Product> t2=(Client_shop.checktypeProduct("厨具"));
                        t=additem(t,t2);
                        List <Product> t3=(Client_shop.checktypeProduct("家装"));
                        t=additem(t,t3);
                        List <Product> t4=(Client_shop.checktypeProduct("礼品"));
                        t=additem(t,t4);
                        List <Product> t5=(Client_shop.checktypeProduct("洗护"));
                        t=additem(t,t5);
                        List <Product> t6=(Client_shop.checktypeProduct("美妆"));
                        t=additem(t,t6);
                    }
                    ShoppingHall f11= new ShoppingHall();
                    if (t != null) {
                        String[][] temp = new String[t.size()][];
                        for (int i = 0; i < t.size(); i++) {
                            String[] tt = new String[7];
                            tt[0] = String.valueOf(t.get(i).getProduct_id());
                            tt[1] = t.get(i).getProduct_name();
                            tt[2] = String.valueOf(t.get(i).getProduct_price());
                            tt[3] = String.valueOf(t.get(i).getProduct_currentNumbers());
                            tt[4] = "1";
                            tt[5] = "加入购物车";
                            tt[6] = "购买";
                            temp[i] = tt;
                        }
                        f11.setShoptable(temp);
                    } else {
                        f11.setShoptable(null);
                    }

                    panel.add(f11, "f11");
                    cardLayout.show(panel, "f11");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void init() {
        setText(text);
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setFont(font);
    }

    public void setText(String text) {
        this.text = text;
        super.setText(text);
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        super.setBackground(color);
    }

    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
        super.setForeground(color);
    }

    public void setFont(Font font) {
        this.font = font;
        super.setFont(font);
    }
}
