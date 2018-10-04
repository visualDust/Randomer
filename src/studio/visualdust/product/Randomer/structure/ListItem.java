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
