import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddOrRemove {

    private double finalTotal = 0;
    private double[] value = new double[0];
    private String[] temp;
    private double[] total = new double[2];


    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Double> price = new ArrayList<>();

    public AddOrRemove() {

    }
    public AddOrRemove(ArrayList<String> list, double[] value, String[] temp, ArrayList<Double> price, double[] total, double finalTotal) {
        this.list = list;
        this.value = value;
        this.temp = temp;
        this.price = price;
        this.total = total;
        this.finalTotal = finalTotal;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }



    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> addItems(String[] items) {

        list.clear();
        for (int i = 0; i < items.length; i++) {

            list.add(items[i]);
        }

        return list;
    }

    public ArrayList<String> removeItems(String[] items) {

        for (int i = 0; i < items.length; i++) {

            list.remove(items[i]);
        }

        return list;
    }

    public String[] Search(String[] items, String itemToRemove) {

        String[] newArray = new String[items.length];

        for (int i = 0; i < items.length; i++) {

            if (items[i] != itemToRemove) {
                newArray[i] = items[i];
            }
        }
        return newArray;
    }


    public ArrayList<String> removePounds(int[] pounds, int[] pounds2, String[] items) {

        list.clear();
        value = new double[items.length];
        temp = new String[items.length];

        for (int i = 0; i < items.length; i++) {

            value[i] = pounds[i] - pounds2[i];

            if (value[i] == 0) {
                items[i] = "REMOVED ITEM";
                temp[i] = "REMOVED ITEM";
            } else {
                temp[i] = items[i];
                items[i] = (value[i] + " pounds of " + items[i]);

                addItems(items);
            }
        }
        list.clear();
        System.out.println("Items in cart before removal: " + Arrays.toString(items));
        addItems(items);
        list.removeAll(Collections.singleton("REMOVED ITEM"));
        list.remove(null);
        return list;
    }


    public ArrayList<String> calculatePrice() {

        for (int i = 0; i < value.length; i++) {


            if (value[i] == 0) {
                price.remove(value[i]);
            } else {
                price.add(value[i]);
            }
        }

        list.clear();
        addItems(temp);
        Search(temp, "REMOVED ITEM");

        list.removeAll(Collections.singleton("REMOVED ITEM"));

        String[] Price = new String[list.size()];
        total = new double[list.size()];

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals("APPLES") || list.get(i).equals("ORANGES") || list.get(i).equals("PEARS")) {
                total[i] = (price.get(i) * 1.25);
                Price[i] = ("+ $" + total[i] + " for " + price.get(i) + " pounds of " + list.get(i));

            } else if (list.get(i).equals("MILK") || list.get(i).equals("CHEESE") || list.get(i).equals("YOGURT")) {
                total[i] = (price.get(i) * 3);
                Price[i] = ("+ $" + total[i] + " for " + price.get(i) + " pounds of " + list.get(i));

            } else if (list.get(i).equals("CHICKEN") || list.get(i).equals("GOAT") || list.get(i).equals("FISH")) {
                total[i] = (price.get(i) * 5);
                Price[i] = ("+ $" + total[i] + " for " + price.get(i) + " pounds of " + list.get(i));

            } else {
                Price[i] = ("INVALID ITEM INPUTTED");
            }
        }

        list.clear();
        addItems(Price);
        list.remove(null);
        return list;

    }

    public double total() {

        finalTotal = 0;

        for (int i = 0; i < total.length; i++) {

            finalTotal += total[i];
        }

        return finalTotal;
    }
}
