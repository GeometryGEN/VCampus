package UIviewer.QQ;

import ClientToServer.ClientToServer;
import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;
import UIhandler.StatusManagement.Client_status;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.RoundJButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class friend_list{
    public static JPanel jPanel;
    public static JPanel roll_panel;
    private static int width;

    static int number_per_page=7;//一页几个好友,即好友条长度
    private static int height;
    private static double width_r;
    private static double height_r;
    static int count_friend,count_tag;
    static tag_slice[] tag=new tag_slice[10];//标签
    static int[] friend_start_tag=new int[10];//每个标签好友开始数
    static int[] friend_end_tag=new int[10];//每个标签好友结束数
    static friend_slice[] friendslice=new friend_slice[50];//好友
    static JScrollPane scrollPane;

    public static void show_Friend(HashMap<String, ArrayList<Friend>> friend) {
        jPanel.removeAll();
        roll_panel=new JPanel();
        roll_panel.setBackground(new Color(255,255,255));
        roll_panel.setSize((int)(width*width_r),(int)((height-200)*height_r));
        roll_panel.setLayout(new BoxLayout(roll_panel, BoxLayout.Y_AXIS));
        scrollPane=new JScrollPane(roll_panel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );//不显示水平滚动条；
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        jPanel.add(scrollPane, BorderLayout.CENTER);
        count_friend=0;
        count_tag=0;

        for(String Tag: friend.keySet()){
            tag[count_tag]=new tag_slice(width_r,height_r,Tag);
            roll_panel.add(tag[count_tag]);
            ArrayList<Friend> arrayList=friend.get(Tag);
            int num=arrayList.size();

            friend_start_tag[count_tag]=count_friend;
            for(int i=0;i<num;i++){
                friendslice[count_friend]=new friend_slice(width-1,height/number_per_page,width_r,height_r,arrayList.get(i));
                roll_panel.add(friendslice[count_friend++]);
            }
            friend_end_tag[count_tag]=count_friend;
            int count1=count_tag;
            tag[count1].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    if(friendslice[friend_start_tag[count1]].isVisible()==true) {
                        for (int i = friend_start_tag[count1]; i < friend_end_tag[count1]; i++) {
                            friendslice[i].setVisible(false);
                        }
                    }
                    else{
                        for (int i = friend_start_tag[count1]; i < friend_end_tag[count1]; i++) {
                            friendslice[i].setVisible(true);
                        }
                    }
                    update();
                }
            });
            count_tag++;
        }
        update();
    }

    public static void update(){//更新UI界面；
        jPanel.updateUI();
    }
    public static void show_unread(String sender){
        for(int i=0;i<count_friend;i++){
            if(friendslice[i].getFriend().getId().equals(sender)){
                friendslice[i].setunread(sender);
            }
        }
    }

   friend_list( int width, int height, double width_r, double height_r, int x, int y){
        jPanel=new JPanel();
        this.width=width;
        this.height=height;
        this.width_r=width_r;
        this.height_r=height_r;
        jPanel.setLayout(new BorderLayout());
        jPanel.setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        jPanel.setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
        jPanel.setBackground(new Color(255,255,255));
   }

}
