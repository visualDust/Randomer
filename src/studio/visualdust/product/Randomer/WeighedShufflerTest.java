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
