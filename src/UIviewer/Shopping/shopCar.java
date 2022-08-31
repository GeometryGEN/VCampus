package UIviewer.Shopping;
import DAO.Library.Book_borrower;
import UIhandler.Library.Client_library;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class shopCar extends JPanel {
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;
    public static volatile String[][] myBook;

    public static String[][] getMyBook() {
        return myBook;
    }

    public static void setMyBook(String[][] myBook) {
        shopCar.myBook = myBook;
    }

    public shopCar(){
        setLayout(null);
        String[] tableTitle = {"商品编号","商品名称","商品数量","商品价格","购买数量","购买","删除"};
        //数据
        DefaultTableModel dtm = new DefaultTableModel(myBook, tableTitle);
        JTable table_want = new JTable(dtm){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table_want.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(table_want.getSelectedColumn()==5){
                    //购买功能
                }

                if(table_want.getSelectedColumn()==6){
                    //删除功能
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
        jsp.setBounds(0,0, (int) (1280*width_r), (int) (680*height_r));
        add(jsp);
        table_want.setRowHeight((int) (30*height_r));

        //调整美化
        table_want.setFont(new Font("宋体",Font.BOLD, (int) (16*width_r)));
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    if (column!=4&&column!=5) {
                        setBackground(Color.white);
                    }else {
                        setBackground(new Color(250,128,114,100));
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