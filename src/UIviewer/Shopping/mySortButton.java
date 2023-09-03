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
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);

    public mySortButton(String text,int x,int y) {
        this.text = text;
        this.font = new Font("微软雅黑", Font.BOLD, 19);
        setBounds((int) (x * width_r), (int) (y * height_r), (int) (80 * width_r), (int) (30 * height_r));
        this.backgroundColor = color4;
        this.foregroundColor = Color.WHITE;
        setBorder(BorderFactory.createLineBorder(color4));
        setFocusPainted(false);
        init();

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
                        t.addAll(Client_shop.checktypeProduct("零食"));
                        System.out.println("1111111111111111");
                        List <Product> t2=(Client_shop.checktypeProduct("饼干"));
                        //t.addAll(t2);
                        System.out.println("t2 creat !!!!");
                        if(t2==null){System.out.println("t2==null!!!!!!");}
                        t.addAll(Client_shop.checktypeProduct("茶"));
                        t.addAll(Client_shop.checktypeProduct("生鲜"));
                    } else if (text=="医药/保健") {
                        t.addAll(Client_shop.checktypeProduct("医药"));
                        t.addAll(Client_shop.checktypeProduct("保健"));
                    }else if (text=="电子数码") {
                        t.addAll(Client_shop.checktypeProduct("手机"));
                        t.addAll(Client_shop.checktypeProduct("数码"));
                        t.addAll(Client_shop.checktypeProduct("电器"));
                    }else if (text=="图书/文娱") {
                        t.addAll(Client_shop.checktypeProduct("手机"));
                    }else if (text=="服饰/运动") {
                        t.addAll(Client_shop.checktypeProduct("饰品"));
                        t.addAll(Client_shop.checktypeProduct("男装"));
                        t.addAll(Client_shop.checktypeProduct("运动"));
                    }
                    else if (text=="生活百货") {
                        t.addAll(Client_shop.checktypeProduct("百货"));
                        t.addAll(Client_shop.checktypeProduct("厨具"));
                        t.addAll(Client_shop.checktypeProduct("家装"));
                        t.addAll(Client_shop.checktypeProduct("礼品"));
                        t.addAll(Client_shop.checktypeProduct("洗护"));
                        t.addAll(Client_shop.checktypeProduct("美妆"));
                    }
                    Item_Rearch_Customer f11= new Item_Rearch_Customer();
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

/*
JButton btnNewButton_1 = new JButton("零食");
        btnNewButton_1.setBounds((int) (20*width_r), (int) (150*height_r), (int) (80*width_r), (int) (30*height_r));
        btnNewButton_1.setFont(myfont1);
        btnNewButton_1.setForeground(new Color(255,255,255));
        btnNewButton_1.setBackground(new Color(254,178,148));
        btnNewButton_1.setBorder(BorderFactory.createLineBorder(new Color(254,178,148)));
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                btnNewButton_1.setContentAreaFilled(false);//设置按钮透明
                btnNewButton_1.setBackground(new Color(255,160,122));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                btnNewButton_1.setContentAreaFilled(true);//设置按钮透明
                btnNewButton_1.setBackground(new Color(254,178,148));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnNewButton_1.setFont(new Font("楷体",Font.BOLD, (int) (20*width_r)));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnNewButton_1.setFont(new Font("楷体 ", Font.PLAIN, (int) (18*width_r)));
            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Product> t = Client_shop.checktypeProduct("零食");
                    if(t!=null) {
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
                        setShoptable(temp);
                    }else {
                        setShoptable(null);
                    }
                    ShoppingHall f11=new ShoppingHall();
                    panel.add(f11,"f11");
                    cardLayout.show(panel, "f11");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } }
        });

 */
