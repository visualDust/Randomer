package studio.visualdust.product.Randomer.structure;

import java.util.*;

public class Shuffler<T> implements Iterator<T> {
    private List<T> list;
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
