package UIviewer.Shopping;
import DAO.Shop.Product;
import UIhandler.Library.Client_library;
import UIhandler.Shop.Client_shop;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import ClientToServer.myInfo;
import UIviewer.login.functionChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static UIviewer.Shopping.shopCustomer.cardLayout;
import static UIviewer.Shopping.shopCustomer.panel;
import static UIviewer.login.forgetPWD.forgetPWDUI;

public class ShoppingHall extends JPanel {
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

    public ShoppingHall() {
        setLayout(null);

        JTextField textField=new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, (int) (18*width_r)));
        textField.setBounds((int) (460*width_r), (int) (30*height_r), (int) (280*width_r), (int) (40*height_r));
        add(textField);
        textField.setColumns((int) (10*height_r));

        JButton b11=new JButton("检索");
        b11.setBounds((int) (830*width_r), (int) (30*height_r), (int) (80*width_r), (int) (40*height_r));
        Font myfont = new Font("楷体", Font.BOLD, (int) (20*width_r));
        b11.setFont(myfont);
        b11.setBackground(new Color(255,127,80));
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
                            String[] tt =new String[5];
                            tt[0]=String.valueOf(t.get(i).getProduct_id());
                            tt[1]=t.get(i).getProduct_name();
                            tt[2]=String.valueOf(t.get(i).getProduct_price());
                            tt[3]=String.valueOf(t.get(i).getProduct_currentNumbers());
                            tt[4]="1";
                            temp[i]=tt;
                        }
                        setShoptable(temp);
                    }else {
                        System.out.println("kong");
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

        JButton btnNewButton_1 = new JButton("零食");
        btnNewButton_1.setBounds((int) (30*width_r), (int) (150*height_r), (int) (100*width_r), (int) (30*height_r));
        Font myfont1 = new Font("宋体 ", Font.PLAIN, (int) (18*width_r));
        btnNewButton_1.setFont(myfont1);
        btnNewButton_1.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_1.setBorder(null);//取消边框
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setForeground(new Color(255,255,255));
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Product> t = Client_shop.checktypeProduct("零食");
                    String[][] temp = new String[t.size()][];
                    for(int i =0;i<t.size();i++){
                        String[] tt =new String[5];
                        tt[0]=String.valueOf(t.get(i).getProduct_id());
                        tt[1]=t.get(i).getProduct_name();
                        tt[2]=String.valueOf(t.get(i).getProduct_price());
                        tt[3]=String.valueOf(t.get(i).getProduct_currentNumbers());
                        tt[4]="1";
                        temp[i]=tt;
                    }
                    System.out.println("t.size()="+t.size());
                    System.out.println(temp[0][0]);
                    setShoptable(temp);
                    ShoppingHall f112=new ShoppingHall();
                    panel.add(f112,"f112");
                    cardLayout.show(panel, "f112");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("饼干");
        btnNewButton_2.setBounds((int) (200*width_r), (int) (150*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_2.setFont(myfont1);
        btnNewButton_2.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_2.setForeground(new Color(255,255,255));
        btnNewButton_2.setBorder(null);//取消边框
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Product> t = Client_shop.checktypeProduct("饼干");
                    String[][] temp = new String[t.size()][];
                    for(int i =0;i<t.size();i++){
                        String[] tt =new String[5];
                        tt[0]=String.valueOf(t.get(i).getProduct_id());
                        tt[1]=t.get(i).getProduct_name();
                        tt[2]=String.valueOf(t.get(i).getProduct_price());
                        tt[3]=String.valueOf(t.get(i).getProduct_currentNumbers());
                        tt[4]="1";
                        temp[i]=tt;
                    }
                    setShoptable(temp);
                    ShoppingHall f12=new ShoppingHall();
                    panel.add(f12,"f12");
                    cardLayout.show(panel, "f12");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("图书");
        btnNewButton_3.setBounds((int) (30*width_r), (int) (220*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_3.setFont(myfont1);
        btnNewButton_3.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_3.setForeground(new Color(255,255,255));
        btnNewButton_3.setBorder(null);//取消边框
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("薯片");
        btnNewButton_4.setBounds((int) (200*width_r), (int) (220*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_4.setFont(myfont1);
        btnNewButton_4.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_4.setForeground(new Color(255,255,255));
        btnNewButton_4.setBorder(null);//取消边框
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("话梅");
        btnNewButton_5.setBounds((int) (30*width_r), (int) (290*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_5.setFont(myfont1);
        btnNewButton_5.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_5.setForeground(new Color(255,255,255));
        btnNewButton_5.setBorder(null);//取消边框
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("衬衫");
        btnNewButton_6.setBounds((int) (200*width_r), (int) (290*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_6.setFont(myfont1);
        btnNewButton_6.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_6.setForeground(new Color(255,255,255));
        btnNewButton_6.setBorder(null);//取消边框
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("薯片");
        btnNewButton_7.setBounds((int) (30*width_r), (int) (360*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_7.setFont(myfont1);
        btnNewButton_7.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_7.setForeground(new Color(255,255,255));
        btnNewButton_7.setBorder(null);//取消边框
        btnNewButton_7.setFocusPainted(false);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("泡面");
        btnNewButton_8.setBounds((int) (200*width_r), (int) (360*height_r), (int) (100*width_r), (int) (30*height_r));
        btnNewButton_8.setFont(myfont1);
        btnNewButton_8.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_8.setForeground(new Color(255,255,255));
        btnNewButton_8.setBorder(null);//取消边框
        btnNewButton_8.setFocusPainted(false);
        btnNewButton_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_8);

        //左侧面板
        JPanel p1=new JPanel();
        p1 = new JPanel();
        p1.setBounds(0, 0, (int) (340*width_r), (int) (780*height_r));
        //p1.setBackground(null);
        p1.setBackground(new Color(255,160,122, 120));
        //panel1.BackColor = Color.FromArgb(80, 255, 0, 0);
        //p1.setOpaque(false);
        add(p1);



        String[] tableTitle = {"商品编号","商品名称","价格","剩余数量","购买数量","加入购物车","购买"};
        //数据

        DefaultTableModel dtm = new DefaultTableModel(shoptable, tableTitle);
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

        //调整美化
        table_want.setFont(new Font("宋体",Font.BOLD, (int) (16*width_r)));
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
                            if(Client_shop.getMoney(myInfo.getId())>=(money*Num)){
                                Client_shop.buyProduct(myInfo.getId(),id,Num,Client_shop.getMoney(myInfo.getId())-money*Num);
                                JOptionPane.showMessageDialog(null,"购买成功！");
                                Client_shop.setId(String.valueOf(myInfo.getType()));
                                Client_shop.setIdcard(myInfo.getId());
                                functionChoose.jf.setContentPane(new shopCustomer());
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

