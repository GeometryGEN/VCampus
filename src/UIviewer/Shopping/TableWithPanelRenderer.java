package UIviewer.Shopping;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableWithPanelRenderer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Table with Panel Renderer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 创建一个包含自定义渲染器的表格模型
            DefaultTableModel model = new DefaultTableModel(new Object[]{"Column 1", "Column 2"}, 0);
            JTable table = new JTable(model);
            table.setDefaultRenderer(MyPanel.class, new MyPanelRenderer());

            // 添加一些数据到表格
            model.addRow(new Object[]{"Row 1", new MyPanel()});
            model.addRow(new Object[]{"Row 2", new MyPanel()});

            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setVisible(true);
        });
    }

    // 自定义的渲染器，用于在表格的单元格中绘制 MyPanel 对象
    private static class MyPanelRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            MyPanel panel = (MyPanel) value; // 将 value 强制转换为 MyPanel 类型
            return panel; // 返回 MyPanel 对象以在表格中绘制
        }
    }

    // 一个简单的 Panel 类，仅用于演示
    private static class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("This is a custom panel!", 50, 50);
        }
        public MyPanel(){
            setBackground(Color.cyan);
            setBounds(0,0,500,500);
        }
    }
}
