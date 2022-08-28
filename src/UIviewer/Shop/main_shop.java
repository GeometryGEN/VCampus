package UIviewer.Shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_shop extends JFrame {

    private JPanel shopping;
    CardLayout cardLayout = new CardLayout();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main_shop frame = new main_shop();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

        //小头像
        public main_shop()
        {
            setTitle("main_shop");
            setBounds(0,0,1273,790);
            shopping=new JPanel();
            setContentPane(shopping);
            shopping.setLayout(null);

           JPanel panel=new JPanel();
           panel.setBounds(0,100,1273,790);
           shopping.add(panel);
           //shopping.setLayout(cardLayout);
            panel.setLayout(cardLayout);
            Shopping_vehicle f1=new Shopping_vehicle();
            panel.add(f1,"f1");
            Consult_goods f2=new Consult_goods();
            panel.add(f2,"f2");
            Search_goods f3=new Search_goods();
            panel.add(f3,"f3");


            /*JLabel touxiang = new JLabel();
            ImageIcon icon = new ImageIcon("src/image/logodz.png");
            touxiang.setIcon(icon);
            touxiang.setBounds(20, 20, 100, 100);
            shopping.add(touxiang);

            //文字
            JLabel l1 = new JLabel("  你好！");
            l1.setBounds(120, 40, 200, 75);
            Font font = new Font("楷体", Font.BOLD, 22);
            l1.setFont(font);
            //l1.setForeground(new Color(111,222,0));
            shopping.add(l1);


            //信息面板
            JLabel l4 = new JLabel("      基本信息");
            l4.setBounds(23, 185, 250, 60);
            Font font2 = new Font("楷体", Font.BOLD, 25);
            l4.setFont(font2);
            l4.setForeground(new Color(94, 38, 18));
            shopping.add(l4);

            String name = "1";
            JLabel l2 = new JLabel(" 姓名：" + name);
            l2.setBounds(30, 310, 250, 60);
            Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
            l2.setFont(font1);
            l2.setForeground(new Color(0, 0, 0));
            shopping.add(l2);
            String card = "";
            JLabel l3 = new JLabel(" 卡号：" + card);
            l3.setBounds(30, 380, 250, 60);
            l3.setFont(font1);
            l3.setForeground(new Color(0, 0, 0));
            shopping.add(l3);*/


            JButton btnNewButton_6 = new JButton("安全返回");
            btnNewButton_6.setBounds(940, 50, 200, 50);
            Font myfont2 = new Font("微软雅黑", Font.PLAIN, 18);
            btnNewButton_6.setFont(myfont2);
            btnNewButton_6.setBackground(new Color(248, 248, 255));
            //btnNewButton_1.setForeground(new Color(248, 248, 255));
            btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
            //btnNewButton_6.setBorder(null);//取消边框

            shopping.add(btnNewButton_6);

            JButton btnNewButton_7 = new JButton("购物车");
            btnNewButton_7.setBounds(340, 50, 200, 50);
            Font myfont5 = new Font("微软雅黑", Font.PLAIN, 18);
            btnNewButton_7.setFont(myfont5);
            btnNewButton_7.setBackground(new Color(248, 248, 255));
            btnNewButton_7.setContentAreaFilled(true);//设置按钮透明
            btnNewButton_7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  cardLayout.show(panel,"f1");
                }
            });
            shopping.add(btnNewButton_7);

            JButton btnNewButton_11 = new JButton("已购商品");
            btnNewButton_11.setBounds(640, 50, 200, 50);
            Font myfont12 = new Font("微软雅黑", Font.PLAIN, 18);
            btnNewButton_11.setFont(myfont12);
            btnNewButton_11.setBackground(new Color(248, 248, 255));
            btnNewButton_11.setContentAreaFilled(true);//设置按钮透明
            btnNewButton_11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panel,"f2");
                }
            });
            shopping.add(btnNewButton_11);

            JButton btnNewButton_19 = new JButton("搜索物品");
            btnNewButton_19.setBounds(40, 50, 200, 50);
            Font myfont15 = new Font("微软雅黑", Font.PLAIN, 18);
            btnNewButton_19.setFont(myfont15);
            btnNewButton_19.setBackground(new Color(248, 248, 255));
            btnNewButton_19.setContentAreaFilled(true);//设置按钮透明
            btnNewButton_19.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panel,"f3");
                }
            });
            shopping.add(btnNewButton_19);

           /* //左侧面板
            JPanel p1 = new JPanel();
            p1.setBounds(0, 0, 310, 784);
            p1.setBackground(new Color(135, 206, 250, 180));
            shopping.add(p1);


            //文本编辑框（输入课程编号或课程名字）
            JLabel lblNewLabel = new JLabel("搜索:");
            lblNewLabel.setFont(new Font("宋体", Font.BOLD, 35));
            lblNewLabel.setBounds(400, 155, 275, 35);
            shopping.add(lblNewLabel);

            JTextField textField1 = new JTextField();
            textField1.setFont(new Font("宋体", Font.BOLD, 18));
            textField1.setBounds(520, 155, 275, 35);
            shopping.add(textField1);
            textField1.setColumns(10);

            JButton btnNewButton_10 = new JButton("确认");
            btnNewButton_10.setBounds(880, 155, 100, 40);
            Font myfont9 = new Font("微软雅黑", Font.PLAIN, 12);
            btnNewButton_10.setFont(myfont9);
            btnNewButton_10.setBackground(new Color(248, 248, 255));
            btnNewButton_10.setContentAreaFilled(true);//设置按钮透明
            shopping.add(btnNewButton_10);

            //右下面板
            JPanel p3 = new JPanel();
            p3.setBounds(330, 200, 920, 585);
            p3.setBackground(new Color(211, 211, 211, 100));
            shopping.add(p3);


            //右侧面板
            JPanel p2 = new JPanel();
            p2.setBounds(300, 0, 950, 1000);
            p2.setBackground(new Color(245, 245, 245, 180));
            shopping.add(p2);

            //横向图片
            JLabel l16 = new JLabel();
            ImageIcon icon7 = new ImageIcon("src/image/background4.jpg");
            l16.setIcon(icon7);
            l16.setBounds(0, 0, 1273, 784);
            shopping.add(l16);

            JTable table =new JTable()
            {
                public boolean isCellEditable(int row,int column)
                {
                    return false;
                }
            };
            table.setRowHeight(400);
            table.setBounds(330,200,920,585);
            table.setFont(new Font("黑体",Font.PLAIN,16));
            table.setShowHorizontalLines(false);
            table.setShowVerticalLines(false);
            table.setIntercellSpacing(new Dimension(0,1));
            table.setGridColor(new Color(220,220,220));
            table.setColumnSelectionAllowed(false);
            table.setRowSelectionAllowed(false);
            shopping.add(table);
            */
            JPanel p2=new JPanel();
            p2.setBounds(0,100,1273,784);
            shopping.add(p2);

            //东南大学标志图片
            JLabel l15 = new JLabel();
            ImageIcon icon6 = new ImageIcon("src/image/background2.jpg");
            l15.setIcon(icon6);
            l15.setBounds(0, 0, 1273, 790);
            shopping.add(l15);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

