package UIviewer.status_manage;

import javax.swing.*;
import java.awt.*;


public class student_status_table extends JFrame{
    private JPanel sstable;
    private JTextField 一卡通号TextField;
    private JTextField a213201939TextField;
    private JTextField 姓名TextField;
    private JTextField 葛张样TextField;

    private void setmargin(JTextField t){
        Insets x =new Insets(0,0,0,0);
        t.setMargin(x);
    }
    public student_status_table(){
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("student_status_table");
        JFrame jf= new student_status_table();
        frame.setContentPane(((student_status_table) jf).sstable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
