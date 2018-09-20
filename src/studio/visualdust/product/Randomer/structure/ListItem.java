package studio.visualdust.product.Randomer.structure;

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

    public double getWeight() {
        return weight;
    }

    public int getKey() {
        return key;
    }
}
