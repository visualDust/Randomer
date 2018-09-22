package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;

public class GTextField extends JPanel {
    public static Color PRE_PANEL_COLOR = new Color(0, 140, 242);
    private Color TEXTFIELD_BG_COLOR = new Color(222, 222, 222);
    private Color DEFAULT_BG_COLOR = TEXTFIELD_BG_COLOR;

    private int PRE_PANEL_WIDTH = 10;
    private int DIVIDIER = 5;

    JPanel prePanel = new JPanel();
    JTextField textField;

    public GTextField(String originalText) {
        this.setLayout(null);
        this.setBackground(DEFAULT_BG_COLOR);
        textField = new JTextField(originalText);
        textField.setBorder(null);
        textField.setBackground(TEXTFIELD_BG_COLOR);
        prePanel.setBackground(PRE_PANEL_COLOR);
        this.add(textField);
        this.add(prePanel);

        SetSize(this.getSize());
    }

    public void SetSize(Dimension dimension) {
        this.setSize(dimension);
        prePanel.setLocation(0, 0);
        prePanel.setSize(PRE_PANEL_WIDTH, this.getHeight());
        textField.setLocation(PRE_PANEL_WIDTH + DIVIDIER, 0);
        textField.setSize(this.getWidth() - PRE_PANEL_WIDTH - DIVIDIER, this.getHeight());
    }

    public void SetTipColor(Color color) {
        prePanel.setBackground(color);
    }

    public String getText() {
        return textField.getText();
    }
}
