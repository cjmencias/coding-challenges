package prac20210925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Solution for coding challenge Extra Long Factorials:
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
public class ExtraLongFactorials {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }

}

class Result {

    public static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.valueOf(n);
        for (int i = n - 1; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }

}