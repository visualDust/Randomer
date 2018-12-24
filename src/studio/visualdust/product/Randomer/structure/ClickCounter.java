package studio.visualdust.product.Randomer.structure;

import studio.visualdust.product.Randomer.gui.MainFrame;
import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.gztwigets.GButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ClickCounter {
    Reducer reducer = new Reducer();
    int count = 0,
            now = 0,
            highest = 0;
    Point oriDisplayDim,
            oriVerLabelDim,
            oriCheckboxDim,
            oriWeightDisplayDim,
            oriSideBarDim,
            oriFrameDim;
    Color oriFG,
            oriBG;
    WeighedShuffler<ListItem> oriShuffler;
    Vector<Achievement> achi = new Vector<>();
    String oriDisplay = "----",
            oriVersion = "----";
    MainFrame frame;

    public ClickCounter(MainFrame frame, GButton button) {
        this.frame = frame;
        oriDisplayDim = frame.display.getLocation();
        oriVerLabelDim = frame.versionLabel.getLocation();
        oriCheckboxDim = frame.showWeight.getLocation();
        oriWeightDisplayDim = frame.weightDisplay.getLocation();
        oriSideBarDim = frame.sideBar.getLocation();
        oriVersion = frame.versionLabel.getText();
        achi.add(new Achievement("Slap", "More than 3 clicks per second", 3, new Color(49, 196, 0), Color.WHITE, 30));
        achi.add(new Achievement("Fast", "More than 4 clicks per second", 4, new Color(0, 204, 181), Color.WHITE, 32));
        achi.add(new Achievement("Arts", "More than 5 clicks per second", 5, new Color(0, 160, 203), Color.WHITE, 34));
        achi.add(new Achievement("Super", "More than 6 clicks per second", 6, new Color(0, 119, 255), Color.WHITE, 36));
        achi.add(new Achievement("Boost", "More than 7 clicks per second", 7, new Color(145, 0, 255), Color.WHITE, 38));
        achi.add(new Achievement("Berserk", "More than 8 clicks per second", 8, new Color(201, 0, 209), Color.WHITE, 40));
        achi.add(new Achievement("Desaster", "More than 9 clicks per second", 9, new Color(201, 149, 0), Color.WHITE, 42));
        achi.add(new Achievement("AppKiller", "More than 10 clicks per second", 10, new Color(224, 108, 0), Color.WHITE, 44));
        achi.add(new Achievement("Unbelievable", "More than 11 clicks per second", 11, new Color(255, 6, 0), Color.WHITE, 46));
        achi.add(new Achievement("Supreme", "More than 12 clicks per second", 12, new Color(5, 0, 161), Color.WHITE, 48));
        achi.add(new Achievement("GodKnows", "More than 13 clicks per second", 13, new Color(12, 0, 122), Color.WHITE, 50));
        achi.add(new Achievement("Death", "More than 14 clicks per second", 14, new Color(10, 10, 10), Color.WHITE, 52));
        achi.add(new Achievement("Debug", "ForDebug", 9999, Color.GRAY, Color.WHITE, 0));
        reducer.start();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (now == 0) {
                    oriBG = frame.getContentPane().getBackground();
                    oriFG = frame.display.getForeground();
                    oriShuffler = frame.shuffler;
                    oriFrameDim = frame.getLocation();
                }
                count++;
                reducer.add();
//                if (count > 2)
//                    frame.speedLabel.setText(achi.elementAt(now).getName() + "!" + String.valueOf(count));
                if (count > achi.elementAt(now).getCount()) {
//                    System.out.println(count);
//                    System.out.println(achi.elementAt(now).getCount());
                    frame.changeBG(achi.elementAt(now).getBg());
                    frame.changeFG(achi.elementAt(now).getFg());

                    if (highest < now) {
                        highest = now;
                        //change the display of Achievement here
                    }
                    frame.versionLabel.setText(achi.elementAt(now).getDescription());
                    frame.achiRotater(achi.elementAt(now).getName() + "!", achi.elementAt(now).getShift());
                    now++;
                    if (highest < now) highest = now;
                }
            }
        });
    }

    public class Reducer extends Thread {

        public Reducer() {
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    sleep(10);
                } catch (Exception e) {
                    EventRW.Write(e);
                }
                while (count <= 2) {
                    try {
                        sleep(10);
                    } catch (Exception e) {
                        EventRW.Write(e);
                    }
                }
                while (count > 2) {
                    for (int i = 0; i < 5; i++) {
                        //Shift here
                        try {
                            sleep(100);
                        } catch (Exception e) {
                            EventRW.Write(e);
                        }
                        //Shift back
                        try {
                            sleep(100);
                        } catch (Exception e) {
                            EventRW.Write(e);
                        }
                    }
                }
                frame.changeBG(oriBG);
                frame.changeFG(oriFG);
                frame.versionLabel.setText(oriVersion);
                frame.shuffler = oriShuffler;
                frame.speedLabel.setText("");
                frame.refresh();
                now = 0;
            }
        }

        public void add() {
            new Clocker().start();
        }
    }

    public class Clocker extends Thread {
        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (Exception e) {
                EventRW.Write(e);
            }
            count -= count > 0 ? 1 : 0;
        }
    }
}

