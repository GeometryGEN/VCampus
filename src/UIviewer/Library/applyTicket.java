package UIviewer.Library;
import DAO.Library.Book_borrower;
import DAO.Library.Punishment;
import UIhandler.Library.Client_library;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class applyTicket extends JPanel {
    public static volatile String[][] myPunish=null;
    public applyTicket(){
        setLayout(null);
        String[] tableTitle = {"罚单编号","罚单金额","书籍编号","罚单备注","缴费"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(myPunish, tableTitle);
        JTable table_want = new JTable(dtm)
        {
            public boolean isCellEditable(int row, int column) {
                return false;}
        };
        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table_want.getSelectedColumn()==4){
                    Punishment punishment=new Punishment();
                    try {
                        String id= (String) table_want.getValueAt(table_want.getSelectedRow(),0);
                        double p= Double.parseDouble((String)table_want.getValueAt(table_want.getSelectedRow(),1));
                        punishment.setCustomer_iD(Client_library.getId());
                        punishment.setPunishmentID(id);
                        punishment.setPrice(p);
                        System.out.println(id);
                        Client_library.reqirePay(punishment);
                    } catch (IOException ex) {
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
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);


        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/main4.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);
        add(p11);

        //调整美化
        table_want.setFont(new Font("宋体",Font.BOLD,16));
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (column!=4) {
                        setBackground(Color.white);
                    }else {
                        setBackground(new Color(60,179,113));
                        //setForeground(new Color(255,255,255));
                        //setFont(new Font("微软雅黑",Font.BOLD,18));
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
    }

}