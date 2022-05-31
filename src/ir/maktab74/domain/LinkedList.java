package ir.maktab74.domain;

import ir.maktab74.util.ApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;

import static ir.maktab74.LinkedListApplication.linkedList;

public class LinkedList<T> {

    private Node<T> first;
    private int size;

    public LinkedList() {
        size = 0;
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(T t) {
        Node newNode = new Node(t, null);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.getNextNode() != null) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(newNode);
        }
        size++;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(first);
    }

    public void delete(T input) {
        Node<T> deleteNode = first;
        Node<T> prev = null;

        if (deleteNode != null && deleteNode.getData() == input) {
            first = deleteNode.getNextNode();
            return;
        }

        while (deleteNode != null && deleteNode.getData() != input) {
            prev = deleteNode;
            deleteNode = deleteNode.getNextNode();
        }

        if (deleteNode == null) {
            return;
        }

        prev.setNextNode(deleteNode.getNextNode());
    }

    public void search(T inputInt, ApplicationContext context) {
        if (linkedList.size() != 0) {
            Iterator iterator = linkedList.iterator();
            int count = 1;
            context.getMenu().showIndexMessage();
            while (iterator.hasNext()) {
                if (iterator.next() == inputInt)
                    context.getMenu().showIndexLinkedList(count);
                count++;
            }
            context.getMenu().getNextLine();
        } else
            context.getMenu().showLinkedListIsEmptyMessage();
    }
}
