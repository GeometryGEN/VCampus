package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applyTicket extends JPanel {
    public static volatile String[][] myPunish;
    public applyTicket(){
        setLayout(null);

        String[] tableTitle = {"罚单编号","罚单金额","书籍编号","罚单备注","缴费"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(myPunish, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);
        table_want.getColumnModel().getColumn(4).setCellRenderer(new MyButtonRender2());

        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/main4.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);
        add(p11);
    }
    public void show_ticket(){
        setLayout(null);

        String[] tableTitle = {"罚单编号","罚单金额","书籍编号","罚单备注","缴费"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(myPunish, tableTitle);
        JTable table_want = new JTable(dtm);
        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jsp.setBounds(0,0,1280,680);
        add(jsp);
        table_want.setRowHeight(30);
        table_want.getColumnModel().getColumn(4).setCellRenderer(new MyButtonRender2());

        JPanel p11=new JPanel();
        p11.setBounds(0,0,1280,650);
        JLabel pic1 = new JLabel();
        ImageIcon icon1 = new ImageIcon("src/image/main4.jpg");
        pic1.setIcon(icon1);
        pic1.setBounds(0,0 , 1300, 650);
        p11.add(pic1);
        add(p11);
    }
}