import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FoodCourt extends AddOrRemove {

    private String main;
    private String side;
    private String drink;

    private double[] value = new double[10];

    private String[] input = new String[10];
    private ArrayList<Double> mealOrder = new ArrayList<>();

    public FoodCourt() {

    }

    public FoodCourt(ArrayList<String> list, double[] value, String[] temp, ArrayList<Double> price, double[] total, double finalTotal, String main, String side, String drink,
                     double[] value1, String[] input, ArrayList<Double> mealOrder) {
        super(list, value, temp, price, total, finalTotal);
        this.main = main;
        this.side = side;
        this.drink = drink;
        this.value = value1;
        this.input = input;
        this.mealOrder = mealOrder;
    }


    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }


    public ArrayList<Double> addItems(double[] items) {

        for (int i = 0; i < items.length; i++) {
            mealOrder.add(items[i]);
        }
        return mealOrder;
    }

    public ArrayList<String> addAll(String[] items, String add) {

        addItems(items);
        getList().add(add);
        getList().removeAll(Collections.singleton(null));
        return getList();
    }

    public ArrayList<String> addDrink(String drink) {
        getList().add(drink);
        return getList();
    }

    public String[] mealCalculator(ArrayList<String> meal) {

        input = new String[meal.size()];
        value = new double[meal.size()];

        for (int i = 0; i < meal.size(); i++) {
            input[i] = String.valueOf(meal.get(i).charAt(0));
            value[i] = Integer.parseInt(input[i]);
            mealOrder.add(value[i]);

            if (meal.get(i).substring(2).length() < 10) {
                if (meal.get(i).substring(2).equals("PIZZA(s)")) {
                    input[i] = ("+ $" + value[i] * 10 + " for " + meal.get(i));
                    value[i] = value[i] * 10;
                }
                if (meal.get(i).substring(2).equals("BURGER(s)")) {
                    input[i] = ("+ $" + value[i] * 5 + " for " + meal.get(i));
                    value[i] = value[i] * 5;
                }
            } else {

                if (meal.get(i).equals("1 LARGE drink")) {
                    input[i] = ("+ $" + 2 + " for " + meal.get(i));
                    value[i] = 2;
                }
                if (meal.get(i).equals("1 REGULAR drink")) {
                    input[i] = ("+ $" + 1.25 + " for " + meal.get(i));
                    value[i] = 1.25;
                }
                if (meal.get(i).substring(12).equals("LARGE FRIES")) {
                    input[i] = ("+ $" + value[i] * 4 + " for " + meal.get(i));
                    value[i] = value[i] * 4;
                }
                if (meal.get(i).substring(12).equals("REGULAR FRIES")) {
                    input[i] = ("+ $" + value[i] * 3 + " for " + meal.get(i));
                    value[i] = value[i] * 3;
                }
            }
        }

        return input;
    }

    public double calculateTotal() {

        double total = 0;

        for (int i = 0; i < value.length; i++) {

            total += value[i];
        }
        return total;
    }

    public double preMadeMealCalculator(ArrayList<String> meal) {

        double value = 0;

        if (meal.get(1).equals("1 BURGER MEAL")) {
            value = 10;
        }
        if (meal.get(1).equals("1 PIZZA MEAL")) {
            value = 15;
        }

        return value;
    }

    public void pauseCode() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void creditCard() {

        Scanner sc = new Scanner(System.in);
        String reEnter = null;
        String creditCardNumber = null;
        System.out.println("PAYMENT:");
        System.out.println("-".repeat(120));
        System.out.println("Enter your first and last name without spaces: ");
        String name = sc.next();
        String expirationDate = null;
        System.out.println("-".repeat(120));
        System.out.println("Enter your 8 digit Credit Card number:");
        creditCardNumber = sc.next();

        if (creditCardNumber.length() == 8) {
            System.out.println("-".repeat(120));
            System.out.println("Now enter the expiration date:");
            expirationDate = sc.next();
            System.out.println("-".repeat(120));
            pauseCode();
            System.out.println("Credit card Found:\n" + name + "\n" + creditCardNumber + "\n" + expirationDate);
            System.out.println("-".repeat(120));
            pauseCode();
            System.out.println("Processing transaction...");
            System.out.println("-".repeat(120));
            pauseCode();
            pauseCode();
            pauseCode();
            pauseCode();
            pauseCode();
            System.out.println("-".repeat(120));
            System.out.println("Transaction successful order will be delivered in 30 minutes!");
            System.out.println("-".repeat(120));

        } else {
            System.out.println("-".repeat(120));
            System.out.println("Invalid Credit Card Number");
            System.out.println("-".repeat(120));
            System.out.println("Re-Enter your 8 digit Credit Card Number:");
            reEnter = sc.next();

            System.out.println("-".repeat(120));
            System.out.println("Now enter the expiration date:");
            expirationDate = sc.next();

            System.out.println("-".repeat(120));
            pauseCode();
            System.out.println("Credit card Found\n" + name + "\n" + reEnter + "\n" + expirationDate);
            System.out.println("-".repeat(120));
            System.out.println("Processing transaction...");
            System.out.println("-".repeat(120));
            pauseCode();
            System.out.println("-".repeat(120));
            System.out.println("Transaction successful order will be delivered in 30 minutes!");
            System.out.println("-".repeat(120));

        }

    }
}
