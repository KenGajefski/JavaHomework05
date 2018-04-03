import java.io.FileInputStream;
import java.util.Scanner;

public class HW5{

    // Constants and Globals
    private static final String FILE_NAME = "ProductInventoryIn.txt";

    public static void main(String[] args){

        // Variables
        Scanner fileIn = null;
        int input;
        Scanner keyboard = new Scanner(System.in);
        fileIn = new Scanner(new FileInputStream("ProductInventoryIn.txt"));

        System.out.println("Make your selection");
        input = keyboard.nextInt();
        while (!(input == 4)){
            // Any other option not on the menu
        }

    }

}
