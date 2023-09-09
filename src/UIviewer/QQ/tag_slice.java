package UIviewer.QQ;

import UIviewer.login.functionChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 标签片
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class tag_slice extends JLabel {
    static Color color1=new Color(125,182,191);
    static Color color2=new Color(68,84,105);
    static Color color3=new Color(51,51,51);
    static Color color4=new Color(69,69,69);
    static Color color5=new Color(30,111,255);
    static Color color6=new Color(45,52,82);
    static Color color7=new Color(190,213,235);
    static Color color8=new Color(31,66,71);
    static Color color9=new Color(125,182,191);
    static Color color10=new Color(111,150,134);
    static Color color11=new Color(207,219,212);
    static Color color12=new Color(200,224,228);

    /**
     * 交流输入
     *
     * @param jLabel j标签
     */
    private void exchangeEnter(JLabel jLabel) {
        if(functionChoose.color_switch){
            //jLabel.setBackground(new Color(242,242,242));
            jLabel.setBackground(color7);
        }else{
            //jLabel.setBackground(new Color(56,56,56));
            jLabel.setBackground(color2);
        }
    }

    /**
     * 交易所退出
     *
     * @param jLabel j标签
     */
    private void exchangeExited(JLabel jLabel) {
        if(functionChoose.color_switch){
            //jLabel.setBackground(new Color(229,229,229));
            jLabel.setBackground(color7);
        }else{
            //jLabel.setBackground(new Color(69,69,69));
            jLabel.setBackground(color2);
        }
    }


    /**
     * 标签片
     *
     * @param width_r  宽度r
     * @param height_r 高r
     * @param s        年代
     */
    public tag_slice(double width_r,double height_r,String s){
        setOpaque(true);
        if(functionChoose.color_switch){
            //setBackground(new Color(229,229,229));
            //setForeground(new Color(0,0,0));
            setBackground(color12);
            setForeground(color6);
        }else{
            //setBackground(new Color(69,69,69));
            //setForeground(new Color(255,255,255));
            setBackground(color2);
            setForeground(Color.white);
        }
        setText("     "+s+"                                                                                            ");
        setFont(new Font("宋体",Font.PLAIN,(int)(24*width_r)));
        JLabel jLabel=this;//为后续按钮提供指针
        //鼠标移进去变色，移出复原

        main_panel.color_choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean color=!functionChoose.color_switch;
                if(color){
                   //setBackground(new Color(229,229,229));
                    //setForeground(new Color(0,0,0));
                    setBackground(color12);
                    setForeground(color6);
                }else{
                    //setBackground(new Color(69,69,69));
                    //setForeground(new Color(255,255,255));
                    setBackground(color4);
                    setForeground(Color.white);
                }
            }
        });
        /*
        jLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                exchangeEnter(jLabel);
            }
            public void mouseExited(MouseEvent e) {
                exchangeExited(jLabel);
            }
        });

         */
    }
}
