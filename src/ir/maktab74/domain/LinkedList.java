package ir.maktab74.domain;

import java.util.ArrayList;

public class LinkedList {

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public int size(){
        return arrayList.size();
    }

    public int get(int x){
        return arrayList.get(x);
    }

    public void addNodeToLinkedList(int input){
        arrayList.add(input);
    }
}
