package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;

public class GStringPanel extends JPanel {
    private Color DEFAULT_BG_COLOR = new Color(255, 255, 255);

    public JLabel textLabel = new JLabel("", JLabel.CENTER);

    public GStringPanel(String text, Color fgc) {
        this.setLayout(null);
        textLabel.setText(text);
        textLabel.setForeground(fgc);
        this.setLayout(null);
        this.add(textLabel);
    }

    public void SetText(String txt) {
        textLabel.setText(txt);
    }

    public void SetSize(Dimension dimension) {
        this.setSize(dimension);
        textLabel.setLocation(0, 0);
        textLabel.setSize(this.getSize());
    }
}
