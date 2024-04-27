package javaTester;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.ui.FluentWait;

public class Topic_06_If_Else_Exercise {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
BT3();
    }

    public static void BT1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = (n % 2 == 0) ? "n la so chan" : "n la so le";
        System.out.println(result);
    }

    public static void BT2(){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String result = (a >= b) ? "a lon hon hoac bang b" : "a nho hon b";
        System.out.println(result);
    }

    public static void BT3(){
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String result = (StringUtils.equals(a, b)) ? "2 nguoi cung ten" : "2 nguoi khac ten";
        System.out.println(result);
    }


}
