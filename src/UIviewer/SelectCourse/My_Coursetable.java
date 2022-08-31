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

    public static volatile  String[][][] tableDate=new String[17][13][6];
    TableColumn column;
    public My_Coursetable()
    {
        setLayout(null);

        JTable table;
        JScrollPane scrollPane;
        DefaultTableModel tableModel;
        for (int i=0;i<=16;i++){
            My_Coursetable.tableDate[i][0][0]="第一节";
            My_Coursetable.tableDate[i][1][0]="第二节";
            My_Coursetable.tableDate[i][2][0]="第三节";
            My_Coursetable.tableDate[i][3][0]="第四节";
            My_Coursetable.tableDate[i][4][0]="第五节";
            My_Coursetable.tableDate[i][5][0]="第六节";
            My_Coursetable.tableDate[i][6][0]="第七节";
            My_Coursetable.tableDate[i][7][0]="第八节";
            My_Coursetable.tableDate[i][8][0]="第九节";
            My_Coursetable.tableDate[i][9][0]="第十节";
            My_Coursetable.tableDate[i][10][0]="第十一节";
            My_Coursetable.tableDate[i][11][0]="第十二节";
            My_Coursetable.tableDate[i][12][0]="第十三节";
        }


        String[] columnNames={"节数","星期一","星期二","星期三","星期四","星期五"};

        tableModel=new DefaultTableModel(tableDate[0],columnNames);
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
