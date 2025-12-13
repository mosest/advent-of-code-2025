package days;

import day03.Day3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Day3Tests {

    public static final boolean USING_PRACTICE_INPUT = true;
    public static final boolean USING_PUZZLE_INPUT = false;

    @Test
    public void Day3_Part1_Practice() {
        int actual = new Day3(USING_PRACTICE_INPUT)
                .part1();

        assertEquals(357, actual);
    }

    @Test
    public void Day3_Part1_Puzzle() {
        int actual = new Day3(USING_PUZZLE_INPUT)
                .part1();

        assertEquals(17109, actual);
    }

    @Test
    public void Day3_Part2_Practice() {
        int actual = new Day3(USING_PRACTICE_INPUT)
                .part2();

        assertEquals(-1, actual);
    }

    @Test
    public void Day3_Part2_Puzzle() {
        int actual = new Day3(USING_PUZZLE_INPUT)
                .part2();

        assertEquals(-1, actual);
    }

    @ParameterizedTest
    @MethodSource("bankAndJoltage_Part1")
    public void GetJoltage_Part1(String bank, int expectedMaxJoltage) {
        Day3 day3 = new Day3(USING_PRACTICE_INPUT); // input doesn't matter for this test
        int actualMaxJoltage = day3.getJoltage_Part1(bank, 2);

        assertEquals(expectedMaxJoltage, actualMaxJoltage);
    }

    static Stream<Arguments> bankAndJoltage_Part1() {
        return Stream.of(
                Arguments.of("987654321111111", 98),
                Arguments.of("811111111111119", 89),
                Arguments.of("234234234234278", 78),
                Arguments.of("818181911112111", 92),
                Arguments.of("111111111111139", 39)
        );
    }
}