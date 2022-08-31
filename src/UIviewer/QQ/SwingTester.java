package UIviewer.QQ;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import java.awt.LayoutManager;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JButton;

import javax.swing.JFileChooser;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

public class SwingTester {

    public static void main(String[] args) {

        createWindow();

    }

    private static void createWindow() {

        JFrame frame = new JFrame("Swing选择文件或目录(yiibai.com)");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);

        frame.setSize(560, 200);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    private static void createUI(final JFrame frame) {

        JPanel panel = new JPanel();

        LayoutManager layout = new FlowLayout();

        panel.setLayout(layout);

        JButton button = new JButton("点击这里~");

        final JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                int option = fileChooser.showOpenDialog(frame);

                if (option == JFileChooser.APPROVE_OPTION) {

                    File file = fileChooser.getSelectedFile();

                    label.setText("选择文件或目录: " + file.getName());

                } else {

                    label.setText("打开命令取消");

                }

            }

        });

        panel.add(button);

        panel.add(label);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

    }

}