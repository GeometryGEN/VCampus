package UIviewer.QQ;

import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class friend_slice extends JLabel {
    private void update(){//更新UI界面；
        this.updateUI();
    }
    private void exchangeEnter(JLabel jLabel) {
        jLabel.setBackground(new Color(242,242,242));
        update();
    }

    private void exchangeExited(JLabel jLabel) {
        jLabel.setBackground(new Color(255,255,255));
        update();
    }

    public friend_slice(int width, int height, double width_r, double height_r,String s){
        setOpaque(true);
        setBackground(new Color(255,255,255));
        int icon1_width=(int)((height-2*20)*height_r);
        try {
            Thumbnails.of(new File("src/image/QQ/qq_image_3.jpg"))
                    .size((int)(icon1_width*width_r), (int)(icon1_width*width_r))
                    .toFile(new File("src/image/QQ/qq_image_3_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setIcon(new ImageIcon("src/image/QQ/qq_image_3_min.png"));
        setText(s+"                                                 ");
        setFont(new Font("宋体", Font.BOLD, (int)(25*width_r)));
        setHorizontalTextPosition(JLabel.RIGHT);
        JLabel jLabel=this;//为后续按钮提供指针
        //鼠标移进去变色，移出复原
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"Hello");

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exchangeEnter(jLabel);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exchangeExited(jLabel);
            }
        });
    }

}
