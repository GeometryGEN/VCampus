package UIviewer.Library;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;
import UIviewer.Shopping.AddDeleteGoods;
import UIviewer.Shopping.adminChoiceButton;
import UIviewer.Shopping.shopAdmin;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static UIviewer.Shopping.shopAdmin.cardLayout;
import static UIviewer.Shopping.shopAdmin.panel;

/**
 * 添加删除本
 *
 * @author Llw
 * @date 2023/9/1
 */
public class AddDeleteBook extends JPanel {
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 20);

    public static String[] addinfo=new String[7];
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static String deleteID;
    //Boolean choice=true;//true为添加，false为删除,初始设置为添加商品

    /**
     * 添加删除商品
     */
    public AddDeleteBook(Boolean choice){
        setLayout(null);
        setBackground(color5);
        //左侧的分类面板背景
        JPanel p12=new JPanel();
        p12.setBounds(0,-5, (int) (330*width_r), (int) (1900*height_r));
        p12.setBackground(new Color(72,115,78,220));
        JPanel p13=new JPanel();
        p13.setBounds(0,-5,(int) (330*width_r), (int) (1900*height_r));
        JLabel pic1 = new JLabel();
        pic1.setIcon(new ImageIcon("src/image/librarybg2_min.jpg"));
        pic1.setBounds(0,0 ,(int) (330*width_r), (int) (1900*height_r));
        p13.add(pic1);

        //左侧的一些分类选择的按钮
        adminChoiceButton b12=new adminChoiceButton(true,0,100);
        adminChoiceButton b13=new adminChoiceButton(false,0,370);
        b12.setText("录入书籍");
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddDeleteBook f111= new AddDeleteBook(true);
                    panel.add(f111,"f111");
                    cardLayout.show(shopAdmin.panel, "f111");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        b13.setText("删除书籍");
        b13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddDeleteGoods f112= new AddDeleteGoods(false);
                    adminLib.panel.add(f112,"f112");
                    adminLib.cardLayout.show(shopAdmin.panel, "f112");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(b12);
        add(b13);
        //录入书籍的面板
        JPanel p14=new JPanel();
        p14.setBounds((int) (330*width_r), 0,(int) (930*width_r), (int) (1900*height_r));
        p14.setBackground(color5);
        p14.setLayout(null);

        //删除书籍的面板
        JPanel p15=new JPanel();
        p15.setBounds((int) (330*width_r),0,(int) (930*width_r), (int) (1900*height_r));
        p15.setBackground(color5);
        p15.setLayout(null);

        //输入商品信息
        JLabel l1 = new JLabel("书籍编号:");
        l1.setFont(myfont1);
        l1.setForeground(color2);
        l1.setBounds((int) (160*width_r), (int) (120*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l1);
        JTextField textField1=new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 17));
        textField1.setBounds((int) (255*width_r), (int) (120*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField1);
        textField1.setColumns(10);

        JLabel l2 = new JLabel("书名:");
        l2.setFont(myfont1);
        l2.setForeground(color2);
        l2.setBounds((int) (460*width_r), (int) (120*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l2);
        JTextField textField2=new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 17));
        textField2.setBounds((int) (555*width_r), (int) (120*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField2);
        textField2.setColumns(10);

        JLabel l3 = new JLabel("作者:");
        l3.setFont(myfont1);
        l3.setForeground(color2);
        l3.setBounds((int) (160*width_r), (int) (200*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 17));
        textField3.setBounds((int) (255*width_r), (int) (200*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField3);
        textField3.setColumns(10);

        JLabel l4 = new JLabel("价格:");
        l4.setFont(myfont1);
        l4.setForeground(color2);
        l4.setBounds((int) (460*width_r), (int) (200*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l4);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 17));
        textField4.setBounds((int) (555*width_r), (int) (200*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField4);
        textField4.setColumns(10);

        JLabel l5 = new JLabel("国家:");
        l5.setFont(myfont1);
        l5.setForeground(color2);
        l5.setBounds((int) (160*width_r), (int) (280*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l5);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 17));
        textField5.setBounds((int) (255*width_r), (int) (280*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField5);
        textField5.setColumns(10);

        JLabel l6 = new JLabel("馆藏地:");
        l6.setFont(myfont1);
        l6.setForeground(color2);
        l6.setBounds((int) (460*width_r), (int) (280*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l6);
        JTextField textField6 = new JTextField();
        textField6.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
        textField6.setBounds((int) (555 * width_r), (int) (280 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField6);
        textField6.setColumns(10);
        //注意，原来是从textF6获取字符串
        // String identity=(String)comboBox2.getSelectedItem();
        JLabel l7 = new JLabel("出版社:");
        l5.setFont(myfont1);
        l5.setForeground(color2);
        l5.setBounds((int) (160*width_r), (int) (360*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l5);
        JTextField textField7=new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 17));
        textField5.setBounds((int) (255*width_r), (int) (360*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField5);
        textField5.setColumns(10);

        JButton b1=new JButton("确定加入");
        b1.setFont(new Font("微软雅黑", Font.BOLD, (int) (18*width_r)));
        b1.setBounds((int) (360*width_r), (int) (380*height_r), (int) (120*width_r), (int) (50*height_r));
        b1.setForeground(Color.white);
        b1.setBackground(color3);
        p14.add(b1);
        b1.setFocusPainted(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                     // TODO Auto-generated method stub
                                     addinfo[0] = textField1.getText();
                                     addinfo[1] = textField2.getText();
                                     addinfo[2] = textField3.getText();
                                     addinfo[3] = textField4.getText();
                                     addinfo[4] = textField5.getText();
                                     addinfo[5] = textField6.getText();
                                     addinfo[6] = textField7.getText();
                                     try {
                                         Book_admin book = new Book_admin();
                                         book.setID(AddDeleteBook.addinfo[0]);
                                         book.setName(AddDeleteBook.addinfo[1]);
                                         book.setAuthor(AddDeleteBook.addinfo[2]);
                                         book.setPrice(Double.valueOf(AddDeleteBook.addinfo[3]));
                                         book.setCountry(AddDeleteBook.addinfo[4]);
                                         book.setPlace(AddDeleteBook.addinfo[5]);
                                         book.setPublisher(AddDeleteBook.addinfo[6]);
                                         book.setAvailable(1);
                                         Client_library.RequireAddBook(book);
                                         JOptionPane.showMessageDialog(null, "图书录入成功！");
                                     } catch (IOException ex) {
                                         throw new RuntimeException(ex);
                                     }
                                     textField1.setText("");
                                     textField2.setText("");
                                     textField3.setText("");
                                     textField4.setText("");
                                     textField5.setText("");
                                     textField6.setText("");
                                     textField7.setText("");

                                 }



        });


        JLabel l8 = new JLabel("书籍编号:");
        l8.setFont(myfont1);
        l8.setForeground(color2);
        l8.setBounds((int) (310*width_r), (int) (180*height_r), (int) (250*width_r), (int) (25*height_r));
        p15.add(l8);
        JTextField textField8=new JTextField();
        textField8.setFont(new Font("宋体", Font.BOLD, (int) (12*width_r)));
        textField8.setBounds((int) (425*width_r), (int) (180*height_r), (int) (125*width_r), (int) (25*height_r));
        p15.add(textField8);
        textField8.setColumns(10);

        JButton b2=new JButton("确定删除");
        b2.setFont(new Font("微软雅黑", Font.BOLD, (int) (18*width_r)));
        b2.setBounds((int) (380*width_r), (int) (250*height_r), (int) (120*width_r), (int) (50*height_r));
        b2.setForeground(Color.white);
        b2.setBackground(color3);
        p15.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //choice=false;
                try {
                    if(Client_shop.deleteProduct(textField8.getText()))
                        JOptionPane.showMessageDialog(null, "删除成功!");
                    else
                        JOptionPane.showMessageDialog(null, "删除失败!");
                    textField8.setText("");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        if(choice==true){
            System.out.println("应该显示添加的面板");
            p14.setVisible(true);
            add(p14);
        }else{
            p15.setVisible(true);
            add(p15);
        }

        add(p12);
        add(p13);
    }
//    public static String[] addinfo = new String[7];
//    static Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//    static int width = (int) screensize.getWidth(); //得到宽度
//    static int height = (int) screensize.getHeight();//获得高度
//    static double width_r = (double) (width) / 1273;
//    static double height_r = (double) (height) / 784;
//    public static String deleteID;
//    static JTextField  textField1,textField2,textField3,textField4,textField5,textField6,textField7;
//    /**
//     * 添加删除本
//     */
//    public AddDeleteBook(boolean b) {
//        setLayout(null);
//        JPanel p12=new JPanel();
//        p12.setBounds(0,-5, (int) (330*width_r), (int) (1900*height_r));
//        p12.setBackground(new Color(72,115,78,220));
//        JPanel p13=new JPanel();
//        p13.setBounds(0,-5,(int) (330*width_r), (int) (1900*height_r));
//        JLabel pic1 = new JLabel();
//        pic1.setIcon(new ImageIcon("src/image/librarybg2_min.jpg"));
//        pic1.setBounds(0,0 ,(int) (330*width_r), (int) (1900*height_r));
//        p13.add(pic1);
//        //左侧的一些分类选择的按钮
//        adminChoiceButton b12=new adminChoiceButton(true,0,100);
//        adminChoiceButton b13=new adminChoiceButton(false,0,370);
//        b12.setText("录入书籍");
//        b12.addActionListener((e)->{
//            try {
//                AddDeleteBook f111= new AddDeleteBook(true);
//                panel.add(f111,"f111");
//                cardLayout.show(shopAdmin.panel, "f111");
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        b13.setText("删除书籍");
//        b13.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    AddDeleteBook f112= new AddDeleteBook(false);
//                    adminLib.panel.add(f112,"f112");
//                    cardLayout.show(shopAdmin.panel, "f112");
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
//        });
//        //添加商品的面板
//        JPanel p14=new JPanel();
//        p14.setBounds((int) (330*width_r), 0,(int) (930*width_r), (int) (1900*height_r));
//        p14.setBackground(new Color(78,96,105));
//        p14.setLayout(null);
//
//        //删除商品的面板
//        JPanel p15=new JPanel();
//        p15.setBounds((int) (330*width_r),0,(int) (930*width_r), (int) (1900*height_r));
//        p15.setBackground(new Color(78,96,105));
//        p15.setLayout(null);
//
////        ButtonGroup option = new ButtonGroup();
////        JRadioButton addBook = new JRadioButton();
////        JRadioButton deleteBook = new JRadioButton();
////        addBook.setBounds((int) (470 * width_r), (int) (230 * height_r), (int) (20 * width_r), (int) (20 * height_r));
////        deleteBook.setBounds((int) (470 * width_r), (int) (320 * height_r), (int) (20 * width_r), (int) (20 * height_r));
////        option.add(addBook);
////        option.add(deleteBook);
////        add(addBook);
////        add(deleteBook);
////        JPanel p = new JPanel();
////        p.setBounds((int) (400 * width_r), (int) (80 * height_r), (int) (450 * width_r), (int) (350 * height_r));
////        p.setBackground(new Color(106, 113, 122, 150));
////        add(p);
////        JPanel p11 = new JPanel();
////        p11.setBounds(0, 0, (int) width, (int) height);
////        JLabel pic1 = new JLabel();
////        ImageIcon icon1 = new ImageIcon("src/image/library1_bg.jpg");
////        int icon1_width = 1280;
////        int icon1_height = 550;
////        try {
////            Thumbnails.of(new File("src/image/library1_bg.jpg"))
////                    .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
////                    .keepAspectRatio(false)
////                    .toFile(new File("src/image/librarybg1_min.jpg"));
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////        pic1.setIcon(new ImageIcon("src/image/librarybg1_min.jpg"));
////        pic1.setBounds(0, 0, (int) (icon1_width * width_r), (int) (icon1_height * height_r));
////        p11.add(pic1);
////        add(p11);
////        surebutton.addActionListener((e) -> {
////            if (addBook.isSelected()) {
////                addBookUI();
////            }
////            if(deleteBook.isSelected()){
////                deleteBookUI();
////            }
////        });
//    }
//
//    public static void addBookUI() {
//        JFrame jf = new JFrame("录入书籍");
//        JButton b1 = new JButton("确定录入");
//        b1.setFont(new Font("楷体", Font.BOLD, (int) (18 * width_r)));
//        b1.setBounds((int) (130*width_r), (int) (500*height_r), (int) (120*width_r), (int) (50*height_r));
//        b1.setBackground(new Color(68,64,105));
//        b1.setForeground(new Color(255,255,255));
//        b1.setFocusPainted(false);
//        jf.getContentPane().add(b1);
////        b1.addActionListener(new ActionListener() {
////                                 @Override
////                                 public void actionPerformed(ActionEvent e) {
////                                     // TODO Auto-generated method stub
////                                     addinfo[0] = textField1.getText();
////                                     addinfo[1] = textField2.getText();
////                                     addinfo[2] = textField3.getText();
////                                     addinfo[3] = textField4.getText();
////                                     addinfo[4] = textField5.getText();
////                                     addinfo[5] = textField6.getText();
////                                     addinfo[6] = textField7.getText();
////                                     try {
////                                         Book_admin book = new Book_admin();
////                                         book.setID(AddDeleteBook.addinfo[0]);
////                                         book.setName(AddDeleteBook.addinfo[1]);
////                                         book.setAuthor(AddDeleteBook.addinfo[2]);
////                                         book.setPrice(Double.valueOf(AddDeleteBook.addinfo[3]));
////                                         book.setCountry(AddDeleteBook.addinfo[4]);
////                                         book.setPlace(AddDeleteBook.addinfo[5]);
////                                         book.setPublisher(AddDeleteBook.addinfo[6]);
////                                         book.setAvailable(1);
////                                         Client_library.RequireAddBook(book);
////                                         JOptionPane.showMessageDialog(null, "图书录入成功！");
////                                     } catch (IOException ex) {
////                                         throw new RuntimeException(ex);
////                                     }
////                                     textField1.setText("");
////                                     textField2.setText("");
////                                     textField3.setText("");
////                                     textField4.setText("");
////                                     textField5.setText("");
////                                     textField6.setText("");
////                                     textField7.setText("");
////
////                                 }
////                             }
////        );
//
//
//
//        JPanel p = new JPanel();
//        p.setBounds((int) (50 * width_r), (int) (50 * height_r), (int) (300 * width_r), (int) (550 * height_r));
//        p.setBackground(new Color(106, 113, 122,100 ));
//        jf.getContentPane().add(p);
//
//        JPanel addBookPanel = new JPanel();
//        JLabel l1 = new JLabel("书籍编号:");
//        l1.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l1.setForeground(new Color(255, 255, 255));
//        l1.setOpaque(true);
//        l1.setBackground(new Color(64,68,105));
//        l1.setBounds((int) (100 * width_r), (int) (70 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        jf.getContentPane().add(l1);
//        textField1 = new JTextField();
//        textField1.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField1.setForeground(new Color(255,255,255));
//        textField1.setBackground(new Color(106,113,122));
//        textField1.setBounds((int) (175 * width_r), (int) (70 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField1);
//        textField1.setColumns(10);
//        JLabel l2 = new JLabel("书名:");
//        l2.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l2.setBounds((int) (100 * width_r), (int) (130 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        l2.setForeground(new Color(255, 255, 255));
//        l2.setBackground(new Color(64,68,105));
//        l2.setOpaque(true);
//        l2.setOpaque(true);
//        jf.add(l2);
//
//        textField2 = new JTextField();
//        textField2.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField2.setBounds((int) (175 * width_r), (int) (130 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField2);
//        textField2.setColumns(10);
//        textField2.setForeground(new Color(255,255,255));
//        textField2.setBackground(new Color(106,113,122));
//        JLabel l3 = new JLabel("作者:");
//        l3.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l3.setBounds((int) (100 * width_r), (int) (190 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        jf.add(l3);
//        l3.setForeground(new Color(255, 255, 255));
//        l3.setOpaque(true);
//        l3.setBackground(new Color(64,68,105));
//        textField3 = new JTextField();
//        textField3.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField3.setBounds((int) (175 * width_r), (int) (190 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField3);
//        textField3.setColumns(10);
//        textField3.setForeground(new Color(255,255,255));
//        textField3.setBackground(new Color(106,113,122));
//        JLabel l4 = new JLabel("价格:");
//        l4.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l4.setBounds((int) (100 * width_r), (int) (250 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        jf.add(l4);
//        l4.setForeground(new Color(255, 255, 255));
//        l4.setOpaque(true);
//        l4.setBackground(new Color(64,68,105));
//        textField4 = new JTextField();
//        textField4.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField4.setBounds((int) (175 * width_r), (int) (250 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField4);
//        textField4.setColumns(10);
//        textField4.setForeground(new Color(255,255,255));
//        textField4.setBackground(new Color(106,113,122));
//        JLabel l5 = new JLabel("国家:");
//        l5.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l5.setBounds((int) (100 * width_r), (int) (310 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        jf.add(l5);
//        l5.setForeground(new Color(255, 255, 255));
//        l5.setOpaque(true);
//        l5.setBackground(new Color(64,68,105));
//        textField5 = new JTextField();
//        textField5.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField5.setBounds((int) (175 * width_r), (int) (310 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField5);
//        textField5.setColumns(10);
//        textField5.setForeground(new Color(255,255,255));
//        textField5.setBackground(new Color(106,113,122));
//        JLabel l6 = new JLabel("馆藏地:");
//        l6.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l6.setBounds((int) (100 * width_r), (int) (370 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        jf.add(l6);
//        l6.setForeground(new Color(255, 255, 255));
//        l6.setOpaque(true);
//        l6.setBackground(new Color(64,68,105));
//        textField6 = new JTextField();
//        textField6.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField6.setBounds((int) (175 * width_r), (int) (370 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField6);
//        textField6.setColumns(10);
//        textField6.setForeground(new Color(255,255,255));
//        textField6.setBackground(new Color(106,113,122));
//        JLabel l7 = new JLabel("出版社:");
//        l7.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l7.setBounds((int) (100 * width_r), (int) (430 * height_r), (int) (200 * width_r), (int) (25 * height_r));
//        jf.add(l7);
//        l7.setForeground(new Color(255, 255, 255));
//        l7.setOpaque(true);
//        l7.setBackground(new Color(64,68,105));
//        textField7 = new JTextField();
//        textField7.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField7.setBounds((int) (175 * width_r), (int) (430 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField7);
//        textField7.setColumns(10);
//        textField7.setForeground(new Color(255,255,255));
//        textField7.setBackground(new Color(106,113,122));
//        JLabel l8 = new JLabel("   ");
//        l8.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l8.setBounds((int) (80 * width_r), (int) (490 * height_r), (int) (250 * width_r), (int) (25 * height_r));
//        jf.add(l8);
//        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        jf.setVisible(true);
//        jf.setSize(400, 600);
//        JPanel p11 = new JPanel();
//        p11.setBounds(0, 0, (int) width, (int) height);
//        JLabel pic1 = new JLabel();
//        ImageIcon icon1 = new ImageIcon("src/image/library2_bg.jpg");
//        int icon1_width = 400;
//        int icon1_height = 600;
//        try {
//            Thumbnails.of(new File("src/image/library2_bg.jpg"))
//                    .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
//                    .keepAspectRatio(false)
//                    .toFile(new File("src/image/librarybg2_min.jpg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        pic1.setIcon(new ImageIcon("src/image/librarybg2_min.jpg"));
//        pic1.setBounds(0, 0, (int) (icon1_width * width_r), (int) (icon1_height * height_r));
//        p11.add(pic1);
//        jf.getContentPane().add(p11);//add(p11);
//    }
//    public static void deleteBookUI(){
//        JFrame jf=new JFrame("删除书籍");
//        //jf.setLayout(null);
//        JButton b2=new JButton("确定删除");
//        b2.setFont(new Font("楷体", Font.BOLD, (int) (18*width_r)));
//        b2.setBounds(125,125,150,40);
//        b2.setForeground(new Color(255,255,255));
//        b2.setBackground(new Color(64,68,105));
//        jf.getContentPane().add(b2);
//        JLabel l1=new JLabel("书籍编号");
//        l1.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
//        l1.setBounds((int) (100 * width_r), (int) (70* height_r), (int) (200 * width_r), (int) (25 * height_r));
//        l1.setBackground(new Color(64,68,105));
//        l1.setOpaque(true);
//        l1.setForeground(new Color(255,255,255));
//        jf.getContentPane().add(l1);
//        JTextField textField8 = new JTextField();
//        textField8.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
//        textField8.setForeground(new Color(255,255,255));
//        textField8.setBackground(new Color(106,113,122));
//        textField8.setBounds((int) (175 * width_r), (int) (70 * height_r), (int) (125 * width_r), (int) (25 * height_r));
//        jf.add(textField8);
//        textField8.setColumns(10);
//        JPanel p = new JPanel();
//        p.setBounds(50,25,300,200);
//        p.setBackground(new Color(106, 113, 122,100 ));
//        jf.getContentPane().add(p);
//        b2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // TODO Auto-generated method stub
//                deleteID=textField8.getText();
//                try {
//                    Client_library.RequireDeleteBook(deleteID);
//                   // JOptionPane.showMessageDialog(null,"图书删除成功！");
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//                textField8.setText("");
//            }
//        });
//        JPanel p11 = new JPanel();
//        p11.setBounds(0, 0, (int) width, (int) height);
//        JLabel pic1 = new JLabel();
//        ImageIcon icon1 = new ImageIcon("src/image/library3_bg.jpg");
//        int icon1_width = 400;
//        int icon1_height = 300;
//        try {
//            Thumbnails.of(new File("src/image/library3_bg.jpg"))
//                    .size((int) (icon1_width * width_r), (int) (icon1_height * height_r))
//                    .keepAspectRatio(false)
//                    .toFile(new File("src/image/librarybg3_min.jpg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        pic1.setIcon(new ImageIcon("src/image/librarybg3_min.jpg"));
//        pic1.setBounds(0, 0, (int) (icon1_width * width_r), (int) (icon1_height * height_r));
//        p11.add(pic1);
//        jf.getContentPane().add(p11);//add(p11);
//
//        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        jf.setVisible(true);
//        jf.setSize(400, 300);
//
//    }

}


