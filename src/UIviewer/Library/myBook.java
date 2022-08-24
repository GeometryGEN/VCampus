package UIviewer.Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myBook extends JPanel {
    public myBook(){
        setLayout(null);

        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/main5.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);
        add(p11);

        JTable table=null;
        String []index={"封面","书名","作者","出版社","可借/归还日期","馆藏地"};
        Object [][] data=new Object[4][index.length];

        data[0][0]="1";
        data[0][1]="2";
        data[0][2]="3";
        data[0][3]="4";
        data[0][4]="5";
        data[0][5]="6";

        data[0][0]="1";
        data[0][1]="2";
        data[0][2]="3";
        data[0][3]="4";
        data[0][4]="5";
        data[0][5]="6";
    }

}