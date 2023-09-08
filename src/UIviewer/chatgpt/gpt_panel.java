package UIviewer.chatgpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.Chat.*;
import lombok.SneakyThrows;

public class gpt_panel extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static String question_toask;
    public static String answer_back;
    public gpt_panel() throws Exception{
        JTextPane question=new JTextPane();
        question.setBackground(new Color(0,0,0));
        question.setBounds(0,(int)(400*height_r),width,(int)(200*height_r));
        add(question);

        JTextPane answer_back=new JTextPane();
        answer_back.setBounds(0,(int)(900*height_r),width,(int)(400*height_r));
        answer_back.setText("返回答案");
        answer_back.setBackground(new Color(0,0,0));
        add(answer_back);

        JButton ask=new JButton("ask");
        ask.setBounds(900,(int)(500*height_r),40,20);

        JScrollPane answers=new JScrollPane();
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
                    answer_back.setText(questionModule.answer);

            }
        });
        add(ask);
    }
}
