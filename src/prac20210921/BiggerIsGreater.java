package prac20210921;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Solution to programming challenge Bigger is Greater:
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */
public class BiggerIsGreater {

    public static void main(String[] args) throws IOException {
        final String INPUT_PATH = "data\\prac20210921\\in.txt";
        final String OUTPUT_PATH = "data\\prac20210921\\out.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();
                String result = Result.biggerIsGreater(w);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    public static String biggerIsGreater(String w) {
        // start processing from the second to the last character
        char[] arr = w.toCharArray();
        for (int i = arr.length - 2; i >= 0; ) {

            // find the next higher value
            int idx = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j] && (idx == -1 || arr[j] < arr[idx])) {
                    idx = j;
                }
            }

            if (idx != -1) {

                // swap
                char temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;

                // sort all characters from the right
                char[] arr2 = new String(arr).substring(i + 1).toCharArray();
                Arrays.sort(arr2);

                // replace
                int j = i + 1;
                for (char item : arr2) {
                    arr[j++] = item;
                }

                // result
                return new String(arr);
            }


            // try next character
            i--;

        }
        return "no answer";
    }

}
