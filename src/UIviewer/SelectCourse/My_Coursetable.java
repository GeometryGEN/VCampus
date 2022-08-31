package UIviewer.SelectCourse;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class My_Coursetable extends JPanel{
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/790;
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
                column.setPreferredWidth(85);
            }
            else {
                column.setPreferredWidth(300);
            }

        }
        JComboBox jc=new JComboBox();
        jc.addItem("--请选择--");
        jc.addItem("第一周");
        jc.addItem("第二周");
        jc.addItem("第三周");
        jc.addItem("第四周");
        jc.addItem("第五周");
        jc.addItem("第六周");
        jc.addItem("第七周");
        jc.addItem("第八周");
        jc.addItem("第九周");
        jc.addItem("第十周");
        jc.addItem("第十一周");
        jc.addItem("第十二周");
        jc.addItem("第十三周");
        jc.addItem("第十四周");
        jc.addItem("第十五周");
        jc.addItem("第十六周");
        jc.setBounds((int)(1075*width_r),(int)(75*height_r),(int)(100*width_r),(int)(40*height_r));
        jc.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    //选择的下拉框选项
                    if(e.getItem()=="第一周")
                    {

                    }
                    if(e.getItem()=="第二周")
                    {

                    }
                    if(e.getItem()=="第三周")
                    {

                    }
                    if(e.getItem()=="第四周")
                    {

                    }
                    if(e.getItem()=="第五周")
                    {

                    }
                    if(e.getItem()=="第六周")
                    {

                    }
                    if(e.getItem()=="第七周")
                    {

                    }
                    if(e.getItem()=="第八周")
                    {

                    }
                    if(e.getItem()=="第九周")
                    {

                    }
                    if(e.getItem()=="第十周")
                    {

                    }
                    if(e.getItem()=="第十一周")
                    {

                    }
                    if(e.getItem()=="第十二周")
                    {

                    }
                    if(e.getItem()=="第十三周")
                    {

                    }
                    if(e.getItem()=="第十四周")
                    {

                    }
                    if(e.getItem()=="第十五周")
                    {

                    }
                    if(e.getItem()=="第十六周")
                    {

                    }

                }
            }
        });
        add(jc);

        //add(scrollPane,BorderLayout.CENTER);
        scrollPane.setBounds(0,0,(int)(1000*width_r),(int)(1000*height_r));
        add(scrollPane);
        setVisible(true);
        //add(table);

    }

}
