import java.util.ArrayList;

//handles various outputs
public abstract class Output {

    //displays the element of an arraylist
    public static void displayChoices(ArrayList<String> choices) {
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ") " + choices.get(i));
        }
    }

    public static void printNewLine(String string) {
        System.out.println(string);
    }

    public static void printSameLine(String string) {
        System.out.print(string);
    }
}