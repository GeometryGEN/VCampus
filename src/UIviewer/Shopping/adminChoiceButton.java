package UIviewer.Shopping;
import UIhandler.Shop.Client_shop;
import DAO.Shop.Product;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import static UIviewer.Shopping.shopAdmin.cardLayout;
import static UIviewer.Shopping.shopAdmin.panel;
import ClientToServer.myInfo;
import UIhandler.Library.Client_library;
import UIviewer.login.functionChoose;
import net.coobird.thumbnailator.Thumbnails;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import static UIhandler.Shop.Client_shop.checktypeProduct;
import static UIviewer.login.forgetPWD.forgetPWDUI;

public class adminChoiceButton extends JButton {

    private Color backgroundColor;
    private Color foregroundColor;
    private Font font;
    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int ) screensize.getWidth(); //得到宽度
    int height=(int ) screensize.getHeight();//获得高度
    double width_r=(double)(width)/1273;
    double height_r=(double)(height)/784;

    Color color1=new Color(233,244,255);
    Color color2=new Color(23,58,26);
    Color color3=new Color(57,94,50);
    Color color4=new Color(72,115,78);
    Color color5=new Color(211,229,210);
    Color color6=new Color(72,115,78,20);
    Color color7=new Color(23,58,26,20);
    Font myfont1=new Font("微软雅黑", Font.BOLD, 19);
    Font myfont2=new Font("微软雅黑", Font.BOLD, 20);

    public adminChoiceButton(Boolean choice,int x,int y) {
        this.font = new Font("微软雅黑", Font.BOLD, 24);
        setBounds((int) (x * width_r), (int) (y * height_r), (int) (330 * width_r), (int) (70 * height_r));
        this.backgroundColor = color6;
        this.foregroundColor = Color.WHITE;
        setBorder(BorderFactory.createLineBorder(color6));
        setFocusPainted(false);
        init();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setContentAreaFilled(false);//设置按钮透明
                setBackground(color5);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                setContentAreaFilled(true);//设置按钮透明
                setBackground(color4);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                //setFont(myfont2);
                setBackgroundColor(color2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //setFont(myfont1);
                setBackgroundColor(color4);
            }
        });

    }

    private void init() {
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setFont(font);
    }

    public void setText(String text) {
        super.setText(text);
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        super.setBackground(color);
    }

    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
        super.setForeground(color);
    }

    public void setFont(Font font) {
        this.font = font;
        super.setFont(font);
    }
}
