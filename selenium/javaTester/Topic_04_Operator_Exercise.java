package javaTester;

import java.util.Scanner;

public class Topic_04_Operator_Exercise {
    public static void main(String[] args) {

BT3();
    }

    public static void BT1 (){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        int ageAfter15 = age + 15;
        System.out.println("After 15 years, age of " + name + " will be " + ageAfter15 );
    }

    public static void BT2 (){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping then a = " + a + " and b = " + b );
    }

    public static void BT3 (){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a > b) {
            System.out.println("true");
    }
        else System.out.println("false");;

}
}
