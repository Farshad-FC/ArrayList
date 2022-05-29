package ir.maktab74.domain;

import ir.maktab74.util.ApplicationContext;

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

    public void deleteNodeFromLinkedList(int inputInt) {
        arrayList.remove(inputInt);
    }

    public void searchInLinkedList(int inputInt, ApplicationContext context) {
        if (arrayList.size() != 0) {
            context.getMenu().showIndexMessage();
            for (int count = 0; count < arrayList.size(); count++) {
                if (arrayList.get(count) == inputInt)
                    context.getMenu().showIndexLinkedList(count + 1);
            }
            context.getMenu().getNextLine();
        } else
            context.getMenu().showLinkedListIsEmptyMessage();
    }
}
