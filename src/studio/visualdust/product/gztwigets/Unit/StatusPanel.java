package studio.visualdust.product.gztwigets.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatusPanel extends JDesktopPane {
    private static int DEFAULT_SP_HEIGHT = 30;
    //The default height of statusPanel.
    private static int DEFAULT_BNT_WIDTH = 40;
    //The default width of three buttons.

    private static int windSizeCHeckDelay = 50;
    //test

    public Color DEFAULT_BG_COLOR = new Color(255, 255, 255);
    //ERRRRRRRR......

    private Color DEFAULT_BNT_BG_COLOR = new Color(217, 217, 217);
    private Color DEFAULT_BNT_FG_COLOR = new Color(155, 155, 155);

    private Color DEFAULT_CLOSEBNT_MOUSEMOVING_BG = new Color(255, 50, 50);
    private Color DEFAULT_CLOSEBNT_MOUSEMOVING_FG = new Color(255, 255, 255);

    private Color DEFAULT_CLOSEBNT_CLICK_BG = new Color(163, 4, 0);
    private Color DEFAULT_CLOSEBNT_CLICK_FG = DEFAULT_CLOSEBNT_MOUSEMOVING_FG;

    private Color DEFAULT_MAXBUN_MOUSEMOVING_BG = new Color(200, 200, 200);
    private Color DEFAULT_MAXBUN_MOUSEMOVING_FG = new Color(255, 255, 255);

    private Color DEFAULT_MINBNT_MOUSEMOVING_BG = DEFAULT_MAXBUN_MOUSEMOVING_BG;
    private Color DEFAULT_MINBNT_MOUSEMOVING_FG = DEFAULT_MAXBUN_MOUSEMOVING_FG;


    private Color DEFAULT_MAXBNT_CLICK_BG = new Color(133, 133, 133);
    private Color DEFAULT_MAXBNT_CLICK_FG = new Color(255, 255, 255);

    private Color DEFAULT_MINBNT_CLICK_BG = DEFAULT_MAXBNT_CLICK_BG;
    private Color DEFAULT_MINBNT_CLICK_FG = DEFAULT_MAXBNT_CLICK_FG;

    private JPanel closePanel = new JPanel();
    private JLabel closeLabel = new JLabel("x", JLabel.CENTER);
    private JPanel maxPanel = new JPanel();
    private JLabel maxLabel = new JLabel("o", JLabel.CENTER);
    private JPanel minPanel = new JPanel();
    private JLabel minLabel = new JLabel("-", JLabel.CENTER);

    private JFrame parent;
    private Dimension oldSize;
    private Point oldLocation;
    private boolean isMouseIn = false;

    public StatusPanel(JFrame Jwind) {
        this.setLayout(null);
        parent = Jwind;

        this.setBackground(DEFAULT_BG_COLOR);

        closePanel.add(closeLabel);
        closePanel.setBackground(DEFAULT_BNT_BG_COLOR);
        closeLabel.setForeground(DEFAULT_BNT_FG_COLOR);
        this.add(closePanel);

        maxPanel.add(maxLabel);
        maxPanel.setBackground(DEFAULT_BNT_BG_COLOR);
        maxLabel.setForeground(DEFAULT_BNT_FG_COLOR);
        this.add(maxPanel);

        minPanel.add(minLabel);
        minPanel.setBackground(DEFAULT_BNT_BG_COLOR);
        minLabel.setForeground(DEFAULT_BNT_FG_COLOR);
        this.add(minPanel);

        //MouseListener Here.
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                closePanel.setBackground(DEFAULT_CLOSEBNT_CLICK_BG);
                closeLabel.setForeground(DEFAULT_CLOSEBNT_CLICK_FG);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isMouseIn) {
                    closePanel.setBackground(DEFAULT_CLOSEBNT_MOUSEMOVING_BG);
                    closeLabel.setForeground(DEFAULT_CLOSEBNT_MOUSEMOVING_FG);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseIn = true;
                closePanel.setBackground(DEFAULT_CLOSEBNT_MOUSEMOVING_BG);
                closeLabel.setForeground(DEFAULT_CLOSEBNT_MOUSEMOVING_FG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseIn = false;
                closePanel.setBackground(DEFAULT_BNT_BG_COLOR);
                closeLabel.setForeground(DEFAULT_BNT_FG_COLOR);
            }
        });

        maxLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!parent.getSize().equals(Toolkit.getDefaultToolkit().getScreenSize())) {
                    oldSize = parent.getSize();
                    oldLocation = parent.getLocation();
                    parent.setLocation(0, 0);
                    parent.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                } else {
                    parent.setLocation(oldLocation);
                    parent.setSize(oldSize);
                }//TODO It doesn't work ...
            }

            @Override
            public void mousePressed(MouseEvent e) {
                maxPanel.setBackground(DEFAULT_MAXBNT_CLICK_BG);
                maxLabel.setForeground(DEFAULT_MAXBNT_CLICK_FG);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isMouseIn) {
                    maxPanel.setBackground(DEFAULT_MAXBUN_MOUSEMOVING_BG);
                    maxLabel.setForeground(DEFAULT_MAXBUN_MOUSEMOVING_FG);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseIn = true;
                maxPanel.setBackground(DEFAULT_MAXBUN_MOUSEMOVING_BG);
                maxLabel.setForeground(DEFAULT_MAXBUN_MOUSEMOVING_FG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseIn = false;
                maxPanel.setBackground(DEFAULT_BNT_BG_COLOR);
                maxLabel.setForeground(DEFAULT_BNT_FG_COLOR);
            }
        });

        minLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setState(Frame.ICONIFIED);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                minPanel.setBackground(DEFAULT_MINBNT_CLICK_BG);
                minLabel.setForeground(DEFAULT_MINBNT_CLICK_FG);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isMouseIn) {
                    minPanel.setBackground(DEFAULT_MINBNT_MOUSEMOVING_BG);
                    minLabel.setForeground(DEFAULT_MINBNT_MOUSEMOVING_FG);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseIn = true;
                minPanel.setBackground(DEFAULT_MINBNT_MOUSEMOVING_BG);
                minLabel.setForeground(DEFAULT_MINBNT_MOUSEMOVING_FG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseIn = false;
                minPanel.setBackground(DEFAULT_BNT_BG_COLOR);
                minLabel.setForeground(DEFAULT_BNT_FG_COLOR);
            }
        });

        parent.add(this);
        this.SetWidth(parent.getContentPane().getWidth());
        ReputButtons();
        (new WindowSizeListenThread()).start();
    }

    public void SetWidth(int width) {
        this.setSize(width, DEFAULT_SP_HEIGHT);
        this.setLocation(0, 0);
        ReputButtons();
    }

    private void ReputButtons() {
        closePanel.setSize(DEFAULT_BNT_WIDTH, this.getHeight());
        closePanel.setLocation(this.getWidth() - DEFAULT_BNT_WIDTH, 0);
        closeLabel.setLocation(0, 0);
        closeLabel.setSize(closePanel.getSize());

        maxPanel.setSize(DEFAULT_BNT_WIDTH, this.getHeight());
        maxPanel.setLocation(this.getWidth() - DEFAULT_BNT_WIDTH * 2, 0);
        maxLabel.setLocation(0, 0);
        maxLabel.setSize(maxPanel.getSize());

        minPanel.setSize(DEFAULT_BNT_WIDTH, this.getHeight());
        minPanel.setLocation(this.getWidth() - DEFAULT_BNT_WIDTH * 3, 0);
        minLabel.setLocation(0, 0);
        minLabel.setSize(minPanel.getSize());

    }

    private class WindowSizeListenThread extends Thread {
        @Override
        public void run() {
            double oldWidth = parent.getContentPane().getWidth();
            while (true) {
                try {
                    sleep(windSizeCHeckDelay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (oldWidth != parent.getContentPane().getWidth()) {
                    oldWidth = parent.getContentPane().getWidth();
                    SetWidth((int) oldWidth);
                    setLocation(0, 0);
                }
            }
        }
    }
}
