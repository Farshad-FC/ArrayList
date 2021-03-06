package ir.maktab74.util;

public class Menu {
    public void showEnterArrayMessage() {
        System.out.println("input sample: 1 3 8 4 5 0 9");
        System.out.print("plz enter a array: ");
    }

    public void showFirstMenuMessage() {
        seperator();
        System.out.println("1: check that the LinkedList is empty");
        System.out.println("2: add node to LinkedList");
        System.out.println("3: delete node from LinkedList");
        System.out.println("4: search in LinkedList");
        System.out.println("5: exit");
        System.out.print("plz choose a number: ");
    }

    public void showEnterRightNumberMessage() {
        seperator();
        System.out.println("plz enter right value.");
        seperator();
    }

    public void seperator(){
        System.out.println("=".repeat(20));
    }

    public void showExitMessage(){
        System.out.println("bye! have a nice time.");
    }

    public void showEnterValueMessage() {
        System.out.print("plz enter a number or 'exit': ");
    }

    public void showNodeInArrayList(Object o) {
        System.out.print(o);
    }

    public void showSpaceBetweenNode() {
        System.out.print(", ");
    }

    public void showFirstCaracter() {
        System.out.print("{");
    }

    public void showLastCaracter() {
        System.out.println("}");
    }

    public void showEnterIndexLinkedListMessage() {
        System.out.print("plz enter index for delete: ");
    }

    public void showIndexLinkedList(int index) {
        System.out.print(index + "\t");
    }

    public void showIndexMessage() {
        System.out.print("index : ");
    }

    public void getNextLine() {
        System.out.println();
    }

    public void showLinkedListIsEmptyMessage() {
        seperator();
        System.out.println("LinkedList is empty.");
    }

    public void showLinkedListIsNotEmptyMessage() {
        seperator();
        System.out.println("LinkedList is not empty.");
    }
}
