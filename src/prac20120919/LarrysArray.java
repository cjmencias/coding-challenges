package prac20120919;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Solution to programming challenge Larry's Array:
 * https://www.hackerrank.com/challenges/larrys-array/problem
 */
public class LarrysArray {

    public static void main(String[] args) throws IOException {
        String inPath = "data\\prac20120919\\in.txt";
        String outPath = "data\\prac20120919\\out.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = LarrysArray.larrysArray(A);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String larrysArray(List<Integer> A) {
        String output = "YES";

        for (int i = 0; i < A.size(); ) {

            // check if the element is correct
            if (A.get(i) != i + 1) {

                // find wrong index of correct value
                int wIdx = -1;
                for (int j = i + 1; j < A.size(); j++) {
                    if (A.get(j) == i + 1) {
                        wIdx = j;
                        break;
                    }
                }

                // extract index range of ABC sub-array
                int sIdx = -1;
                int eIdx = -1;
                if (wIdx != -1) {
                    if ((wIdx - 2) >= i) {
                        sIdx = wIdx - 2;
                        eIdx = wIdx;
                    } else if ((wIdx + 1) < A.size()) {
                        sIdx = wIdx - 1;
                        eIdx = wIdx + 1;
                    }

                }

                // perform rotation
                if (sIdx != -1 && eIdx != -1) {
                    if (i + 1 == A.get(eIdx)) {
                        // clockwise
                        int temp = A.get(sIdx);
                        A.set(sIdx, A.get(eIdx));
                        A.set(eIdx, A.get(sIdx + 1));
                        A.set(sIdx + 1, temp);
                    } else {
                        // counter-clockwise
                        int temp = A.get(sIdx);
                        A.set(sIdx, A.get(sIdx + 1));
                        A.set(sIdx + 1, A.get(eIdx));
                        A.set(eIdx, temp);
                    }
                } else {
                    // nothing to rotate
                    output = "NO";
                    break;
                }

            }

            // move to the next element
            if (A.get(i) == i + 1) {
                i++;
            }

        }

        return output;
    }

}
