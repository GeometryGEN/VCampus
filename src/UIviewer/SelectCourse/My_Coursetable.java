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
        /*JPanel p11=new JPanel();
        p11.setBounds(0,0,1273,784);*/

        /*JLabel l1 = new JLabel("  你好！");
        l1.setBounds(170, 100, 100, 75);
        Font font = new Font("楷体", Font.BOLD, 22);
        l1.setFont(font);
        //l1.setForeground(new Color(111,222,0));
        add(l1);

        JLabel l4 = new JLabel("      基本信息");
        l4.setBounds(23, 205, 250, 60);
        Font font2 = new Font("楷体", Font.BOLD, 25);
        l4.setFont(font2);
        l4.setForeground(new Color(94, 38, 18));
        add(l4);

        String name = "1";
        JLabel l2 = new JLabel(" 姓名：" + name);
        l2.setBounds(30, 300, 250, 60);
        Font font1 = new Font("微软雅黑", Font.PLAIN, 18);
        l2.setFont(font1);
        l2.setForeground(new Color(0, 0, 0));
        add(l2);
        String card = "";
        JLabel l3 = new JLabel(" 卡号：" + card);
        l3.setBounds(30, 410, 250, 60);
        l3.setFont(font1);
        l3.setForeground(new Color(0, 0, 0));
        add(l3);
*/

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
        /*DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setPreferredSize(new Dimension(0,0));
        table.getTableHeader().setDefaultRenderer(renderer);*/
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



       /* JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 310, 784);
        p1.setBackground(new Color(135, 206, 250, 180));
        add(p1);


        JPanel p3 = new JPanel();
        p3.setBounds(310, 0, 950, 685);
        p3.setBackground(new Color(211, 211, 211, 100));
        add(p3);

        JPanel p2 = new JPanel();
        p2.setBounds(310, 0, 950, 1000);
        p2.setBackground(new Color(245, 245, 245, 180));
        add(p2);*/


        /*String[] tableTitle={"节数","星期一","星期二","星期三","星期四","星期五"};
        DefaultTableModel dtm=new DefaultTableModel(tableDate,tableTitle);
        JTable table_want=new JTable(dtm);
        table_want.setRowHeight(40);
        table_want.setBounds(330,50,920,585);
        table_want.setFont(new Font("黑体",Font.PLAIN,16));*/
        /*table_want.setShowHorizontalLines(true);
        table_want.setShowVerticalLines(true);
        table_want.setIntercellSpacing(new Dimension(0,1));
        table_want.setGridColor(new Color(255,240,245,180));
        table_want.setColumnSelectionAllowed(false);
        table_want.setRowSelectionAllowed(false);*/
        //支持滚动
        /*JScrollPane jsp=new JScrollPane(table_want);
        jsp.setBounds(0,0,1273,790);
        jsp.setBackground(new Color(140,130,205,180));
        add(jsp);
        jsp.setOpaque(false);
        jsp.getViewport().setOpaque(false);
        add(table_want);*/


        /*JLabel l16 = new JLabel();
        ImageIcon icon7 = new ImageIcon("src/image/background2.jpg");
        l16.setIcon(icon7);
        l16.setBounds(0, 0, 1273, 790);
        p11.add(l16);*/


        //setBounds(310,300,375,120);
        /*Object [][]tableData= {
                new Object[]{"第一节", " ", " ", " ", " ", " "},
                new Object[]{"第二节", " ", " ", " ", " ", " "},
                new Object[]{"第三节"," "," "," "," "," "},
                new Object[]{"第四节"," "," "," "," "," "},
                new Object[]{"第五节"," "," "," "," "," "},
                new Object[]{"第六节"," "," "," "," "," "},
                new Object[]{"第七节"," "," "," "," "," "},
                new Object[]{"第八节"," "," "," "," "," "},
                new Object[]{"第九节"," "," "," "," "," "},
                new Object[]{"第十节"," "," "," "," "," "},
                new Object[]{"第十一节"," "," "," "," "," "},
                new Object[]{"第十二节"," "," "," "," "," "},
                new Object[]{"第十三节"," "," "," "," "," "},
        };*/
        /*String[] columnTitle={"节数","星期一","星期二","星期三","星期四","星期五"};
        DefaultTableModel dtm = new DefaultTableModel(tableDate, columnTitle);
        JTable table_want = new JTable(dtm) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.setRowHeight(60);
        Font myfont5 = new Font("宋体", Font.PLAIN, 14);
        table_want.setFont(myfont5);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        jsp.setBackground(new Color(255, 240, 245, 180));
        add(jsp);
        add(table_want);*/


        //add(p11);
    }

}
