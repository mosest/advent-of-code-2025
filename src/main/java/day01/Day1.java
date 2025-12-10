package day01;

import models.Day;
import util.FileHelper;

import java.util.ArrayList;

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

    // Hey I called the problem statement!
    public int part2() {

        //ArrayHelper.printArray_String(INPUT);

        // Manipulate the input to consolidate subsequent L and R turns.
        // We no longer have to keep them separate, since we're not counting actual "land on 0"s but "pass 0"s.
        // This consolidation helps us count passes. Now our big problem is just counting lands

        ArrayList<String> newInput = consolidateInput();

        System.out.println("NEW INPUT! WOOHOO");
        for (String s : newInput) System.out.println(s);

        // According to instructions, start at position 50 on the dial
        int position = 50;
        int count = 0;

        for (String s : newInput) {

            char direction = s.toCharArray()[0];
            int clicks = Integer.parseInt(s.substring(1));

            // If the clicks are multiple full rotations, just count the 0s and then pretend it only asked us to turn the partial rotation
            count += clicks / SPOTS_ON_DIAL;

            if (clicks / SPOTS_ON_DIAL > 0) {
                System.out.println(direction + " " + Integer.parseInt(s.substring(1)) + ": +" + clicks / SPOTS_ON_DIAL + " because of full rotations. Count is now " + count + "\n");
            }

            clicks %= SPOTS_ON_DIAL;
            if (clicks == 0) continue;

            // Turn the dial
            int newPosition = turnDial(position, direction, clicks);

            // Count times when we bounced off 0

            if (newPosition == 0) {
                count++;
                System.out.println("+1! Bounce! Count is now " + count);
            }

            // Count times when we clearly crossed it

            // We were turning left, but we ended up to the right of where we started
            if (newPosition != 0 && position != 0 && direction == 'L' && newPosition > position) {
                //System.out.println(direction + " " + Integer.parseInt(s.substring(1)) + " (" + clicks + "): Started at " + position + ", ended at " + newPosition);
                count++;
                System.out.println("+1! Count is now " + count + "\n");
            }

            // We were turning right, but we ended up to the left of where we started
            else if (newPosition != 0 && direction == 'R' && newPosition < position) {
                //System.out.println(direction + " " + Integer.parseInt(s.substring(1)) + " (" + clicks + "): Started at " + position + ", ended at " + newPosition);
                count++;
                System.out.println("+1! Count is now " + count + "\n");
            }

            position = newPosition;
        }

        return count;
    }

    // Returns the dial's position after the turn
    public int turnDial(int start, char direction, int clicks) {

        if (direction == 'L')
            clicks *= -1;

        int end = start + clicks;

        if (end < 0)
            end = SPOTS_ON_DIAL - Math.abs(end % SPOTS_ON_DIAL);

        if (end >= SPOTS_ON_DIAL)
            end %= SPOTS_ON_DIAL;

        System.out.println(direction + " " + clicks + ": Started at " + start + ", ended at " + end);

        return end;
    }

    public ArrayList<String> consolidateInput() {

        ArrayList<String> newList = new ArrayList<>();

        char currentDirection = INPUT[0].toCharArray()[0];
        int currentClicks = Integer.parseInt(INPUT[0].substring(1));

        for (int i = 1; i < INPUT.length; i++) {

            String s = INPUT[i];

            char direction = s.toCharArray()[0];
            int clicks = Integer.parseInt(s.substring(1));

            if (direction != currentDirection) {
                newList.add(currentDirection + "" + currentClicks);

                currentDirection = direction;
                currentClicks = clicks;
            } else {
                currentClicks += clicks;
            }
        }

        newList.add(currentDirection + "" + currentClicks);

        return newList;
    }
}
