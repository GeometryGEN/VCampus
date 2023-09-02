package UIviewer.Library;
import DAO.Library.Punishment;
import UIhandler.Library.Client_library;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;/**
 * 给票
 *
 * @author Liu lewei
 * @date 2023/09/02
 */
public class giveTicket extends JPanel {

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    /**
     * 给票
     */
    public giveTicket(){
        setLayout(null);
        Border blackline=BorderFactory.createLineBorder(Color.black);
        //录入信息
        JLabel l = new JLabel("罚 款 单");
        l.setForeground(new Color(255,255,255));
        l.setBounds((int) (520*width_r), (int) (60*height_r), (int) (290*width_r), (int) (80*height_r));
        Font font = new Font("楷体", Font.BOLD, (int) (45*width_r));
        l.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l);

        JLabel l1 = new JLabel("罚单编号:");
        l1.setBackground(new Color(255,255,255));
        l1.setOpaque(true);
        l1.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        l1.setBounds((int) (640*width_r), (int) (151*height_r), (int) (200*width_r), (int) (50*height_r));
        add(l1);
        JTextField textField1=new JTextField();
        textField1.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        textField1.setBounds((int) (775*width_r), (int) (151*height_r), (int) (200*width_r), (int) (50*height_r));
        add(textField1);
        textField1.setColumns((int) (200*width_r));
        textField1.setBackground(new Color(255,255,255,250));

        JLabel l2 = new JLabel(" 罚款金额");
        l2.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        l2.setBounds((int) (251*width_r), (int) (274*height_r), (int) (165*width_r), (int) (75*height_r));
        add(l2);
        l2.setBorder(blackline);
        l2.setOpaque(true);
        JTextField textField2=new JTextField();
        textField2.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        textField2.setBounds((int) (415*width_r), (int) (274*height_r), (int) (560*width_r), (int) (75*height_r));
        add(textField2);
        textField2.setColumns((int) (530*width_r));
        textField2.setBorder(blackline);

        JLabel l3 = new JLabel("  罚款用户");
        l3.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        l3.setBounds((int) (251*width_r), (int) (200*height_r), (int) (165*width_r), (int) (75*height_r));
        add(l3);
        l3.setBorder(blackline);
        l3.setBackground(new Color(255,255,255));
        l3.setOpaque(true);
        JTextField textField3=new JTextField();
        textField3.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        textField3.setBounds((int) (415*width_r), (int) (200*height_r), (int) (200*width_r), (int) (75*height_r));
        add(textField3);
        textField3.setColumns((int) (200*width_r));
        textField3.setBorder(blackline);

        JLabel l4 = new JLabel(" 书籍编号");
        l4.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        l4.setBounds((int) (615*width_r), (int) (200*height_r), (int) (165*width_r), (int) (75*height_r));
        add(l4);
        l4.setBorder(blackline);
        l4.setBackground(new Color(255,255,255));
        l4.setOpaque(true);
        JTextField textField4=new JTextField();
        textField4.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        textField4.setBounds((int) (775*width_r), (int) (200*height_r), (int) (200*width_r), (int) (75*height_r));
        add(textField4);
        textField4.setColumns((int) (200*width_r));
        textField4.setBorder(blackline);

        JLabel l5 = new JLabel(" 罚款备注");
        l5.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        l5.setBounds((int) (251*width_r), (int) (348*height_r), (int) (165*width_r), (int) (75*height_r));
        add(l5);
        l5.setBorder(blackline);
        l5.setBackground(new Color(255,255,255));
        l5.setOpaque(true);
        JTextField textField5=new JTextField();
        textField5.setFont(new Font("宋体", Font.BOLD, (int) (25*width_r)));
        textField5.setBounds((int) (415*width_r), (int) (348*height_r), (int) (560*width_r), (int) (75*height_r));
        add(textField5);
        textField5.setColumns((int) (530*width_r));
        textField5.setBorder(blackline);

        JButton b1=new JButton("确定提交");
        b1.setForeground(new Color(255,255,255));
        b1.setFont(new Font("楷体", Font.BOLD, (int) (18*width_r)));
        b1.setBounds((int) (575*width_r), (int) (455*height_r), (int) (120*width_r), (int) (50*height_r));
        b1.setBackground(new Color(68,84,105));
        add(b1);
        b1.setFocusPainted(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Punishment p=new Punishment();
                    p.setPunishmentID(textField1.getText());
                    p.setPrice(Double.valueOf(textField2.getText()));
                    p.setCustomer_iD(textField3.getText());
                    p.setBook_id(textField4.getText());
                    p.setNotice(textField5.getText());
                    p.setStatus(0);
                    Client_library.RequireNewPunishment(p);
                    JOptionPane.showMessageDialog(null,"罚单提交成功！");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");

            }
        });
        //中间面板
        JPanel p3 = new JPanel();
        p3.setBounds((int) (200*width_r), 50, (int) (900*width_r), (int) (550*height_r));
        p3.setBackground(new Color(106,113,122,150));
        add(p3);

//        JPanel p12=new JPanel();
//        p12.setBounds((int) (300*width_r),0, (int) (685*width_r), (int) (660*height_r));
//        JLabel pic2 = new JLabel();
//        ImageIcon icon2 = new ImageIcon("src/image/library1_bg.jpg");
//        int icon2_width= 685;
//        int icon2_height=660;
//        try {
//            Thumbnails.of(new File("src/image/library1_bg.jpg"))
//                    .size((int)(icon2_width*width_r), (int)(icon2_height*height_r))
//                    .keepAspectRatio(false)
//                    .toFile(new File("src/image/library1_bg_min.jpg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        pic2.setIcon(new ImageIcon("src/image/library1_bg.jpg"));
//        pic2.setBounds((int) (300*width_r),0 , (int) (685*width_r), (int) (660*height_r));
//        p12.add(pic2);
//        add(p12);

        JPanel p11=new JPanel();
        p11.setBounds(0,0, (int) (1300*width_r), (int) (650*height_r));
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/library1_bg.jpg");
        int icon3_width= 1300;
        int icon3_height=650;
        try {
            Thumbnails.of(new File("src/image/library1_bg.jpg"))
                    .size((int)(icon3_width*width_r), (int)(icon3_height*height_r))
                    .keepAspectRatio(false)
                    .toFile(new File("src/image/library1_bg_min.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pic1.setIcon(new ImageIcon("src/image/library1_bg_min.jpg"));
        pic1.setBounds(0,0 , (int) (1300*width_r), (int) (650*height_r));
        p11.add(pic1);
        add(p11);

    }
}