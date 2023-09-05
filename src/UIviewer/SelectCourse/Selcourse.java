package UIviewer.SelectCourse;
import ClientToServer.myInfo;
import UIhandler.Currirulum.Client_curriculum;
import UIhandler.Library.Client_library;
import UIhandler.QICQ.Client_qicq;
import UIhandler.Shop.Client_shop;
import UIhandler.StatusManagement.Client_status;
import UIviewer.Library.readLib;
import UIviewer.QQ.main_panel;
import UIviewer.Shopping.shopAdmin;
import UIviewer.Shopping.shopCustomer;
import UIviewer.login.functionChoose;
import UIviewer.status_manage.manage_status;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * selcourse
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 */
public class Selcourse extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
    public static CardLayout cardLayout=new CardLayout();
    public static JPanel panel=new JPanel();

    /**
     * selcourse
     */
    public Selcourse()
    {

        //导航条
        JPanel guide=new JPanel();
        //学籍管理
            JButton btnNewButton_11 = new JButton("学籍管理");
            btnNewButton_11.setFocusPainted(false);
            guide.add(btnNewButton_11);
            btnNewButton_11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    functionChoose.jf.remove(panel);
                    if(myInfo.getType()==1) {
                        try {
                            Client_status.stu_enter();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else if(myInfo.getType()==3){
                        try {
                            functionChoose.jf.setContentPane(new manage_status(width,height).manage_panel);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        functionChoose.jf.setTitle("admin_status_management");
                    } else {
                        JOptionPane.showMessageDialog(null,"抱歉，您暂无学籍管理权限！");
                    }
                }
            });
            guide.add(btnNewButton_11);
        //图书管理
        JButton btnNewButton_22 = new JButton("图书管理");
        btnNewButton_22.setFocusPainted(false);
        btnNewButton_22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.remove(panel);
                try {
                    Client_qicq.setId(myInfo.getId());
                    if(myInfo.getType()!=3)
                    {
                        functionChoose.jf.setContentPane(new readLib());
                        functionChoose.jf.setTitle("readLib");
                        functionChoose.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        functionChoose.jf.setVisible(true);
                    }
                    else
                    {
                        //Client_library.RequireshowAllBooks();
                        Client_library.admin_enter();
                        //jf.setContentPane(new adminLib());
                        //jf.setTitle("adminLib");
                        //jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        //jf.setVisible(true);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        guide.add(btnNewButton_22);
        //校园超市
        JButton btnNewButton_33 = new JButton("校园超市");
        btnNewButton_33.setFocusPainted(false);
        btnNewButton_33.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    if(myInfo.getType()!=3)
                    {
                        Client_shop.setId(String.valueOf(myInfo.getType()));
                        Client_shop.setIdcard(myInfo.getId());
                        functionChoose.jf.setContentPane(new shopCustomer());
                        functionChoose.jf.setTitle("shopCustomer");
                    }
                    else
                    {
                        Client_shop.setId(String.valueOf(myInfo.getType()));
                        Client_shop.setIdcard(myInfo.getId());
                        functionChoose.jf.setContentPane(new shopAdmin());
                        functionChoose.jf.setTitle("shopAdmin");
                    }
                    functionChoose.jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    functionChoose.jf.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        guide.add(btnNewButton_33);
        //站内通信
        JButton btnNewButton_55 = new JButton("站内通信");
        btnNewButton_55.setFocusPainted(false);
        btnNewButton_55.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.remove(panel);
                try {
                    Client_qicq.setId(myInfo.getId());
                    if(myInfo.getType()!=3)
                    {
                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType(),true).mjp);
                        functionChoose.jf.setTitle("userqq");
                    }
                    else
                    {
                        functionChoose.jf.setContentPane(new main_panel(width,height,myInfo.getType(),true).mjp);
                        functionChoose.jf.setTitle("adminqq");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        guide.add(btnNewButton_55);
        //敬请期待
        JButton btnNewButton_77 = new JButton("敬请期待");
        btnNewButton_77.setFocusPainted(false);
        btnNewButton_77.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null,"正在开发中，敬请期待！");
            }
        });
        guide.add(btnNewButton_77);
        //导航条
        guide.setBounds(0,0,500,500);
        add(guide);

        setBounds(0,0,width,height);
        setBackground(Color.green);
        setLayout(null);
        panel.setBounds(0,(int)(115*height_r),(int)(1273*width_r),(int)(790*height_r));
        add(panel);
        panel.setLayout(cardLayout);
        ConsultCourse_Info f1=new ConsultCourse_Info();
        panel.add(f1,"f1");
        ConsultCourse_Chosen f2=new ConsultCourse_Chosen();
        panel.add(f2,"f2");
        ChooseCourse_guidance f3=new ChooseCourse_guidance();
        panel.add(f3,"f3");
        Choosing_Course f4=new Choosing_Course();
        panel.add(f4,"f4");
        My_Coursetable f5=new My_Coursetable(1);
        panel.add(f5,"f5");

        //六个按钮
        // 按钮1
        JButton btnNewButton_1 = new JButton("查询课程信息");
        btnNewButton_1.setBounds((int)(95*width_r), (int)(50*height_r), (int)(160*width_r), (int)(50*height_r));
        Font myfont = new Font("微软雅黑 ",Font.BOLD,18);
        btnNewButton_1.setFont(myfont);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBackground(new Color(	220 ,220, 220));
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f1");
            }
        });
        add(btnNewButton_1);


        // 按钮2
        JButton btnNewButton_2 = new JButton("查看已选课程");
        btnNewButton_2.setBounds((int)(275*width_r), (int)(50*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_2.setFont(myfont);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBackground(new Color(	250 ,255, 240));
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_curriculum.RequireMyChoice();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(btnNewButton_2);


        // 按钮3
        JButton btnNewButton_3 = new JButton("选课帮助");
        btnNewButton_3.setBounds((int)(455*width_r), (int)(50*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_3.setFont(myfont);
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.setBackground(new Color(	250 ,240, 230));
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel,"f3");
            }
        });
        add(btnNewButton_3);

        //按钮4
        JButton btnNewButton_4 = new JButton("选课界面");
        btnNewButton_4.setBounds((int)(635*width_r), (int)(50*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_4.setFont(myfont);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setBackground(new Color(	220 ,220, 220));
        btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_curriculum.Require_suitable();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                cardLayout.show(panel,"f4");
            }
        });
        add(btnNewButton_4);

        //按钮5
        JButton btnNewButton_5 = new JButton("我的课表");
        btnNewButton_5.setBounds((int)(815*width_r), (int)(50*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_5.setFont(myfont);
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.setBackground(new Color(	250 ,255, 240));
        btnNewButton_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client_curriculum.RequireSchedule();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(btnNewButton_5);

        //按钮6
        JButton btnNewButton_6 = new JButton("退出");
        btnNewButton_6.setBounds((int)(995*width_r), (int)(50*height_r), (int)(160*width_r), (int)(50*height_r));
        btnNewButton_6.setFont(myfont);
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.setBackground(new Color(	250 ,240, 230));

        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                functionChoose.jf.setContentPane(functionChoose.fc_panel);
                functionChoose.jf.setTitle("functionChoose");
                setVisible(false);
            }
        });
        add(btnNewButton_6);

        //东南大学标志图片
        JLabel l15 = new JLabel();
        try {
            Thumbnails.of(new File("src/image/background2.jpg"))
                    .size((int)(width), (int)(height))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/background2_min.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        l15.setIcon(new ImageIcon("src/image/background2_min.jpg"));
        l15.setBounds(0, 0, width, height);
        l15.setOpaque(true);
        add(l15);
        setVisible(true);
    }
}
