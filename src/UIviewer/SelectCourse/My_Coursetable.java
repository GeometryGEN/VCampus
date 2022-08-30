package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class My_Coursetable extends JPanel{

    public static volatile  String[][] tableDate=null;
    TableColumn column;
    public My_Coursetable()
    {
        setLayout(null);

        JTable table;
        JScrollPane scrollPane;
        DefaultTableModel tableModel;



        String[] columnNames={"节数","星期一","星期二","星期三","星期四","星期五"};
        String [][] tableValues={
                {"第一节"},{"第二节"},{"第三节"},{"第四节"},
                {"第五节"},{"第六节"},{"第七节"},{"第八节"},
                {"第九节"},{"第十节"},{"第十一节"},{"第十二节"},
                {"第十三节"}
        };
        tableModel=new DefaultTableModel(tableValues,columnNames);
        table=new JTable(tableModel);
        //scrollPane.setViewportView(table);
        scrollPane=new JScrollPane(table);

        table.setRowHeight(48);//设置行宽

        //table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        for(int i=0;i<6;i++)
        {
            column=table.getColumnModel().getColumn(i);
            if(i==0)
            {
                column.setPreferredWidth(150);
            }
            else {
                column.setPreferredWidth(200);
            }

        }
        //add(scrollPane,BorderLayout.CENTER);
        scrollPane.setBounds(0,0,1000,1000);
        add(scrollPane);
        setVisible(true);
        //add(table);






    }

}
