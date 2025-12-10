package models;

public class Day {

    public final boolean IS_PRACTICE;
    public final String INPUT_FILE_NAME;
    public final int INPUT_NUM_LINES;

    public Day(int dayNumber, int puzzleInputNumLines, int practiceInputNumLines, boolean practice) {

        String twoDigitDayNumber = String.format("%02d", dayNumber);

        String inputFileName = "day" + twoDigitDayNumber + ".txt";
        String practiceInputFileName = "day" + twoDigitDayNumber + "-practice.txt";

        IS_PRACTICE = practice;
        if (practice) {
            INPUT_FILE_NAME = practiceInputFileName;
            INPUT_NUM_LINES = practiceInputNumLines;
        } else {
            INPUT_FILE_NAME = inputFileName;
            INPUT_NUM_LINES = puzzleInputNumLines;
        }
    }

    public Day(int dayNumber, boolean practice) {

        String twoDigitDayNumber = String.format("%02d", dayNumber);

        String inputFileName = "day" + twoDigitDayNumber + ".txt";
        String practiceInputFileName = "day" + twoDigitDayNumber + "-practice.txt";

        IS_PRACTICE = practice;
        if (practice) {
            INPUT_FILE_NAME = practiceInputFileName;
            INPUT_NUM_LINES = 0;
        } else {
            INPUT_FILE_NAME = inputFileName;
            INPUT_NUM_LINES = 0;
        }
    }
}
