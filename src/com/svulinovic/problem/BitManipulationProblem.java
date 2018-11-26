package com.svulinovic.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitManipulationProblem {

    public static void testCellActiveInactive() {
        cellActiveInactive(new int[] {1, 0, 0, 0, 0, 1, 0, 0}, 2);
        cellActiveInactive(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1);
        cellActiveInactive(new int[] {0, 1, 1, 0, 0, 0, 0, 1}, 1);
        cellActiveInactive(new int[] {1, 1, 1, 0, 0, 1, 0, 0}, 1);
    }

    public static List<Integer> cellActiveInactive(int[] states, int days) {
        System.out.println("cellActiveInactive - in: days = " + days + ", states = " + Arrays.toString(states));

        List<Integer> result = new ArrayList<>();

        int mask = 0; //1 byte 0xff
        int currentState = 0;
        for (int i = 0; i < states.length; i++) {
            mask = (mask << 1) | 1;
            currentState = (currentState << 1) | states[i];
        }

        for (int day = 0; day < days; day++) {

            int leftShift = currentState << 1;
            int rightShift = currentState >>> 1;

            currentState = (leftShift ^ rightShift) & mask;
        }

        for (int i = states.length - 1; i >= 0; i--) {
            result.add((currentState >>> i) & 1);
        }

        System.out.println("cellActiveInactive - out: result = " + result);
        return result;
    }

}
