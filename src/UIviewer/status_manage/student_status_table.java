package UIviewer.status_manage;

import ClientToServer.ClientToServer;
import UIhandler.StatusManagement.Client_status;
import UIviewer.login.functionChoose;
import User.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ClientToServer.myInfo;

/**
 * 学生状态表
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class student_status_table extends JPanel{
    public JButton jb1,jb2,jb3;
    public static JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28,text29,text30,text31,text32;
    static JLabel title_label1=new JLabel("基本信息");
    static   JLabel title_label2=new JLabel("学业信息");
        /**
     * 文本标题
     *
     * @param s        年代
     * @param width_r  宽度r
     * @param height_r 高r
     * @param x        x
     * @param y        y
     * @return {@link JTextField}
     */

    private JTextField text_title(String s, double width_r, double height_r, int x, int y,boolean color_switch){
       JTextField text=new JTextField();
        text.setText("   "+s);
        if(color_switch){
            text.setBackground(new Color(200,200,200));
        }
        else{
            text.setBackground(new Color(100,108,114));
        }

        text.setBorder(BorderFactory.createLineBorder(new Color(110,118,124)));
        text.setEditable(false);
        Font font = new Font("微软雅黑", Font.BOLD, (int)(25*width_r));
        text.setFont(font);
        if(student_status.color_switch) {
            text.setForeground(new Color(51, 51, 51));
        }else{
            text.setForeground(new Color(204,204,204));
        }
        text.setBounds((int)(x*width_r),(int)(y*height_r),(int)(230*width_r),(int)(65*height_r));
        return text;
    }

    /**
     * 文本信息
     *
     * @param s        年代
     * @param width_r  宽度r
     * @param height_r 高r
     * @param x        x
     * @param y        y
     * @return {@link JTextField}
     */
    private JTextField text_info(String s, double width_r, double height_r, int x, int y){
        JTextField text=new JTextField("   "+s);
        if(student_status.color_switch){
            text.setBackground(new Color(200,224,228));}
        else{
            text.setBackground(new Color(68,84,105));
        }
        text.setBorder(BorderFactory.createLineBorder(new Color(110,118,124)));
        text.setEditable(false);
        Font font = new Font("微软雅黑", Font.PLAIN, (int)(25*width_r));
        text.setFont(font);
        if(student_status.color_switch) {
            text.setForeground(new Color(51, 51, 51));
        }else{
            text.setForeground(new Color(204,204,204));
        }
        text.setBounds((int)(x*width_r),(int)(y*height_r),(int)(310*width_r),(int)(65*height_r));
        return text;
    }

    /**
     * 切换到编辑
     */
    public void switch_to_edit(){
        text2.setEditable(true);
        text4.setEditable(true);
        text6.setEditable(true);
        text8.setEditable(true);
        text10.setEditable(true);
        text12.setEditable(true);
        text14.setEditable(true);
        text16.setEditable(true);
        text18.setEditable(true);
        text20.setEditable(true);
        text22.setEditable(true);
        text24.setEditable(true);
        text26.setEditable(true);
        text28.setEditable(true);
        text30.setEditable(true);
        text32.setEditable(true);
    }

    /**
     * 切换到unedit
     */
    public void switch_to_unedit(){
        text2.setEditable(false);
        text4.setEditable(false);
        text6.setEditable(false);
        text8.setEditable(false);
        text10.setEditable(false);
        text12.setEditable(false);
        text14.setEditable(false);
        text16.setEditable(false);
        text18.setEditable(false);
        text20.setEditable(false);
        text22.setEditable(false);
        text24.setEditable(false);
        text26.setEditable(false);
        text28.setEditable(false);
        text30.setEditable(false);
        text32.setEditable(false);
    }

    /**
     * 学生状态表
     *
     * @param width_r  宽度r
     * @param height_r 高r
     * @param width    宽度
     * @param height   高度
     * @param sinfo    sinfo
     * @throws Exception 异常
     */
    public student_status_table(double width_r, double height_r, double width, double height,Student sinfo,boolean color_switch) throws Exception {
        if(color_switch){
            setBackground(new Color(200,224,228));
        }else {
        setBackground(new Color(68,84,105));
        }
        setBorder(BorderFactory.createEtchedBorder());
        setBorder(BorderFactory.createLineBorder(new Color(232,237,239)));
        setLayout(null);//设置绝对布局

        //个人基本信息文字
//        JLabel title_label1=new JLabel("基本信息");
        title_label1.setBounds((int)(50*width_r), (int)(10*height_r), (int)(250*width_r), (int)(50*height_r));
        Font title_font1 = new Font("微软雅黑", Font.BOLD, (int)(27*width_r));
        title_label1.setFont(title_font1);
        if(student_status.color_switch){
        title_label1.setForeground(new Color(102,102,102));}
        else{
            title_label1.setForeground(new Color(170,170,170));
        }
        add(title_label1);
        /*if(myInfo.getType()==3){
            sinfo = Client_status.returnStatus_Admin(IDcard);
        }else{
            sinfo = Client_status.returnStatusInfo(IDcard);
        }*/
        //信息表格
        text1=text_title("姓名",width_r,height_r,50,80,student_status.color_switch);
        add(text1);
        text2=text_info(sinfo.getStudent_name(),width_r, height_r,280,80);
        add(text2);
        text3=text_title("民族",width_r,height_r,590,80,student_status.color_switch);
        add(text3);
        text4=text_info(sinfo.getNation(),width_r, height_r,820,80);
        add(text4);
        text5=text_title("年龄",width_r, height_r,50,145,student_status.color_switch);
        add(text5);
        text6=text_info(Integer.toString(sinfo.getStudent_age()),width_r, height_r,280,145);
        add(text6);
        text7=text_title("籍贯",width_r, height_r,590,145,student_status.color_switch);
        add(text7);
        text8=text_info(sinfo.getNative_place(),width_r, height_r,820,145);
        add(text8);
        text9=text_title("出生日期",width_r, height_r,50,210,student_status.color_switch);
        add(text9);
        text10=text_info(sinfo.getBirthday(),width_r, height_r,280,210);
        add(text10);
        text11=text_title("身份证号",width_r, height_r,590,210,student_status.color_switch);
        add(text11);
        text12=text_info(sinfo.getID(),width_r, height_r,820,210);
        add(text12);
        text13=text_title("性别",width_r, height_r,50,275,student_status.color_switch);
        add(text13);
        text14=text_info(sinfo.getStudent_gender(),width_r, height_r,280,275);
        add(text14);
        text15=text_title("邮箱",width_r, height_r,590,275,student_status.color_switch);
        add(text15);
        text16=text_info(sinfo.getStudent_email(), width_r, height_r,820,275);
        add(text16);
//        JLabel title_label2=new JLabel("学业信息");
        title_label2.setBounds((int)(50*width_r), (int)(350*height_r), (int)(250*width_r), (int)(50*height_r));
        Font title_font2 = new Font("微软雅黑", Font.BOLD, (int)(27*width_r));
        title_label2.setFont(title_font2);
        if(student_status.color_switch) {
            title_label2.setForeground(new Color(102, 102, 102));
        }else{
            title_label2.setForeground(new Color(170,170,170));
        }
        add(title_label2);
        text17=text_title("一卡通号",width_r, height_r,50,405,student_status.color_switch);
        add(text17);
        text18=text_info(sinfo.getStudent_idcard(), width_r, height_r,280,405);
        add(text18);
        text19=text_title("学号",width_r, height_r,590,405,student_status.color_switch);
        add(text19);
        text20=text_info(sinfo.getStudent_id(),width_r, height_r,820,405);
        add(text20);
        text21=text_title("专业",width_r, height_r,50,465,student_status.color_switch);
        add(text21);
        text22=text_info(sinfo.getMajor(),width_r, height_r,280,465);
        add(text22);
        text23=text_title("班级",width_r, height_r,590,465,student_status.color_switch);
        add(text23);
        text24=text_info(sinfo.getSclass(),width_r, height_r,820,465);
        add(text24);
        text25=text_title("入学年级",width_r, height_r,50,530,student_status.color_switch);
        add(text25);
        text26=text_info(sinfo.getStudent_class(),width_r, height_r,280,530);
        add(text26);
        text27=text_title("预计毕业日期",width_r, height_r,590,530,student_status.color_switch);
        add(text27);
        text28=text_info(sinfo.getDue_graduate_date(),width_r, height_r,820,530);
        add(text28);
        text29=text_title("学生类别",width_r, height_r,50,595,student_status.color_switch);
        add(text29);
        text30=text_info(sinfo.getStudent_type(),width_r, height_r,280,595);
        add(text30);
        text31=text_title("校区",width_r, height_r,590,595,student_status.color_switch);
        add(text31);
        text32=text_info(sinfo.getCampus(),width_r, height_r,820,595);
        add(text32);




        if(myInfo.getType()==3){
            jb1=new JButton("修改学籍信息");
            jb1.setBounds((int)(360*width_r),(int)(650*height_r),(int)(170*width_r),(int)(50*height_r));
            jb1.setBackground(new Color(33,150,243));
            jb1.setForeground(new Color(255,255,255));
            jb1.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            add(jb1);
            jb1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch_to_edit();
                    jb3.setVisible(true);
                    jb1.setVisible(false);
                }
            });
            manage_status.jb_back_to_search =new JButton("返回");
            manage_status.jb_back_to_search.setBounds((int)(550*width_r),(int)(650*height_r),(int)(100*width_r),(int)(50*height_r));
            manage_status.jb_back_to_search.setBackground(new Color(96,190,41));
            manage_status.jb_back_to_search.setForeground(new Color(255,255,255));
            manage_status.jb_back_to_search.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            add(manage_status.jb_back_to_search);

            manage_status.jb_back_to_search.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                //    System.out.println("exit");
                    manage_status.search_text.setHorizontalAlignment(JTextField.CENTER);
                    manage_status.search_text.addFocusListener(new JTextFieldHintListener(manage_status.search_text, "请输入要查询学生的一卡通号"));
                    manage_status.status_jpanel.setVisible(false);
                    manage_status.search_panel.setVisible(true);
                }
            });
            jb3=new JButton("提交学籍信息");
            jb3.setBounds((int)(360*width_r),(int)(650*height_r),(int)(170*width_r),(int)(50*height_r));
            jb3.setBackground(new Color(33,150,243));
            jb3.setForeground(new Color(255,255,255));
            jb3.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            add(jb3);
            jb3.setVisible(false);
            jb3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result=JOptionPane.showConfirmDialog(null, "确认提交本次修改内容吗", "提示", JOptionPane.OK_CANCEL_OPTION);
                    if(JOptionPane.OK_OPTION==result){
                        Student temp = new Student();
                        String idcard=text2.getText().trim();temp.setStudent_idcard(idcard);
                        String id=text4.getText().trim();temp.setStudent_id(id);
                        String name=text6.getText().trim();temp.setStudent_name(name);
                        String age=text8.getText().trim();temp.setStudent_age(Integer.parseInt(age));
                        String gender=text10.getText().trim();temp.setStudent_gender(gender);
                        String nation=text12.getText().trim();temp.setNation(nation);
                        String shenfenzheng=text14.getText().trim();temp.setID(shenfenzheng);
                        String birthday=text16.getText().trim();    temp.setBirthday(birthday);
                        String natibe_place=text18.getText().trim();temp.setNative_place(natibe_place);
                        String major=text20.getText().trim();temp.setMajor(major);
                        String Class=text22.getText().trim();temp.setStudent_class(Class);
                        String type=text24.getText().trim(); temp.setStudent_type(type);
                        String Sclass=text26.getText().trim();temp.setSclass(Sclass);
                        String campus=text28.getText().trim();temp.setCampus(campus);
                        String due_gradute=text30.getText().trim();temp.setDue_graduate_date(due_gradute);
                        String email=text32.getText().trim();temp.setStudent_email(email);
                        /*try {
                            if(Client_status.renewInfo(temp))
                                JOptionPane.showMessageDialog(null, "修改学生信息成功!");
                            else
                                JOptionPane.showMessageDialog(null, "修改学生信息失败!");
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }*/
                        try {
                            Client_status.change(temp);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        System.out.println("submit");
                        switch_to_unedit();
                        jb3.setVisible(false);
                        jb1.setVisible(true);
                    }
                }
            });
        }
        else if(myInfo.getType()==1){
            functionChoose.back_from_student_status =new JButton("返回功能选择");
            functionChoose.back_from_student_status.setBounds((int)(470*width_r),(int)(700*height_r),(int)(170*width_r),(int)(50*height_r));
            functionChoose.back_from_student_status.setBackground(new Color(96,190,41));
            functionChoose.back_from_student_status.setForeground(new Color(255,255,255));
            functionChoose.back_from_student_status.setFont(new Font("微软雅黑",Font.PLAIN,(int)(22*width_r)));
            add(functionChoose.back_from_student_status);
            functionChoose.back_from_student_status.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
               //     Client_status.resetS();
                    functionChoose.jf.setContentPane(functionChoose.fc_panel);
                }
            });
        }
    }

}
