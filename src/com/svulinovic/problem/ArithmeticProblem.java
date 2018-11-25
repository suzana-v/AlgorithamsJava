package com.svulinovic.problem;

import java.util.Arrays;

public class ArithmeticProblem {

    public static void testGreatestCommonDivider() {
        greatestCommonDivider(5, new int[] {4, 6, 8, 4, 6, 8});
        greatestCommonDivider(5, new int[] {12, 6, 18, 42, 666, 81});
    }

    public static int greatestCommonDivider(int num, int[] arr){
        System.out.println("greatestCommonDivider - in: num = " + num + ", arr = " + Arrays.toString(arr));

        //searching smallest number in array
        int gcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < gcd) {
                gcd = arr[i];
            }
        }

        while (gcd > 1) {
            int count = 0;
            //checking if numbers are dividable by current greatest common divider
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % gcd == 0) {
                    count++;
                }
            }
            //if all numbers are dividable by current greatest common divider, we are done
            if (count == arr.length) {
                break;
            }
            //else check again for greatest common divider - 1
            gcd--;
        }

        System.out.println("greatestCommonDivider - out: gcd = " + gcd);
        return gcd;
    }

}
