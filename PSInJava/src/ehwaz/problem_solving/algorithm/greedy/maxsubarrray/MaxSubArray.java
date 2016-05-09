package ehwaz.problem_solving.algorithm.greedy.maxsubarrray;

import java.io.*;
import java.util.*;

/**
 * Created by Sangwook on 2016-05-06.
 */
public class MaxSubArray {
    public static void solve(Scanner sc) {
        int valNum = Integer.parseInt(sc.nextLine());
        int start = 0;
        int end = 0;
        int curVal;

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        int maxSoFar = Integer.parseInt(st.nextToken());
        int maxEndingHere = maxSoFar;
        for (int valCnt = 1; valCnt < valNum; valCnt++) {
            curVal = Integer.parseInt(st.nextToken());
            // Subproblem: maximum subarray of 0 ~ N is maximum subarray of 0 ~ (N-1) or,
            //              (value in N) + (maximum subarray ends in index N-1).
            if (curVal < maxEndingHere + curVal) {
                maxEndingHere = maxEndingHere + curVal;
            } else {
                maxEndingHere = curVal;
                if (maxSoFar < maxEndingHere) {
                    start = valCnt;
                }
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = valCnt;
            }
        }
        System.out.println("MaxVal: " + maxSoFar + ", Idx: " + start + " to " + end);
    }

    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int testNum = Integer.parseInt(sc.nextLine());
        for (int testCnt = 0; testCnt < testNum; testCnt++) {
            solve(sc);
        }
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
