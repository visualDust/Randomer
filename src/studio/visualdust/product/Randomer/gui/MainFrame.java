package studio.visualdust.product.Randomer.gui;

import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.resource.Resource;
import studio.visualdust.product.Randomer.structure.*;
import studio.visualdust.product.gztwigets.GButton;
import studio.visualdust.product.gztwigets.GCheckBox;
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
    private static final int DISPLAY_FONTSIZE = 150;
    private File file;
    private Recounter<ListItem> recounter = null;
    public WeighedShuffler<ListItem> shuffler;
    private Vector<ListItem> ListItemVec = new Vector<>();
    private ListItem newListItem = new ListItem("..");
    public AutoNext autoNext = new AutoNext(1000);

    private JFrame me = this;
    public JLabel display = new JLabel("-- --", JLabel.CENTER);

    Resource resource = new Resource();

    private JLabel recounterLabel = new JLabel("----", JLabel.CENTER);
    private JLabel totleLabel = new JLabel("---总数", JLabel.CENTER);
    private JLabel passedLabel = new JLabel("---通过数", JLabel.CENTER);
    private JLabel ratioLabel = new JLabel("---通过率", JLabel.CENTER);
    public GButton refreshButton = new GButton("重载列表");
    public GCheckBox showWeight = new GCheckBox("显示权值", false);
    public GButton sideBar = new GButton("...");
    public JLabel versionLabel = new JLabel(Resource.softName + Resource.version, JLabel.LEFT);
    public JLabel weightDisplay = new JLabel("----", JLabel.CENTER);
    GButton bgButton = new GButton("背景色");
    GButton fgButton = new GButton("文字色");
    public JLabel speedLabel = new JLabel("", JLabel.CENTER);

    private JLabel tipLabel = new JLabel("", JLabel.CENTER);
    JDialog bgChooseDialog;
    JColorChooser bgChooseWind = new JColorChooser();
    JDialog fgChooseDialog;
    JColorChooser fgChooseWind = new JColorChooser();

    public MainFrame(WeighedShuffler<ListItem> shuffler) {
        this.shuffler = shuffler;
        this.setLayout(null);
        this.setUndecorated(false);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - WIDTH / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - HEIGHT / 2);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                new Refresher().start();
            }
        });

        bgButton.SetBackColor(new Color(255, 255, 255));
        bgButton.SetForeColor(new Color(0, 0, 0));
        bgButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                bgChooseDialog = JColorChooser.createDialog(me, "选择一个颜色", false, bgChooseWind, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color color = bgChooseWind.getColor();
                        changeBG(color);
                    }
                }, null);
                bgChooseDialog.setVisible(true);
            }
        });
        bgButton.SetSize(new Dimension(WIDTH / 4, 50));
        bgButton.setLocation(WIDTH, HEIGHT - 77 - 50);
        fgButton.SetBackColor(new Color(0, 0, 0));
        fgButton.SetForeColor(new Color(255, 255, 255));
        fgButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                fgChooseDialog = JColorChooser.createDialog(me, "选择一个颜色", false, fgChooseWind, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Color color = fgChooseWind.getColor();
                        changeFG(color);
                    }
                }, null);
                fgChooseDialog.setVisible(true);
            }
        });
        fgButton.SetSize(new Dimension(WIDTH / 4, 50));
        fgButton.setLocation(WIDTH, HEIGHT - 77 - 50 - 50);
        this.add(fgButton);
        this.add(bgButton);

//        this.setTitle(Resource.softName+Resource.version+" By "+Resource.author);

        display.setLocation(0, 0);
        display.setSize(WIDTH, HEIGHT - 50);
        display.setFont(new Font("微软雅黑", 0, DISPLAY_FONTSIZE));
        display.setForeground(new Color(50, 50, 50));
        this.add(display);

