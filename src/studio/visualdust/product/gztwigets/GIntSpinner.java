package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GIntSpinner extends JPanel {
    private Color DEFAULT_BG_COLOR = new Color(244, 244, 244);

    private int BUTTON_WIDTH = 30;

    GButton leftButton = new GButton("-");
    GButton rightButton = new GButton("+");
    JTextField textField = new JTextField("0", JTextField.CENTER);

    public GIntSpinner(int oriNum) {
        this.setLayout(null);
        this.add(leftButton);
        this.add(rightButton);
        textField.setBorder(null);
        textField.setBackground(DEFAULT_BG_COLOR);
        textField.setText(String.valueOf(oriNum));
        this.add(textField);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                CheckNumStr();
            }
        });
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckNumStr();
                textField.setText(String.valueOf(Integer.valueOf(textField.getText()) - 1));
            }
        });
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CheckNumStr();
                textField.setText(String.valueOf(Integer.valueOf(textField.getText()) + 1));
            }
        });

        this.SetSize(this.getSize());
    }

    private void CheckNumStr() {
        String text = textField.getText();
        String num = "";
        for (int i = 0; i < text.length(); i++) {
            try {
                if (String.valueOf(text.charAt(i)).equals(String.valueOf("-"))) {
                    num += String.valueOf(text.charAt(i));
                } else {
                    num += Integer.valueOf(String.valueOf(text.charAt(i)));
                }
            } catch (Exception e) {

            }
        }
        if (num.isEmpty())
            num = "0";
        textField.setText(num);
    }

    public void SetSize(Dimension dimension) {
        this.setSize(dimension);

        leftButton.setLocation(0, 0);
        leftButton.SetSize(new Dimension(BUTTON_WIDTH, this.getHeight()));

        textField.setLocation(BUTTON_WIDTH, 0);
        textField.setSize(this.getWidth() - 2 * BUTTON_WIDTH, this.getHeight());

        rightButton.setLocation(this.getWidth() - BUTTON_WIDTH, 0);
        rightButton.SetSize(new Dimension(BUTTON_WIDTH, this.getHeight()));
    }

    public void SetValue(int value) {
        textField.setText(String.valueOf(value));
    }

    public int GetValue() {
        CheckNumStr();
        return Integer.valueOf(textField.getText());
    }
}
