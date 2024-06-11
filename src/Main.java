import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("-".repeat(120));
        AddOrRemove addOrRemove = new AddOrRemove();
        FoodCourt foodCourt = new FoodCourt();

        String[] items = null;
        String[] items2 = null;
        String[] temp = null;
        String [] items3 = new String[10];
        String drink = "";

        String sideOrder = null;
        String main = null;
        String side = "";
        int input = 0;
        int Court = 0;
        int[] pounds = new int[100];
        int[] pounds2 = new int[100];
        double price = 0;
        double mealTotal = 0;
        double grocery = 0;
        double foodCourtTotal = 0;
        double itemsTotal = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tGROCERY STORE");
        System.out.println("-".repeat(120));

        System.out.println("\t\t\t\tWelcome to Aarav's online Grocery Store where you can shop for fresh groceries online");
        System.out.println("-".repeat(120));
        System.out.println("Available actions:\n\t0 - to exit\n\t1 - to add item(s) to " +
                "shopping cart \n\t2 - to remove any items from cart when done adding to cart" +
                "" + "\n" + "\t3 - to order from food court\n"
                + "Enter a answer for which action " +
                "you want to do: ");
        int userInput = sc.nextInt();

            if (userInput == 1) {

                System.out.println("-".repeat(120));
                System.out.println("\t\t\t\t\t\t\t\t\t\t\tItems in stock:");
                System.out.println("\t\t\t" + "-".repeat(80));
                System.out.println("\t\t\t\t\t\t\t\tAPPLES, ORANGES, PEARS - $1.25 per pound" +
                        "\n\t\t\t\t\t\t\t\tMILK, CHEESE, YOGURT - $3 per pound" +
                        "\n\t\t\t\t\t\t\t\tCHICKEN, GOAT, FISH - $5 per pound");

                System.out.println("-".repeat(120));
                System.out.println("First enter How many Items you want to add to your online grocery cart:");
                int arraySize = sc.nextInt();

                if (arraySize > 9) {
                    arraySize = 9;
                }

                items = new String[arraySize];
                temp = new String[arraySize];

                System.out.println("-".repeat(120));

                for (int i = 0; i < items.length ; i++) {

                    System.out.println("Enter item you want to add to shopping cart: ");
                    String item = sc.next();
                    items[i] = item;
                    temp[i] = item.toUpperCase();

                    if (item != null) {
                        System.out.println("-".repeat(80));
                        System.out.println("How many pounds of " + item + ":");
                        pounds[i] = sc.nextInt();
                    }

                        items[i] = (pounds[i] + " pounds of "+ item.toUpperCase());
                        System.out.println(pounds[i] + " pounds of " + item.toUpperCase() + " was ADDED to cart");
                        System.out.println("-".repeat(50));
                }
//                addItems(items);
                System.out.println("-".repeat(400));
                System.out.println( "Grocery cart after adding items: "+ addOrRemove.addItems(items));
                System.out.println("-".repeat(400));

                System.out.println("Enter 2 to continue and remove items from shopping cart, or 0 to cancel order:");
                input = sc.nextInt();

            }
            if (input == 2) {

                System.out.println("-".repeat(120));

                for (int i = 0; i < items.length; i++) {

                    System.out.println("Enter pounds of " + items[i].substring(12) + " you want to remove: ");
                    pounds2[i] = sc.nextInt();
                    System.out.println(pounds2[i] + " of item " + items[i].substring(12) + " was Removed from cart");
                    System.out.println("-".repeat(50));
                }

                foodCourt.pauseCode();
                System.out.println("-".repeat(300));
                System.out.println("Items in cart after removal: " + addOrRemove.removePounds(pounds, pounds2, temp));
                System.out.println("-".repeat(300));

                //addOrRemove.CalculatePrice;
                foodCourt.pauseCode();
                System.out.println(addOrRemove.calculatePrice().toString());
                foodCourt.pauseCode();
                System.out.println("-".repeat(20));
                System.out.println("TOTAL:");
                System.out.print("$");
                System.out.println(addOrRemove.total());
                System.out.println("-".repeat(20));

                System.out.println("Groceries ordering completed, press 0 to exit, or enter 3 to " +
                        "order from our delicious food court: ");
                Court = sc.nextInt();

                if (Court == 0) {
                    foodCourt.creditCard();
                }
            }

            if (userInput == 3 || Court == 3) {

                System.out.println("-".repeat(120));
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tFOOD COURT");
                System.out.println("-".repeat(120));
                System.out.println("\t\t\t\t\t\t\t\tWelcome to Aarav's online in store restaurant");
                System.out.println("-".repeat(120));
                System.out.println("Enter:");
                System.out.println("-".repeat(120));
                System.out.println("\t1 - if you want a main item for $6\n\t2 - just a side for $4\n\t3 - just a drink for $2\n\t" +
                        "4 - a complete meal with all 3 for $10\nEnter a answer for which action you want to do:");
                int answer = sc.nextInt();
                System.out.println("-".repeat(120));

                if (answer == 1) {
                    System.out.println("How many main items do you want: ");
                    int item = sc.nextInt();
                    System.out.println("-".repeat(120));
                    items3 = new String[item];
                    pounds = new int[item];

                    for (int i = 0; i < items3.length; i++) {
                        System.out.println("Choose a Main:\n\tPIZZA - $10 per pizza\n\tBURGER - $5 each");
                        items3[i] = sc.next();
                        System.out.println("-".repeat(120));
                        System.out.println("How many " + items3[i] + "'s, you can only have 9 at most: ");
                        pounds[i] = sc.nextInt();
                        System.out.println("-".repeat(120));
                        System.out.println(pounds[i] + " " + items3[i].toUpperCase() + "'s" + " was added");
                        System.out.println("-".repeat(120));

                        items3[i] = (pounds[i] + " " + items3[i].toUpperCase() + "(s)");
                    }
                    System.out.println("-".repeat(120));
                    System.out.println("Items after adding food: " + Arrays.toString(items3));
                    System.out.println("-".repeat(120));


                    System.out.println("Do you want a side of fries with your order, yes/no: ");
                    side = sc.next().toUpperCase();
                    System.out.println("-".repeat(120));

                    if (side.equals("NO")) {
                        System.out.println(Arrays.toString(foodCourt.mealCalculator(addOrRemove.addItems(items3))));
                        System.out.println("-".repeat(40));
                        System.out.print("Total for order: $");
                        foodCourtTotal = foodCourt.calculateTotal();
                        System.out.println(foodCourtTotal);
                        System.out.println("-".repeat(40));
                        foodCourt.pauseCode();
                        System.out.print("TOTAL for grocery list was: ");
                        System.out.print("$");
                        grocery = addOrRemove.total();
                        System.out.println(grocery);

                        itemsTotal = grocery + foodCourtTotal;

                        foodCourt.pauseCode();
                        System.out.println("-".repeat(40));
                        System.out.println("Total for both orders: ");
                        System.out.print("$");
                        System.out.println(itemsTotal);
                        System.out.println("-".repeat(40));
                        foodCourt.creditCard();
                    }
                }

                if (side.toUpperCase().equals("YES") || answer == 2) {
                    System.out.println("REGULAR or LARGE FRIES: ");
                    side = sc.next().toUpperCase();
                    System.out.println("-".repeat(120));
                    System.out.println("How many orders of " + side.toUpperCase() + " FRIES:");
                    input = sc.nextInt();
                    System.out.println("-".repeat(120));
                    System.out.println(input + " orders of " + side.toUpperCase() + " FRIES" + " was ADDED to cart");
                    System.out.println("-".repeat(120));
                    sideOrder = (input + " orders of " + side.toUpperCase() + " FRIES");


                    System.out.println("-".repeat(120));
                    System.out.print("Cart after adding: ");
                    ArrayList<String> SIDE = foodCourt.addAll(items3, sideOrder);
                    System.out.println(SIDE.toString());
                    System.out.println("-".repeat(120));

                    System.out.println("Would you like to add a drink yes/no: ");
                    drink = sc.next().toUpperCase();

                    if (drink.equals("NO")) {
                        System.out.println(Arrays.toString(foodCourt.mealCalculator(SIDE)));
                        System.out.println("-".repeat(40));
                        System.out.print("Total for order: $");
                        foodCourtTotal = foodCourt.calculateTotal();
                        System.out.println(foodCourtTotal);
                        System.out.println("-".repeat(40));

                        foodCourt.pauseCode();
                        System.out.print("TOTAL for grocery list was: ");
                        System.out.print("$");
                        grocery = addOrRemove.total();
                        System.out.println(grocery);
                        System.out.println("-".repeat(40));

                        foodCourt.pauseCode();
                        itemsTotal = grocery + foodCourtTotal;
                        System.out.println("Total for both orders: ");
                        System.out.println("$" + itemsTotal);
                        System.out.println("-".repeat(40));
                        foodCourt.creditCard();
                    }
                }

                if (drink.toUpperCase().equals("YES") || answer == 3) {

                    System.out.println("LARGE or REGULAR drink: ");
                    side = sc.next().toUpperCase();
                    System.out.println("-".repeat(120));
                    System.out.println(side + " drink was ADDED to cart");
                    foodCourt.pauseCode();
                    sideOrder = ("1 " + side + " drink");

                    System.out.println("-".repeat(120));
                    foodCourt.pauseCode();
                    System.out.print("Cart after adding: ");
                    ArrayList<String> DRINK = foodCourt.addDrink(sideOrder);
                    System.out.println(DRINK);
                    foodCourt.pauseCode();
                    System.out.println("-".repeat(120));

                    System.out.println(Arrays.toString(foodCourt.mealCalculator(DRINK)));
                    System.out.println("-".repeat(40));
                    System.out.print("Total for order: $");
                    foodCourtTotal = foodCourt.calculateTotal();
                    System.out.println(foodCourtTotal);
                    System.out.println("-".repeat(40));
                    foodCourt.pauseCode();

                    foodCourt.pauseCode();
                    System.out.print("TOTAL for grocery list was: ");
                    System.out.print("$");
                    grocery = addOrRemove.total();
                    System.out.println(grocery);
                    System.out.println("-".repeat(40));

                    foodCourt.pauseCode();
                    itemsTotal = foodCourtTotal + grocery;
                    System.out.println("Total for both orders: ");
                    System.out.println("$" + itemsTotal);
                    System.out.println("-".repeat(40));
                    foodCourt.creditCard();
                }

                if (answer == 4) {

                    System.out.println("Pre-Made Meals:\n\tBurger Meal - $10\n\tPizza Meal - $15\n" +
                            "Enter Burger or Pizza to order either meal:");
                    String meal = ("1 " + sc.next() + " meal").toUpperCase();

                    System.out.println("-".repeat(120));
                    System.out.println(meal + " was ADDED to cart");
                    System.out.println("-".repeat(120));
                    foodCourt.pauseCode();

                    System.out.print("Cart: ");
                    System.out.println(foodCourt.addDrink(meal));
                    System.out.println("-".repeat(40));
                    foodCourt.pauseCode();
                    System.out.print("Total for order: $");
                    System.out.println((foodCourt.preMadeMealCalculator(foodCourt.addDrink(meal))));
                    System.out.println("-".repeat(40));
                    mealTotal = foodCourt.preMadeMealCalculator(foodCourt.addDrink(meal));
                    grocery = addOrRemove.total();
                    mealTotal += grocery;
                    foodCourt.pauseCode();
                    System.out.println("Total after adding grocery list total:");
                    System.out.println(mealTotal);
                    System.out.println("-".repeat(40));
                    foodCourt.creditCard();
                }
            }
    }
}
