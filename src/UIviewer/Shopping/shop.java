package UIviewer.Shopping;
import DAO.Library.Book_borrower;
import DAO.Shop.Product;
import UIhandler.Shop.Client_shop;
import UIviewer.Shopping.shoppinghall;
import UIhandler.Library.Client_library;
import UIviewer.Library.readLib;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import static UIviewer.Shopping.shoppinghall.cardLayout;
import static UIviewer.Shopping.shoppinghall.panel;
import static UIviewer.login.register.registerUI;

public class shop extends JPanel {
    public static volatile String[][] shoptable;

    public static String[][] getShoptable() {
        return shoptable;
    }

    public static void setShoptable(String[][] shoptable) {
        shop.shoptable = shoptable;
    }

    public shop() {
        setLayout(null);
        JButton btnNewButton_1 = new JButton("零食");
        btnNewButton_1.setBounds(30, 50, 100, 30);
        Font myfont1 = new Font("宋体 ", Font.PLAIN, 18);
        btnNewButton_1.setFont(myfont1);
        btnNewButton_1.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_1.setBorder(null);//取消边框
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setForeground(new Color(255,255,255));
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_shop.checktypeProduct("零食");
                    List<Product> ps = Client_shop.returnAllProduct();
                    String[][] changed_ps = new String[ps.size()][];
                    for(int i = 0;i<ps.size();i++){
                        String[] temp=new String[4];
                        temp[0]=ps.get(i).getProduct_name();
                        temp[1]=String.valueOf(ps.get(i).getProduct_currentNumbers());
                        temp[2]=ps.get(i).getProduct_type();
                        temp[3]=String.valueOf(ps.get(i).getProduct_id());
                        changed_ps[i]=temp;
                    }
                    shoptable=changed_ps;

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("饼干");
        btnNewButton_2.setBounds(200, 50, 100, 30);
        btnNewButton_2.setFont(myfont1);
        btnNewButton_2.setContentAreaFilled(false);//设置按钮透明
        btnNewButton_2.setForeground(new Color(255,255,255));
        btnNewButton_2.setBorder(null);//取消边框
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"XXX,你妈妈给你带来了你最爱的旺仔雪饼！");
            }
        });
        add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("图书");
        btnNewButton_3.setBounds(30, 120, 100, 30);
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
        btnNewButton_4.setBounds(200, 120, 100, 30);
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
        btnNewButton_5.setBounds(30, 190, 100, 30);
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
        btnNewButton_6.setBounds(200, 190, 100, 30);
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
        btnNewButton_7.setBounds(30, 260, 100, 30);
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
        btnNewButton_8.setBounds(200, 260, 100, 30);
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
        p1.setBounds(0, 0, 340, 780);
        //p1.setBackground(null);
        p1.setBackground(new Color(255,160,122, 180));
        //panel1.BackColor = Color.FromArgb(80, 255, 0, 0);
        //p1.setOpaque(false);
        add(p1);



        String[] tableTitle = {"图片","商品信息","价格","剩余数量","加入购物车","购买"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(shoptable, tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        table_want.getColumnModel().getColumn(0).setPreferredWidth(300);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(260);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(180);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(180);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(100);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(120);



        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table_want.getSelectedColumn()==4){
                    System.out.println("car");
                }

                if(table_want.getSelectedColumn()==5){
                    System.out.println("buy");
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
                try {
                    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                        @Override
                        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                            if (column!=8&&column!=7) {
                                setBackground(Color.white);
                            }else {
                                setBackground(new Color(255,255,255));
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
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(340,0,940,680);
        add(jsp);
        table_want.setRowHeight(30);

        setVisible(true);

        }
}

