package UIviewer.Library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class justForTest  {
    //这一块是JFrame北部的部分
    //信息的输入
    JLabel number = new JLabel("班级:");
    JTextField numtext = new JTextField(5);
    JLabel stuid = new JLabel("学号:");
    JTextField stuidtext = new JTextField(5);
    JLabel name = new JLabel("姓名:");
    JTextField nametext = new JTextField(5);
    JLabel phone = new JLabel("电话:");
    JTextField phonetext = new JTextField(11);

    public void puttogether() {
        JFrame jf = new JFrame("表格");
        JPanel jp = new JPanel();
        jp.add(number);
        jp.add(numtext);
        jp.add(stuid);
        jp.add(stuidtext);
        jp.add(name);
        jp.add(nametext);
        jp.add(phone);
        jp.add(phonetext);

        jf.add(jp);

        //这一块是中间的表格
        //列名
        String[] tableTitle = {"班级", "姓名", "学号", "电话"};
        //数据
        String[][] tableDate = {
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
                {"310203", "朱溧3", "2020130403", "18652606256"},
                {"310201", "朱溧1", "2020130401", "18652606256"},
                {"310202", "朱溧2", "2020130402", "18652606256"},
           };


        DefaultTableModel dtm = new DefaultTableModel(tableDate, tableTitle);
        JTable table_want = new JTable(dtm);


        //支持滚动
        JScrollPane jsp = new JScrollPane(table_want);
        jf.add(jsp);

        //这一块是南边的按钮区域




        //避免出现窗口运行后需要拉一下窗口才显示  把JFrame的设置最后放
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setBounds(500, 500, 600, 500);
        jf.setVisible(true);


    }
    //这个方法是用来清除掉输入框里的文本
    void clearthing(){
        numtext.setText("");
        nametext.setText("");
        stuidtext.setText("");
        phonetext.setText("");
    }
    public static void main(String[] args) {
        new justForTest().puttogether();
    }
}