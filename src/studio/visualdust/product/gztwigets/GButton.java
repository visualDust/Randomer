package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GButton extends JPanel {
    /*
    Author GZT
     if you want to add an actionListener for GButton
     why not try to add a mouseAdapter(Clicked)
     that's the way it work .
     you can see this type extended Jpanel.
     good luck.
     YOU MUST USE NULL LAYOUT !!!!!!!!!
    */
    public Color DEFAULT_BG_COLOR = new Color(222, 222, 222);
    public Color DEFAULT_FG_COLOR = new Color(0, 0, 0);
    public Color DEFAULT_MOUSEMOVING_BG = new Color(133, 133, 133);
    public Color DEFAULT_MOUSEMOVING_FG = new Color(255, 255, 255);
    public Color DEFAULT_CLICK_BG = new Color(0, 140, 242);
    public Color DEFAULT_CLICK_FG = DEFAULT_MOUSEMOVING_FG;

    private JLabel textLabel = new JLabel("", JLabel.CENTER);

    public GButton(String text) {
        this.setLayout(null);
        this.setBackground(DEFAULT_BG_COLOR);
        textLabel.setText(text);
        textLabel.setForeground(DEFAULT_FG_COLOR);
        this.add(textLabel);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(DEFAULT_MOUSEMOVING_BG);
                textLabel.setForeground(DEFAULT_MOUSEMOVING_FG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(DEFAULT_BG_COLOR);
                textLabel.setForeground(DEFAULT_FG_COLOR);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(DEFAULT_CLICK_BG);
                textLabel.setForeground(DEFAULT_CLICK_FG);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(DEFAULT_MOUSEMOVING_BG);
                textLabel.setForeground(DEFAULT_MOUSEMOVING_FG);
            }

        });
        SetSize(this.getSize());
    }

    public void SetForeColor(Color fore) {
        DEFAULT_FG_COLOR = fore;
        textLabel.setForeground(fore);
    }

    public void SetBackColor(Color back) {
        DEFAULT_BG_COLOR = back;
        this.setBackground(back);
    }

    public void SetText(String text) {
        textLabel.setText(text);
    }

    public void SetSize(Dimension dimension) {
        this.setSize(dimension);
        textLabel.setLocation(0, 0);
        textLabel.setSize(this.getSize());
    }
}
