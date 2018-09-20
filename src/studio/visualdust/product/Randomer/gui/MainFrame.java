package studio.visualdust.product.Randomer.gui;

import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.structure.ListItem;
import studio.visualdust.product.Randomer.structure.Shuffler;
import studio.visualdust.product.gztwigets.GButton;
import studio.visualdust.product.gztwigets.GMessageWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    static int WIDTH = 600;
    static int HEIGHT = 400;

    JFrame me = this;

    Shuffler<ListItem> shuffler;
    JLabel display = new JLabel("-- --", JLabel.CENTER);
    GButton nextButton = new GButton("下一个");
    GButton exitButton = new GButton("退出");

    public MainFrame(Shuffler<ListItem> shuffler) {
        this.shuffler = shuffler;
        this.setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WIDTH / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - HEIGHT / 2);

        display.setLocation(0, 0);
        display.setSize(WIDTH, HEIGHT - 50);
        display.setFont(new Font("等线", 0, 100));
        this.add(display);

        exitButton.SetSize(new Dimension(WIDTH / 2, 50));
        exitButton.setLocation(0, HEIGHT - 50);
        exitButton.SetBackColor(new Color(169, 30, 0));
        exitButton.SetForeColor(new Color(255, 255, 255));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GMessageWindow messageWindow = new GMessageWindow(me, 1, "确定退出吗？");
                messageWindow.okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        EventRW.Write("User exited");
                        System.exit(0);
                    }
                });
            }
        });
        this.add(exitButton);

        nextButton.SetSize(new Dimension(WIDTH / 2, 50));
        nextButton.setLocation(WIDTH / 2, HEIGHT - 50);
        nextButton.SetBackColor(new Color(6, 155, 0));
        nextButton.SetForeColor(new Color(255, 255, 255));
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                (new Refresher()).start();
            }
        });
        this.add(nextButton);
    }

    public Shuffler<ListItem> getShuffler() {
        return shuffler;
    }

    public void setShuffler(Shuffler<ListItem> shuffler) {
        this.shuffler = shuffler;
    }

    class Refresher extends Thread {
        String[] strings = new String[10];

        @Override
        public void run() {
            try {
                for (int i = 0; i < 9; i++) {
                    strings[i] = MainFrame.this.shuffler.next().getName();
                }
                for (int i = 0; i < 9; i++) {
                    display.setText(strings[i]);
                    Thread.sleep(10);
                }
            } catch (Exception e1) {
                EventRW.Write(e1);
            }
            String name = MainFrame.this.shuffler.next().getName();
            display.setText(name);
            EventRW.Write("New random created : " + name);
            System.gc();
        }
    }
}
