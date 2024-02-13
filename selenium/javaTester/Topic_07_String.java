package javaTester;

public class Topic_07_String {
    public static void main(String[] args) {
        String firstName = "Long";
        String lastName = "Dang";

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        fullName = firstName.concat(" ").concat(lastName);

    }
}
