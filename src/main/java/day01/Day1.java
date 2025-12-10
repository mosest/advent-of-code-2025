package day01;

import models.Day;
import util.ArrayHelper;
import util.FileHelper;

public class Day1 extends Day {

    private final String[] INPUT;
    private final int SPOTS_ON_DIAL = 100;

    public Day1(boolean practice) {
        super(1, 4099, 10, practice);
        INPUT = FileHelper.readIntoArray_String(INPUT_FILE_NAME, INPUT_NUM_LINES);
    }

    public int part1() {

        //ArrayHelper.printArray_String(INPUT);

        // According to instructions, start at position 50 on the dial
        int position = 50;
        int count = 0;

        for (String s : INPUT) {

            char direction = s.toCharArray()[0];
            int clicks = Integer.parseInt(s.substring(1));

            // Turn the dial
            position = turnDial(position, direction, clicks);

            // In Part 1, count the number of times that the dial points DIRECTLY AT 0.
            // I suspect that Part 2 will want me to count the number of times the dial CROSSES 0. We will see!
            if (position == 0) count++;
        }

        return count;
    }

    public int part2() {
        return -1;
    }

    // Returns the dial's position after the turn
    public int turnDial(int start, char direction, int clicks) {

        if (direction == 'L')
            clicks *= -1;

        int end = start + clicks;

        if (end < 0)
            end = SPOTS_ON_DIAL - Math.abs(end);

        if (end >= SPOTS_ON_DIAL)
            end %= SPOTS_ON_DIAL;

        System.out.println(direction + " " + clicks + ": Started at " + start + ", ended at " + end);

        return end;
    }
}
