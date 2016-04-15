package ehwaz.problem_solving.algorithm.dynamic_programmming.fibonaccimodified;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 * Created by Sangwook on 2016-04-14.
 */
public class FibonacciModified {
    static BigInteger[] results;
    static BigInteger A;
    static BigInteger B;

    public static BigInteger getCustomFibo(int count) {
        if (count == 3) {
            results[2] = B.pow(2).add(A);
            return results[2];
        } else if (count == 2) {
            return B;
        } else {
            BigInteger valMinusOne = (results[count - 2] != null) ? results[count - 2] : getCustomFibo(count - 1);
            BigInteger valMinusTwo = (results[count - 3] != null) ? results[count - 3] : getCustomFibo(count - 2);

            results[count-1] = valMinusOne.pow(2).add(valMinusTwo);
            return results[count-1];
        }
    }

    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);
        A = new BigInteger(Integer.toString(sc.nextInt()));
        B = new BigInteger(Integer.toString(sc.nextInt()));
        int N = sc.nextInt();

        results = new BigInteger[N];

        BigInteger result = getCustomFibo(N);
        System.out.println(result);
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
