package day02;

import models.Day;
import util.ArrayHelper;
import util.FileHelper;

import java.math.BigInteger;

public class Day2 extends Day {

    private final Long[][] INPUT;

    public Day2(boolean practice) {
        super(2, practice);

        String inputString = FileHelper.readIntoString(INPUT_FILE_NAME);
        INPUT = formatInput_Long_2D(inputString);

        ArrayHelper.printArray_2D(INPUT);
    }

    public BigInteger part1() {

        // First, let me see if I even need to use BigInteger on the input.
        // I hate using BigInteger for math ops unless it's absolutely necessary

        // BigInteger x = ArrayHelper.findBiggestNumber_Long_2D(INPUT);

        BigInteger sum = BigInteger.ZERO;
        for (Long[] range : INPUT) {

            // Inclusive of both ends
            for (long currentId = range[0]; currentId <= range[1]; currentId++) {

                if (isInvalid_Part1(currentId + "")) {
                    sum = sum.add(new BigInteger(currentId + ""));
                }
            }
        }

        return sum;
    }

    public BigInteger part2() {

        BigInteger sum = BigInteger.ZERO;
        for (Long[] range : INPUT) {

            // Inclusive of both ends
            for (long currentId = range[0]; currentId <= range[1]; currentId++) {

                if (isInvalid_Part1(currentId + "")) {
                    sum = sum.add(new BigInteger(currentId + ""));
                }
            }
        }

        return sum;
    }

    /*
     * ID which is made only of some sequence of digits repeated twice
     *
     * Oh, I didn't realize that this was ONLY the same sequence twice, no other digits.
     * That makes it easy - I'll just cut the string in half and check.
     *
     * Part 2 guess:
     * ID which is made of any sequence repeated twice,
     * with other stuff in between or at the beginning or end
     */
    public boolean isInvalid_Part1(String str) {
        if (str.length() % 2 != 0) return false;
        String firstHalf = str.substring(0, str.length() / 2);

        return firstHalf.compareTo(str.substring(str.length() / 2)) == 0;
    }

    private Long[][] formatInput_Long_2D(String stringToParse) {

        String[] stringPieces = stringToParse.split(",");
        Long[][] returnMe = new Long[stringPieces.length][2];

        for (int i = 0; i < stringPieces.length; i++) {

            String[] nums = stringPieces[i].split("-");

            returnMe[i] = new Long[2];
            returnMe[i][0] = Long.parseLong(nums[0]);
            returnMe[i][1] = Long.parseLong(nums[1]);
        }

        return returnMe;
    }
}
