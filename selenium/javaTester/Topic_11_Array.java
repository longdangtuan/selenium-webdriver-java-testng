package javaTester;

import java.util.ArrayList;
import java.util.Arrays;

public class Topic_11_Array {
    public static void main(String[] args) {
BT1();
    }

    public static void BT1(){
     int[] a = new int[]{2, 7, 6, 8, 9};
        int x = 0;
        for (int i = 0; i < a.length; i++){
            if (x < a[i]){
                x= a[i];
            }
        }
        System.out.println(x);
    }


}
