package studio.visualdust.product.Randomer.gui;

import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.resource.Resource;
import studio.visualdust.product.Randomer.structure.LinedFile;
import studio.visualdust.product.Randomer.structure.ListItem;
import studio.visualdust.product.Randomer.structure.Recounter;
import studio.visualdust.product.Randomer.structure.WeighedShuffler;
import studio.visualdust.product.gztwigets.GButton;
import studio.visualdust.product.gztwigets.GMessageWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

public class MainFrame extends JFrame {
    private static int WIDTH = 900;
    private static int HEIGHT = 576;
    private File file;
    private Recounter<ListItem> recounter = null;
    private WeighedShuffler<ListItem> shuffler;
    private Vector<ListItem> ListItemVec = new Vector<>();
    private ListItem newListItem = new ListItem("..");

    private JFrame me = this;
    private JLabel display = new JLabel("-- --", JLabel.CENTER);

    private JLabel recounterLabel = new JLabel("----", JLabel.CENTER);
    private JLabel totleLabel = new JLabel("---总数", JLabel.CENTER);
    private JLabel passedLabel = new JLabel("---通过数", JLabel.CENTER);
    private JLabel ratioLabel = new JLabel("---通过率", JLabel.CENTER);
    public GButton refreshButton = new GButton("重载列表");

    private JLabel tipLabel = new JLabel("", JLabel.CENTER);

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
        display.setForeground(new Color(50, 50, 50));
        this.add(display);

        GButton exitButton = new GButton("退出");
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

