package UIviewer.QQ;

import ClientToServer.ClientToServer;
import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;
import ClientToServer.myInfo;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static UIviewer.QQ.chat_panel.send_button_height;
import static UIviewer.QQ.chat_panel.send_button_width;

/**
 * 朋友片
 *
 * @author Zhangyang_Ge
 * @date 2022/09/03
 */
public class friend_slice extends JLabel {
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
    /**
     * 更新
     */
    private void update(){//更新UI界面；
        this.updateUI();
    }
    private double width_r;
    private double height_r;

    /**
     * 交流输入
     *
     * @param jLabel j标签
     */
    private void exchangeEnter(JLabel jLabel) {
        if(functionChoose.color_switch){
            jLabel.setBackground(new Color(145,202,211));
        }else{
            jLabel.setBackground(new Color(22,32,45));
        }
        update();
    }

    /**
     * 交易所退出
     *
     * @param jLabel j标签
     */
    private void exchangeExited(JLabel jLabel) {
        if(functionChoose.color_switch){
            jLabel.setBackground(new Color(125,182,191));
        }else{
            jLabel.setBackground(new Color(42,52,65));
        }
        update();
    }

    Friend friend;

    /**
     * 得到朋友
     *
     * @return {@link Friend}
     */
    public Friend getFriend(){
        return this.friend;
    }

    //朋友名片
    public friend_slice( int width, int height, double width_r, double height_r, Friend friend) {
        this.friend = friend;
        this.width_r = width_r;
        this.height_r = height_r;
        setOpaque(true);
        if(functionChoose.color_switch){
            setBackground(new Color(125,182,191));
        }else{
            setBackground(new Color(42,52,65));
        }
        setBorder(null);
        int icon1_width = (int) ((height - 2 * 20) * height_r);
        FileOutputStream fileOutputStream = null;
        if (friend.image != null) {
            try {
                fileOutputStream = new FileOutputStream("src/image/QQ/" + friend.getId() + ".jpg");
                fileOutputStream.write(friend.image);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                Thumbnails.of(new File("src/image/QQ/"+friend.getId()+".jpg"))
                        .size((int)(icon1_width*width_r), (int)(icon1_width*width_r))
                        .toFile(new File("src/image/QQ/"+friend.getId()+"_min.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            setIcon(new ImageIcon("src/image/QQ/" + friend.getId() + "_min.jpg"));
            if(functionChoose.color_switch){
                setBackground(new Color(125,182,191));
            }else{
                setBackground(new Color(42,52,65));
            }
            //弹出式菜单
            JPopupMenu jpopupmenu1 = new JPopupMenu();   //弹出式菜单
            JMenuItem jmenuitem1 = new JMenuItem("修改备注与分组");  //菜单项
            jmenuitem1.setFont(new Font("微软雅黑", Font.BOLD, 14));
            jmenuitem1.setBackground(color10);
            jmenuitem1.setForeground(Color.white);
            jmenuitem1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    change_panel.change_panel(friend);
                }
            });
            jpopupmenu1.add(jmenuitem1);

            //鼠标移进去变色，移出复原，右键菜单修改备注与分组
            JLabel jLabel = this;//提供指针
            jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int c = e.getButton();
                    if (c == MouseEvent.BUTTON1) {
                        if(getForeground()==Color.red){
                            setForeground(Color.black);
                        }
                        //聊天面板
                        try {
                            Client_qicq.get_message(friend.getId());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        if (main_panel.cpn != null) {
                            main_panel.mjp.remove(main_panel.cpn);
                        }
                        chat_panel chatPanel = new chat_panel(1920 / 3 * 2, 1080, width_r, height_r, 1920 / 3, 0, friend);
                        main_panel.mjp.add(chatPanel);
                        main_panel.cpn = chatPanel;
                        main_panel.mjp.updateUI();
                    } else if (c == MouseEvent.BUTTON3) {
                        JPopupMenu jpopupmenu2 = jpopupmenu1;
                        jpopupmenu2.show(e.getComponent(), e.getX(), e.getY());
                    }
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
        else {
            try {
                Thumbnails.of(new File("src/image/QQ/manager_logo.png"))
                        .size((int) (icon1_width * width_r), (int) (icon1_width * width_r))
                        .toFile(new File("src/image/QQ/manager_logo_min.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            setIcon(new ImageIcon("src/image/QQ/manager_logo_min.png"));
            JLabel jLabel = this;//提供指针
            if(functionChoose.color_switch){
                setBackground(new Color(125,182,191));
            }else{
                setBackground(new Color(42,52,65));
            }
            jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int c = e.getButton();
                    if (c == MouseEvent.BUTTON1) {
                        //聊天面板
                        if (main_panel.cpn != null) {
                            main_panel.mjp.remove(main_panel.cpn);
                        }
                        chat_panel chatPanel = new chat_panel(1920 / 3 * 2, 1080, width_r, height_r, 1920 / 3, 0, friend);
                        Client_qicq.get_announcement();
                        main_panel.mjp.add(chatPanel);
                        main_panel.cpn = chatPanel;
                        if((myInfo.getType()!=3)){
                            main_panel.cpn.send_button.setVisible(false);
                            main_panel.cpn.send_file_button.setVisible(false);
                            main_panel.cpn.receive_button.setVisible(false);
                            main_panel.cpn.set_Close();
                            main_panel.cpn.type_field.setEditable(false);
                            //main_panel.cpn.close_button.setLocation((int)((width-send_button_width-1)*width_r),(int)((height/4-send_button_height-30)*height_r));
                        }
                        main_panel.mjp.updateUI();
                    }
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
       // System.out.println("shit5");
        if ((friend.getOnline() == 1) || (myInfo.getType()==3)) {
            setText(friend.getName() + "                                                 ");
            setForeground(Color.black);
        }
        else {
            setText(friend.getName() + "[离线请留言]                                             ");
            setForeground(new Color(138, 138, 138));
        }
        setFont(new Font("宋体", Font.BOLD, (int) (25 * width_r)));
        setHorizontalTextPosition(JLabel.RIGHT);

        main_panel.color_choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean color=!functionChoose.color_switch;
                if(color){
                    setBackground(new Color(125,182,191));
                }else{
                    setBackground(new Color(42,52,65));
                }
            }
        });
    }

    /**
     * setunread
     *
     * @param sender 发送方
     */
    public void setunread(String sender) {
        if((main_panel.cpn!=null)&&(main_panel.cpn.isVisible())&&( main_panel.cpn.getFriend().getId().equals(sender))){
            try {
                Client_qicq.get_message(sender);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else{
            setForeground(Color.red);
            update();
        }
    }
}
