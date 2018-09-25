 
# GButton.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GButton.java  
WordCount = 2560
```java
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

```
---
---
# GCheckBox.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GCheckBox.java  
WordCount = 3127
```java
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

```
---
---
# GIntSpinner.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GIntSpinner.java  
WordCount = 2878
```java
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

```
---
---
# GMessageWindow.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GMessageWindow.java  
WordCount = 4265
```java
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

    public void setText(String s) {
        textField.setText(s);
    }

    public void setWaring(boolean b) {
        textField.SetTipColor(b ? new Color(159, 8, 0) : textField.PRE_PANEL_COLOR);
    }

    public String getText() {
        return textField.getText();
    }

}

```
---
---
# GStringPanel.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GStringPanel.java  
WordCount = 747
```java
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

```
---
---
# GTextField.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GTextField.java  
WordCount = 1429
```java
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

    public void setText(String s) {
        textField.setText(s);
    }
}

```
---
---
# GTheme.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\GTheme.java  
WordCount = 942
```java
package studio.visualdust.product.gztwigets;

import javax.swing.*;
import java.awt.*;

public class GTheme {
    public static void GZTIniter() {
        ResetFont();
    }

    public static void ResetFont() {
        Font f = new Font("等线", 0, 20);
        String names[] = {"Label", "CheckBox", "PopupMenu", "MenuItem", "CheckBoxMenuItem",
                "JRadioButtonMenuItem", "ComboBox", "Button", "Tree", "ScrollPane",
                "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                "PasswordField", "TextField", "Table", "Label", "Viewport",
                "RadioButtonMenuItem", "RadioButton", "DesktopPane", "InternalFrame"
        };
        for (String item : names) {
            UIManager.put(item + ".font", f);
        }
    }
}

```
---
---
# StatusPanel.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\gztwigets\Unit\StatusPanel.java  
WordCount = 8528
```java
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

```
---
---
# MainFrame.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\gui\MainFrame.java  
WordCount = 11489
```java
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
                (new windWipper(me.getWidth() == WIDTH + WIDTH / 4 ? WIDTH : WIDTH + WIDTH / 4)).start();
            }
        });
        this.add(moreButton);

        JLabel versionLabel = new JLabel(Resource.softName + Resource.version + " By " + Resource.author, JLabel.LEFT);
        versionLabel.setFont(new Font("等线", 0, 20));
        versionLabel.setForeground(new Color(211, 211, 211));
        versionLabel.setSize(WIDTH, 20);
        versionLabel.setLocation(0, 0);
        this.add(versionLabel);

        GButton refreshButton = new GButton("重载列表");
        refreshButton.SetSize(new Dimension(WIDTH / 4, 50));
        refreshButton.setLocation(WIDTH, HEIGHT - 50);
        refreshButton.SetBackColor(new Color(222, 171, 0));
        refreshButton.SetForeColor(new Color(255, 255, 255));
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RefreshList(file);
                display.setText("列表重载");
            }
        });
        this.add(refreshButton);

        GButton recounterButton = new GButton("新建唱票基");
        recounterButton.setLocation(WIDTH, 0);
        recounterButton.SetSize(new Dimension(WIDTH / 4, 50));
        this.add(recounterButton);

        recounterLabel.setFont(new Font("等线", 0, 40));
        recounterLabel.setLocation(WIDTH, 50);
        recounterLabel.setSize(WIDTH / 4, 100);
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
                recounterLabel.setText(newListItem.getName());
                passedLabel.setText(recounter.getPassCount() + " : 通过");
                ratioLabel.setText(Integer.valueOf(recounter.getPassCount() * 100 / recounter.getSize()) + "% : 通过率");
            }
        });

        recounterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
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

    class windWipper extends Thread {
        int width;

        windWipper(int width) {
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

```
---
---
# EventRW.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\method\EventRW.java  
WordCount = 1729
```java
package studio.visualdust.product.Randomer.method;

import studio.visualdust.product.Randomer.resource.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventRW {
    public static File logoutfile = new File(LocalDate.now().toString() + "_" + Resource.softName + ".md");
    public static OutputStream logstream;

    public static void Write(Exception e) {
        try {
            logstream = new FileOutputStream(logoutfile, true);
            logstream.write(("").getBytes());
            logstream.write(("> " + LocalDateTime.now().toString() + " Exception : " + e.toString() + "\r\n\r\n").getBytes());
            logstream.write(("").getBytes());
        } catch (Exception e1) {
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        System.out.println(e.toString());
        e.printStackTrace();
    }

    public static void Write(String event) {
        try {
            logstream = new FileOutputStream(logoutfile, true);
            logstream.write((LocalDateTime.now().toString() + " Event : " + event + "  \r\n").getBytes());
        } catch (Exception e1) {
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        System.out.println(event);
    }

    public static void WriteStrOnly(String string) {
        try {
            logstream = new FileOutputStream(logoutfile, true);
            logstream.write((string+"  \r\n").getBytes());
        } catch (Exception e1) {
            System.out.println(e1.toString());
            e1.printStackTrace();
        }
        System.out.println(string);
    }
}

```
---
---
# FileWriter.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\method\FileWriter.java  
WordCount = 1173
```java
package studio.visualdust.product.Randomer.method;

import java.io.*;
import java.nio.charset.Charset;

public class FileWriter {
    private static OutputStream FileWriterStream;

    public static void WriteLineUTF8(File file, String string, boolean append) {
        try {
            FileWriterStream = new FileOutputStream(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileWriterStream, Charset.forName("UTF-8")));
            bufferedWriter.write(string);
            bufferedWriter.write("\r\n");
            bufferedWriter.close();
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }

    public static void WriteLineUnicode(File file, String string, boolean append) {
        try {
            FileWriterStream = new FileOutputStream(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileWriterStream, Charset.forName("Unicode")));
            bufferedWriter.write(string);
            bufferedWriter.write("\r\n");
            bufferedWriter.close();
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }
}

```
---
---
# RandomerLauncher.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\RandomerLauncher.java  
WordCount = 3839
```java
package studio.visualdust.product.Randomer;

import studio.visualdust.product.Randomer.gui.MainFrame;
import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.structure.LinedFile;
import studio.visualdust.product.Randomer.structure.ListItem;
import studio.visualdust.product.Randomer.structure.Shuffler;
import studio.visualdust.product.Randomer.structure.WeighedShuffler;
import studio.visualdust.product.gztwigets.GMessageWindow;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class RandomerLauncher {


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            EventRW.Write(e);
        }
        ResetFonts();

        MainFrame mainFrame = new MainFrame(null);

        JFrame rubbishFrame = new JFrame();
        rubbishFrame.setSize(1, 1);
        rubbishFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        rubbishFrame.setVisible(false);
        GMessageWindow messageWindow = new GMessageWindow(rubbishFrame, 2, "请输入一个列表的路径");
        messageWindow.okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                messageWindow.setWaring(false);
                ArrayList<ListItem> collection = new ArrayList<>();
                File file = new File(stripQuotes(messageWindow.getText()));
                if (!file.isFile() || !file.exists()) {
                    messageWindow.setVisible(true);
                    messageWindow.setText("File not enabled !!!");
                    messageWindow.setWaring(true);
                } else {
                    mainFrame.RefreshList(file);
                    mainFrame.setVisible(true);
                }
            }
        });

        messageWindow.cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventRW.Write("User exited");
                System.exit(0);
            }
        });

        messageWindow.noButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventRW.Write("User exited");
                System.exit(0);
            }
        });

        EventRW.Write("Randomer Launched");
    }

    public static Font defaultFont = new Font("等线", 0, 17);

    public static void ResetFonts() {

        String names[] = {"Label", "CheckBox", "PopupMenu", "MenuItem", "CheckBoxMenuItem",
                "JRadioButtonMenuItem", "ComboBox", "Button", "Tree", "ScrollPane",
                "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                "PasswordField", "TextField", "Table", "Label", "Viewport",
                "RadioButtonMenuItem", "RadioButton", "DesktopPane", "InternalFrame"
        };
        for (String item : names) {
            UIManager.put(item + ".font", defaultFont);
        }
    }

    private static String stripQuotes(String s) {
        int begin = 0;
        int end = s.length();
        while (s.charAt(begin) == '"') {
            begin++;
        }
        while (s.charAt(end - 1) == '"') {
            end--;
        }
        return s.substring(begin, end);
    }
}

```
---
---
# Resource.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\resource\Resource.java  
WordCount = 275
```java
package studio.visualdust.product.Randomer.resource;

public class Resource {
    public static String softName = "Randomer";
    public static String version = "2018.9 Preview Version";
    public static String author = "Studio.VisualDust";

    public Resource() {
    }
}

```
---
---
# LinedFile.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\structure\LinedFile.java  
WordCount = 2383
```java
package studio.visualdust.product.Randomer.structure;

import studio.visualdust.product.Randomer.method.EventRW;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Vector;

public class LinedFile {
    Vector<String> strings = new Vector<>();
    ReaderThread readerThread = null;
    String name;
    String path;
    long wordCount;
    long lineCount;

    public LinedFile(File file) {
        readerThread = new ReaderThread(file);
        readerThread.start();
        name = file.getName();
        path = file.getPath();
        wordCount = file.length();
    }

    public boolean isReading() {
        return readerThread.isAlive();
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getLineCount() {
        while (this.isReading()) {
        }
        return lineCount;
    }

    public String getLineOn(int index) {
        while (this.isReading()) {
        }
        return strings.elementAt(index);
    }

    @Override
    public String toString() {
        while (this.isReading()) {
        }
        String string = "";
        for (int i = 0; i < strings.size(); i++) {
            string = string + strings.elementAt(i) + "\n";
        }
        return string;
    }

    private class ReaderThread extends Thread {
        File readerFile = null;

        public ReaderThread(File file) {
            readerFile = file;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = new FileInputStream(readerFile);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                String str = bufferedReader.readLine();
                if (str.length() != 0) {
                    strings.add(str);
                }
                lineCount = 1;
                while (str != null) {
                    str = bufferedReader.readLine();
                    if (str == null) break;
                    if (str.length() == 0)
                        continue;
                    strings.add(str);
                    lineCount++;
                }
            } catch (Exception e) {
                EventRW.Write(e);
            }
        }
    }
}

```
---
---
# ListItem.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\structure\ListItem.java  
WordCount = 1528
```java
package studio.visualdust.product.Randomer.structure;

import java.util.Objects;

public class ListItem {
    private String name;
    private int key = 0;
    private double weight = 1;

    public ListItem(String name) {
        this.name = name;
    }

    public ListItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public ListItem(String name, int key) {
        this.name = name;
        this.key = key;
    }

    public ListItem(String name, double weight, int key) {
        this.name = name;
        this.weight = weight;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "name='" + name + '\'' +
                ", key=" + key +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem listItem = (ListItem) o;
        return key == listItem.key &&
                Double.compare(listItem.weight, weight) == 0 &&
                Objects.equals(name, listItem.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, key, weight);
    }

    public double getWeight() {
        return weight;
    }

    public int getKey() {
        return key;
    }
}

```
---
---
# Recounter.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\structure\Recounter.java  
WordCount = 706
```java
package studio.visualdust.product.Randomer.structure;

import java.util.Vector;

public class Recounter<T> {
    Vector<T> vector;
    int pointer = 0;
    int size;
    int passCount = 0;

    public Recounter(Vector<T> vector) {
        this.vector = vector;
        pointer = 0;
        size = vector.size();
    }

    public T setPass(boolean b) {
        if (pointer <= size)
            passCount += b ? 1 : 0;
        return this.next();
    }

    public T next() {
        return pointer >= size ? null : vector.elementAt(pointer++);
    }

    public int getPassCount() {
        return passCount;
    }

    public int getSize() {
        return size;
    }
}

```
---
---
# Shuffler.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\structure\Shuffler.java  
WordCount = 846
```java
package studio.visualdust.product.Randomer.structure;

import java.util.*;

public class Shuffler<T> implements Iterator<T> {
    public List<T> list;
    private int index = 0;
    private int size;

    public Shuffler(Collection<? extends T> l) {
//        System.out.println("Size of l : "+l.size());
        if (l.isEmpty()) throw new IllegalArgumentException("Size of collection is zero.");
        list = new ArrayList<>();
        list.addAll(l);
        size = list.size();
        Collections.shuffle(list);
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T next() {
//        System.out.println(list);
        if (index >= size) {
            Collections.shuffle(list);
            index = 0;
        }
        return list.get(index++);
    }
}

```
---
---
# WeighedShufflerTest.java
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\WeighedShufflerTest.java  
WordCount = 2559
```java
package studio.visualdust.product.Randomer;

import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.structure.LinedFile;
import studio.visualdust.product.Randomer.structure.ListItem;
import studio.visualdust.product.Randomer.structure.WeighedShuffler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeighedShufflerTest {
    private static final String path = "C:\\Users\\VisualDust\\Desktop\\YZNOIGroup\\名单\\NameList.txt";
    private static final int SAMPLE_COUNT = 2000000;
    private static final int LONGEST_LINE = 100;

    public static void main(String[] args) {
        File f = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            final List<ListItem> list = br.lines().map(WeighedShufflerTest::parseListItem).collect(Collectors.toList());
//            List<String> names = list.stream().map(ListItem::getName).collect(Collectors.toList());
            final double[] weights = list.stream().mapToDouble(ListItem::getWeight).toArray();
            final WeighedShuffler<ListItem> shuffler = new WeighedShuffler<>(list, weights);
            final Map<ListItem, Long> result = IntStream.range(0, SAMPLE_COUNT)
                    .mapToObj(i -> shuffler.next())
                    .collect(Collectors.groupingBy(listItem -> listItem, Collectors.counting()));
            printQuantityWithStars(result, System.out);
        } catch (Exception e) {
            EventRW.Write(e);
        }
    }

    private static ListItem parseListItem(String s) {
        String[] split = s.split(",");
        double weight = split.length > 1 ? Double.parseDouble(split[1]) : 1.0;
        return new ListItem(split[0], weight);
    }

    private static <T> void printQuantityWithStars(Map<T, Long> map, PrintStream ps) {
        long max = map.values().stream().mapToLong(Long::longValue).max().orElse(0);
        if (max == 0) ps.println("No data");
        double scaleRatio = (double) LONGEST_LINE / max;
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            ps.println(String.format("%s \t\t: %s", entry.getKey(), stars((int) (entry.getValue() * scaleRatio))));
        }
    }

    private static String stars(int count) {
        char[] c = new char[count];
        Arrays.fill(c, '*');
        return String.valueOf(c);
    }
}

```
---
---

