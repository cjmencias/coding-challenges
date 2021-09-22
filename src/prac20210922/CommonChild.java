package prac20210922;

import java.io.*;

/**
 * Solution to programming challenge Common Child
 * https://www.hackerrank.com/challenges/common-child/problem
 */
public class CommonChild {

    public static void main(String[] args) throws IOException {
        final String INPUT_PATH = "data\\prac20210922\\in-3.txt";
        final String OUTPUT_PATH = "data\\prac20210922\\out.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH));
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        int result = Result.commonChild(s1, s2);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    public static int commonChild(String s1, String s2) {
        int[][] table = new int[s2.length() + 1][ s1.length() + 1];

        // using algorithm for "Longest Common Subsequence"
        for (int r = 1; r < table.length; r++) {
            for (int c = 1; c < table[r].length; c++) {
                if (s2.charAt(r - 1) == s1.charAt(c - 1)) {
                    table[r][c] = table[r - 1][c - 1] + 1;
                } else {
                    table[r][c] = Math.max(table[r][c - 1], table[r - 1][c]);
                }
            }
        }

        return table[s2.length()][ s1.length()];
    }

}