//        GButton exitButton = new GButton("退出");
//        exitButton.SetSize(new Dimension(WIDTH / 2, 50));
//        exitButton.setLocation(0, HEIGHT - 77);
//        exitButton.SetBackColor(new Color(169, 30, 0));
//        exitButton.SetForeColor(new Color(255, 255, 255));
//        exitButton.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                GMessageWindow messageWindow = new GMessageWindow(me, 1, "确定退出吗？");
//                messageWindow.okButton.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mousePressed(MouseEvent e) {
//                        EventRW.Write("User exited");
//                        System.exit(0);
//                    }
//                });
//            }
//        });
//        this.add(exitButton);

        GButton nextButton = new GButton("Next");
        nextButton.SetSize(new Dimension(WIDTH * 4 / 5, 50));
        nextButton.setLocation(WIDTH / 5, HEIGHT - 77);
        nextButton.SetBackColor(new Color(6, 155, 0));
        nextButton.SetForeColor(new Color(255, 255, 255));
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                (new Refresher()).start();
            }
        });
        this.add(nextButton);

        GButton aboutButton = new GButton("About");
        aboutButton.SetSize(new Dimension(WIDTH / 5, 50));
        aboutButton.setLocation(0, HEIGHT - 77);
        aboutButton.SetBackColor(new Color(0, 133, 202));
        aboutButton.SetForeColor(new Color(255, 255, 255));
        aboutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                resource.aboutDialog.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-resource.aboutDialog.getWidth()/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-resource.aboutDialog.getHeight()/2);
                resource.aboutDialog.setVisible(true);
            }
        });
        this.add(aboutButton);

        sideBar.SetSize(new Dimension(20, 100));
        sideBar.setLocation(WIDTH - 25, (HEIGHT - 77 - 50) / 2);
        sideBar.SetText("|");
        sideBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                (new WindWipper(me.getWidth() == WIDTH + WIDTH / 4 ? WIDTH : WIDTH + WIDTH / 4)).start();
            }
        });
        this.add(sideBar);

        versionLabel.setFont(new Font("微软雅黑", 0, 20));
        versionLabel.setForeground(new Color(211, 211, 211));
        versionLabel.setSize(WIDTH, 20);
        versionLabel.setLocation(0, 0);
        this.add(versionLabel);

        weightDisplay.setFont(new Font("微软雅黑", 0, 20));
        weightDisplay.setLocation(WIDTH - 100, 0);
        weightDisplay.setSize(100, 50);
        this.add(weightDisplay);
        weightDisplay.setVisible(false);

        showWeight.setLocation(WIDTH - 300, 0);
        showWeight.SetSize(new Dimension(200, 50));
        showWeight.listenerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                weightDisplay.setVisible(showWeight.IsChosen());
            }
        });
        this.add(showWeight);

        refreshButton.SetSize(new Dimension(WIDTH / 4, 50));
        refreshButton.setLocation(WIDTH, HEIGHT - 77);
        refreshButton.SetBackColor(new Color(222, 171, 0));
        refreshButton.SetForeColor(new Color(255, 255, 255));
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (file.exists()) {
                    RefreshList(file);
                    (new Tipper("列表已刷新", 111, 2000)).start();
                } else {
                    (new Tipper("源文件不存在", 111, 2000)).start();
                }
            }
        });
        this.add(refreshButton);

        speedLabel.setFont(new Font("Stencil", 0, 50));
        speedLabel.setLocation(20, aboutButton.getY() - 120);
        speedLabel.setSize(400, 100);
        this.add(speedLabel);

        tipLabel.setFont(new Font("微软雅黑", 0, 20));
        tipLabel.setForeground(new Color(111, 111, 111));
        tipLabel.setLocation(WIDTH, HEIGHT - 77);
        tipLabel.setSize(new Dimension(WIDTH / 4, 50));
        this.add(tipLabel);

        GButton recounterButton = new GButton("新建/重置唱票基");
        recounterButton.setLocation(WIDTH, 0);
        recounterButton.SetSize(new Dimension(WIDTH / 4, 50));
        this.add(recounterButton);

        recounterLabel.setFont(new Font("微软雅黑", 0, 40));
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

        totleLabel.setFont(new Font("微软雅黑", 0, 20));
        totleLabel.setLocation(WIDTH, 210);
        totleLabel.setSize(WIDTH / 4, 30);
        totleLabel.setVisible(false);
        this.add(totleLabel);

        passedLabel.setFont(new Font("微软雅黑", 0, 20));
        passedLabel.setLocation(WIDTH, 240);
        passedLabel.setSize(WIDTH / 4, 30);
        passedLabel.setVisible(false);
        this.add(passedLabel);

        ratioLabel.setFont(new Font("微软雅黑", 0, 20));
        ratioLabel.setLocation(WIDTH, 270);
        ratioLabel.setSize(WIDTH / 4, 30);
        ratioLabel.setVisible(false);
        this.add(ratioLabel);

        trueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
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
            public void mousePressed(MouseEvent e) {
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
            public void mousePressed(MouseEvent e) {
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
        new ClickCounter(this, nextButton);
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
                int fontSize = DISPLAY_FONTSIZE;
                for (int i = 0; i < shuffler.getList().size(); i++) {
                    if (i >= 20) break;
                    display.setText(shuffler.getList().get(i).getName());
                    display.setFont(new Font("微软雅黑", 0, fontSize + i));
                    sleep(10);
                }
            } catch (Exception e1) {
                EventRW.Write(e1);
            }
            ListItem item = MainFrame.this.shuffler.next();
            weightDisplay.setText(String.valueOf(item.getWeight()));
            display.setText(item.getName());
            try {
                int fontSize = DISPLAY_FONTSIZE;
                for (int i = 0; i <= 20; i++) {
                    sleep(2);
                    display.setFont(new Font("微软雅黑", 0, fontSize - i));
                }
            } catch (Exception e) {
                EventRW.Write(e);
            }
            EventRW.Write("New random created : " + item.getName());
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

    public class timer extends Thread {
        @Override
        public void run() {

        }
    }

    public class AutoNext extends Thread {
        int ms;

        public AutoNext(int ms) {
            this.ms = ms;
        }

        @Override
        public void run() {
            for (; ; ) {
                shuffler.next();
                try {
                    sleep(ms);
                } catch (Exception e) {
                    EventRW.Write(e);
                }
            }
        }
    }

    public void changeBG(Color color) {
        new BGSlapper(color);
        me.getContentPane().setBackground(color);
        bgButton.SetBackColor(color);
        fgButton.SetForeColor(color);
        showWeight.SetBackColor(color);
    }

    public void changeFG(Color color) {
        new FGSlapper(color);
        display.setForeground(color);
        fgButton.SetBackColor(color);
        bgButton.SetForeColor(color);
        weightDisplay.setForeground(color);
        showWeight.SetForeColor(color);
        speedLabel.setForeground(color);
        versionLabel.setForeground(color);
    }

    public class BGSlapper extends Thread {
        Color color;
        Color ori;

        public BGSlapper(Color color) {
            ori = me.getContentPane().getBackground();
            this.color = color;
            start();
        }

        @Override
        public void run() {
            try {
                me.getContentPane().setBackground(color);
                bgButton.SetBackColor(color);
                fgButton.SetForeColor(color);
                showWeight.SetBackColor(color);
                speedLabel.setBackground(color);
                sleep(50);
                me.getContentPane().setBackground(ori);
                bgButton.SetBackColor(ori);
                fgButton.SetForeColor(ori);
                showWeight.SetBackColor(ori);
                speedLabel.setBackground(ori);
                sleep(50);
                me.getContentPane().setBackground(color);
                bgButton.SetBackColor(color);
                fgButton.SetForeColor(color);
                showWeight.SetBackColor(color);
                speedLabel.setBackground(color);
                sleep(50);
                me.getContentPane().setBackground(ori);
                bgButton.SetBackColor(ori);
                fgButton.SetForeColor(ori);
                showWeight.SetBackColor(ori);
                speedLabel.setBackground(ori);
                sleep(50);
                me.getContentPane().setBackground(color);
                bgButton.SetBackColor(color);
                fgButton.SetForeColor(color);
                showWeight.SetBackColor(color);
                speedLabel.setBackground(color);
            } catch (Exception e) {
                EventRW.Write(e);
            }
        }
    }

    public class FGSlapper extends Thread {
        Color color;
        Color ori;

        public FGSlapper(Color color) {
            this.color = color;
            ori = display.getForeground();
            start();
        }

        @Override
        public void run() {
            try {
                display.setForeground(color);
                fgButton.SetBackColor(color);
                bgButton.SetForeColor(color);
                weightDisplay.setForeground(color);
                showWeight.SetForeColor(color);
                sleep(50);
                display.setForeground(ori);
                fgButton.SetBackColor(ori);
                bgButton.SetForeColor(ori);
                weightDisplay.setForeground(ori);
                showWeight.SetForeColor(ori);
                sleep(50);
                display.setForeground(color);
                fgButton.SetBackColor(color);
                bgButton.SetForeColor(color);
                weightDisplay.setForeground(color);
                showWeight.SetForeColor(color);
                sleep(50);
                display.setForeground(ori);
                fgButton.SetBackColor(ori);
                bgButton.SetForeColor(ori);
                weightDisplay.setForeground(ori);
                showWeight.SetForeColor(ori);
                sleep(50);
                display.setForeground(color);
                fgButton.SetBackColor(color);
                bgButton.SetForeColor(color);
                weightDisplay.setForeground(color);
                showWeight.SetForeColor(color);
            } catch (Exception e) {
                EventRW.Write(e);
            }
        }
    }

    public class achiRotate extends Thread {
        int size;
        String string;

        public achiRotate(String string, int size) {
            this.string = string;
            this.size = size;
            start();
        }

        @Override
        public void run() {
            speedLabel.setText(string);
            speedLabel.setFont(new Font("Stencil", 0, 50 + size));
            for (int i = 50 + size; i >= 50; i--) {
                try {
                    sleep(1);
                } catch (Exception e) {
                    EventRW.Write(e);
                }
                speedLabel.setFont(new Font("Stencil", 0, i));
            }
        }
    }

    public void refresh() {
        (new Refresher()).start();
    }

    public void achiRotater(String string, int size) {
        new achiRotate(string, size);
    }

    public void shufflerRusher(int times) {
        for (int i = 0; i < times; i++)
            shuffler.next();
    }
}
