package UIviewer.login;
import ClientToServer.ClientToServer;
import connection.JDBC_Connector;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import static UIviewer.login.register.registerUI;
import static UIviewer.login.forgetPWD.forgetPWDUI;//之后改为修改密码UI函数

/**
 * 登录框
 *
 * @author Tong_tuoyi
 * @date 2023/8/26
 */
//#7DB6BF 125,182,191 薄荷绿色

public class LoginFrame extends JFrame{

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int) screensize.getWidth(); //得到宽度
    int height=(int) screensize.getHeight();//获得高度
    double width_r=(double) width/1000;
    double height_r=(double) height/720;//1280,720

    private ClientToServer ucs = new ClientToServer();
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JTextField textField;
    public static JPasswordField passwordField;
    Color color1=new Color(31,66,71);
    Color color2=new Color(125,182,191);
    Color color3=new Color(111,150,134);
    Color color4=new Color(207,219,212);
    Font myfont1=new Font("等线", Font.BOLD, 17);
    Font myfont2=new Font("等线", Font.BOLD, 15);
    public static JFrame jf = new JFrame("登录");

    /**
     * 登录框
     */
    public LoginFrame() throws UnknownHostException {
        System.out.println(width);
        System.out.println(height);
        System.out.println(width_r);
        System.out.println(height_r);
        //菜单栏aq
        JMenuBar menuBar=new JMenuBar();
        JMenu menu1=new JMenu("注册");
        menu1.setFont(myfont1);
        menuBar.add(menu1);
        JMenu menu2=new JMenu("找回密码");
        menu2.setFont(myfont1);
        menuBar.add(menu2);

        JMenuItem item1 = new JMenuItem("注册");
        item1.setFont(myfont2);
        item1.setBackground(color4);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    registerUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        JMenuItem item2 = new JMenuItem("找回密码");
        item2.setFont(myfont2);
        item2.setBackground(color4);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    forgetPWDUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu1.add(item1);
        menu2.add(item2);
        menuBar.setBackground(color3);
        jf.setJMenuBar(menuBar);
        //add(menuBar);

        //背景图片
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        try {
            Thumbnails.of(new File("src/image/登录/19.png"))
                    .size((int)(width), (int)(height))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/登录/19_fit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblBackground.setIcon(new ImageIcon("src/image/登录/19_fit.png"));
        lblBackground.setBounds(0, 0, width,height); // 设置组件的显示位置及大小

        //左侧空白的面板，用来装那些字符和按钮输入，面板设置为透明
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.BLUE);
        panel1.setOpaque(false);
        panel1.setBounds((int)((width-width_r*554)/2) ,(int)((height-height_r*357)/2),(int)(width_r*554) ,(int)(height_r*337));
        jf.getContentPane().add(panel1);
        System.out.println((int)(width_r*850));
        System.out.println((int)(width-width_r*850)/2);
        //panel的背景图片设置为圆角方形
        JLabel lblBackground2 = new JLabel(); // 创建一个标签组件对象
        try {
            Thumbnails.of(new File("src/image/登录/22.png"))
                    .size((int)(width_r*554),(int)(height_r*337))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/登录/22_fit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lblBackground2.setIcon(new ImageIcon("src/image/登录/22_fit.png"));
        lblBackground2.setBounds(0, 0, (int)(width_r*554),(int)(height_r*337)); // 设置组件的显示位置及大小

        JLabel vcam = new JLabel("Welcome to Vcampus !");
        vcam.setFont(new Font("宋体", Font.BOLD, 23));
        vcam.setForeground(color1);
        vcam.setBounds((int)(width_r*(380-290)), (int)(height_r*(232-198)), (int)(width_r*350), (int)(height_r*25));
        panel1.add(vcam);
        //账号密码
        JLabel lblNewLabel = new JLabel("一卡通号:");
        lblNewLabel.setIcon(new ImageIcon("src/image/登录/17.png"));
        lblNewLabel.setFont(new Font("等线", Font.BOLD, 19));
        lblNewLabel.setForeground(color1);
        lblNewLabel.setBounds((int)(width_r*(370-290)), (int)(height_r*(292-198)), (int)(width_r*100), (int)(height_r*25));
        panel1.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("   密  码:");
        lblNewLabel_1.setIcon(new ImageIcon("src/image/登录/18.png"));
        lblNewLabel_1.setFont(new Font("等线", Font.BOLD, 20));
        lblNewLabel_1.setForeground(color1);
        lblNewLabel_1.setBounds((int)(width_r*(370-290)), (int)(height_r*(332-198)), (int)(width_r*100), (int)(height_r*25));
        panel1.add(lblNewLabel_1);

        textField=new JTextField();
        textField.setFont(new Font("宋体", Font.BOLD, 16));
        textField.setBounds((int)(width_r*(450-290)), (int)(height_r*(292-198)), (int)(width_r*90), (int)(height_r*25));
        textField.setBackground(color4);
        //textField.setBorder(null);
        panel1.add(textField);
        //textField.setColumns(10);

        passwordField=new JPasswordField();
        passwordField.setFont(new Font("宋体", Font.BOLD, 16));
        passwordField.setBounds((int)(width_r*(450-290)), (int)(height_r*(332-198)), (int)(width_r*90), (int)(height_r*25));
        passwordField.setBackground(color4);
        //passwordField.setBorder(null);
        panel1.add(passwordField);
        //passwordField.setColumns(10);

        //boolean choice;
        JLabel chooselabel = new JLabel("请选择您的身份： ");
        chooselabel.setFont(new Font("等线", Font.BOLD, 20));
        chooselabel.setForeground(color1);
        chooselabel.setBounds((int)(width_r*(370-290)), (int)(height_r*(380-198)), (int)(width_r*200), (int)(height_r*25));
        panel1.add(chooselabel);
        JRadioButton rbtnstu= new JRadioButton("学生",false);
        rbtnstu.setFont(new Font("等线", Font.BOLD, 20));
        rbtnstu.setForeground(color1);
        //rbtnstu.setSelected(true);
        rbtnstu.setContentAreaFilled(false);
        rbtnstu.setBounds((int)(width_r*(370-290)), (int)(height_r*(412-198)), (int)(width_r*80), (int)(height_r*25));
        panel1.add(rbtnstu);
        JRadioButton rbtntea= new JRadioButton("教师",false);
        rbtntea.setFont(new Font("等线", Font.BOLD, 20));
        rbtntea.setForeground(color1);
        //rbtntea.setSelected(true);
        rbtntea.setContentAreaFilled(false);
        rbtntea.setBounds((int)(width_r*(450-290)), (int)(height_r*(412-198)), (int)(width_r*80), (int)(height_r*25));
        panel1.add(rbtntea);
        ButtonGroup group1=new ButtonGroup();
        group1.add(rbtnstu);
        group1.add(rbtntea);

        //登录
        JButton btnNewButton_1 = new JButton("登录");
        btnNewButton_1.setBounds((int)(width_r*(370-290)), (int)(height_r*(470-198)), (int)(width_r*160), (int)(height_r*25));
        Font myfont = new Font("楷体", Font.PLAIN, 25);
        btnNewButton_1.setFont(myfont);
        //btnNewButton_1.setBackground(new Color(34, 139, 34));
        btnNewButton_1.setBackground(color3);
        btnNewButton_1.setForeground(Color.white);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String username=textField.getText();
                    String pwd=String.valueOf(passwordField.getPassword());
                    if(rbtnstu.isSelected()) {
                        if (ucs.checkStudent(username, pwd)) {
                        //if (true) {
                            System.out.println(username + "登录成功！");
                            functionChoose.functionChooseUI();
                            jf.setVisible(false);
                        } else
                            JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                    }
                    else if (rbtntea.isSelected()) {
                        if(ucs.checkTeacher(username,pwd)) {
                            System.out.println(username+"登录成功！");
                            functionChoose.functionChooseUI();
                            jf.setVisible(false);}
                            else
                            JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                        }
                    else if (ucs.checkAdmin(username,pwd)) {
                                System.out.println(username+"登录成功！");
                                functionChoose.functionChooseUI();
                                jf.setVisible(false);
                            }
                    else
                        JOptionPane.showMessageDialog(p1, "身份选择错误,请重试!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel1.add(btnNewButton_1);
        panel1.add(lblBackground2);

        // 管理员登录
        JButton btnNewButton_3 = new JButton("管理员登录热键为alt+A");
        //btnNewButton_3.setAccelerator(KeyStroke.getKeyStroke('A', java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnNewButton_3.setMnemonic(java.awt.event.KeyEvent.VK_A);
        btnNewButton_3.setBounds(50, 1880, 420, 30);
        btnNewButton_3.setFont(new Font("等线",Font.BOLD,10));
        btnNewButton_3.setBackground(new Color(34, 139, 34));
        btnNewButton_3.setForeground(new Color(248, 248, 255));
        btnNewButton_3.setOpaque(false);
        //btnNewButton_3.setVisible(false);
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    String username=textField.getText();
                    String pwd=String.valueOf(passwordField.getPassword());
                    if(ucs.checkAdmin(username,pwd)) {
                        System.out.println(username+"登录成功！");
                        functionChoose.functionChooseUI();
                        jf.setVisible(false);
                    }else
                        JOptionPane.showMessageDialog(p1, "用户名或密码错误,请重试!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jf.getContentPane().add(btnNewButton_3);

        jf.setBounds(0,0,width,height);
        jf.setLocationRelativeTo(null);
        jf.getContentPane().add(lblBackground); // 将组件添加到面板中
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    /**
     * 主要
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
           //         JDBC_Connector.first_connect();
                    LoginFrame frame = new LoginFrame();
                    // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
