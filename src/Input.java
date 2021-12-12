import java.util.InputMismatchException;
import java.util.Scanner;

//abstract class that handles user inputs
public abstract class Input {

    //handles string input
    public static String inputString() {
        Scanner stringScanner = new Scanner(System.in);
        return stringScanner.nextLine();
    }

    //handles integer input
    public static int inputNumbers() {
        while (true) {
            try {
                Scanner numberScanner = new Scanner(System.in);
                return numberScanner.nextInt();
            } catch (InputMismatchException e) {
                Output.printNewLine("Not a number");
            }
        }
    }


}
