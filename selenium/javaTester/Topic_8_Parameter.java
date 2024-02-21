package javaTester;

public class Topic_8_Parameter {
    static String fullNameGlobal = "Long";

    public static void main(String[] args) {
        // Đối số
        setFullName("xyz");

    }
    public static void setFullName(String fullName){
         fullNameGlobal = fullName;
    }
}
