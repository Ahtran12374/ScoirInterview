public class Person {


    private String first_name;
    private String last_name;
    private String dob;


    public Person(String first_name, String last_name, String dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public int getDoB() {
        return Integer.parseInt(dob);
    }

    public void printData() {
        Output.printNewLine(first_name + ", " + last_name + ", " + dob);
    }

}