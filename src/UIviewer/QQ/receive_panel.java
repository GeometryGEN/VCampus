package UIviewer.QQ;

import DAO.QICQ.Filetrans;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import java.awt.LayoutManager;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class receive_panel {
    static File file;
    public static void main(String[] args) {

        //createWindow();

    }
    static ArrayList<Filetrans>files;
    public static void createWindow(ArrayList<Filetrans> f) {
        JFrame frame;
        frame = new JFrame("接收文件");
        files=f;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);

        frame.setSize(360, 120);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    private static void createUI(final JFrame frame) {

        JPanel panel = new JPanel();
        JPanel panel1=new JPanel();

        LayoutManager layout = new FlowLayout();

        panel.setLayout(layout);
        panel1.setLayout(layout);
        JButton button = new JButton("浏览本地文件目录");
        JButton button1=new JButton("接收");

        JButton button2=new JButton("取消");

        final JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                int option = fileChooser.showOpenDialog(frame);

                if (option == JFileChooser.APPROVE_OPTION) {

                    file = fileChooser.getSelectedFile();

                    label.setText("选择文件或目录: " + file.getName());

                } else {

                    label.setText("打开命令取消");

                }

            }

        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(label.getText().equals("打开命令取消")){
                    JOptionPane.showMessageDialog(null, "请选择文件！", "WARNING!", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    for(int i=0;i<files.size();i++){
                        try {
                            chat_panel.receive_file(files.get(i),file.getAbsolutePath()+"\\"+files.get(i).getName());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    frame.dispose();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(button);

        panel.add(label);
        panel1.add(button1);
        panel1.add(button2);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.getContentPane().add(panel1,BorderLayout.SOUTH);

    }

}