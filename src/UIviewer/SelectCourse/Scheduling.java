package UIviewer.SelectCourse;

import DAO.Curriculum.Course;
import DAO.Library.Book_borrower;
import UIhandler.Currirulum.Client_curriculum;
import UIhandler.Library.Client_library;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import static UIviewer.login.forgetPWD.forgetPWDUI;

/**
 * 调度
 *
 * @author Chen_GuanZhi
 * @date 2022/09/03
 *///可以修改课程的时间、地点、课容量   排课功能
public class Scheduling extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    public static volatile String[][] courses=null;

    /**
     * 调度
     */
    public Scheduling() {
        setLayout(null);
        String[] tableTitle = {"课程编号", "课程名", "任课老师","学时", "时间", "课容量", "地点"};
        DefaultTableModel dtm = new DefaultTableModel(courses, tableTitle);
        JTable table_want = new JTable(dtm) {
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        JTableHeader jTableHeader=table_want.getTableHeader();
        jTableHeader.setFont(new Font("楷体",Font.BOLD,18));
        jTableHeader.setBackground(new Color(68,84,105));
        jTableHeader.setForeground(new Color(255,248,250));
        table_want.setCellSelectionEnabled(true);
        table_want.getColumnModel().getColumn(0).setPreferredWidth(160);
        table_want.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_want.getColumnModel().getColumn(2).setPreferredWidth(60);
        table_want.getColumnModel().getColumn(3).setPreferredWidth(60);
        table_want.getColumnModel().getColumn(4).setPreferredWidth(450);
        table_want.getColumnModel().getColumn(5).setPreferredWidth(60);
        table_want.getColumnModel().getColumn(6).setPreferredWidth(180);

        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0, 0, (int)(1280*width_r), (int)(420*height_r));
        add(jsp);
        table_want.setRowHeight((int)(30*height_r));
        setVisible(true);
        Font myfont1 = new Font("宋体", Font.BOLD, (int) (16*width_r));
        table_want.setFont(myfont1);
        table_want.setBackground(new Color(237,253,254));
        table_want.setOpaque(false);
        setBackground(new Color(237,253,254));

        JButton del_button = new JButton("删除课程");
        del_button.setBounds((int)(520*width_r), (int)(470*height_r), (int)(200*width_r), (int)(40*height_r));
        add(del_button);
        Font myfont2 = new Font("微软雅黑", Font.PLAIN, 18);

        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (row % 2 == 0) {
                        setBackground(new Color(237,253,254));
                    } else {
                        setBackground(new Color(169,189,205));
                    }
                    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                }
            };
            //居中
            tcr.setHorizontalAlignment(JLabel.CENTER);
            table_want.setDefaultRenderer(Object.class, tcr);
            for (int i = 0; i < table_want.getColumnCount(); i++)
            {
                table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
                    Client_curriculum.RequireallCourse();
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
        btnNewButton_6.setBounds((int)(520*width_r), (int)(550*height_r), (int)(200*width_r), (int)(40*height_r));
        btnNewButton_6.setFont(myfont2);
        btnNewButton_6.setBackground(new Color(248, 248, 255));
        //btnNewButton_1.setForeground(new Color(248, 248, 255));
        btnNewButton_6.setContentAreaFilled(true);//设置按钮透明
        add(btnNewButton_6);
        btnNewButton_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    table_want.clearSelection();

                int n=table_want.getRowCount();

                for(int i=0;i<n;i++){
                    Course c=new Course();
                    c.setId((String) table_want.getValueAt(i,0));
                    c.setTimestring((String) table_want.getValueAt(i,4));
                    c.setClassroom((String) table_want.getValueAt(i,6));
                    c.setSize(Integer.valueOf((String) table_want.getValueAt(i,5)));
               //     System.out.println(c.getClassroom());
                    try {
                        Client_curriculum.arrange(c);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            //    System.out.println("ok");
                try {
                    Client_curriculum.RequireallCourse();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
