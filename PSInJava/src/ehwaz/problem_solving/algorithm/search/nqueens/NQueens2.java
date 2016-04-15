package ehwaz.problem_solving.algorithm.search.nqueens;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sangwook on 2016-04-15.
 */

// When N=13, it took 2344 msec in my desktop. (slower than NQueens solution 1)
// When N=9, it took 7 msec in my desktop. (faster than NQueens solution 2)
public class NQueens2 {
    static List<List<String>> results;
    static int N;

    public static void generateBoard(char[][] board) {
        List<String> curResult = new ArrayList<String>();
        StringBuilder row;  // !!!: Don't forget to use StringBuilder!! if not, solution times out!!
        for (int rowIdx = 0; rowIdx < N; rowIdx++) {
            row = new StringBuilder();
            for (int colIdx = 0; colIdx < N; colIdx++) {
                row.append(board[rowIdx][colIdx]);
            }
            curResult.add(row.toString());
        }
        results.add(curResult);
    }

    // Overhead of checking through all boards gets bigger if board size increases.
    public static boolean isPositionValid(int posRowIdx, int posColIdx, char[][] board) {
        for(int rowIdx = 0; rowIdx < posRowIdx; rowIdx++) {
            for(int colIdx = 0; colIdx < N; colIdx++) {
                if(board[rowIdx][colIdx] == 'Q' &&
                        // This condition is reallllly cool!!!
                        (posRowIdx + colIdx == rowIdx + posColIdx ||
                                posRowIdx + posColIdx == rowIdx + colIdx ||
                                colIdx == posColIdx)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void search(int rowIdx, char[][] board) {
        if (rowIdx == N) {
            generateBoard(board);
        } else {
            for (int colIdx = 0; colIdx < N; colIdx++) {
                if (isPositionValid(rowIdx, colIdx, board)) {
                    board[rowIdx][colIdx] = 'Q';
                    search(rowIdx+1, board);
                    board[rowIdx][colIdx] = '.';
                }
            }
        }
    }

    // Function format for Leetcode online judge.
    public List<List<String>> solveNQueens(int n) {
        N = n;
        results = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int rowIdx = 0; rowIdx < n; rowIdx++) {
            for (int colIdx = 0; colIdx < N; colIdx++) {
                board[rowIdx][colIdx] = '.';
            }
        }

        search(0, board);

        return results;
    }

    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);
        N = sc.nextInt();
        results = new ArrayList<List<String>>();
        char[][] board = new char[N][N];
        for (int rowIdx = 0; rowIdx < N; rowIdx++) {
            for (int colIdx = 0; colIdx < N; colIdx++) {
                board[rowIdx][colIdx] = '.';
            }
        }

        long startTime, stopTime;
        startTime = System.currentTimeMillis();
        search(0, board);
        stopTime = System.currentTimeMillis();
        System.out.println("NQueen solution #2 with board size of " + N + " took " + Long.toString(stopTime - startTime)  + "ms to run.");

        for (List<String> aResult : results) {
            for (String row : aResult) {
                System.out.println(row);
            }
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
