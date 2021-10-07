package prac20210929;

import java.io.*;

/**
 * Solution to problem Encryption
 * https://www.hackerrank.com/challenges/encryption/problem
 */
class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {

        // remove spaces
        s = s.replaceAll("\\s+", "");

        // square root
        int len = s.length();
        double sqrt = Math.sqrt(len);

        System.out.println(String.format("s=%s, len=%d, sqrt=%f", s, len, sqrt));

        // get smallest possible row and col size
        double row = Math.floor(sqrt);
        double col = Math.ceil(sqrt);
        while (((row - 1) * col) >= len) {
            System.out.println("  reducing row");
            row--;
        }
        while ((row * col) < len) {
            System.out.println("  increasing row");
            row++;
        }

        System.out.println(String.format("  row=%f, col=%f, area=%f", row, col, row * col));

        // create output array
        char[][] output = new char[(int) row][(int) col];

        // encode the string
        int idx = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (idx < len) {
                    output[r][c] = s.charAt(idx++);
                } else {
                    output[r][c] = ' ';
                }
            }
        }

        // display whole array
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(output[r][c]);
            }
            System.out.println();
        }

        // result
        String result = "";
        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                result += output[r][c] != ' ' ? output[r][c] : "";
            }
            result += " ";
        }

        System.out.println("  result=" + result);

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

