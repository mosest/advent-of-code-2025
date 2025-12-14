package day03;

import models.Day;
import util.ArrayHelper;
import util.FileHelper;

import java.math.BigInteger;
import java.util.Arrays;

public class Day3 extends Day {

    private final String[] INPUT;

    public Day3(boolean practice) {
        super(3, 200, 4, practice);
        INPUT = FileHelper.readIntoArray_String(INPUT_FILE_NAME, INPUT_NUM_LINES);
        //ArrayHelper.printArray(INPUT);
    }

    public BigInteger part1() {

        BigInteger sum = BigInteger.ZERO;

        for (String bank : INPUT) {
            BigInteger joltage = getJoltage_Part1(bank, 2);
            sum = sum.add(joltage);
        }

        return sum;
    }

    public BigInteger part2() {

        BigInteger sum = BigInteger.ZERO;

        for (String bank : INPUT) {
            BigInteger joltage = getJoltage_Part1(bank, 12);
            sum = sum.add(joltage);
        }

        return sum;
    }

    /*
     * It sounds like a battery is only 1-9 joltage for now - so we don't have to put it into a Battery model
     *
     * Part 2 Guess:
     * Maybe in Part 2, you can choose like 10 batteries instead of 2? So maybe instead of calculating A*10 + B, we should make this a summation
     *
     * Okay original plan didn't work. I didn't clock this as a recursion problem upon the first read! SURPRISE RECURSION.
     */
    public BigInteger getJoltage_Part1(String bank, int numDigits) {

        System.out.println();
        System.out.println(bank + " with " + bank.length() + " digits");
        System.out.println();

        return recurse(0, bank.length() - (numDigits - 1), 0, BigInteger.ZERO, numDigits, bank);
    }

    // It's a walking window function.
    public BigInteger recurse(int startIndex, int endIndexExclusive, int depth, BigInteger sum, int unchanging_numDigits, String unchanging_fullString) {

        // base case 1: there aren't enough inputs
        if (endIndexExclusive > unchanging_fullString.length()) return sum; // If we have reached the end of the string
        if (depth >= unchanging_numDigits) return sum;                        // If we have gotten all the digits we need

        // base case 2: the rest of the input is exactly the number of digits we still need
        String rightHalfOfString = unchanging_fullString.substring(startIndex);

        if ((unchanging_numDigits - depth) == rightHalfOfString.length()) {
            sum = sum.add(new BigInteger(rightHalfOfString));
            return sum;
        }

        // recursive case
        String window = unchanging_fullString.substring(startIndex, endIndexExclusive);
        char[] chars = window.toCharArray();
        Arrays.sort(chars);

        int aAsciiVal = chars[chars.length - 1];
        int aIndex = startIndex + window.indexOf((char)aAsciiVal);

        // update the changing variables
        startIndex = aIndex + 1;
        endIndexExclusive++;

        // if we need 3 digits and depth is 1, then sum needs to be += a * 100
        long digitMultiplier = (long) Math.pow(
                10,
                unchanging_numDigits - depth - 1);

        // ASCII value of character '1' is 49
        sum = sum.add(BigInteger.valueOf((aAsciiVal - 48) * digitMultiplier));

        depth++;

        // recurse
        return recurse(startIndex, endIndexExclusive, depth, sum, unchanging_numDigits, unchanging_fullString);
    }
}
