package com.svulinovic.problem.adventofcode2017;

public class InverseCaptcha {

    /**
     * You're standing in a room with "digitization quarantine" written in LEDs along one wall. The only door is locked,
     * but it includes a small interface. "Restricted Area - Strictly No Digitized Users Allowed."
     *
     * It goes on to explain that you may only leave by solving a captcha to prove you're not a human. Apparently,
     * you only get one millisecond to solve the captcha: too fast for a normal human, but it feels like hours to you.
     *
     * The captcha requires you to review a sequence of digits (your puzzle input) and find the sum of all digits that
     * match the next digit in the list. The list is circular, so the digit after the last digit is the first digit in the list.
     *
     * For example:
     *
     * 1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
     * 1111 produces 4 because each digit (all 1) matches the next.
     * 1234 produces 0 because no digit matches the next.
     * 91212129 produces 9 because the only digit that matches the next one is the last digit, 9.
     * What is the solution to your captcha?
     *
     * Your puzzle answer was 1228.
     *
     */

    public static void testPartOne() {
        partOne(PuzzleInput.INVERSE_CAPTCHA);
    }

    public static long partOne(String input) {
        System.out.println("InverseCaptcha - partOne - in: " + input);
        long timeStart = System.currentTimeMillis();

        long result = 0;

        if (input != null) {
            int inputSize = input.length();

            for (int i = 0; i < inputSize; i++) {

                String current = input.substring(i, i + 1);
                String next;
                if (i == inputSize - 1) {
                    next = input.substring(0, 1);
                } else {
                    next = input.substring(i + 1, i + 2);
                }

                if (current.equals(next)) {
                    result += Integer.parseInt(current); //input should contain digits only
                }
            }
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("InverseCaptcha - partOne - out: " + result);
        System.out.printf("InverseCaptcha - partOne - finished in %d ms \n", timeEnd - timeStart);
        return result;
    }


    /**
     * Now, instead of considering the next digit, it wants you to consider the digit halfway around the circular list. That is, if your list contains 10 items, only include a digit in your sum if the digit 10/2 = 5 steps forward matches it. Fortunately, your list has an even number of elements.
     *
     * For example:
     *
     * 1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
     * 1221 produces 0, because every comparison is between a 1 and a 2.
     * 123425 produces 4, because both 2s match each other, but no other digit has a match.
     * 123123 produces 12.
     * 12131415 produces 4.
     * What is the solution to your new captcha?
     *
     * Your puzzle answer was 1238.
     *
     */

    public static void testPartTwo() {
        partTwo(PuzzleInput.INVERSE_CAPTCHA);
    }

    public static long partTwo(String input) {
        System.out.println("InverseCaptcha - partTwo - in: " + input);
        long timeStart = System.currentTimeMillis();

        long result = 0;

        if (input != null) {

            int inputSize = input.length(); //input.length() should be even number
            int offset = inputSize / 2;

            for (int i = 0; i < inputSize; i++) {

                String current = input.substring(i, i + 1);
                String next;
                if (i + offset == inputSize - 1) {
                    next = input.substring(0, 1);
                } else {
                    next = input.substring((i + offset) % inputSize, (i + offset + 1) % inputSize);
                }

                if (current.equals(next)) {
                    result += Integer.parseInt(current); //input should contain digits only
                }
            }
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("InverseCaptcha - partTwo - out: " + result);
        System.out.printf("InverseCaptcha - partTwo - finished in %d ms \n", timeEnd - timeStart);
        return result;
    }

}
