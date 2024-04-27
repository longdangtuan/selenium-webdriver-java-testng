package javaTester;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Switch_case {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BT1();
    }
    public static void BT1(){
        int a = scanner.nextInt();
        switch (a){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            case 10:
                System.out.println("ten");
                break;

        }
    }

    public static void BT2(){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
    }
}
