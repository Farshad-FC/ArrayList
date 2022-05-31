package ir.maktab74.domain;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> current;

    public LinkedListIterator(Node<T> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T t = current.getData();
        current = current.getNextNode();
        return t;
    }
}
