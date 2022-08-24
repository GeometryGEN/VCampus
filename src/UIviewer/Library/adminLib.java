package UIviewer.Library;
import ClientToServer.ClientToServer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class adminLib extends JFrame {
    private JPanel mainLib;
    CardLayout cardLayout=new CardLayout();
    public static void adminLibUI(ClientToServer ucs) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    adminLib frame = new adminLib();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
        adminLib (){
        setTitle("adminLib");
        setBounds(0,0,1273,790);
        mainLib=new JPanel();
        setContentPane(mainLib);
        mainLib.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 150, 1273, 790);
        mainLib.add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
//		创建相应面板类的对象
        bookSearch f1=new bookSearch();
//		将面板添加到住面板中，注意:add()方法里有两个参数，第一个是要添加的对象，第二个给这个对象所放置的卡片
//		起个名字，后面调用显示的时候要用到这个名字
        panel.add(f1,"f1");
        AddDeleteBook f2=new AddDeleteBook();
        panel.add(f2,"f2");
        giveTicket f3=new giveTicket();
        panel.add(f3,"f3");


        //图书馆标志与背景
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/logonew.png");
        logo.setIcon(icon);
        logo.setBounds(30, 10, 600, 75);
        mainLib.add(logo);

        //上方面板
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1280, 100);
        p1.setBackground(new Color(5,44,5));
        mainLib.add(p1);

        //按钮
        JButton b1=new JButton("查看图书状态");
        b1.setBounds(100,100,250,50);
        Font myfont1 = new Font("微软雅黑", Font.BOLD, 18);
        b1.setFont(myfont1);
        b1.setContentAreaFilled(false);//设置按钮透明
        b1.setFocusPainted(false);
        b1.setForeground(new Color(248, 248, 255));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f1");
            }
        });
        mainLib.add(b1);

        JButton b2=new JButton("录入/删除书籍");
        b2.setBounds(370,100,250,50);
        b2.setFont(myfont1);
        b2.setContentAreaFilled(false);//设置按钮透明
        b2.setFocusPainted(false);
        b2.setForeground(new Color(248, 248, 255));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f2");
            }
        });
        mainLib.add(b2);

        JButton b3=new JButton("开罚单");
        b3.setBounds(640,100,250,50);
        b3.setFont(myfont1);
        b3.setContentAreaFilled(false);//设置按钮透明
        b3.setFocusPainted(false);
        b3.setForeground(new Color(248, 248, 255));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                cardLayout.show(panel, "f3");
            }
        });
        mainLib.add(b3);

        JButton b4=new JButton("退出图书馆");
        b4.setBounds(910,100,250,50);
        b4.setFont(myfont1);
        b4.setContentAreaFilled(false);//设置按钮透明
        b4.setFocusPainted(false);
        b4.setForeground(new Color(248, 248, 255));
            b4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    dispose();
                }
            });
        mainLib.add(b4);



        //按钮面板
        JPanel p2 = new JPanel();
        p2.setBounds(0, 100, 1280, 50);
        p2.setBackground(new Color(57,106,57));
        mainLib.add(p2);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
    }
}