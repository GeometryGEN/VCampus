package UIviewer.chatgpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import ClientToServer.myInfo;
import DAO.Chat.*;
import UIviewer.login.functionChoose;
import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnails;

import static UIviewer.login.functionChoose.jf;

public class gpt_panel extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static String question_toask;
    public static String answer_back;
    static String name;
    public static JPanel panel = new JPanel();
    static void getName(String a)
    {
        name=a;
    }
    public static CardLayout cardLayout=new CardLayout();
    public gpt_panel() throws Exception{
        //问题返回界面
        JTextArea answers=new JTextArea();
        answers.setBounds((int)(200*width_r),(int)(170*height_r),(int)(800*width_r),(int)(400*height_r));
        //answers.setBackground(new Color(235,225,228));
        add(answers);
        answers.setLineWrap(true);
        answers.setFont(new Font("楷体",Font.BOLD,20));
        JScrollPane jsp=new JScrollPane(answers);
        //支持滚动
        //JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds((int)(200*width_r),(int)(170*height_r),(int)(800*width_r),(int)(400*height_r));
        add(jsp);
        //jScrollPane.setPreferredSize(new Dimension(460,100));
        //jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//提问按钮
        JButton ask=new JButton("ask");
        ask.setBounds((int)(900*width_r),(int)(600*height_r),(int)(100*width_r),(int)(50*height_r));
        ask.setBackground(new Color(190,182,191));
        ask.setFont(new Font("华文新魏",Font.BOLD,30));
        add(ask);
        //主界面
        String name= myInfo.getName();
        getName(name);
        functionChoose.jf.getJMenuBar().setBackground(new Color(68,84,105));
        functionChoose.jf.getJMenuBar().getMenu(0).setForeground(new Color(255,255,255));
        setBounds(0,0, (int) (1273*width_r), (int) (790*height_r));
        setLayout(null);
        panel.setBounds(0, (int) (150*height_r), (int) (1273*width_r), (int) (790*height_r));
        add(panel);
//		给主要显示面板添加布局方式
        panel.setLayout(cardLayout);
        //setBounds(0,0,width,height);
        setBackground(new Color(169,189,205));
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("src/image/zhushoubg_1.png");
        int icon1_width= 600;
        int icon1_height=75;
        try {
            Thumbnails.of(new File("src/image/zhushoubg_1.png"))
                    .size((int)(icon1_width*width_r), (int)(icon1_height*height_r))
                    .toFile(new File("src/image/zhushoubg_1min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logo.setIcon(new ImageIcon("src/image/zhushoubg_1min.png"));
        logo.setBounds((int) (30*width_r), (int) (10*height_r), (int) (600*width_r), (int) (75*height_r));
        add(logo);
        //文字
        JLabel l1 = new JLabel("你好！"+name);
        l1.setBounds((int) (1100*width_r), (int) (30*height_r), (int) (200*width_r), (int) (55*height_r));
        l1.setForeground(new Color(248, 248, 255));
        Font font = new Font("楷体", Font.BOLD, (int) (20*width_r));
        l1.setFont(font);
        add(l1);

        JPanel p1 = new JPanel();

        //上方面板
        p1.setBounds(0, 0, (int) (1279*width_r), (int) (100*height_r));
        p1.setBackground(new Color(42,52,65));
        add(p1);
        Font myfont = new Font("微软雅黑 ", Font.BOLD, 20);
        JButton btnNewButton_6 = new JButton("退出智能助手");
        btnNewButton_6.setBounds((int) (1100*width_r), (int) (100*height_r), (int) (173*width_r), (int) (50*height_r));
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.setForeground(new Color(220, 220, 220));
        btnNewButton_6.setContentAreaFilled(false);
        btnNewButton_6.setBorder(null);
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                setVisible(false);
            }

        });
        add(btnNewButton_6);
        //按钮面板
        JPanel p2 = new JPanel();
        p2.setBounds(0, (int) (100*height_r), (int) (1280*width_r), (int) (50*height_r));
        p2.setBackground(new Color(68,84,105));
        add(p2);

        //问问题界面
        JTextPane question=new JTextPane();
        question.setBackground(new Color(235,225,228));
        question.setBounds((int)(200*width_r),(int)(600*height_r),(int)(600*width_r),(int)(50*height_r));
        add(question);
        question.setFont(new Font("楷体",Font.BOLD,25));
        String questionContent=question.getText();
        answers.setText(questionContent);

//        //返回按钮
//        JButton go_back=new JButton("go back");
//        add(go_back);
//        go_back.setBounds((int)(200*width_r),(int)(700*height_r),(int)(600*width_r),(int)(50*height_r));

        //不要改的东西
        ask.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                String questionContent=question.getText();
                answers.append(questionContent);
                answers.append("\r\n");
                question_toask=question.getText();
                AskQuestion askQuestion=new AskQuestion();
                QuestionModule questionModule;
                System.out.print("\n你有什么想问我的嘛？如果想退出系统，请输入‘q’哦！^_^\n");
                questionModule = askQuestion.Ask(question_toask);
                System.out.println("本次回答花费：" + questionModule.timeConsuming + "秒。虽然有点慢，但我尽力了呢~ ^.^");
                System.out.println(questionModule.answer);
                JTextPane answer_back=new JTextPane();
                answers.append(questionModule.answer);
                answers.append("\r\n");
                question.setText("");
            }
        });


//        go_back.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jf.getJMenuBar().setBackground(new Color(125,182,191));
//                jf.getJMenuBar().getMenu(0).setForeground(new Color(31,66,71));
//                jf.setContentPane(functionChoose.fc_panel);
//                jf.setTitle("functionChoose");
//            }
//        });
    }
}
