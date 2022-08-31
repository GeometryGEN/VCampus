package UIviewer.QQ;

import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;
import ClientToServer.myInfo;
import message.Message;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class chat_panel extends JPanel {
    private JPanel type_panel;
    private static JScrollPane scrollPane;
    private Friend friend;
    static double width_r;
    static JTextPane jTextPane = new JTextPane();
    static StyledDocument doc = jTextPane.getStyledDocument();
    public static void insertText(String text, Color colorName, int textSize, int textAlign){
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, colorName);//设置文本颜色
        StyleConstants.setFontSize(set, textSize);//设置文本大小
        StyleConstants.setAlignment(set, textAlign);//设置文本对齐方式
        doc.setParagraphAttributes(jTextPane.getText().length(), doc.getLength() - jTextPane.getText().length(), set, false);
        try {
            doc.insertString(doc.getLength(), text+"\n", set);//插入文本
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    public static void show_message(ArrayList<Message> messages){
        jTextPane.setText(null);
        //开头空格
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setFontSize(set, 0);//设置文本大小
        StyleConstants.setAlignment(set, 1);//设置文本对齐方式
        doc.setParagraphAttributes(jTextPane.getText().length(), doc.getLength() - jTextPane.getText().length(), set, false);
        try {
            doc.insertString(doc.getLength(), " ", set);//插入文本
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        int num=messages.size();
        for(int i=num-1;i>=0;i--) {
            System.out.println(messages.get(i).getSendTime());
            if(messages.get(i).getSender().equals(myInfo.getId())){
                insertText(messages.get(i).getSendTime(),Color.black,(int)(22*width_r),1);
                insertText((String)(messages.get(i).getData()),Color.black,(int)(32*width_r),2);
            }
            else{
                insertText(messages.get(i).getSendTime(),Color.black,(int)(22*width_r),1);
                insertText((String)(messages.get(i).getData()),Color.red,(int)(32*width_r),0);
            }
        }
        jTextPane.setCaretPosition(doc.getLength());
        jTextPane.setEditable(false);
        //scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        jTextPane.updateUI();
    }
    public chat_panel( int width, int height, double width_r, double height_r, int x, int y, Friend friend){
        this.friend=friend;
        setLayout(null);
        this.width_r=width_r;
        setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        setBackground(new Color(224,224,224));
        setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));

        //发消息界面
        type_panel=new JPanel();
        type_panel.setLayout(null);
        type_panel.setBounds(0,(int)(3*height/4*height_r),(int)(width*width_r),(int)(height/4*height_r));
        type_panel.setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));
        type_panel.setBackground(new Color(224,224,224));
        add(type_panel);
        //发送消息按钮
        JButton send_button= new JButton();
        int send_button_height=70;
        int send_button_width=140;
        send_button.setBackground(new Color(30,111,255));
        send_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        send_button.setText("发送");
        send_button.setForeground(new Color(255,255,255));
        send_button.setBounds((int)((width-send_button_width-1)*width_r),(int)((height/4-send_button_height-30)*height_r),(int)(send_button_width*width_r),(int)(send_button_height*height_r));
        type_panel.add(send_button);
        //关闭该聊天框按钮
        JButton close_button= new JButton();
        int close_button_height=70;
        int close_button_width=140;
        close_button.setBackground(new Color(211,10,11));
        close_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        close_button.setText("关闭");
        close_button.setForeground(new Color(255,255,255));
        close_button.setBounds((int)((width-2*send_button_width-1.5)*width_r),(int)((height/4-send_button_height-30)*height_r),(int)(send_button_width*width_r),(int)(send_button_height*height_r));
        type_panel.add(close_button);
        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        //输入消息框
        JTextArea type_field=new JTextArea();
        type_field.setBounds(0,0,(int)(width*width_r),(int)((height/4-1)*height_r));
        type_field.setBorder(BorderFactory.createLineBorder(new Color(224,224,224)));
        type_field.setBackground(new Color(245,246,247));
        type_field.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        type_panel.add(type_field);
        //发送信息
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //发送信息函数
                Client_qicq.send_message(type_field.getText(), myInfo.getId(),friend.getId());
                try {
                    Client_qicq.get_message(friend.getId());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                type_field.setText("");

            }
        });

        //显示消息界面
        scrollPane=new JScrollPane(jTextPane);
        //scrollPane.setLayout(null);
        scrollPane.setBounds(0,0,(int)(width*width_r),(int)(height/4*3*height_r));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));
        scrollPane.setBackground(new Color(245,246,247));
        //jTextPane.setBounds(0,0,(int)(width*width_r),(int)(height/4*3*height_r));
        jTextPane.setBackground(new Color(245,246,247));
        //scrollPane.add(jTextPane);
        add(scrollPane);
    }
}
