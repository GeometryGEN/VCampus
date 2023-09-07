package UIviewer.QQ;

import DAO.QICQ.Filetrans;
import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;
import ClientToServer.myInfo;
import UIviewer.Shopping.shopCustomer;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.RoundJButton;
import message.Message;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 聊天面板
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class chat_panel extends JPanel {
    public JPanel type_panel;
    private static JScrollPane scrollPane;
    private static Friend friend;
    static double width_r,height_r;
    JTextArea type_field;
    static int width,height,send_button_height,send_button_width;
    static JTextPane jTextPane = new JTextPane();
    static StyledDocument doc = jTextPane.getStyledDocument();
    static JButton  receive_button,close_button,send_button,send_file_button;
    static ArrayList<Filetrans>files=new ArrayList<>();

    static Color color1=new Color(125,182,191);
    static Color color2=new Color(68,84,105);
    static Color color3=new Color(51,51,51);
    static Color color4=new Color(69,69,69);

    /**
     * 插入文本
     *
     * @param text      文本
     * @param colorName 颜色名称
     * @param textSize  文字大小
     * @param textAlign 文本对齐
     */
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

    /**
     * 发送文件
     *
     * @param src      src
     * @param filename 文件名
     */
    public static void send_file(String src,String filename){
        Client_qicq.send_file(src,Client_qicq.getId(),friend.getId(),filename);
        try {
            Client_qicq.get_message(friend.getId());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
      //  System.out.println(friend.getId());
    }

    /**
     * 接收文件
     *
     * @param src      src
     * @param filepath filepath
     * @throws IOException ioexception
     */
    public static void receive_file(Filetrans src,String filepath) throws IOException {
        Client_qicq.receive_file(src,filepath);
        //System.out.println(friend.getId());
    }

    /**
     * 显示消息
     *
     * @param messages 消息
     */
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
//            System.out.println(messages.get(i).getSendTime());
            if(messages.get(i).isfile==1)
            {

                if(messages.get(i).getSender().equals(myInfo.getId())){
                    insertText(messages.get(i).getSendTime(),new Color(122,122,123),(int)(16*width_r),1);
                    insertText(myInfo.getName()+"(我)"+":",Color.black,(int)(22*width_r),2);
                    Filetrans f=(Filetrans)messages.get(i).getData();
                    insertText((String)"给对方发送文件:  "+f.getName(),color2,(int)(42*width_r),2);
                }
                else{
                    Filetrans f=(Filetrans)messages.get(i).getData();
                    insertText(messages.get(i).getSendTime(),new Color(122,122,123),(int)(16*width_r),1);
                    insertText( friend.getName()+":",color1,(int)(22*width_r),0);
                    insertText((String)(String)"收到对方发送的文件:  "+f.getName(),color2,(int)(42*width_r),0);
                    files.add(f);
                }
            }
            else {
                if(messages.get(i).getSender().equals(myInfo.getId())){
                    Color color=Color.white;
                    if(functionChoose.color_switch){
                        color=Color.black;
                    }else{
                        color=Color.white;
                    }
                    insertText(messages.get(i).getSendTime(),new Color(122,122,123),(int)(16*width_r),1);
                    insertText(myInfo.getName()+"(我)"+":",color,(int)(22*width_r),2);
                    insertText((String)(messages.get(i).getData()),color,(int)(42*width_r),2);
                }
                else{
                    insertText(messages.get(i).getSendTime(),new Color(122,122,123),(int)(16*width_r),1);
                    insertText(friend.getName()+":",color1,(int)(22*width_r),0);
                    insertText((String)(messages.get(i).getData()),color1,(int)(42*width_r),0);
                }
            }

        }
        if(files.size()!=0){
            receive_button.setVisible(true);
            close_button.setLocation((int)(650*width_r),(int)(900*height_r));
            receive_button.setFocusPainted(false);
        }
        else {
            receive_button.setVisible(false);
            close_button.setLocation((int)(650*width_r),(int)(900*height_r));
            receive_button.setFocusPainted(false);
        }

        jTextPane.setEditable(false);

        jTextPane.updateUI();
        jTextPane.setCaretPosition(jTextPane.getStyledDocument().getLength());
    }

    /**
     * 聊天面板
     *
     * @param width    宽度
     * @param height   高度
     * @param width_r  宽度r
     * @param height_r 高r
     * @param x        x
     * @param y        y
     * @param friend   朋友
     */
    public chat_panel( int width, int height, double width_r, double height_r, int x, int y, Friend friend){
        this.friend=friend;
        setLayout(null);
        this.width_r=width_r;
        this.height_r=height_r;
        this.width=width;
        this.height=height;
        setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        if(functionChoose.color_switch){
            setBackground(new Color(247,247,247));
            setBorder(BorderFactory.createLineBorder(new Color(229,229,229)));
        }else{
            setBackground(new Color(51,51,51));
            setBorder(BorderFactory.createLineBorder(new Color(69,69,69)));
        }
        //发消息界面
        type_panel=new JPanel();
        type_panel.setLayout(null);
        type_panel.setBounds(0,0,width,height);
        if(functionChoose.color_switch){
            type_panel.setBorder(BorderFactory.createLineBorder(new Color(229,229,229)));
            type_panel.setBackground(new Color(200,224,228));
        }else{
            type_panel.setBorder(BorderFactory.createLineBorder(new Color(69,69,69)));
            type_panel.setBackground(new Color(68,84,105));
        }
        add(type_panel);
        //发送消息按钮
        send_button= new RoundJButton();
        send_button.setFocusPainted(false);
        send_button_height=40;
        send_button_width=140;
        if(functionChoose.color_switch){
            send_button.setBackground(new Color(125,182,191));
            send_button.setForeground(new Color(0,0,0));
        }else{
            send_button.setBackground(new Color(42,52,65));
            send_button.setForeground(new Color(255,255,255));
        }
        send_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        send_button.setText("发送");
        send_button.setBounds((int)(1100*width_r),(int)(900*height_r),(int)(send_button_width*width_r-20),(int)(send_button_height*height_r));
        type_panel.add(send_button);
        //发送文件按钮
        send_file_button= new RoundJButton();
        send_file_button.setFocusPainted(false);
        if(functionChoose.color_switch){
            send_file_button.setBackground(new Color(125,182,191));
            send_file_button.setForeground(new Color(0,0,0));
        }else{
            send_file_button.setBackground(new Color(42,52,65));
            send_file_button.setForeground(new Color(255,255,255));
        }
        send_file_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        send_file_button.setText("文件");
        send_file_button.setBounds((int)(950*width_r),(int)(900*height_r),(int)(send_button_width*width_r-20),(int)(send_button_height*height_r));
        type_panel.add(send_file_button);
        send_file_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file_panel.createWindow(0);
            }
        });
        //关闭该聊天框按钮
        close_button= new RoundJButton();
        close_button.setFocusPainted(false);
        if(functionChoose.color_switch){
            close_button.setBackground(new Color(125,182,191));
            close_button.setForeground(new Color(0,0,0));
        }else{
            close_button.setBackground(new Color(42,52,65));
            close_button.setForeground(new Color(255,255,255));
        }
        close_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        close_button.setText("关闭");
        close_button.setBounds((int)(700*width_r),(int)(900*height_r),(int)(send_button_width*width_r-20),(int)(send_button_height*height_r));
        type_panel.add(close_button);
        close_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                main_panel.buttonPanel.setVisible(true);
            }
        });

        //接受文件按钮
        int receive_button_height=70;
        int receive_button_width=140;
        receive_button= new RoundJButton();
        receive_button.setFocusPainted(false);
        if(functionChoose.color_switch){
            receive_button.setBackground(new Color(125,182,191));
            receive_button.setForeground(new Color(0,0,0));
        }else{
            receive_button.setBackground(new Color(42,52,65));
            receive_button.setForeground(new Color(255,255,255));
        }
        receive_button.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        receive_button.setText("接收");
        receive_button.setForeground(new Color(255,255,255));
        receive_button.setBounds((int)(800*width_r),(int)(900*height_r),(int)(send_button_width*width_r-20),(int)(send_button_height*height_r));
        type_panel.add(receive_button);
        receive_button.setVisible(false);
        receive_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receive_panel.createWindow(files);
            }
        });
        type_panel.add(receive_button);

        //输入消息框
        type_field=new JTextArea();
        type_field.setBounds(0,height-(int)((height/4-1)*height_r)-20,(int)(width*width_r),80);
        type_field.setOpaque(false);
        type_panel.setBorder(null);
        if(functionChoose.color_switch){
            type_field.setBorder(BorderFactory.createLineBorder(new Color(224,224,224)));
            type_field.setBackground(new Color(245,246,247));
            type_field.setForeground(Color.black);
        }else{
            type_field.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
            type_field.setBackground(new Color(1,2,3));
            type_field.setForeground(Color.white);
        }
        type_field.setFont(new Font("宋体",Font.PLAIN,(int)(25*width_r)));
        type_panel.add(type_field);
        //发送信息
        send_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myInfo.getType()!=3){
                    //发送信息函数
                    Client_qicq.send_message(type_field.getText(), myInfo.getId(),friend.getId());
                    try {
                        Client_qicq.get_message(friend.getId());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    Client_qicq.add_announcement(myInfo.getId(),type_field.getText());
                    Client_qicq.get_announcement();
                }
                type_field.setText("");

            }
        });

        //显示消息界面
        scrollPane=new JScrollPane(jTextPane);
        scrollPane.setBounds(0,0,(int)(width*width_r),(int)(height/4*3*height_r));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));
        if(functionChoose.color_switch){
            scrollPane.setBackground(new Color(245,246,247));
            jTextPane.setBackground(new Color(245,246,247));
            jTextPane.setForeground(new Color(0,0,0));
        }else{
            scrollPane.setBackground(new Color(0,1,2));
            jTextPane.setBackground(new Color(0,1,2));
            jTextPane.setForeground(new Color(255,255,255));
        }

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            @Override
            public boolean isVisible() {
                return true;
            }
        };
        scrollPane.setVerticalScrollBar(scrollBar);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollBar.setUnitIncrement(30);

        add(scrollPane);

        main_panel.color_choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean color=!functionChoose.color_switch;
                if(color){
                    setBackground(new Color(125,182,191));
                    setBackground(new Color(247,247,247));
                    setBorder(BorderFactory.createLineBorder(new Color(229,229,229)));
                    type_panel.setBorder(BorderFactory.createLineBorder(new Color(229,229,229)));
                    type_panel.setBackground(new Color(200,224,228));
                    send_button.setBackground(new Color(125,182,191));
                    send_button.setForeground(new Color(0,0,0));
                    send_file_button.setBackground(new Color(125,182,191));
                    send_file_button.setForeground(new Color(0,0,0));
                    close_button.setBackground(new Color(125,182,191));
                    close_button.setForeground(new Color(0,0,0));
                    receive_button.setBackground(new Color(125,182,191));
                    receive_button.setForeground(new Color(0,0,0));
                    type_field.setBorder(BorderFactory.createLineBorder(new Color(224,224,224)));
                    type_field.setBackground(new Color(245,246,247));
                    type_field.setForeground(Color.black);
                    scrollPane.setBackground(new Color(245,246,247));
                    jTextPane.setBackground(new Color(245,246,247));
                    jTextPane.setForeground(new Color(0,0,0));
                }else{
                    setBackground(new Color(42,52,65));
                    setBackground(new Color(51,51,51));
                    setBorder(BorderFactory.createLineBorder(new Color(69,69,69)));
                    type_panel.setBorder(BorderFactory.createLineBorder(new Color(69,69,69)));
                    type_panel.setBackground(new Color(68,84,105));
                    send_button.setBackground(new Color(42,52,65));
                    scrollPane.setBackground(new Color(0,1,2));
                    jTextPane.setBackground(new Color(0,1,2));
                    jTextPane.setForeground(new Color(255,255,255));
                    send_button.setForeground(new Color(255,255,255));
                    send_file_button.setBackground(new Color(42,52,65));
                    send_file_button.setForeground(new Color(255,255,255));
                    type_field.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
                    type_field.setBackground(new Color(1,2,3));
                    type_field.setForeground(Color.white);
                    receive_button.setBackground(new Color(42,52,65));
                    receive_button.setForeground(new Color(255,255,255));
                    close_button.setBackground(new Color(42,52,65));
                    close_button.setForeground(new Color(255,255,255));
                }
            }
        });
    }

    /**
     * 显示公告
     *
     * @param messages 消息
     */
    public static void show_announcement(ArrayList<Message> messages) {
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
            Color color;
            if(functionChoose.color_switch){
                color=Color.black;
            }else{
                color=Color.white;
            }
                insertText(messages.get(i).getSendTime(),new Color(122,122,123),(int)(16*width_r),1);
                insertText((String)(messages.get(i).getData()),color,(int)(42*width_r),1);
        }

        jTextPane.setEditable(false);
       // System.out.println(1);
        jTextPane.updateUI();
        scrollPane.updateUI();

        jTextPane.setCaretPosition(jTextPane.getStyledDocument().getLength());

    }

    /**
     * 得到朋友
     *
     * @return {@link Friend}
     */
    public Friend getFriend() {
        return friend;
    }

    /**
     * 设置关闭
     */
    public void set_Close() {
        close_button.setBounds((int)(700*width_r),(int)(900*height_r),(int)(send_button_width*width_r-20),(int)(send_button_height*height_r));
    }

    public static void main(String[] args){
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width=(int) screensize.getWidth(); //得到宽度
        int height=(int) screensize.getHeight();//获得高度
        JFrame jf=new JFrame("shopCustomer");
        jf.setSize(width,height);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println("before creat");
        jf.setContentPane(new chat_panel(width,height,width/1200,height/800,500,500,null));
        System.out.println("after creat");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

    };
}
