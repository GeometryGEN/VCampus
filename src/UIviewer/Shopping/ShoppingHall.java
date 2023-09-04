package UIviewer.Shopping;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import ClientToServer.myInfo;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static UIhandler.Shop.Client_shop.checktypeProduct;
import static UIviewer.Shopping.shopCustomer.cardLayout;
import static UIviewer.Shopping.shopCustomer.panel;
import static UIviewer.login.forgetPWD.forgetPWDUI;

/**
 * 购物大厅
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class ShoppingHall extends JPanel {
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(243,248,242);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 20);

    public static JButton b11=new JButton("商城");
    public static JButton b12=new JButton("购物车");
    public static JButton b13=new JButton("我的订单");


    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    public static Object[][] data;

    /**
     * 获取数据
     *
     * @return {@link Object[][]}
     */
    public static Object[][] getData() {
        return data;
    }

    /**
     * 集数据
     *
     * @param data 数据
     */
    public static void setData(Object[][] data) {
        ShoppingHall.data = data;
    }

    public static String[][] shoptable;

    /**
     * resetshoptable
     */
    public static void resetshoptable(){
        shoptable=null;
    }

    /**
     * 得到shoptable
     *
     * @return {@link String[][]}
     */
    public static String[][] getShoptable() {
        return shoptable;
    }

    /**
     * 设置shoptable
     *
     * @param shoptable shoptable
     */
    public static void setShoptable(String[][] shoptable) {
        ShoppingHall.shoptable = shoptable;
    }

    /**
     * 购物大厅
     */
    public ShoppingHall() {
        setLayout(null);

        setBackground(color5);
        //左侧的分类面板背景
        JPanel p12=new JPanel();
        p12.setBounds(0,-5, (int) (330*width_r), (int) (1900*height_r));
        p12.setBackground(new Color(72,115,78,220));
        JPanel p13=new JPanel();
        p13.setBounds(0,-5,(int) (330*width_r), (int) (1900*height_r));
        JLabel pic1 = new JLabel();
        pic1.setIcon(new ImageIcon("src/image/商店/2.jpg"));
        pic1.setBounds(0,0 ,(int) (330*width_r), (int) (1900*height_r));
        p13.add(pic1);
        //分类标题
        JLabel l19 = new JLabel("类别选择");
        l19.setHorizontalAlignment(JLabel.CENTER); // 将文本居中
        l19.setBounds(0,0, (int) (330*width_r), (int) (70*height_r));
        l19.setForeground(Color.white);
        Font font5 = new Font("微软雅黑", Font.BOLD, (int) (22*width_r));
        l19.setFont(font5);
        l19.setBorder(BorderFactory.createLineBorder(Color.white));
        add(l19);

        //输入搜索内容的文本框
        JTextField textField=new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, (int) (18*width_r)));
        textField.setBounds((int)(600*width_r), (int) (80*height_r), (int) (420*width_r), (int) (50*height_r));
        textField.setBackground(color1);
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
        add(b11);

        //左侧的一些分类选择的按钮
        mySortButton b12=new mySortButton("食品/酒水",0,100);
        mySortButton b13=new mySortButton("图书/文娱",0,170);
        mySortButton b14=new mySortButton("服饰/运动",0,240);
        mySortButton b15=new mySortButton("电子数码",0,310);
        mySortButton b16=new mySortButton("医药/保健",0,370);
        mySortButton b17=new mySortButton("生活百货",0,440);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);
        add(b17);

        String[] tableTitle = {"商品编号","商品名称","价格","剩余数量","购买数量","加入购物车","购买"};
        //数据

//        //将图片Icon对象放入表格数据数组
//        Object[][] data = new Object[][] {
//                {new ImageIcon("E://Vcampus//src//image//1.jpg"), "Text 2","111","222"}
//        };

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
        JTableHeader jTableHeader=table_want.getTableHeader();
        jTableHeader.setFont(new Font("等线", Font.BOLD, 25));
        jTableHeader.setBackground(color3);
        jTableHeader.setForeground(Color.white);

        //调整美化
        table_want.setFont(new Font("宋体",Font.BOLD, (int) (16*width_r)));
        table_want.setBackground(color5);
        setBackground(color5);

        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (row % 2 == 0) {
                        setBackground(color5);
                    } else {
                        setBackground(color6);
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
                                ShoppingHall.setShoptable(temp);
                                ShoppingHall f1=new ShoppingHall();
                                panel.add(f1,"f1");

                                Client_shop.setId(String.valueOf(myInfo.getType()));
                                Client_shop.setIdcard(myInfo.getId());
                                functionChoose.jf.setContentPane(new shopCustomer());
                                ShoppingHall f11=new ShoppingHall();
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
            jsp.setBounds((int) (340*width_r), (int) (180*height_r), (int) (900*width_r), (int) (360*height_r));
            jsp.setBackground(color5);
            jsp.getViewport().setOpaque(false);
            add(jsp);
            table_want.setRowHeight(30);

        setVisible(true);
        add(p12);
        add(p13);
        }
}

