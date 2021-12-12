import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//handles various validation
public abstract class Validation {

    //makes sure the user's choice is not a letter or outside hte boundary
    public static int validUserNumberChoice(int numberOfChoices) {
        int userInput = Input.inputNumbers();
        while (userInput > numberOfChoices || userInput < 1) {
            Output.printNewLine("Not an option, choose an existing number option.");
            userInput = Input.inputNumbers();
        }
        return userInput;
    }


    //helper method to check fo special characters
    public static boolean checkForSpecialCharacter(String string) {
        Pattern p = Pattern.compile("[^A-Za-z0-9._]");
        Matcher m = p.matcher(string);
        return m.find();
    }
}
