package UIviewer.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bookSearch extends JPanel {

    public bookSearch(){
        setLayout(null);

        //馆藏查询
        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/bg2.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);

        JPanel p21=new JPanel();
        p21.setBounds(270,100,730,230);
        p21.setBackground(new Color(0,0,0,170));

        //文字
        JLabel l1 = new JLabel("     欢 迎 使 用 至 善 搜 索 !");
        l1.setBounds(290, 100, 290, 80);
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        l1.setForeground(new Color(255,255,255));
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);

        //文字
        JLabel l2 = new JLabel("              可对书籍名、作者名、书籍编号等进行检索 ");
        l2.setBounds(500, 260, 800, 80);
        Font font1 = new Font("楷体", Font.PLAIN, 18);
        l2.setForeground(new Color(255,255,255));
        l2.setFont(font1);
        //l1.setForeground(new Color(111,222,0));
        add(l2);

        JTextField textField=new JTextField();
        textField.setFont(new Font("微软雅黑", Font.BOLD, 18));
        textField.setBounds(290, 180,600 , 50);
        add(textField);
        textField.setColumns(10);

        JButton b11=new JButton("检索");
        b11.setBounds(910,180,80,50);
        Font myfont = new Font("楷体", Font.BOLD, 20);
        b11.setFont(myfont);
        b11.setBackground(new Color(255,127,80));
        b11.setForeground(new Color(255,255,255));
        b11.setFocusPainted(false);
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(b11);
        add(p21);
        add(p11);
    }

}