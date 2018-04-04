import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW5{

    // Globals, constants, and format specifiers
    private static final String FILE_NAME = "ProductInventoryIn.txt";
    private static final String COL_LABEL = "%-14s";
    private static final String COL_AMOUNT = "%-14d";
    private static final String COL_VALUE = "%,-14.2f";

    public static void sellProduct(int userCode, int userAmount, Product[] inv){

        double revenue;
        int amount = inv[userCode].getCount();

        revenue = inv[userCode].getCost() * userAmount;

        // Changing values of Product
        Product.setInventoryCount(-userAmount);
        Product.setInventoryValue(-revenue);
        inv[userCode].setCount(amount - userAmount);

        // Printing revenue and changes
        System.out.printf(COL_LABEL + COL_AMOUNT + "\n", "Code:", userCode);
        System.out.printf(COL_LABEL + COL_AMOUNT + "\n", "Amount:", userAmount);
        System.out.printf(COL_LABEL + COL_VALUE + "\n", "Revenue:", revenue);
    }

    public static void orderProduct(int userCode, int userAmount, Product[] inv){

        int amount = inv[userCode].getCount();
        double value = inv[userCode].getCost() * userAmount;

        // Changing values of Product
        Product.setInventoryCount(userAmount);
        Product.setInventoryValue(value);
        inv[userCode].setCount(amount + userAmount);

        // Printing cost and changes
        System.out.printf(COL_LABEL + COL_AMOUNT + "\n", "Code:", userCode);
        System.out.printf(COL_LABEL + COL_AMOUNT + "\n", "Amount:", userAmount);
        System.out.printf(COL_LABEL + COL_VALUE + "\n", "Cost:", value);

    }
    
    public static void listInventory(Product[] inv){

        System.out.printf(COL_LABEL + COL_LABEL + COL_LABEL + COL_LABEL + "\n",
                "Code", "Name", "Cost", "Count");
        for (int i = 0; i < 10; i++){
            System.out.printf(COL_AMOUNT + COL_LABEL + COL_VALUE + COL_AMOUNT + "\n",
                    inv[i].getCode(), inv[i].getName(), inv[i].getCost(), inv[i].getCount());
        }

        
    }

    public static void main(String[] args){

        // Variables
        Scanner fileIn = null;
        Scanner keyboard = new Scanner(System.in);
        Product[] inv = new Product[11];
        String tempLine;
        String input;
        int maxInv;
        int userMenuChoice = 0;
        int userAmount = 0;
        int userCode;
        boolean terminate = false;

        // Attempt to open input file
        try
        {
            // Assign external file to file handle
            fileIn = new Scanner(new FileInputStream(FILE_NAME));
            tempLine = fileIn.nextLine();

            for(int i = 0; i < 10; i++){
                // Create object in array and set all values
                inv[i] = new Product((Integer.parseInt(tempLine.substring(0,6).trim())),
                        tempLine.substring(7,31).trim(),
                        Double.parseDouble(tempLine.substring(31,41).trim()),
                        Integer.parseInt(tempLine.substring(42,51).trim()));
                if (i != 9)
                    tempLine = fileIn.nextLine();
            }
        }
        // Handle file error
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file '" + FILE_NAME+
                    "' not found.");
            System.out.println("Default folder: " +
                    System.getProperty("user.dir"));
            System.out.println("Error message:" + e.getMessage());
        }


        while(userMenuChoice != 4) {

            // Menu
            System.out.print("=============================\n" +
                    "=== Camping Critters Menu ===\n" +
                    "=== 1. Sell Product       ===\n" +
                    "=== 2. Order Product      ===\n" +
                    "=== 3. List Inventory     ===\n" +
                    "=== 4. Exit               ===\n" +
                    "=============================");
            System.out.println();
            System.out.println("Make you menu selection.");
            input = keyboard.next();

            // Input validation
            while (!terminate) {
                try {
                    if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 4) {
                        System.out.println("That is not a valid input for the menu. Please enter another option.");
                        input = keyboard.next();
                    }
                    else{
                        userMenuChoice = Integer.parseInt(input);
                        terminate = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That is not a valid input for the menu. Please enter another option.");
                    input = keyboard.next();
                }
            }
            // End of validation loop

            // Menu option functions
            switch (userMenuChoice){
                case 1:
                    System.out.println("Enter the code of the object you would like to sell.");
                    input = keyboard.next();
                    userCode = Integer.parseInt(input);
                    if (userCode < 80 || userCode > 89) {
                        System.out.println("Not a valid product code.");
                        break;
                    }
                    else{
                        maxInv = inv[userCode-80].getCount();
                        System.out.println("Enter an amount to sell.");
                        input = keyboard.next();
                        userAmount = Integer.parseInt(input);
                        if (userAmount > maxInv || userAmount <= 0){
                            System.out.println("Not a valid amount of the object to be sold.");
                            break;
                        }
                        else
                            sellProduct(userCode - 80, userAmount, inv);
                    }
                    break;
                case 2:
                    System.out.println("Enter the code of the object you would like to order.");
                    input = keyboard.next();
                    userCode = Integer.parseInt(input);
                    if (userCode < 80 || userCode > 89) {
                        System.out.println("Not a valid product code.");
                        break;
                    }
                    else {
                        System.out.println("Enter an amount to order.");
                        input = keyboard.next();
                        userAmount = Integer.parseInt(input);
                        if (userAmount <= 0) {
                            System.out.println("Not a valid amount of the object to be ordered.");
                            break;
                        } else
                            orderProduct(userCode - 80, userAmount, inv);
                    }
                    break;
                case 3:
                    listInventory(inv);
                    break;
            }
            // End of switch statement

            // Resets the flag for validation loop
            terminate = false;
        }
        // End of menu

        System.out.println("Now exiting the program.");

    }

}
