package javaTester;

import java.util.Scanner;

public class Topic_10_Break_Continue {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static void BT1(){
        String browserName = scanner.nextLine();
        switch (browserName){
            case "Chrome":
                System.out.println(browserName);
                break;
            case "FireFox":
                System.out.println("FireFox");
                break;
            case "IE":


        }

    }
    public static void BT2(){
        int a = scanner.nextInt();
        switch (a){
            case 1:
                System.out.println("JAN");
                break;
            case 2:
                System.out.println("FEB");
                break;
            case 3:
                System.out.println("MAR");
                break;
            case 4:
                System.out.println("APRIL");
                break;
            case 5:
                System.out.println("MAY");
                break;
            case 6:
                System.out.println("JUNE");
                break;
            case 7:
                System.out.println("JULY");
                break;
            case 8:
                System.out.println("AUG");
                break;
            case 9:
                System.out.println("SEP");
                break;
            case 10:
                System.out.println("OCT");
                break;

        }
    }
}
