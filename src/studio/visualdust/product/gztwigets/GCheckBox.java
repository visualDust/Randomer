package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GCheckBox extends JPanel {
    private Color DEFAULT_BG_COLOR = new Color(255, 255, 255);
    private Color MOVINGPANEL_FG = new Color(255, 255, 255);
    private Color GAIN_BG_COLOR = new Color(192, 192, 192);
    private Color ON_COLOR = new Color(21, 188, 0);
    private Color OFF_COLOR = new Color(177, 0, 3);

    private int GAIN_WIDTH = 60;
    private int GAIN_HEIGHT = 30;

    JLabel titleLabel = new JLabel("", JLabel.CENTER);
    public JLabel listenerLabel = new JLabel();
    GStringPanel onGStrPanel = new GStringPanel("ON", MOVINGPANEL_FG);
    GStringPanel offGStrPanel = new GStringPanel("OFF", MOVINGPANEL_FG);

    private boolean chosen;
    private boolean isEnabled = true;

    public GCheckBox(String title, boolean b) {
        this.setLayout(null);
        this.setBackground(DEFAULT_BG_COLOR);
        onGStrPanel.setBackground(ON_COLOR);
        offGStrPanel.setBackground(OFF_COLOR);
        titleLabel.setText(title);
        this.add(titleLabel);
        this.add(onGStrPanel);
        this.add(offGStrPanel);
        this.add(listenerLabel);
        SetChosen(b);

        listenerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                SetChosen(!chosen);
            }
        });

        this.SetSize(this.getSize());
    }

    public boolean IsChosen() {
        return chosen;
    }

    public void SetChosen(boolean b) {
        if (isEnabled) {
            this.chosen = b;
            if (b) {
                onGStrPanel.setBackground(ON_COLOR);
                onGStrPanel.SetText("ON");
                offGStrPanel.setBackground(GAIN_BG_COLOR);
                offGStrPanel.SetText("");
            } else {
                offGStrPanel.setBackground(OFF_COLOR);
                offGStrPanel.SetText("OFF");
                onGStrPanel.setBackground(GAIN_BG_COLOR);
                onGStrPanel.SetText("");
            }
        }
    }

    public void SetEnable(boolean b) {

        listenerLabel.setVisible(b);
        isEnabled = b;
        onGStrPanel.SetText(b ? "ON" : "X");
        offGStrPanel.SetText(b ? "OFF" : "X");
    }

    public boolean IsEnabled() {
        return isEnabled;
    }

    public void SetSize(Dimension dimension) {
        this.setSize(dimension);
        titleLabel.setLocation(0, 0);
        titleLabel.setSize(this.getWidth() - 2 * GAIN_WIDTH, this.getHeight());
        onGStrPanel.SetSize(new Dimension(GAIN_WIDTH, GAIN_HEIGHT));
        onGStrPanel.setLocation(this.getWidth() - GAIN_WIDTH, this.getHeight() / 2 - GAIN_HEIGHT / 2);
        offGStrPanel.SetSize(new Dimension(GAIN_WIDTH, GAIN_HEIGHT));
        offGStrPanel.setLocation(this.getWidth() - GAIN_WIDTH * 2, this.getHeight() / 2 - GAIN_HEIGHT / 2);
        listenerLabel.setSize(GAIN_WIDTH * 2, GAIN_HEIGHT);
        listenerLabel.setLocation(this.getWidth() - GAIN_WIDTH * 2, this.getHeight() / 2 - GAIN_HEIGHT / 2);
    }
}
