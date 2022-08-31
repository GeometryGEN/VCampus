package UIviewer.SelectCourse;

import DAO.Library.Book_borrower;
import UIhandler.Currirulum.Client_curriculum;
import UIhandler.Library.Client_library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import static UIviewer.login.forgetPWD.forgetPWDUI;

//可以修改课程的时间、地点、课容量   排课功能
public class Scheduling extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    public static volatile String[][] courses=null;
    public Scheduling() {
        setLayout(null);
        String[] tableTitle = {"课程编号", "课程名", "任课老师", "时间", "课容量", "地点"};
        DefaultTableModel dtm = new DefaultTableModel(courses, tableTitle);
        JTable table_want = new JTable(dtm) {
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        table_want.getColumnModel().getColumn(0).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(60);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(450);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(150);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(120);

        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0, 0, (int)(1280*width_r), (int)(420*height_r));
        add(jsp);
        table_want.setRowHeight(40);
        setVisible(true);


        JButton del_button = new JButton("删除课程");
        del_button.setBounds((int)(350*width_r), (int)(525*height_r), (int)(200*width_r), (int)(40*height_r));
        add(del_button);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 18);
        del_button.setFont(myfont2);
        del_button.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        del_button.setContentAreaFilled(true);//设置按钮透明
        del_button.setVisible(false);
        del_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                try {
                    Client_curriculum.Require_deleteCourse(id);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        table_want.addMouseListener(new MouseListener() {
            int last_clicked_row = -1;
            @Override
            public void mouseClicked(MouseEvent e) {
                if (table_want.getSelectedRow() == last_clicked_row) {
                    last_clicked_row=-1;
                    table_want.clearSelection();
                    del_button.setVisible(false);
                } else {
                    last_clicked_row = table_want.getSelectedRow();
                    del_button.setVisible(true);
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

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        JButton btnNewButton_6 = new JButton("确认修改");
        btnNewButton_6.setBounds((int)(625*width_r), (int)(525*height_r), (int)(200*width_r), (int)(40*height_r));
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        add(btnNewButton_6);
    }
}
