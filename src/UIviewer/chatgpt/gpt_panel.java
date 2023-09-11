package UIviewer.chatgpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClientToServer.myInfo;
import DAO.Chat.*;
import UIviewer.login.functionChoose;
import lombok.SneakyThrows;

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
        setBounds(0,0,width,height);
        setBackground(new Color(231,21,21));

        //问问题界面
        JTextPane question=new JTextPane();
        question.setBackground(new Color(0,0,0));
        question.setBounds(0,(int)(400*height_r),width,(int)(200*height_r));
        add(question);

        //提问按钮
        JButton ask=new JButton("ask");
        ask.setBounds(900,(int)(500*height_r),40,20);

        //问题返回界面
        JTextArea answers=new JTextArea();
        answers.setBackground(new Color(12,241,2));
        add(answers);

        //返回按钮
        JButton go_back=new JButton("go back");
        add(go_back);

        //不要改的东西
        ask.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
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
        add(ask);

        go_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.getJMenuBar().setBackground(new Color(125,182,191));
                jf.getJMenuBar().getMenu(0).setForeground(new Color(31,66,71));
                jf.setContentPane(functionChoose.fc_panel);
                jf.setTitle("functionChoose");
            }
        });
    }
}
