package UIviewer.Shopping;
import javax.swing.*;
import java.awt.*;

public class AddDel_Lable extends JPanel{
    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(72,115,78,20);
    Color color7=new Color(23,58,26,20);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);

    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    private String text;
    private Font font;
    private Color foreground;
    private Color background;
    private int x;
    private int y;

    public AddDel_Lable(String text, int x, int y) {
        this.text = text;
        this.font = myfont1;
        this.foreground = color2;
        this.background = color5;
        this.x = x;
        this.y = y;
        setSize((int) (250*width_r), (int) (25*height_r));
        setBackground(background);
        setFont(font);
        setForeground(foreground);
        setBounds((int) (x*width_r), (int) (y*height_r), (int) (250*width_r), (int) (25*height_r));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        g2d.setColor(foreground);
        g2d.setBackground(background);
        g2d.drawString(text, x, y);
    }
}
