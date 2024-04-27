package javaTester;

import java.util.Scanner;

public class Topic_08_Loop_Statement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BT2();

    }
    public static void BT1(){
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++){
            System.out.print(i + " ");
        }
    }

    public static void BT2() {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a;  i <= b; i++){
            System.out.print(i + " ");
        }
    }
}
