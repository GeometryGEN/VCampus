package UIviewer.QQ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class tag_slice extends JLabel {
    private void exchangeEnter(JLabel jLabel) {
        jLabel.setBackground(new Color(242,242,242));
    }

    private void exchangeExited(JLabel jLabel) {
        jLabel.setBackground(new Color(255,255,255));
    }
    public tag_slice(int width,int height,double width_r,double height_r,String s){
        setOpaque(true);
        setSize((int)(width*width_r),(int)(height*height_r));
        setBackground(new Color(255,255,255));
        setText("     "+s+"                                                                                            ");
        setFont(new Font("宋体",Font.PLAIN,(int)(24*width_r)));
        JLabel jLabel=this;//为后续按钮提供指针
        //鼠标移进去变色，移出复原
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
