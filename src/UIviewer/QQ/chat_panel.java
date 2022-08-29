package UIviewer.QQ;

import javax.swing.*;
import java.awt.*;

public class chat_panel extends JPanel {
    private JPanel type_panel;
    private JPanel record_panel;
    public chat_panel(int width,int height,double width_r,double height_r,int x,int y){
        setLayout(null);
        setBounds((int)(x*width_r),(int)(y*height_r),(int)(width*width_r),(int)(height*height_r));
        setBackground(new Color(245,246,247));
        setBorder(BorderFactory.createLineBorder(new Color(234,234,234)));

    }
}
