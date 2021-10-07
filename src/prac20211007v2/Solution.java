package prac20211007v2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Solution to problem Organizing Containers of Balls
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 */
class Result {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        System.out.println();

        // get sum for each container and type
        List<Integer> cSum = new ArrayList();
        List<Integer> tSum = new ArrayList();
        for (int i = 0; i < container.size(); i++) {

            // sum of each container
            int sum = container.get(i).stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
            cSum.add(sum);

            // sum of each type
            sum = 0;
            for (int j = 0; j < container.size(); j++) {
                sum += container.get(j).get(i);
            }
            tSum.add(sum);
        }
        System.out.println("cSum=" + cSum);
        System.out.println("tSum=" + tSum);

        // sort
        Collections.sort(cSum);
        Collections.sort(tSum);

        System.out.println("sorted:");
        System.out.println("cSum=" + cSum);
        System.out.println("tSum=" + tSum);

        for (int i = 0; i < cSum.size(); i++) {
            int v1 = cSum.get(i);
            int v2 = tSum.get(i);
            boolean result = v1 != v2;
            if (result) {
                System.out.println("v1=" + v1 + ", v2=" + v2 + ", result=" + result);
                return "Impossible";
            }
        }

        return "Possible";
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

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
