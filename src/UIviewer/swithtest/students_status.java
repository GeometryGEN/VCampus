package UIviewer.swithtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class students_status extends JFrame {
    private JPanel panel1;
    private JButton jjjButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("students_status");
        frame.setContentPane(new students_status().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public students_status() {
        jjjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();// 返回当前组件树的根组件
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);
                JPanel contentPane= new test().test_panel;
                frame.setContentPane(contentPane);
                frame.setVisible(true);
            }
        });
    }

/*    public static void main(String[] args) {
        JFrame frame = new JFrame("students_status");
        frame.setContentPane(new students_status().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    students_status frame = new students_status();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
}
