package UIviewer.Shopping;

import javax.swing.*;
import java.awt.*;

public class myProductPanel extends JPanel {
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(243,248,242);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 20);

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    public myProductPanel(String [] inf){
        setLayout(null);
        //商品名称
        JLabel l1=new JLabel(inf[0]);
        l1.setBounds(0,0,50,50);
        l1.setFont(myfont1);
        l1.setOpaque(false); // 设置背景透明
        l1.setBorder(BorderFactory.createEmptyBorder()); // 去除边框
        add(l1);

        //商品价格
        JLabel l2=new JLabel("价格：");
        l2.setBounds(150,0,290,30);
        l2.setOpaque(false); // 设置背景透明
        l2.setBorder(BorderFactory.createEmptyBorder()); // 去除边框
        l2.setFont(myfont1);
        add(l2);
        JLabel l3=new JLabel(inf[1]);
        l3.setBounds(200,0,50,30);
        l3.setOpaque(false); // 设置背景透明
        l3.setBorder(BorderFactory.createEmptyBorder()); // 去除边框
        l3.setFont(myfont1);
        add(l3);

        //剩余数量
        JLabel l4=new JLabel("剩余数量：");
        l4.setBounds(150,50,200,30);
        l4.setOpaque(false); // 设置背景透明
        l4.setBorder(BorderFactory.createEmptyBorder()); // 去除边框
        l4.setFont(myfont1);
        add(l4);
        JLabel l5=new JLabel(inf[2]);
        l5.setBounds(300,50,50,30);
        l5.setOpaque(false); // 设置背景透明
        l5.setBorder(BorderFactory.createEmptyBorder()); // 去除边框
        l5.setFont(myfont1);
        add(l5);

        setBackground(color4);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        String[] inf={"1","2","3","4","5"};
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) screensize.getWidth(); //得到宽度
        int height=(int) screensize.getHeight();//获得高度
        JFrame jf=new JFrame("shopCustomer");
        jf.setSize(width,height);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setContentPane(new myProductPanel(inf));
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    };
}
