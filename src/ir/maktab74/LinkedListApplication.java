package ir.maktab74;

import ir.maktab74.util.ApplicationContext;
import ir.maktab74.domain.LinkedList;

import java.util.Iterator;

public class LinkedListApplication {
    public static ApplicationContext context = new ApplicationContext();
    public static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        loop:
        while (true) {
            int selectedNumber;
            try {
                context.getMenu().showFirstMenuMessage();
                selectedNumber = context.getNumberScanner().nextInt();
            } catch (Exception e) {
                context.getMenu().showEnterRightNumberMessage();
                context.getNumberScanner().next();
                selectedNumber = 0;
            }
            switch (selectedNumber) {
                case 1:
                    checkLinkedListisEmpty();
                    break;
                case 3:
                case 4:
                    if (linkedList.isEmpty()) {
                        context.getMenu().showLinkedListIsEmptyMessage();
                        break;
                    }
                case 2:
                    addAndDeleteNodeAndSearchInLinkedList(selectedNumber);
                    break;
                case 5:
                    context.getMenu().showExitMessage();
                    break loop;
            }
        }
    }

    private static void checkLinkedListisEmpty() {
        if (!linkedList.isEmpty())
            context.getMenu().showLinkedListIsNotEmptyMessage();
        else
            context.getMenu().showLinkedListIsEmptyMessage();
    }

    private static void addAndDeleteNodeAndSearchInLinkedList(int selectedNumber) {
        while (true) {
            String inputString = getInputFromUser(selectedNumber);
            if (inputString.equals("exit"))
                break;
            int inputInt = Integer.parseInt(inputString);
            switch (selectedNumber) {
                case 2:
                    linkedList.add(inputInt);
                    break;
                case 3:
                    linkedList.delete(inputInt);
                    break;
                case 4:
                    linkedList.search(inputInt, context);
                    break;
            }

        }
    }

    private static String getInputFromUser(int selectedNumber) {
        String inputString = "";
        int inputInt;
        while (true) {
            try {
                showArrayList();
                context.getMenu().showEnterValueMessage();
                inputString = context.getStringScanner().nextLine();
                if (inputString.equals("exit"))
                    return inputString;
                inputInt = Integer.parseInt(inputString);
                break;
            } catch (Exception e) {
                context.getMenu().showEnterRightNumberMessage();
                inputInt = 0;
            }
        }
        return inputString;
    }

    private static void showArrayList() {
        Iterator iterator = linkedList.iterator();
        context.getMenu().showFirstCaracter();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext())
                context.getMenu().showSpaceBetweenNode();
        }
        context.getMenu().showLastCaracter();
    }
}
