package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Robot;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import DAO.Curriculum.Course;
import UIhandler.Currirulum.Client_curriculum;
import java.util.Timer;
public class Choosing_Course extends JPanel {

        public static  volatile String [][] selectcourse=null;
        public Choosing_Course()
        {
        //小头像
            setLayout(null);


        String[] tableTitle={"课程编号","课程名","时间","任课老师","地点","选择"};
        DefaultTableModel dtm=new DefaultTableModel(selectcourse,tableTitle);
        JTable table_want=new JTable(dtm);
                table_want.setFont(new Font("宋体",Font.BOLD,16));

                table_want.getColumnModel().getColumn(0).setPreferredWidth(90);
                table_want.getColumnModel().getColumn(1).setPreferredWidth(180);
                table_want.getColumnModel().getColumn(2).setPreferredWidth(450);
                table_want.getColumnModel().getColumn(3).setPreferredWidth(170);
                table_want.getColumnModel().getColumn(4).setPreferredWidth(150);
                table_want.getColumnModel().getColumn(5).setPreferredWidth(100);

                //支持滚动
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,590);

        add(jsp);

        //调整美化
                try {
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                                @Override
                                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                                        if (column!=5) {
                                                setBackground(Color.white);
                                        }else {
                                                setBackground(new Color(60,179,113));
                                        }
                                        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                                }
                        };

                        for (int i = 0; i < table_want.getColumnCount(); i++)
                        {
                                table_want.getColumn(table_want.getColumnName(i)).setCellRenderer(tcr);
                        }
                } catch (Exception ex) {
                        ex.printStackTrace();
                }

        table_want.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                        if(table_want.getSelectedColumn()==5){
                                Course choose=new Course();
                                try
                                {
                                    String id=(String)table_want.getValueAt(table_want.getSelectedRow(),0);
                                    choose.setId(id);
                                    Client_curriculum.requireToChoose(choose);
                                }catch(IOException ex){
                                        throw new RuntimeException(ex);
                                }


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
        table_want.setRowHeight(50);



    }

}