        GButton nextButton = new GButton("下一个");
        nextButton.SetSize(new Dimension(WIDTH / 2, 50));
        nextButton.setLocation(exitButton.getX() + WIDTH / 2, HEIGHT - 50);
        nextButton.SetBackColor(new Color(6, 155, 0));
        nextButton.SetForeColor(new Color(255, 255, 255));
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                (new Refresher()).start();
            }
        });
        this.add(nextButton);

        GButton moreButton = new GButton("...");
        moreButton.SetSize(new Dimension(20, 100));
        moreButton.setLocation(WIDTH - 20, (HEIGHT - 100 - 50) / 2);
        moreButton.SetText("|");
        moreButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                (new WindWipper(me.getWidth() == WIDTH + WIDTH / 4 ? WIDTH : WIDTH + WIDTH / 4)).start();
            }
        });
        this.add(moreButton);

        JLabel versionLabel = new JLabel(Resource.softName + Resource.version + " By " + Resource.author, JLabel.LEFT);
        versionLabel.setFont(new Font("等线", 0, 20));
        versionLabel.setForeground(new Color(211, 211, 211));
        versionLabel.setSize(WIDTH, 20);
        versionLabel.setLocation(0, 0);
        this.add(versionLabel);

        refreshButton.SetSize(new Dimension(WIDTH / 4, 50));
        refreshButton.setLocation(WIDTH, HEIGHT - 50);
        refreshButton.SetBackColor(new Color(222, 171, 0));
        refreshButton.SetForeColor(new Color(255, 255, 255));
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RefreshList(file);
                (new Tipper("列表已刷新", 111, 2000)).start();
            }
        });
        this.add(refreshButton);

        tipLabel.setFont(new Font("等线", 0, 20));
        tipLabel.setForeground(new Color(111, 111, 111));
        tipLabel.setLocation(WIDTH, HEIGHT - 50);
        tipLabel.setSize(new Dimension(WIDTH / 4, 50));
        this.add(tipLabel);

        GButton recounterButton = new GButton("新建/重置唱票基");
        recounterButton.setLocation(WIDTH, 0);
        recounterButton.SetSize(new Dimension(WIDTH / 4, 50));
        this.add(recounterButton);

        recounterLabel.setFont(new Font("等线", 0, 40));
        recounterLabel.setLocation(WIDTH, 50);
        recounterLabel.setSize(WIDTH / 4, 100);
        recounterLabel.setForeground(new Color(50, 50, 50));
        this.add(recounterLabel);

        GButton trueButton = new GButton("咕");
        trueButton.setLocation(WIDTH + WIDTH / 8, 150);
        trueButton.SetSize(new Dimension(WIDTH / 8, 50));
        trueButton.SetBackColor(new Color(6, 155, 0));
        trueButton.SetForeColor(new Color(255, 255, 255));
        trueButton.setVisible(false);
        this.add(trueButton);

        GButton falseButton = new GButton("蛤");
        falseButton.setLocation(WIDTH, 150);
        falseButton.SetSize(new Dimension(WIDTH / 8, 50));
        falseButton.SetBackColor(new Color(169, 30, 0));
        falseButton.SetForeColor(new Color(255, 255, 255));
        falseButton.setVisible(false);
        this.add(falseButton);

        totleLabel.setFont(new Font("等线", 0, 20));
        totleLabel.setLocation(WIDTH, 210);
        totleLabel.setSize(WIDTH / 4, 30);
        totleLabel.setVisible(false);
        this.add(totleLabel);

        passedLabel.setFont(new Font("等线", 0, 20));
        passedLabel.setLocation(WIDTH, 240);
        passedLabel.setSize(WIDTH / 4, 30);
        passedLabel.setVisible(false);
        this.add(passedLabel);

        ratioLabel.setFont(new Font("等线", 0, 20));
        ratioLabel.setLocation(WIDTH, 270);
        ratioLabel.setSize(WIDTH / 4, 30);
        ratioLabel.setVisible(false);
        this.add(ratioLabel);

        trueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newListItem = recounter.setPass(true);
                if (newListItem == null) {
                    recounterLabel.setText("没有更多");
                    return;
                }
                EventRW.Write("User choosed \'true\' for " + newListItem.getName());
                recounterLabel.setText(newListItem.getName());
                passedLabel.setText(recounter.getPassCount() + " : 通过");
                ratioLabel.setText(Integer.valueOf(recounter.getPassCount() * 100 / recounter.getSize()) + "% : 通过率");
            }
        });

        falseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newListItem = recounter.setPass(false);
                if (newListItem == null) {
                    recounterLabel.setText("没有更多");
                    return;
                }
                EventRW.Write("User choosed \'false\' for " + newListItem.getName());
                recounterLabel.setText(newListItem.getName());
                passedLabel.setText(recounter.getPassCount() + " : 通过");
                ratioLabel.setText(Integer.valueOf(recounter.getPassCount() * 100 / recounter.getSize()) + "% : 通过率");
            }
        });

        recounterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventRW.Write("Inited Recounter , " + ListItemVec.size() + " Items in total");
                setRecounter(new Recounter<>(ListItemVec));
                recounterLabel.setText("----");
                totleLabel.setText(recounter.getSize() + " : 总数");
                trueButton.setVisible(true);
                falseButton.setVisible(true);
                totleLabel.setVisible(true);
                passedLabel.setVisible(true);
                passedLabel.setText("0 : 通过数");
                ratioLabel.setVisible(true);
                ratioLabel.setText("0 : 通过率");
            }
        });
    }

    public WeighedShuffler<ListItem> getShuffler() {
        return shuffler;
    }

    private void setShuffler(WeighedShuffler<ListItem> shuffler) {
        this.shuffler = shuffler;
    }

    private void setRecounter(Recounter<ListItem> recounter) {
        this.recounter = recounter;
    }

    class Tipper extends Thread {

        int colorDeep = 111;
        int remainTime;

        Tipper(String s, int colorDeep, int remainTime) {
            tipLabel.setText(s);
            this.colorDeep = colorDeep;
            this.remainTime = remainTime;
            this.start();
        }

        @Override
        public void run() {
            tipLabel.setVisible(true);
            refreshButton.setVisible(false);
            try {
                for (int i = 255; i >= colorDeep; i--) {
                    tipLabel.setForeground(new Color(i, i, i));
                    sleep(1);
                }
                sleep(remainTime);
                for (int i = colorDeep; i <= 255; i++) {
                    tipLabel.setForeground(new Color(i, i, i));
                    sleep(1);
                }
            } catch (Exception e) {
                EventRW.Write(e);
            }
            refreshButton.setVisible(true);
            tipLabel.setVisible(false);
        }
    }

    class WindWipper extends Thread {
        int width;

        WindWipper(int width) {
            this.width = width;
        }

        @Override
        public void run() {
            int i = width > me.getWidth() ? 1 : -1;
            int step = width - me.getWidth() > 0 ? width - me.getWidth() : me.getWidth() - width;
            int height = me.getHeight();
            int wid = me.getWidth();
            try {
                for (int j = 0; j <= step / 5; j++) {
                    me.setSize(wid + i * j * 5, height);
                    sleep(1);
                }
            } catch (Exception e) {
                EventRW.Write(e);
            }
            me.setSize(i == -1 ? WIDTH : WIDTH + WIDTH / 4, HEIGHT);
        }
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
//            System.gc();
        }
    }

    public void RefreshList(File f) {
        this.file = f;
        ArrayList<ListItem> collection = new ArrayList<>();
        ListItemVec.removeAllElements();
        if (!f.isFile() || !f.exists()) {
            EventRW.Write(new Exception("Studio.VisualDust.Product.Exception.FileNotEnabledException"));
            System.exit(255);
        }
        LinedFile linedFile = new LinedFile(f);
        final int len = (int) linedFile.getLineCount();
        double[] weights = new double[len];
        for (int i = 0; i < linedFile.getLineCount(); i++) {
            ListItem tmp = new ListItem(linedFile.getLineOn(i).split(",")[0]);
            ListItemVec.add(tmp);
            collection.add(tmp);
            weights[i] = linedFile.getLineOn(i).split(",").length >= 2 ? Double.valueOf(linedFile.getLineOn(i).split(",")[1]) : 1.0;
        }
        this.setShuffler(new WeighedShuffler<>(collection, weights));
        this.setRecounter(new Recounter<>(ListItemVec));
        EventRW.Write("List Refreshed");
    }
}
