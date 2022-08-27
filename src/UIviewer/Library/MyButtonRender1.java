package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;


public class MyButtonRender1 implements TableCellRenderer {
    private JPanel jPanel;
    private JButton jButton;

    public MyButtonRender1() {
        initJPanel();
        initButton();
        jPanel.add(jButton);
    }

    private void initButton() {
        jButton = new JButton();
        jButton.setBounds(0, 0, 118, 30);
        jButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("" + e.getActionCommand());
                        System.out.println(jButton.getText());
                    }
                });
    }

    private void initJPanel() {
        jPanel = new JPanel();
        jPanel.setLayout(null);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        jButton.setText("续借");
        return jPanel;
    }
}

