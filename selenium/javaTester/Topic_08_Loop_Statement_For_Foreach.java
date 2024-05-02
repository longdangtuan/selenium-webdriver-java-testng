package javaTester;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_08_Loop_Statement_For_Foreach {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BT5();

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


    public static void BT3(){
int sum = 0;
        for (int i = 1 ; i <= 10; i++)
        {
            if(i % 2 == 0){
                sum += i ;
            }
        }
        System.out.println(sum);
    }


    public static void BT4(){
        int a = scanner.nextInt();
        int b= scanner.nextInt();
        int sum = 0;
        for(int i = a; i <= b; i++){
            sum += i;
        }
        System.out.println(sum);
    }

    public static void BT5(){
        int a = scanner.nextInt();
        int sum = 0;
        for(int i = 0; i <= a; i++){
            if(i % 2 != 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
