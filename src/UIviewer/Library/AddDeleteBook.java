package UIviewer.Library;
import DAO.Library.Book_admin;
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
    //Color color1 = new Color(233, 244, 255);
    Color color2 = new Color(1, 15, 68);
    Color color3 = new Color(1, 63, 110);
    //Color color4 = new Color(72, 115, 78);
    Color color5 = new Color(199, 204, 211);
    Font myfont1 = new Font("微软雅黑", Font.BOLD, 20);

    public static String[] addinfo = new String[7];
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screensize.getWidth(); //得到宽度
    int height = (int) screensize.getHeight();//获得高度
    double width_r = (double) (width) / 1273;
    double height_r = (double) (height) / 784;
    public static String deleteID;
    //Boolean choice=true;//true为添加，false为删除,初始设置为添加商品

    /**
     * 添加删除商品
     */
    public AddDeleteBook(Boolean choice) {
        setLayout(null);
        setBackground(color5);
        //左侧的分类面板背景
        JPanel p12 = new JPanel();
        p12.setBounds(0, -5, (int) (330 * width_r), (int) (1900 * height_r));
        p12.setBackground(new Color(87, 101, 123, 190));
        JPanel p13 = new JPanel();
        p13.setBounds(0, -5, (int) (330 * width_r), (int) (1900 * height_r));
        JLabel pic1 = new JLabel();
        pic1.setIcon(new ImageIcon("src/image/librarybg2_min.jpg"));
        pic1.setBounds(0, 0, (int) (330 * width_r), (int) (1900 * height_r));
        p13.add(pic1);

        //左侧的一些分类选择的按钮
        adminChoiceButton b12 = new adminChoiceButton(true, 0, 100);
        adminChoiceButton b13 = new adminChoiceButton(false, 0, 370);
        b12.setText("录入书籍");
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddDeleteBook f111 = new AddDeleteBook(true);
                    panel.add(f111, "f111");
                    cardLayout.show(adminLib.panel, "f111");
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
                    AddDeleteBook f112 = new AddDeleteBook(false);
                    adminLib.panel.add(f112, "f112");
                    adminLib.cardLayout.show(adminLib.panel, "f112");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(b12);
        add(b13);
        //录入书籍的面板
        JPanel p14 = new JPanel();
        p14.setBounds((int) (330 * width_r), 0, (int) (930 * width_r), (int) (1900 * height_r));
        p14.setBackground(color5);
        p14.setLayout(null);

        //删除书籍的面板
        JPanel p15 = new JPanel();
        p15.setBounds((int) (330 * width_r), 0, (int) (930 * width_r), (int) (1900 * height_r));
        p15.setBackground(color5);
        p15.setLayout(null);

        //输入商品信息
        JLabel l1 = new JLabel("书籍编号:");
        l1.setFont(myfont1);
        l1.setForeground(color2);
        l1.setBounds((int) (160 * width_r), (int) (120 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l1);
        JTextField textField1 = new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 17));
        textField1.setBounds((int) (255 * width_r), (int) (120 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField1);
        textField1.setColumns(10);

        JLabel l2 = new JLabel("书名:");
        l2.setFont(myfont1);
        l2.setForeground(color2);
        l2.setBounds((int) (460 * width_r), (int) (120 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l2);
        JTextField textField2 = new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 17));
        textField2.setBounds((int) (555 * width_r), (int) (120 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField2);
        textField2.setColumns(10);

        JLabel l3 = new JLabel("作者:");
        l3.setFont(myfont1);
        l3.setForeground(color2);
        l3.setBounds((int) (160 * width_r), (int) (200 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l3);
        JTextField textField3 = new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 17));
        textField3.setBounds((int) (255 * width_r), (int) (200 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField3);
        textField3.setColumns(10);

        JLabel l4 = new JLabel("价格:");
        l4.setFont(myfont1);
        l4.setForeground(color2);
        l4.setBounds((int) (460 * width_r), (int) (200 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l4);
        JTextField textField4 = new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 17));
        textField4.setBounds((int) (555 * width_r), (int) (200 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField4);
        textField4.setColumns(10);

        JLabel l5 = new JLabel("国家:");
        l5.setFont(myfont1);
        l5.setForeground(color2);
        l5.setBounds((int) (160 * width_r), (int) (280 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l5);
        JTextField textField5 = new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 17));
        textField5.setBounds((int) (255 * width_r), (int) (280 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField5);
        textField5.setColumns(10);

        JLabel l6 = new JLabel("馆藏地:");
        l6.setFont(myfont1);
        l6.setForeground(color2);
        l6.setBounds((int) (460 * width_r), (int) (280 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l6);
        JTextField textField6 = new JTextField();
        textField6.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
        textField6.setBounds((int) (555 * width_r), (int) (280 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField6);
        textField6.setColumns(10);
        // String identity=(String)comboBox2.getSelectedItem();
        JLabel l7 = new JLabel("出版社:");
        l7.setFont(myfont1);
        l7.setForeground(color2);
        l7.setBounds((int) (160 * width_r), (int) (360 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l7);
        JTextField textField7 = new JTextField();
        textField7.setFont(new Font("宋体", Font.BOLD, 17));
        textField7.setBounds((int) (255 * width_r), (int) (360 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p14.add(textField7);
        textField7.setColumns(10);
        JLabel l8 = new JLabel("   ");
        l8.setFont(new Font("宋体", Font.BOLD, (int) (15 * width_r)));
        l8.setBounds((int) (460 * width_r), (int) (360 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p14.add(l8);
        JButton b1 = new JButton("确定加入");
        b1.setFont(new Font("微软雅黑", Font.BOLD, (int) (18 * width_r)));
        b1.setBounds((int) (360 * width_r), (int) (430 * height_r), (int) (120 * width_r), (int) (50 * height_r));
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


        JLabel l9 = new JLabel("书籍编号:");
        l9.setFont(myfont1);
        l9.setForeground(color2);
        l9.setBounds((int) (310 * width_r), (int) (180 * height_r), (int) (250 * width_r), (int) (25 * height_r));
        p15.add(l9);
        JTextField textField8 = new JTextField();
        textField8.setFont(new Font("宋体", Font.BOLD, (int) (12 * width_r)));
        textField8.setBounds((int) (425 * width_r), (int) (180 * height_r), (int) (125 * width_r), (int) (25 * height_r));
        p15.add(textField8);
        textField8.setColumns(10);

        JButton b2 = new JButton("确定删除");
        b2.setFont(new Font("微软雅黑", Font.BOLD, (int) (18 * width_r)));
        b2.setBounds((int) (380 * width_r), (int) (250 * height_r), (int) (120 * width_r), (int) (50 * height_r));
        b2.setForeground(Color.white);
        b2.setBackground(color3);
        p15.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                deleteID = textField8.getText();
                try {
                    Client_library.RequireDeleteBook(deleteID);
                    // JOptionPane.showMessageDialog(null,"图书删除成功！");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                textField8.setText("");
            }

        });

        if (choice == true) {
            System.out.println("应该显示添加的面板");
            p14.setVisible(true);
            add(p14);
        } else {
            p15.setVisible(true);
            add(p15);
        }

        add(p12);
        add(p13);
    }
}
