package javaTester;

import java.util.Scanner;

public class Topic_09_While_Do_While {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BT5();
    }

    public static void BT1(){
        int n = scanner.nextInt();
        while (n<=100){
            if (n % 2 == 0){
                System.out.println(n);
            }
            n ++;
        }
    }

    public static void BT2(){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int i = a;
        while (i <=b){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println(i);
            }
            i++;
        }
    }

    public static void BT3(){
        int n = scanner.nextInt();
        int sum = 0;
        int i = 0;
        while(i <= n){
            if(i % 2 != 0){
                sum += i;
            }
            i++;
        }
        System.out.println(sum);
    }

    public static void BT4(){
        int a = scanner.nextInt();
        int b= scanner.nextInt();
        int i = a;
        while (i <= b){
            if(i % 3 == 0){
                System.out.println(i);
            }
            i++;
        }
    }

    public static void BT5(){
        int a = scanner.nextInt();
        long fact = 1;
        int i =1;
        while (i <= a){
            fact *= i;
            i++;
        }
        System.out.println(fact);
    }
}
