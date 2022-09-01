package UIviewer.Shopping;

/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.09.01 13:15]
 */

import java.util.Enumeration;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class JTableImg extends JFrame {

    private JTable table;

    public static void main(String[] args) {
        JTableImg frame = new JTableImg();
        frame.setVisible(true);
    }

    public JTableImg() {
        //绝对路径读取图片
        Icon icon2 = new ImageIcon("E:\\Vcampus\\src\\image\\1.jpg");
        table = new JTable();
        String[] columnNames = new String[] {"头像", "姓名","111","222"};
        //将图片Icon对象放入表格数据数组
        Object[][] data = new Object[][] {
                {icon2, "Text 2","111","222"}
        };
        //将表格数据数组放入表格模型,并重写getColumnClass方法
        table.setModel(new DefaultTableModel(data,columnNames){
            @Override   //核心步骤2：重写getColumnClass方法
            public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
        });
        //设置每一列的列宽
        //table.getColumn(columnNames[0]).setPreferredWidth(59);
        table.setRowHeight(0, 80);
        table.setRowHeight(1, 80);
        table.setRowHeight(2, 80);
        table.setRowHeight(3, 80);
        //fitTableColumns(table); //非必须，设置列宽随表格内容自动调整
        JScrollPane  jsp = new JScrollPane(table);
        jsp.setSize(530, 349);

    }

    //设置列宽随表格内容自动调整   参考博客：https://blog.csdn.net/tototuzuoquan/article/details/8982618
    public void fitTableColumns(JTable myTable) { // 設置table的列寬隨內容調整
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
        Enumeration columns = myTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());

            int width = (int) myTable.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(myTable,column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) myTable.getCellRenderer(row, col)
                        .getTableCellRendererComponent(myTable,myTable.getValueAt(row, col), false, false,row, col)
                        .getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column);
            column.setWidth(width + myTable.getIntercellSpacing().width);
        }

    }

}