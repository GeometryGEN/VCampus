package UIviewer.Shopping;

import ClientToServer.myInfo;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static UIviewer.Shopping.shopCustomer.cardLayout;
import static UIviewer.Shopping.shopCustomer.panel;


public class Item_Rearch_Customer extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    //public static JPanel panel = new JPanel();;
    static String name;
    public static CardLayout cardLayout=new CardLayout();
    static void getName(String a)
    {
        name=a;
    }

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 20);

    public static JButton b11=new JButton("商城");
    public static JButton b12=new JButton("购物车");
    public static JButton b13=new JButton("我的订单");

    public static Object[][] data;
    public static Object[][] getData() {
        return data;
    }
    public static void setData(Object[][] data) {
        ShoppingHall.data = data;
    }

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

    public Item_Rearch_Customer() {
        setLayout(null);
        //主体背景
        JPanel p11 = new JPanel();;
        p11.setBounds(0,-5, (int) (1273*width_r), (int) (650*height_r));
        p11.setBackground(color5);

        //左侧的分类面板背景
        JPanel p12=new JPanel();
        p12.setBounds(0,-5, (int) (330*width_r), (int) (1900*height_r));
        p12.setBackground(color4);
        //分类标题
        JLabel l19 = new JLabel("类别选择");
        l19.setBounds(135,-5, (int) (150*width_r), (int) (50*height_r));
        l19.setForeground(Color.white);
        Font font5 = new Font("微软雅黑", Font.BOLD, (int) (22*width_r));
        l19.setFont(font5);
        add(l19);

        //输入搜索内容的文本框
        JTextField textField=new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, (int) (18*width_r)));
        //textField.setBounds(0,0, getMaximumSize().width, getMaximumSize().height);
        textField.setBounds((int)(600*width_r), (int) (80*height_r), (int) (420*width_r), (int) (50*height_r));
        textField.setBackground(color1);
        //textField.setOpaque(false);
        textField.setColumns((int) (10*height_r));
        add(textField);

        //东南大学logo
        JLabel logo = new JLabel();
        int icon1_width=  (int) (60*width_r);
        int icon1_height=(int) (60*height_r);
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/商店/1.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/商店/1_fit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/商店/1_fit.png"));
        logo.setBounds((int) (510*width_r), (int) (70*height_r), (int) (70*width_r), (int) (70*height_r));
        add(logo);

        //搜索按钮
        JButton b11=new JButton("搜索");
        b11.setBounds((int) (1018*width_r), (int) (80*height_r), (int) (80*width_r), (int) (50*height_r));
        Font myfont = new Font("黑体", Font.BOLD, (int) (22*width_r));
        b11.setFont(myfont);
        b11.setBackground(color3);
        b11.setForeground(new Color(255,255,255));
        b11.setFocusPainted(false);
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String searchInfo=textField.getText();
                try {
                    List<Product> t = Client_shop.checkProduct(searchInfo);
                    if(t!=null){
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
                        setShoptable(temp);
                    }else {
                        // System.out.println("kong");
                        setShoptable(null);
                    }
                    ShoppingHall f112=new ShoppingHall();
                    panel.add(f112,"f112");
                    cardLayout.show(panel, "f112");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        mySortButton b12=new mySortButton("食品/酒水",20,150);
        mySortButton b13=new mySortButton("图书/文娱",20,250);
        mySortButton b14=new mySortButton("服饰/运动",20,350);
        mySortButton b15=new mySortButton("电子数码",20,450);
        mySortButton b16=new mySortButton("医药/保健",20,550);
        mySortButton b17=new mySortButton("生活百货",20,650);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);
        add(b17);
        add(b11);
        add(p12);
        add(p11);

        String[] tableTitle = {"商品编号","商品名称","价格","剩余数量","购买数量","加入购物车","购买"};
        TableModel dtm = new DefaultTableModel(shoptable, tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                if(column==4)
                {
                    return true;
                }
                else {
                    return false;
                }
            }
        };
        //将表格数据数组放入表格模型,并重写getColumnClass方法
        table_want.setModel(dtm);
        //调整美化
        table_want.setFont(new Font("微软雅黑",Font.BOLD, (int) (16*width_r)));

        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (column!=5&&column!=6) {
                        setBackground(Color.white);
                    }else {
                        setBackground(new Color(250,128,114,100));
                        //setForeground(new Color(255,255,255));
                        //setFont(new Font("微软雅黑",Font.BOLD,18));
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            };
            //居中
            tcr.setHorizontalAlignment(JLabel.CENTER);
            table_want.setDefaultRenderer(Object.class, tcr);
            for (int i = 0; i < table_want.getColumnCount(); i++)
            {
                table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table_want.getSelectedColumn() == 5) {
                    //购物车
                    int id= Integer.parseInt((String) table_want.getValueAt(table_want.getSelectedRow(),0));
                    int Num = Integer.parseInt((String) table_want.getValueAt(table_want.getSelectedRow(),4));
                    try {
                        Client_shop.addToShopCar(myInfo.getId(),id,Num);
                        JOptionPane.showMessageDialog(null,"添加购物车成功！");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (table_want.getSelectedColumn() == 6) {

                    String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                    double money= Double.parseDouble((String) table_want.getValueAt(table_want.getSelectedRow(),2));
                    int Num = Integer.parseInt((String) table_want.getValueAt(table_want.getSelectedRow(),4));
                    try {
                        double temp1;
                        if(myInfo.getType()==1){
                            temp1=Client_shop.getMoney(myInfo.getId());
                        }
                        else{
                            temp1=Client_shop.getMoney_Teacher(myInfo.getId());
                        }
                        if(temp1>=(money*Num)){
                            if(myInfo.getType()==1){
                                if(Client_shop.buyProduct(myInfo.getId(),id,Num,Client_shop.getMoney(myInfo.getId())-money*Num))
                                    JOptionPane.showMessageDialog(null,"购买成功！");
                            }
                            else {
                                if(Client_shop.buyProduct_Teacher(myInfo.getId(),id,Num,Client_shop.getMoney_Teacher(myInfo.getId())-money*Num))
                                    JOptionPane.showMessageDialog(null,"购买成功！");
                            }
                            List<Product> t = Client_shop.returnAllProduct();
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
                            Item_Rearch_Customer.setShoptable(temp);
                            Item_Rearch_Customer f1=new Item_Rearch_Customer();
                            panel.add(f1,"f1");

                            Client_shop.setId(String.valueOf(myInfo.getType()));
                            Client_shop.setIdcard(myInfo.getId());
                            functionChoose.jf.setContentPane(new shopCustomer());
                            Item_Rearch_Customer f11=new Item_Rearch_Customer();
                            panel.add(f11,"f11");
                            cardLayout.show(panel,"f11");
                            functionChoose.jf.setTitle("shopCustomer");
                        }else {
                            JOptionPane.showMessageDialog(null,"余额不足！");
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds((int) (340*width_r), (int) (100*height_r), (int) (940*width_r), (int) (460*height_r));
        add(jsp);
        table_want.setRowHeight(30);

        setVisible(true);

    }

}
