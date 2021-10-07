package prac20210922p2;

import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Solution to problem Find Digits
 * https://www.hackerrank.com/challenges/find-digits/problem
 */
public class FindDigits {

    public static void main(String[] args) throws IOException {
        final String INPUT_PATH = "data\\prac20210922p2\\in0.txt";
        final String OUTPUT_PATH = "data\\prac20210922p2\\out.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    class Result {
        public static int findDigits(int n) {
            return (int) Stream.of(String.valueOf(n).split(""))
                    .mapToInt(Integer::parseInt)
                    .filter(x -> x > 0 && n % x == 0)
                    .count();
        }
    }
}
