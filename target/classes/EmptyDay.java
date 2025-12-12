package day02;

import models.Day;
import util.FileHelper;

public class EmptyDay extends Day {

    private final String[] INPUT;

    public EmptyDay(boolean practice) {
        super(2, 4099, 10, practice);
        INPUT = FileHelper.readIntoArray_String(INPUT_FILE_NAME, INPUT_NUM_LINES);
    }

    public int part1() {

        return -1;
    }

    public int part2() {

        return -1;
    }
}
