package prac20211007;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Solution to problem The Time In Words
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        String result = "";
        List<String> words = Arrays.asList("", "one", "two", "three",
                "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "quarter",
                "sixteen", "seventeen", "eighteen", "ninteen", "twenty",
                "twenty one", "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven", "twenty eight",
                "twenty nine");

        if (m == 0) {
            result += words.get(h);
            result += " o' clock";
        } else if (m == 1) {
            result += words.get(m);
            result += " minute past ";
            result += words.get(h);
        } else if (m == 15) {
            result += words.get(m);
            result += " past ";
            result += words.get(h);
        } else if (m == 30) {
            result += "half past ";
            result += words.get(h);
        } else if (m == 45) {
            result += "quarter to ";
            result += words.get(h + 1);
        } else if (m < 30) {
            result += words.get(m);
            result += " minutes past ";
            result += words.get(h);
        } else {
            result += words.get(60 - m);
            result += " minutes to ";
            result += words.get(h + 1);
        }

        System.out.println(String.format("h=%d, m=%d", h, m));
        System.out.println("  result=" + result);

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
