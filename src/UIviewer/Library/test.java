package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
public class test {
    public static void main(String[] args) {
        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Column 1");
        model.addColumn("Column 2");
        model.addRow(new Object[]{"Row 1", "Value 1"});
        model.addRow(new Object[]{"Row 2", "Value 2"});
        model.addRow(new Object[]{"Row 3", "Value 3"});

        // 创建表格并设置模型
        JTable table = new JTable(model);

        // 创建自定义的表格单元格渲染器
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(Color.RED); // 设置单元格的背景色为红色
        renderer.setHorizontalAlignment(SwingConstants.CENTER); // 设置文本居中对齐

        // 设置第一列的单元格渲染器
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setCellRenderer(renderer);

        // 创建一个包含表格的窗口并显示
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

}
