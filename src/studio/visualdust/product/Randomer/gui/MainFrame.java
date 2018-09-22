package studio.visualdust.product.Randomer.gui;

import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.resource.Resource;
import studio.visualdust.product.Randomer.structure.LinedFile;
import studio.visualdust.product.Randomer.structure.ListItem;
import studio.visualdust.product.Randomer.structure.Shuffler;
import studio.visualdust.product.Randomer.structure.WeighedShuffler;
import studio.visualdust.product.gztwigets.GButton;
import studio.visualdust.product.gztwigets.GMessageWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    static int WIDTH = 900;
    static int HEIGHT = 576;
    File file;

    JFrame me = this;

    WeighedShuffler<ListItem> shuffler;
    JLabel display = new JLabel("-- --", JLabel.CENTER);
    GButton nextButton = new GButton("下一个");
    GButton exitButton = new GButton("退出");
    GButton refreshButton = new GButton("重载列表");

    public MainFrame(WeighedShuffler<ListItem> shuffler) {
        this.shuffler = shuffler;
        this.setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WIDTH / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - HEIGHT / 2);

        display.setLocation(0, 0);
        display.setSize(WIDTH, HEIGHT - 50);
        display.setFont(new Font("等线", 0, 150));
        this.add(display);

        exitButton.SetSize(new Dimension(WIDTH / 3, 50));
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

        refreshButton.SetSize(new Dimension(WIDTH / 3, 50));
        refreshButton.setLocation(WIDTH / 3, HEIGHT - 50);
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RefreshList(file);
            }
        });
        this.add(refreshButton);

        nextButton.SetSize(new Dimension(WIDTH / 3, 50));
        nextButton.setLocation(refreshButton.getLocation().x + WIDTH / 3, HEIGHT - 50);
        nextButton.SetBackColor(new Color(6, 155, 0));
        nextButton.SetForeColor(new Color(255, 255, 255));
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                (new Refresher()).start();
            }
        });
        this.add(nextButton);

        JLabel versionLabel = new JLabel(Resource.softName + Resource.version + " By " + Resource.author, JLabel.LEFT);
        versionLabel.setFont(new Font("等线", 0, 20));
        versionLabel.setForeground(new Color(222, 222, 222));
        versionLabel.setSize(WIDTH, 20);
        versionLabel.setLocation(0, 0);
        this.add(versionLabel);
    }

    public WeighedShuffler<ListItem> getShuffler() {
        return shuffler;
    }

    public void setShuffler(WeighedShuffler<ListItem> shuffler) {
        this.shuffler = shuffler;
    }

    class Refresher extends Thread {
        String[] strings = new String[10];

        @Override
        public void run() {
            try {
                for (int i = 0; i < shuffler.getList().size(); i++) {
                    if (i >= 15) break;
                    display.setText(shuffler.getList().get(i).getName());
                    sleep(10);
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

    public void RefreshList(File f) {
        this.file = f;
        ArrayList<ListItem> collection = new ArrayList<>();
        if (!f.isFile() || !f.exists()) {
            EventRW.Write(new Exception("Studio.VisualDust.Product.Exception.FileNotEnabledException"));
            System.exit(255);
        }
        LinedFile linedFile = new LinedFile(f);
        final int len = (int) linedFile.getLineCount();
        double[] weights = new double[len];
        for (int i = 0; i < linedFile.getLineCount(); i++) {
            collection.add(new ListItem(linedFile.getLineOn(i).split(",")[0]));
            weights[i] = linedFile.getLineOn(i).split(",").length >= 2 ? Double.valueOf(linedFile.getLineOn(i).split(",")[1]) : 1.0;
        }
        this.setShuffler(new WeighedShuffler<>(collection, weights));
        EventRW.Write("List Refreshed");
    }
}
