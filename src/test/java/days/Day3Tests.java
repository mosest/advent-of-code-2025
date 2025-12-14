package days;

import day03.Day3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Day3Tests {

    public static final boolean USING_PRACTICE_INPUT = true;
    public static final boolean USING_PUZZLE_INPUT = false;

    @Test
    public void Day3_Part1_Practice() {
        BigInteger actual = new Day3(USING_PRACTICE_INPUT)
                .part1();

        assertEquals(new BigInteger("357"), actual);
    }

    @Test
    public void Day3_Part1_Puzzle() {
        BigInteger actual = new Day3(USING_PUZZLE_INPUT)
                .part1();

        assertEquals(new BigInteger("17109"), actual);
    }

    @Test
    public void Day3_Part2_Practice() {
        BigInteger actual = new Day3(USING_PRACTICE_INPUT)
                .part2();

        assertEquals(new BigInteger("3121910778619"), actual);
    }

    @Test
    public void Day3_Part2_Puzzle() {
        BigInteger actual = new Day3(USING_PUZZLE_INPUT)
                .part2();

        assertEquals(new BigInteger("1"), actual);
    }

    @ParameterizedTest
    @MethodSource("bankAndJoltage_2Digits")
    public void GetJoltage_2Digits(String bank, BigInteger expected) {

        Day3 day3 = new Day3(USING_PRACTICE_INPUT); // input doesn't matter for this test

        BigInteger actual = day3.getJoltage_Part1(bank, 2);

        assertEquals(expected.longValue(), actual.longValue());
    }

    static Stream<Arguments> bankAndJoltage_2Digits() {
        return Stream.of(
                Arguments.of("987654321111111", new BigInteger("98")),
                Arguments.of("811111111111119", new BigInteger("89")),
                Arguments.of("234234234234278", new BigInteger("78")),
                Arguments.of("818181911112111", new BigInteger("92")),
                Arguments.of("111111111111139", new BigInteger("39"))
        );
    }

    @ParameterizedTest
    @MethodSource("bankAndJoltage_12Digits")
    public void GetJoltage_12Digits(String bank, BigInteger expected) {

        Day3 day3 = new Day3(USING_PRACTICE_INPUT);

        BigInteger actual = day3.getJoltage_Part1(bank, 12);

        assertEquals(expected.longValue(), actual.longValue());
    }

    static Stream<Arguments> bankAndJoltage_12Digits() {
        return Stream.of(
                Arguments.of("987654321111111", new BigInteger("987654321111")),
                Arguments.of("811111111111119", new BigInteger("811111111119")),
                Arguments.of("234234234234278", new BigInteger("434234234278")),
                Arguments.of("818181911112111", new BigInteger("888911112111"))
        );
    }
}