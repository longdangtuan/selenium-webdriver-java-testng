package javaTester;

public class Topic_03_Data_Type_Exercise {
    public static void main(String[] args) {
        BT1(6, 2);
        BT2(7.5f, 3.8f);
        BT3("Automation Testing");
    }

    public static void BT1(int a, int b) {
        int P1 = a + b;
        System.out.println("a + b = " + P1);

        int P2 = a - b;
        System.out.println("a - b = " + P2);

        int P3 = a * b;
        System.out.println("a - b = " + P3);

        int P4 = a / b;
        System.out.println("a / b = " + P4);
    }

    public static void BT2(float a, float b) {
        float P = a * b;
        System.out.println("Area = " + P);
    }

    public static void BT3(String a) {
        System.out.println("Hello " + a);
    }

}
