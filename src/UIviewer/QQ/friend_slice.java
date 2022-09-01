package UIviewer.QQ;

import ClientToServer.ClientToServer;
import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;
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
    public friend_slice( int width, int height, double width_r, double height_r, Friend friend) {
        this.friend = friend;
        this.width_r = width_r;
        this.height_r = height_r;
        setOpaque(true);
        setBackground(new Color(255, 255, 255));
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
            //弹出式菜单
            JPopupMenu jpopupmenu1 = new JPopupMenu();   //弹出式菜单
            JMenuItem jmenuitem1 = new JMenuItem("修改备注与分组");  //菜单项
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
                        .toFile(new File("src/image/QQ/manager_logo_min.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            setIcon(new ImageIcon("src/image/QQ/manager_logo_min.jpg"));
            JLabel jLabel = this;//提供指针
            jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int c = e.getButton();
                    if (c == MouseEvent.BUTTON1) {
                        //聊天面板
                        Client_qicq.get_announcement();
                        if (main_panel.cpn != null) {
                            main_panel.mjp.remove(main_panel.cpn);
                        }
                        chat_panel chatPanel = new chat_panel(1920 / 3 * 2, 1080, width_r, height_r, 1920 / 3, 0, friend);
                        main_panel.mjp.add(chatPanel);
                        main_panel.cpn = chatPanel;
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
        if ((friend.getOnline() == 1) || (friend.getName().equals("全体同学"))) {
            setText(friend.getName() + "                                                 ");
            setForeground(Color.black);
            //System.out.println("online");
        }
        else {
            setText(friend.getName() + "[离线请留言]                                             ");
            setForeground(new Color(138, 138, 138));
        }
        setFont(new Font("宋体", Font.BOLD, (int) (25 * width_r)));
        setHorizontalTextPosition(JLabel.RIGHT);
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
