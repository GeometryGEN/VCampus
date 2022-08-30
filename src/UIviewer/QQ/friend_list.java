package UIviewer.QQ;

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
import javax.swing.*;

public class friend_list extends JPanel{

    public static JPanel roll_panel/*=new JPanel()*/;
    private static int width;

    static int number_per_page=7;//一页几个好友,即好友条长度
    private static int height;
    private static double width_r;
    private static double height_r;
   // private static int[] clickF=new int[50];
    private static Friend[] friendList= new Friend[50];
    private static String[] tagList= new String[50];
    //private static int count;
    public void update(){//更新UI界面；
        this.updateUI();
    }
    public static void add(String tag, ArrayList<Friend> arrayList){
        tag_slice tag1=new tag_slice(width_r,height_r,tag);
        int num=arrayList.size();
        roll_panel.add(tag1);
        friend_slice[] slice= new friend_slice[10];
        //int count=1;

        for(int i=0;i<num;i++){
           // friendList[count]=arrayList.get(i);
            //tagList[count]=tag;
            //count++;
            slice[i]=new friend_slice(width-1,height/number_per_page,width_r,height_r,arrayList.get(i).getName());
            roll_panel.add(slice[i]);
            roll_panel.updateUI();
        }
        tag1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if(slice[0].isVisible()==true) {
                    for (int i = 0; i < num; i++) {
                        slice[i].setVisible(false);
                        roll_panel.updateUI();
                    }
                }
                else{
                    for (int i = 0; i < num; i++) {
                        slice[i].setVisible(true);
                        roll_panel.updateUI();
                    }
                }
            }
        });

    }

   friend_list(/*ClientToServer ucs,*/int width, int height,double width_r,double height_r,int x,int y){
        roll_panel=new JPanel();
        this.width=width;
        this.height=height;
        this.width_r=width_r;
        this.height_r=height_r;
        setLayout(new BorderLayout());
        setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
        setBackground(new Color(255,255,255));
        //滚动条
        roll_panel.setBackground(new Color(255,255,255));
        roll_panel.setSize((int)(width*width_r),(int)((height-200)*height_r));
        roll_panel.setLayout(new BoxLayout(roll_panel, BoxLayout.Y_AXIS));
       try {
           Client_qicq.Require_friend_list();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       JScrollPane scrollPane=new JScrollPane(roll_panel);
       scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );//不显示水平滚动条；
       scrollPane.setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
       add(scrollPane, BorderLayout.CENTER);

   }
}
