package ehwaz.problem_solving.algorithm.dynamic_programmming.mincostpath;

import java.util.*;
import java.io.*;

/**
 * Created by Sangwook on 2016-05-11.
 */
public class MinCostPath {

    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int rowSize = sc.nextInt();
        int colSize = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[rowSize][colSize];
        String row;
        StringTokenizer st;
        for  (int rowIdx = 0; rowIdx < rowSize; rowIdx++) {
            row = sc.nextLine();
            st = new StringTokenizer(row);
            for (int colIdx = 0; colIdx < colSize; colIdx++) {
                board[rowIdx][colIdx] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] memo = new int[rowSize][colSize];
        memo[0][0] = board[0][0];
        for (int i = 1; i < rowSize; i++) {
            memo[i][0] = memo[i-1][0] + board[i-1][0];
        }
        for (int j = 1; j < colSize; j++) {
            memo[0][j] = memo[0][j-1] + board[0][j];
        }
        List<Integer> minCandidates;
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                minCandidates = new ArrayList<Integer>();
                minCandidates.add(memo[i-1][j-1]);
                minCandidates.add(memo[i-1][j]);
                minCandidates.add(memo[i][j-1]);
                memo[i][j] = board[i][j] + Collections.min(minCandidates);
            }
        }
        System.out.println(memo[rowSize-1][colSize-1]);
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
