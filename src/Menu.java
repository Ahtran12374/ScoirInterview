import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.*;

public class Menu {

    private ArrayList<String> actions = new ArrayList<>(Arrays.asList
            ("Open file", "Filter by first name", "Sort by Last name", "Filter by Last name", "Filter by DoB", "Exit"));
    private ArrayList<Person> listOfPeople = new ArrayList<Person>();

    public Menu() {
        File dir = new File("./csv data");
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

        //add new function choice
    public void runMenu() {
        Output.displayChoices(actions);
        int userInput = Validation.validUserNumberChoice(actions.size());
        while (userInput != 6) {
            switch (userInput) {
                case 1:
                    openCsv();
                    break;
                case 2:
                    sortByFirst();
                    break;
                case 3:
                    sortByLast();
                    break;
                case 4:
                    filterByLast();
                    break;
                case 5:
                    sortByDoB();
                    break;
            }
            Output.displayChoices(actions);
            userInput = Validation.validUserNumberChoice(actions.size());
        }
    }

    private void sortByDoB() {
        Output.printNewLine("");
        Output.printNewLine( "First, Last, DoB");
        listOfPeople.sort(Comparator.comparingInt(Person::getDoB));
        for(Person person : listOfPeople) {
            person.printData();
        }
        Output.printNewLine("");
    }

    private void sortByLast() {
        Output.printNewLine("");
        Output.printNewLine( "First, Last, DoB");
        listOfPeople.sort(Comparator.comparing(Person::getLastName));
        for(Person person : listOfPeople) {
            person.printData();
        }
        Output.printNewLine("");
    }

    private void filterByLast() {
        Output.printNewLine("");
        Output.printNewLine("Please enter a last name to filter.");
        String nameMatch = Input.inputString().toLowerCase();
        ArrayList<Person> filteredPeople = new ArrayList<>();
        for(Person person : listOfPeople) {
            if(nameMatch.equals(person.getLastName().toLowerCase())) {
                filteredPeople.add(person);
            }
        }
        Output.printNewLine( "First, Last, DoB");
        for(Person person : filteredPeople) {
            person.printData();
        }
        Output.printNewLine("");
    }

    private void sortByFirst() {
        Output.printNewLine("");
        Output.printNewLine( "First, Last, DoB");
        listOfPeople.sort(Comparator.comparing(Person::getFirstName));
        for(Person person : listOfPeople) {
            person.printData();
        }
        Output.printNewLine("");
    }

    private void openCsv() {
        listOfPeople = Parser.parseCsv();
    }
}
