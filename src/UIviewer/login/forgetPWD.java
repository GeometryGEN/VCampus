package UIviewer.login;
import ClientToServer.ClientToServer;
import DAO.Login.Mail;
import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UIviewer.login.forgetPWD2.forgetPWDUI2;

/**
 * 忘记pwd
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class forgetPWD {

    /**
     * 忘记pwdui
     */
    public static String captcha;//验证码
    static Color color1=new Color(31,66,71);
    static Color color2=new Color(125,182,191);
    static Color color3=new Color(111,150,134);
    static Color color4=new Color(207,219,212);
    static Font myfont1=new Font("等线", Font.BOLD, 17);
    static Font myfont2=new Font("等线", Font.BOLD, 15);

    static Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    static int width=(int) screensize.getWidth(); //得到宽度
    static int height=(int) screensize.getHeight();//获得高度
    static double width_r=(double) width/1000;
    static double height_r=(double) height/720;//1280,720

    public static void forgetPWDUI() {
        JFrame jf = new JFrame("找回密码");
        jf.setResizable(false);
        //找回密码
        //注册信息
        JLabel l2=new JLabel("找回密码");
        l2.setBounds((int)(width_r*90) ,(int)(width_r*140),(int)(width_r*200) ,(int)(height_r*60));
        //l2.setBounds(140,210,290,80);
        Font font=new Font("宋体",Font.BOLD,26);
        l2.setFont(font);
        l2.setForeground(color1);
        jf.getContentPane().add(l2);
        //账号密码
        JLabel l3=new JLabel("一卡通:");
        l3.setBounds((int)(width_r*65) ,(int)(width_r*200),(int)(width_r*180) ,(int)(height_r*20));
        l3.setFont(new Font("等线",Font.BOLD,18));
        l3.setForeground(color1);
        //l3.setBounds(100,330,250,25);
        jf.add(l3);
        JTextField textField3=new JTextField();
        textField3.setBounds((int)(width_r*115) ,(int)(width_r*200),(int)(width_r*80) ,(int)(height_r*20));
        textField3.setFont(new Font("宋体",Font.BOLD,17));
        //textField3.setBounds(170,330,120,25);
        textField3.setBorder(null);
        jf.add(textField3);
        textField3.setColumns(10);

        JLabel l10=new JLabel("邮箱:");
        l10.setFont(new Font("等线",Font.BOLD,18));
        l10.setForeground(color1);
        l10.setBounds((int)(width_r*65) ,(int)(width_r*240),(int)(width_r*180) ,(int)(height_r*20));
        //l10.setBounds(100,380,250,25);
        jf.add(l10);
        JTextField textField10=new JTextField();
        textField10.setBounds((int)(width_r*115) ,(int)(width_r*240),(int)(width_r*80) ,(int)(height_r*20));
        textField10.setFont(new Font("宋体",Font.BOLD,17));
        //textField10.setBounds(170,380,120,25);
        textField10.setBorder(null);
        jf.add(textField10);
        textField10.setColumns(10);

        //填写验证码的地方
        JTextField textField11=new JTextField();
        textField11.setBounds((int)(width_r*65) ,(int)(width_r*280),(int)(width_r*50) ,(int)(height_r*20));
        textField11.setFont(new Font("宋体",Font.BOLD,12));
        //textField11.setBounds(100,430,70,25);
        textField11.setBorder(null);
        jf.add(textField11);
        textField10.setColumns(11);
        //发送验证码
        JButton b2=new JButton("发送验证码");
        b2.setBounds((int)(width_r*125) ,(int)(width_r*280),(int)(width_r*70) ,(int)(height_r*20));
        //b2.setBounds(180,430,110,25);
        b2.setFont(new Font("等线",Font.BOLD,14));
        b2.setForeground(color1);
        b2.setBackground(color4);
        b2.setFocusPainted(false);
        jf.add(b2);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String idcard = textField3.getText(); //一卡通号
                    String mail = textField10.getText(); //邮箱
                    if (idcard == null || (mail.isEmpty())) {
                        JOptionPane.showMessageDialog(jf, "信息填写不完整，请重新填写!");
                    }
                    //registerUI2();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String mail = textField10.getText();
                try{
                    Mail send_mail=new Mail(mail);
                    captcha=send_mail.getVerifiCode();
                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        });

        JButton b1=new JButton("确认");
        b1.setBounds((int)(width_r*90) ,(int)(width_r*330),(int)(width_r*75) ,(int)(height_r*20));
        //b1.setBounds(145,490,100,30);
        b1.setBackground(color3);
        b1.setForeground(Color.white);
        b1.setFont(new Font("楷体", Font.PLAIN, 25));
        b1.setFocusPainted(false);

        //点击确认之后对比输入的验证码是否正确，若正确调用注册的函数
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mycaptcha=textField11.getText();//填验证码的文本框
                //测试中先直接点进去，不用验证
                //jf.setVisible(false);
                //forgetPWDUI2(textField10.getText(),textField3.getText());
                //if(mycaptcha==captcha)
                //if(true)
                if(Objects.equals(mycaptcha, captcha))
                {
                    //继续注册
                    jf.setVisible(false);
                    forgetPWDUI2(textField10.getText(),textField3.getText());
                }
                else{
                    //报填写错误，验证码不对
                    JOptionPane.showMessageDialog(jf, "验证码错误，请选择重新发送!");
                }

            }
        });
        jf.add(b1);

        JPanel p11=new JPanel();
        p11.setBounds(0,0, 400, 200);
        JLabel pic1 = new JLabel();
        int icon1_width= 400;
        int icon1_height=200;
        //裁减2到min的尺寸
        try {
            Thumbnails.of(new File("src/image/登录/13.jpg"))
                    .size((int)(icon1_width), (int)(icon1_height))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/登录/15_fit.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/登录/15_fit.jpg"));
        pic1.setBounds(0,-15 ,400,200);
        p11.add(pic1);
        p11.setBackground(color4);
        jf.add(p11);

        jf.setBackground(color4);
        jf.setBounds(0,0,400,650);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

}
