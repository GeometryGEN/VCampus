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
    /**
     * 交流输入
     *
     * @param jLabel j标签
     */
    private void exchangeEnter(JLabel jLabel) {
        if(functionChoose.color_switch){
            jLabel.setBackground(new Color(242,242,242));
        }else{
            jLabel.setBackground(new Color(56,56,56));
        }
    }

    /**
     * 交易所退出
     *
     * @param jLabel j标签
     */
    private void exchangeExited(JLabel jLabel) {
        if(functionChoose.color_switch){
            jLabel.setBackground(new Color(229,229,229));
        }else{
            jLabel.setBackground(new Color(69,69,69));
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
            setBackground(new Color(229,229,229));
            setForeground(new Color(0,0,0));
        }else{
            setBackground(new Color(69,69,69));
            setForeground(new Color(255,255,255));
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
                    setBackground(new Color(229,229,229));
                    setForeground(new Color(0,0,0));
                }else{
                    setBackground(new Color(69,69,69));
                    setForeground(new Color(255,255,255));
                }
            }
        });
        jLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                exchangeEnter(jLabel);
            }
            public void mouseExited(MouseEvent e) {
                exchangeExited(jLabel);
            }
        });
    }
}
