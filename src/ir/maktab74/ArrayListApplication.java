package ir.maktab74;

import ir.maktab74.domain.LinkedList;
import ir.maktab74.util.ApplicationContext;

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
                    arrayList.checkLinkedListisEmpty(context);
                    break;
                case 3:
                case 4:
                    if (arrayList.size() == 0) {
                        context.getMenu().showLinkedListIsEmptyMessage();
                        break;
                    }
                case 2:
                    addAndDeleteNodeAndSearchInLinkedList(selectedNumber);
                    break;
                case 5:
                    removeImproperlyArrangedPairs();
                    break;
                case 6:
                    context.getMenu().showExitMessage();
                    break loop;
            }
        }
    }

    private static void removeImproperlyArrangedPairs() {
        for (int count = 0; count < arrayList.size();) {
            if(count == arrayList.size()-1)
                arrayList.deleteNodeFromLinkedList(count);
            else {
                if (arrayList.get(count) > arrayList.get(count+1)){
                    arrayList.deleteNodeFromLinkedList(count);
                    arrayList.deleteNodeFromLinkedList(count);
                }
                else
                    count+=2;
            }
        }
        showArrayList(arrayList);
    }

    private static void addAndDeleteNodeAndSearchInLinkedList(int selectedNumber) {
        while (true) {
            String inputString = getInputFromUser(selectedNumber);
            if (inputString.equals("exit"))
                break;
            int inputInt = Integer.parseInt(inputString);
            switch (selectedNumber) {
                case 2:
                    arrayList.addNodeToLinkedList(inputInt);
                    break;
                case 3:
                    if (inputInt <= arrayList.size())
                        arrayList.deleteNodeFromLinkedList((inputInt-1));
                    else
                        context.getMenu().showEnterRightNumberMessage();
                    break;
                case 4:
                    arrayList.searchInLinkedList(inputInt, context);
                    break;
            }

        }
    }

    private static String getInputFromUser(int selectedNumber) {
        String inputString="";
        int inputInt;
        while (true) {
            try {
                showArrayList(arrayList);
                switch (selectedNumber){
                    case 3:
                        context.getMenu().showEnterIndexLinkedListMessage();
                        break;
                    case 2:
                    case 4:
                        context.getMenu().showEnterValueMessage();
                        break;
                }
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
