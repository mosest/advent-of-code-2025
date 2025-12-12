package days;

import day02.Day2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class Day2Tests {

    public static final boolean USING_PRACTICE_INPUT = true;
    public static final boolean USING_PUZZLE_INPUT = false;

    @Test
    public void Day2_Part1_Practice() {
        BigInteger actual = new Day2(USING_PRACTICE_INPUT)
                .part1();

        assertEquals(new BigInteger("1227775554"), actual);
    }

    @Test
    public void Day2_Part1_Puzzle() {
        BigInteger actual = new Day2(USING_PUZZLE_INPUT)
                .part1();

        assertEquals(new BigInteger("26255179562"), actual);
    }

    @Test
    public void Day2_Part2_Practice() {
        BigInteger actual = new Day2(USING_PRACTICE_INPUT)
                .part2();

        assertEquals(new BigInteger("3"), actual);
    }

    @Test
    public void Day2_Part2_Puzzle() {
        BigInteger actual = new Day2(USING_PUZZLE_INPUT)
                .part2();

        assertEquals(new BigInteger("3"), actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "11",           // 1 repeated digit
            "2323",         // 2 repeated digits
            "446446",       // 3 repeated digits
            "38593859",     // 4 repeated digits
            "1188511885"})  // 5 repeated digits
    public void isInvalid_Part1_ReturnsTrue(String input) {
        Day2 day2 = new Day2(USING_PRACTICE_INPUT); // input doesn't matter for this test

        assertTrue(day2.isInvalid_Part1(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "141",
            "23423",
            "4461446",
            "3859385900",
            "118851188522"})
    public void isInvalid_Part1_ReturnsFalse(String input) {
        Day2 day2 = new Day2(USING_PRACTICE_INPUT); // input doesn't matter for this test

        assertFalse(day2.isInvalid_Part1(input));
    }
}