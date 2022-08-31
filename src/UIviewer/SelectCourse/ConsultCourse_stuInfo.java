package UIviewer.SelectCourse;
import DAO.Curriculum.Course;
import UIhandler.Currirulum.Client_curriculum;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class ConsultCourse_stuInfo extends JPanel {
    public static volatile String[][] consult_stu=null;

    public ConsultCourse_stuInfo()
    {
        setLayout(null);

        String[] tableTitle={"课程编号","课程名","课程学分","任课老师","查询"};
        DefaultTableModel dtm=new DefaultTableModel(consult_stu,tableTitle);
        JTable table_want=new JTable(dtm);
        JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,220);
        add(jsp);
        table_want.setRowHeight(40);

        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (column!=4) {
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
                if(table_want.getSelectedColumn()==4){
                    Course consult_course=new Course();
                    try{
                        String id=(String)table_want.getValueAt(table_want.getSelectedRow(),0);
                        consult_course.setId(id);
                        Client_curriculum.Require_show_my_students(id);
                    }catch(IOException ex)
                    {
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


        String[] tableTitle2={"学生姓名","一卡通号"};
        DefaultTableModel dtm2=new DefaultTableModel(consult_stu,tableTitle2);
        JTable table_want2=new JTable(dtm2);
        JScrollPane jsp2=new JScrollPane(table_want2);
        jsp2.setBounds(0,260,1280,280);
        add(jsp2);
        table_want2.setRowHeight(70);


    }

}
