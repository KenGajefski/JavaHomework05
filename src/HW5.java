import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW5{

    // Constants and Globals
    private static final String FILE_NAME = "ProductInventoryIn.txt";

    public static void main(String[] args){

        // Variables
        Scanner fileIn = null;
        Scanner keyboard = new Scanner(System.in);
        int input;


        // Attempt to open input file
        try
        {
            // Assign external file to file handle
            fileIn = new Scanner(new FileInputStream(FILE_NAME));
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


        // Menu
        /*
        System.out.println("Make your selection");
        input = keyboard.nextInt();
        while (!(input == 4)){
            // Any other option not on the menu
        }
        */
        // End of menu
    }

}
