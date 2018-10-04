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
