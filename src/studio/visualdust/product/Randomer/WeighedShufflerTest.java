package studio.visualdust.product.Randomer;

import studio.visualdust.product.Randomer.method.EventRW;
import studio.visualdust.product.Randomer.structure.LinedFile;
import studio.visualdust.product.Randomer.structure.ListItem;
import studio.visualdust.product.Randomer.structure.WeighedShuffler;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class WeighedShufflerTest {
    public static void main(String[] args) {
        ArrayList<ListItem> collection = new ArrayList<>();
        File file = new File("C:\\Users\\VisualDust\\Desktop\\YZNOIGroup\\名单\\test.txt");
        if (!file.isFile() || !file.exists()) {
            EventRW.Write(new Exception("Studio.VisualDust.Product.Exception.FileNotEnabledException"));
            System.exit(255);
        }
        LinedFile linedFile = new LinedFile(file);
        final int len = (int) linedFile.getLineCount();
        double[] weights = new double[len];
        for (int i = 0; i < linedFile.getLineCount() ; i++) {
            collection.add(new ListItem(linedFile.getLineOn(i).split(",")[0]));
            weights[i] = linedFile.getLineOn(i).split(",").length >= 2 ? Double.valueOf(linedFile.getLineOn(i).split(",")[1]) : 1.0;
        }
        WeighedShuffler<ListItem> gugugu = new WeighedShuffler<>(collection, weights);

        int gugu[] = new int[21];
        for (int i = 0; i < 200000; i++) {
            gugu[Integer.valueOf(gugugu.next().getName())]++;
        }
        for (int i = 0; i < 20; i++) {
            gugu[i] /= 500;
            System.out.print("name is " + i + " : ");
            for (int j = 0; j < gugu[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
