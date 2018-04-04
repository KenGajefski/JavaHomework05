import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HW5{

    // Constants and Globals
    private static final String FILE_NAME = "ProductInventoryIn.txt";

    public static void sellProduct(){

    }

    public static void main(String[] args){

        // Variables
        Scanner fileIn = null;
        Scanner keyboard = new Scanner(System.in);
        Product[] inv = new Product[11];
        String tempLine;
        String input;
        int menu = 0;
        boolean terminate = false;

        // Attempt to open input file
        try
        {
            // Assign external file to file handle
            fileIn = new Scanner(new FileInputStream(FILE_NAME));
            tempLine = fileIn.nextLine();

            for(int i = 0; i < 10; i++){
                // Create object in array and set all values
                inv[i] = new Product();
                inv[i].setCode(Integer.parseInt(tempLine.substring(0,6).trim()));
                inv[i].setName(tempLine.substring(7,31).trim());
                inv[i].setCost(Double.parseDouble(tempLine.substring(31,41).trim()));
                inv[i].setCount(Integer.parseInt(tempLine.substring(42,51).trim()));
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


        while(menu != 4) {

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
                        menu = Integer.parseInt(input);
                        terminate = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That is not a valid input for the menu. Please enter another option.");
                    input = keyboard.next();
                }
            }
            // End of validation loop

            // Menu option functions

            // Resets the flag for validation loop
            terminate = false;
        }

        System.out.println("Now exiting the program.");

    }

}
