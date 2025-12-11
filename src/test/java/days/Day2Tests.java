package days;

import day02.Day2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Day2Tests {

    public static final boolean USING_PRACTICE_INPUT = true;
    public static final boolean USING_PUZZLE_INPUT = false;

    @Test
    public void Day2_Part1_Practice() {
        int actual = new Day2(USING_PRACTICE_INPUT)
                .part1();

        assertEquals(3, actual);
    }

    @Test
    public void Day2_Part1_Puzzle() {
        int actual = new Day2(USING_PUZZLE_INPUT)
                .part1();

        assertEquals(989, actual);
    }

    @Test
    public void Day2_Part2_Practice() {
        int actual = new Day2(USING_PRACTICE_INPUT)
                .part2();

        assertEquals(6, actual);
    }

    @Test
    public void Day2_Part2_Puzzle() {
        int actual = new Day2(USING_PUZZLE_INPUT)
                .part2();

        assertEquals(5941, actual);
    }
}