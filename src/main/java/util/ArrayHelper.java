package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.SequencedCollection;

public class ArrayHelper {

    /*
     * Tara, remember that you can't use primitive types here
     */
    public static <T>void printArray(T[] array) {

        for (T n : array) {
            System.out.println(n);
        }
    }

    /*
     * Tara, remember that you can't use primitive types here
     */
    public static <T>void printArray_2D(T[][] array) {

        for (T[] row : array) {
            for (T col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void printArray_Char_2D(char[][] array) {

        for (char[] row : array) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static <T>void printList(SequencedCollection<T> items) {

        for (T item : items) {
            System.out.println(item);
        }
    }

    public static List<String> transform2DCharIntoStringList_Diagonally_ForwardSlash(char[][] chars) {

        List<String> diagonalStrings = new ArrayList<>();

        // start at SW and go along left border, then top border, to NE
        for (int r = 0; r < chars.length; r++) {
            for (int c = 0; c < chars[r].length; c++) {

                if (r == 0 || c == 0) {

                    // If we're at the top row or the leftmost column, go get that diagonal.
                    StringBuilder diagonalString = new StringBuilder();

                    int dr = r;
                    int dc = c;

                    do {
                        diagonalString.append(chars[dr][dc]);
                        dr++;
                        dc++;
                    } while (dr < chars.length && dc < chars[dr].length);

                    diagonalStrings.add(diagonalString.toString());
                }
            }
        }

        return diagonalStrings;
    }

    public static List<String> transform2DCharIntoStringList_Diagonally_Backslash(char[][] chars) {

        List<String> diagonalStrings = new ArrayList<>();

        // start at SE and go along bottom border, then left border, to NW
        for (int r = 0; r < chars.length; r++) {
            for (int c = 0; c < chars[r].length; c++) {

                if (r == chars.length - 1 || c == 0) {

                    // If we're at the top row or the leftmost column, go get that diagonal.
                    StringBuilder diagonalString = new StringBuilder();

                    int dr = r;
                    int dc = c;

                    do {
                        diagonalString.append(chars[dr][dc]);
                        dr--;
                        dc++;
                    } while (dr >= 0 && dc < chars[dr].length);

                    diagonalStrings.add(diagonalString.toString());
                }
            }
        }

        return diagonalStrings;
    }

    public static BigInteger findBiggestNumber_BigInteger_2D(BigInteger[][] bigIntegers) {
        BigInteger biggest = bigIntegers[0][0];
        for (BigInteger[] row : bigIntegers) {
            for (BigInteger rowItem : row) {
                if (rowItem.compareTo(biggest) > 0)
                    biggest = rowItem;
            }
        }
        return biggest;
    }
}