# WeighedShuffler.kt
FilePath = C:\Users\VisualDust\Desktop\DesktopFiles\IdeaProjects\Randomer\src\studio\visualdust\product\Randomer\structure\WeighedShuffler.kt  
WordCount = 1394
```kotlin
package studio.visualdust.product.Randomer.structure

import java.util.*
import kotlin.collections.ArrayList

open class WeighedShuffler<T>(list: List<T>,
                              weight: DoubleArray)
    : Iterator<T>, Iterable<T> {

    val list: ArrayList<T> = ArrayList(list)
    private val size: Int = list.size

    private val weightRange: DoubleArray
    private val weightSum: Double

    private val weight: DoubleArray = Arrays.copyOf(weight, weight.size)

    private val random = Random()

    init {
        weightRange = DoubleArray(size + 1)
        for (i in 0 until size) {
            weightRange[i + 1] = weightRange[i] + weight[i]
        }
        weightSum = weightRange[size]
    }

    override fun hasNext(): Boolean {
        return size != 0
    }

    override fun next(): T {
        val value = random.nextDouble() * weightSum
        val index = bisearch(value)
        return list[index]
    }

    private fun bisearch(w: Double): Int {
        var left = 0
        var right = size
        while (left + 1 != right) {
            val mid = (left + right) / 2
            if (w >= weightRange[mid]) {
                left = mid
            } else {
                right = mid
            }
        }
        return left
    }

    override fun iterator(): Iterator<T> {
        return this
    }
}

```
---
---

Auto by CodeToMD , Studio.VisualDust

