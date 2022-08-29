package UIviewer.QQ;

import java.awt.*;
import javax.swing.*;

public class friend_list extends JPanel{

    public JPanel roll_panel=new JPanel();
    private int clickF=0;
    private void update(){//更新UI界面；
        this.updateUI();
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

        setLayout(new BorderLayout());
        setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
        setBackground(new Color(255,255,255));
        //滚动条
        roll_panel.setBackground(new Color(255,255,255));
        roll_panel.setSize((int)(width*width_r),(int)((height-200)*height_r));
        roll_panel.setLayout(new BoxLayout(roll_panel, BoxLayout.Y_AXIS));
        int number_per_page=7;//一页几个好友,即好友条长度
        //好友标签栏
        JLabel friend_label= new tag_slice(width,height/number_per_page,width_r,height_r,"我的好友");
        roll_panel.add(friend_label);
        //好友列表
        JLabel friend1=new friend_slice(width-1,height/number_per_page,width_r,height_r);
        roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
        roll_panel.add(friend1);
        JLabel friend2=new friend_slice(width-1,height/number_per_page,width_r,height_r);
        roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
        roll_panel.add(friend2);
        JLabel friend3=new friend_slice(width-1,height/number_per_page,width_r,height_r);
        roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
        roll_panel.add(friend3);
       JLabel friend4=new friend_slice(width-1,height/number_per_page,width_r,height_r);
       roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
       roll_panel.add(friend4);
       JLabel friend5=new friend_slice(width-1,height/number_per_page,width_r,height_r);
       roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
       roll_panel.add(friend5);
       JLabel friend6=new friend_slice(width-1,height/number_per_page,width_r,height_r);
       roll_panel.add(Box.createVerticalStrut((int)(10*width_r)));
       roll_panel.add(friend6);

        //好友
        friend_label.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent e) {
               clickF+=1;
               if(clickF%2==1){
                   friend1.setVisible(false);
                   friend2.setVisible(false);
                   friend3.setVisible(false);
//                   jLabel12.setVisible(false);
//                   jLabel.setIcon(new ImageIcon("src/image/student_manage_logo.png"));
                   update();
               }else{
                   friend1.setVisible(true);
                   friend2.setVisible(true);
                   friend3.setVisible(true);
//                   jLabel12.setVisible(true);
//                   jLabel.setIcon(new ImageIcon("src/image/student_manage_logo.png"));
                   update();
               }
           }
        });
        JScrollPane scrollPane=new JScrollPane(roll_panel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );//不显示水平滚动条；
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(244,244,244)));
        add(scrollPane, BorderLayout.CENTER);

   }
}
