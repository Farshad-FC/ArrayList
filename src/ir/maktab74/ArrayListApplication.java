package ir.maktab74;

import ir.maktab74.domain.LinkedList;
import ir.maktab74.util.ApplicationContext;

import java.util.ArrayList;

public class ArrayListApplication {
    public static ApplicationContext context = new ApplicationContext();
    public static LinkedList arrayList = new LinkedList();

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
                    addNodeToLinkedList();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    context.getMenu().showExitMessage();
                    break loop;
            }
        }
    }

    private static void addNodeToLinkedList() {
        loop:
        while (true) {
            String inputString = getInputFromUser();
            if (inputString.equals("exit"))
                break loop;
            int inputInt = Integer.parseInt(inputString);
            arrayList.addNodeToLinkedList(inputInt);
        }
    }

    private static String getInputFromUser() {
        String inputString="";
        int inputInt;
        while (true) {
            try {
                showArrayList(arrayList);
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

    private static void showArrayList(LinkedList arrayList){
        context.getMenu().showFirstCaracterArrayList();
        for (int count = 0; count < arrayList.size(); count++) {
            context.getMenu().showNodeInArrayList(arrayList.get(count));
            if (count < arrayList.size()-1)
                context.getMenu().showSpaceBetweenNode();
        }
        context.getMenu().showLastCaracterArrayList();
    }
}
