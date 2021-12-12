import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Parser {

    public static ArrayList<Person> parseCsv() {
        ArrayList<Person> listOfPeople = new ArrayList<Person>();
        int fileNumber;
        Output.printNewLine("");
        try {
            File folder = new File("./csv data");
            FileFilter filter = new FileFilter() {

                public boolean accept(File f)
                {
                    return f.getName().endsWith("csv");
                }
            };
            File[] files = folder.listFiles(filter);
            int i = 1;
            for (File file : files) {
                Output.printNewLine(i + ") " + file.getName());
                i++;
            }
            Output.printNewLine("\nEnter the cvs's file number:");
            fileNumber = Validation.validUserNumberChoice(files.length);
            Output.printNewLine("");
            BufferedReader br = new BufferedReader(new FileReader(files[fileNumber - 1]));
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                listOfPeople.add(new Person(values[0], values[1], values[2]));
            }

            return listOfPeople;

        } catch (NullPointerException | FileNotFoundException e) {
            Output.printNewLine("An error occur. Returning to main menu.");
            return listOfPeople;
        } catch (IOException e) {
            e.printStackTrace();
            return listOfPeople;
        }

    }

}
