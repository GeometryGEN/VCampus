package UIviewer.QQ;

import DAO.QICQ.Friend;
import UIhandler.QICQ.Client_qicq;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class friend_list extends JPanel{

    public static JPanel roll_panel=new JPanel();
    private static int width;

    static int number_per_page=7;//一页几个好友,即好友条长度
    private static int height;
    private static double width_r;
    private static double height_r;
   // private static int[] clickF=new int[50];
    private static Friend[] friendList= new Friend[50];
    private static String[] tagList= new String[50];
    private static int count=1;
    private void update(){//更新UI界面；
        this.updateUI();
    }
    public static void add(String tag, ArrayList<Friend> arrayList){
        tag_slice tag1=new tag_slice(width_r,height_r,tag);
        int num=arrayList.size();
        roll_panel.add(tag1);
        friend_slice[] slice= new friend_slice[10];
        for(int i=0;i<num;i++){
            friendList[count]=arrayList.get(i);
            tagList[count]=tag;
            count++;
            slice[i]=new friend_slice(width-1,height/number_per_page,width_r,height_r,arrayList.get(i).getName());
            roll_panel.add(slice[i]);
        }
        int clickF=0;
        tag1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if(slice[0].isVisible()==true) {
                    for (int i = 0; i < num; i++) {
                        slice[i].setVisible(false);
                    }
                }
                else{
                    for (int i = 0; i < num; i++) {
                        slice[i].setVisible(true);
                    }
                }
            }
        });

    }

    private void clickBlack2(JLabel []jb){//点击标签，将后面的标签全部设为不可视；x
        for(int i=1;i<jb.length;i++){
            try{
                jb[i].setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        update();
    }
    private void clickBlack(JLabel []jb){//点击标签，将后面的标签全部设为可视；
        for(int i=1;i<jb.length;i++){
            try{
                jb[i].setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        update();
    }
   friend_list(/*ClientToServer ucs,*/int width, int height,double width_r,double height_r,int x,int y){
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
        //好友列表
//        JLabel friend1=new friend_slice(width-1,height/number_per_page,width_r,height_r);
//        roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
//        roll_panel.add(friend1);
//        JLabel friend2=new friend_slice(width-1,height/number_per_page,width_r,height_r);
//        roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
//        roll_panel.add(friend2);
//        JLabel friend3=new friend_slice(width-1,height/number_per_page,width_r,height_r);
//        roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
//        roll_panel.add(friend3);
//       JLabel friend4=new friend_slice(width-1,height/number_per_page,width_r,height_r);
//       roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
//       roll_panel.add(friend4);
//       JLabel friend5=new friend_slice(width-1,height/number_per_page,width_r,height_r);
//       roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
//       roll_panel.add(friend5);
//       JLabel friend6=new friend_slice(width-1,height/number_per_page,width_r,height_r);
//       roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
//       roll_panel.add(friend6);
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
