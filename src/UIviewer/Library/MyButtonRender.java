package UIviewer.Library;
import DAO.Library.Book_borrower;
import UIhandler.Library.Client_library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.table.TableCellRenderer;


public class MyButtonRender implements TableCellRenderer {
    private JPanel jPanel;
    private JButton jButton;

    public MyButtonRender(String info) {
        initJPanel();
        initButton(info);
        jPanel.add(jButton);
    }

    private void initButton(String info) {
        jButton = new JButton();
        jButton.setBounds(0, 0, 118, 30);
        jButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Book_borrower book=new Book_borrower();
                        book.setId(info);
                        try {
                            Client_library.reqireReturn(book);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
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
        jButton.setText("归还");
        return jPanel;
    }
}

