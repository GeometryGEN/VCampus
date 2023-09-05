package UIviewer.Shopping;
import javax.swing.*;
import java.awt.*;

public class AddDel_TextField extends JTextField{

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(72,115,78,20);
    Color color7=new Color(23,58,26,20);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);

    private Font font;
    private Color foregroundColor;
    private Color backgroundColor;
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;


    public AddDel_TextField(int x,int y) {
        this.font = new Font("微软雅黑", Font.BOLD, 24);
        setBounds((int) (x * width_r), (int) (y * height_r), (int) (330 * width_r), (int) (70 * height_r));
        this.foregroundColor = color6;
        this.backgroundColor = Color.WHITE;
        setBorder(BorderFactory.createLineBorder(color6));
    }

}
