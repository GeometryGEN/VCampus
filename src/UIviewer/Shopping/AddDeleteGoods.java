package UIviewer.Shopping;
import DAO.Library.Book_admin;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;
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
 * 添加删除商品
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class AddDeleteGoods extends JPanel {
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
    public AddDeleteGoods(Boolean choice){
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

        //左侧的一些分类选择的按钮
        adminChoiceButton b12=new adminChoiceButton(true,0,100);
        adminChoiceButton b13=new adminChoiceButton(false,0,370);
        b12.setText("添加商品");
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddDeleteGoods f111= new AddDeleteGoods(true);
                    panel.add(f111,"f111");
                    cardLayout.show(shopAdmin.panel, "f111");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        b13.setText("删除商品");
        b13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddDeleteGoods f112= new AddDeleteGoods(false);
                    shopAdmin.panel.add(f112,"f112");
                    shopAdmin.cardLayout.show(shopAdmin.panel, "f112");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(b12);
        add(b13);

        //添加商品的面板
        JPanel p14=new JPanel();
        p14.setBounds((int) (330*width_r), 0,(int) (930*width_r), (int) (1900*height_r));
        p14.setBackground(color5);
        p14.setLayout(null);

        //删除商品的面板
        JPanel p15=new JPanel();
        p15.setBounds((int) (330*width_r),0,(int) (930*width_r), (int) (1900*height_r));
        p15.setBackground(color5);
        p15.setLayout(null);

        //输入商品信息
        JLabel l1 = new JLabel("商品名称:");
        l1.setFont(myfont1);
        l1.setForeground(color2);
        l1.setBounds((int) (160*width_r), (int) (120*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l1);
        JTextField textField1=new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, 17));
        textField1.setBounds((int) (255*width_r), (int) (120*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField1);
        textField1.setColumns(10);

        JLabel l2 = new JLabel("商品编号:");
        l2.setFont(myfont1);
        l2.setForeground(color2);
        l2.setBounds((int) (460*width_r), (int) (120*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l2);
        JTextField textField2=new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, 17));
        textField2.setBounds((int) (555*width_r), (int) (120*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField2);
        textField2.setColumns(10);

        JLabel l3 = new JLabel("商品价格:");
        l3.setFont(myfont1);
        l3.setForeground(color2);
        l3.setBounds((int) (160*width_r), (int) (200*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l3);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, 17));
        textField3.setBounds((int) (255*width_r), (int) (200*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField3);
        textField3.setColumns(10);

        JLabel l4 = new JLabel("总数量:");
        l4.setFont(myfont1);
        l4.setForeground(color2);
        l4.setBounds((int) (460*width_r), (int) (200*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l4);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, 17));
        textField4.setBounds((int) (555*width_r), (int) (200*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField4);
        textField4.setColumns(10);

        JLabel l5 = new JLabel("剩余数量:");
        l5.setFont(myfont1);
        l5.setForeground(color2);
        l5.setBounds((int) (160*width_r), (int) (280*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l5);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, 17));
        textField5.setBounds((int) (255*width_r), (int) (280*height_r), (int) (125*width_r), (int) (25*height_r));
        p14.add(textField5);
        textField5.setColumns(10);

        JLabel l6 = new JLabel("商品种类:");
        l6.setFont(myfont1);
        l6.setForeground(color2);
        l6.setBounds((int) (460*width_r), (int) (280*height_r), (int) (250*width_r), (int) (25*height_r));
        p14.add(l6);
        JComboBox<String> comboBox2 =new JComboBox<String>();
        comboBox2.setBounds((int) (555*width_r), (int) (280*height_r), (int) (125*width_r), (int) (25*height_r));
        comboBox2.setBackground(color5);
        comboBox2.setFont(new Font("宋体", Font.BOLD, 14));
        comboBox2.setForeground(color2);
        comboBox2.addItem("零食");
        comboBox2.addItem("饼干");
        comboBox2.addItem("茶");
        comboBox2.addItem("生鲜");
        comboBox2.addItem("医药");
        comboBox2.addItem("保健");
        comboBox2.addItem("手机");
        comboBox2.addItem("数码");
        comboBox2.addItem("电器");
        comboBox2.addItem("饰品");
        comboBox2.addItem("男装");
        comboBox2.addItem("运动");
        comboBox2.addItem("百货");
        comboBox2.addItem("厨具");
        comboBox2.addItem("家装");
        comboBox2.addItem("礼品");
        comboBox2.addItem("洗护");
        comboBox2.addItem("美妆");
        comboBox2.addItem("书籍");
        comboBox2.setEditable(false);//不可修改的文字
        p14.add(comboBox2);
//        JTextField textField6=new JTextField();
//        textField6.setFont(new Font("宋体", Font.BOLD, 17));
//        textField6.setBounds((int) (555*width_r), (int) (280*height_r), (int) (125*width_r), (int) (25*height_r));
//        p14.add(textField6);
//        textField6.setColumns(10);
        //注意，原来是从textF6获取字符串
        // String identity=(String)comboBox2.getSelectedItem();


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
                String name = textField1.getText();
                String id = textField2.getText();
                String price = textField3.getText();
                String leftNum = textField5.getText();
                String sumNum = textField4.getText();
                String type=(String)comboBox2.getSelectedItem();
                //String type = textField6.getText();
                Product p = new Product();
                p.setProduct_name(name);
                p.setProduct_id(Integer.parseInt(id));
                p.setProduct_price(Double.parseDouble(price));
                p.setProduct_currentNumbers(Integer.parseInt(leftNum));
                p.setProduct_sumNumbers(Integer.parseInt(sumNum));
                p.setProduct_type(type);
                p.setProduct_takeaway(false);
                p.setProduct_toshop(1);
                try {
                    if(Client_shop.addProduct(p))
                        JOptionPane.showMessageDialog(null, "添加成功!");
                    else
                        JOptionPane.showMessageDialog(null, "添加失败!");
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                    //textField6.setText("");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JLabel l8 = new JLabel("商品编号:");
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
}