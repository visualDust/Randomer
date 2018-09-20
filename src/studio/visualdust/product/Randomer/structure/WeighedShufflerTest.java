package studio.visualdust.product.Randomer.structure;

import java.util.Arrays;

public class WeighedShufflerTest {
    public static void main(String[] args) {
        String[] names = {"a", "b", "c"};
        double[] weight = {1.0, 1.5, 97.0};
        for (String name : new WeighedShuffler<>(Arrays.asList(names), weight)) {
            System.out.println(name);
        }
    }
}
