package day04;

import models.Day;
import util.FileHelper;

public class Day4 extends Day {

    private final char[][] INPUT;

    static final char PAPER = '@';

    public Day4(boolean practice) {
        super(4, 135, 10, practice);
        INPUT = FileHelper.readIntoArray_Char_2D(INPUT_FILE_NAME, INPUT_NUM_LINES);
    }

    public int part1() {

        int count = 0;

        for (int r = 0; r < INPUT.length; r++) {
            for (int c = 0; c < INPUT[r].length; c++) {

                // If this spot isn't a roll of paper, skip it
                if (INPUT[r][c] != PAPER) continue;

                // Check roll of paper
                if (isAccessibleByForklift(r, c, INPUT)) {
                    count++;
                }
            }
        }

        return count;
    }

    public int part2() {

        return -1;
    }

    public boolean isAccessibleByForklift(int rowIndex, int colIndex, char[][] map) {

        // Right now, the roll of paper is "accessible by the forklift" if <4 spots around it are also rolls of paper.

        // I bet that in Part 2, we have to look at any spots that are within 2 of the current position.
        // So let's just go ahead and make that a variable...
        int squareRadius = 1;

        int maxRolls = 4; // this includes the roll in the center of the square
        int adjacentRollCount = 0;

        int rowMin = Math.max(rowIndex - squareRadius, 0);
        int rowMax = Math.min(rowIndex + squareRadius, map.length - 1);
        int colMin = Math.max(colIndex - squareRadius, 0);
        int colMax = Math.min(colIndex + squareRadius, map[0].length - 1);

        for (int r = rowMin; r <= rowMax; r++) {
            for (int c = colMin; c <= colMax; c++) {
                if (map[r][c] == PAPER) {
                    adjacentRollCount++;
                }
            }
        }

        // Done going through our little area.
        return adjacentRollCount <= maxRolls;
    }
}
