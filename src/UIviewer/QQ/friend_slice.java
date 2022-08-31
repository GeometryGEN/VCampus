package UIviewer.QQ;

import ClientToServer.ClientToServer;
import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;
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
    private double width_r;
    private double height_r;
    private void exchangeEnter(JLabel jLabel) {
        jLabel.setBackground(new Color(242,242,242));
        update();
    }

    private void exchangeExited(JLabel jLabel) {
        jLabel.setBackground(new Color(255,255,255));
        update();
    }
    Friend friend;
    public Friend getFriend(){
        return this.friend;
    }
    public friend_slice( int width, int height, double width_r, double height_r, Friend friend){
        this.friend=friend;
        this.width_r=width_r;
        this.height_r=height_r;
        setOpaque(true);
        setBackground(new Color(255,255,255));
        setBorder(null);
        int icon1_width=(int)((height-2*20)*height_r);
        try {
            Thumbnails.of(new File("src/image/QQ/qq_image_3.jpg"))
                    .size((int)(icon1_width*width_r), (int)(icon1_width*width_r))
                    .toFile(new File("src/image/QQ/qq_image_3_min.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setIcon(new ImageIcon("src/image/QQ/qq_image_3_min.png"));
        if(friend.getOnline()==1){
            setText(friend.getName()+"                                                 ");
            setForeground(Color.black);
            //System.out.println("online");
        }
        else{
            setText(friend.getName()+"[离线请留言]                                             ");
            setForeground(new Color(138,138,138));
        }
        setFont(new Font("宋体", Font.BOLD, (int)(25*width_r)));
        setHorizontalTextPosition(JLabel.RIGHT);
        JLabel jLabel=this;//为后续按钮提供指针
        //鼠标移进去变色，移出复原
        jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                //聊天面板
                try {
                    Client_qicq.get_message(friend.getId());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(main_panel.cpn!=null){
                    main_panel.mjp.remove(main_panel.cpn);
                }
                chat_panel chatPanel=new chat_panel(1920/3*2,1080,width_r,height_r,1920/3,0,friend);
                main_panel.mjp.add(chatPanel);
                main_panel.cpn=chatPanel;
                main_panel.mjp.updateUI();
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

    public void setunread(String sender) {
        if((main_panel.cpn!=null)&&( main_panel.cpn.getFriend().getId().equals(sender))){
            try {
                Client_qicq.get_message(sender);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else{
            setForeground(Color.red);
        }
    }
}
