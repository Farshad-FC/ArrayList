package ir.maktab74;

import ir.maktab74.domain.LinkedList;
import ir.maktab74.util.ApplicationContext;

import java.util.ArrayList;

public class ArrayListApplication {
    public static ApplicationContext context = new ApplicationContext();
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        while (true) {
            String inputString = getInputFromUser();
            if (inputString.equals("exit"))
                break;
            int inputInt = Integer.parseInt(inputString);
            arrayList.add(inputInt);
        }

        removeImproperlyArrangedPairs();
    }

    private static void removeImproperlyArrangedPairs() {
        for (int count = 0; count < arrayList.size(); ) {
            if (count == arrayList.size() - 1)
                arrayList.remove(count);
            else {
                if ((int) arrayList.get(count) > (int) arrayList.get(count + 1)) {
                    arrayList.remove(count);
                    arrayList.remove(count);
                } else
                    count += 2;
            }
        }
        showArrayList();
    }

    private static String getInputFromUser() {
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
        context.getMenu().showFirstCaracter();
        for (int count = 0; count < arrayList.size(); count++) {
            context.getMenu().showNodeInArrayList(arrayList.get(count));
            if (count < arrayList.size() - 1)
                context.getMenu().showSpaceBetweenNode();
        }
        context.getMenu().showLastCaracter();
    }
}
