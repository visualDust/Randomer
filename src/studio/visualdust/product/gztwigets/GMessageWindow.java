package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GMessageWindow extends JDialog {

    private Color DEFAULT_BG_COLOR = new Color(255, 255, 255);

    private Dimension SIZE_WITH_FIELD = new Dimension(400, 150);
    private Dimension SIZE_WITHOUT_FIELD = new Dimension(300, 90);
    private Dimension NOW_SIZE = SIZE_WITHOUT_FIELD;

    private int BUTTON_WIDTH = (int) (SIZE_WITH_FIELD.width / 3.0);
    private int BUTTON_HEIGHT = 40;
    private Dimension BUTTON_SIZE = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);

    private int LABEL_HEIGHT = 50;
    private int FIELD_HEIGHT = 50;
    private int BORDER_WIDTH = 70;

    private Color FONT_COLOR = new Color(0, 0, 0);

    private int state = -1;

    public GButton okButton = new GButton("Ok");           //state 0
    public GButton noButton = new GButton("No");           //state 1
    public GButton cancelButton = new GButton("Cancel");   //state 2

    public GTextField textField = new GTextField("");
    public JLabel label = new JLabel("", JLabel.LEFT);

    public GMessageWindow(Container container, int style, String message) {
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBackground(DEFAULT_BG_COLOR);
//        this.setTitle("Hey !");

        //add buttons
        this.add(okButton);
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                state = 0;
                container.setEnabled(true);
            }
        });
        if (style > 0) {
            this.add(noButton);
            noButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setVisible(false);
                    state = 1;
                    container.setEnabled(true);
                }
            });
            this.add(cancelButton);
            cancelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setVisible(false);
                    state = 2;
                    container.setEnabled(true);
                }
            });
        }

        //init other wigets
        if (style == 2) {
            this.add(textField);
            NOW_SIZE = SIZE_WITH_FIELD;
        } else {
            label = new JLabel("", JLabel.CENTER);
            NOW_SIZE = SIZE_WITHOUT_FIELD;
        }
        this.add(label);
        label.setText(" " + message);
        label.setForeground(FONT_COLOR);

        container.setEnabled(false);
        this.SetSize(NOW_SIZE);
        this.setLocation(container.getX() + container.getWidth() / 2 - NOW_SIZE.width / 2, container.getY() + container.getHeight() / 2 - NOW_SIZE.height / 2);
        this.setVisible(true);
    }

    public void SetSize(Dimension dimension) {
        this.setSize(dimension);
        BUTTON_WIDTH = (int) (NOW_SIZE.width / 3.0);
        BUTTON_SIZE = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
        okButton.SetSize(BUTTON_SIZE);
        okButton.setLocation(NOW_SIZE.width - BUTTON_WIDTH, NOW_SIZE.height - BUTTON_HEIGHT);
        noButton.SetSize(BUTTON_SIZE);
        noButton.setLocation(NOW_SIZE.width - 2 * BUTTON_WIDTH, NOW_SIZE.height - BUTTON_HEIGHT);
        cancelButton.SetSize(BUTTON_SIZE);
        cancelButton.setLocation(NOW_SIZE.width - 3 * BUTTON_WIDTH, NOW_SIZE.height - BUTTON_HEIGHT);

        label.setLocation(0, 0);
        label.setSize(this.getWidth(), LABEL_HEIGHT);

        textField.setLocation(BORDER_WIDTH * 2, LABEL_HEIGHT);
        textField.SetSize(new Dimension(this.getWidth() - 2 * BORDER_WIDTH, FIELD_HEIGHT));
    }

    public int getState() {
        return state;
    }

    public String getText() {
        return textField.getText();
    }

}
