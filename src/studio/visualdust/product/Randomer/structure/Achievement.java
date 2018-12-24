package studio.visualdust.product.Randomer.structure;

import java.awt.*;

public class Achievement {
    String name;
    String description;
    int count;
    Color bg, fg;
    int shift;

    public Achievement(
            String name,
            String description,
            int count,
            Color bg, Color fg,
            int shift
    ) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.bg = bg;
        this.fg = fg;
        this.shift = shift;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public Color getBg() {
        return bg;
    }

    public Color getFg() {
        return fg;
    }

    public int getShift() {
        return shift;
    }
}
