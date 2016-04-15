package ehwaz.problem_solving.algorithm.search.nqueens;

import java.io.*;
import java.util.*;

/**
 * Created by Sangwook on 2016-04-15.
 */

// When N=13, it took 1943 msec in my desktop. (faster than NQueens solution 2)
// When N=9, it took 10 msec in my desktop. (slower than NQueens solution 2)
public class NQueens1 {
    static List<List<String>> results;
    static int N;

    public static void generateBoard(List<Integer> positions) {
        List<String> curResult = new ArrayList<String>();
        StringBuilder row;  // !!!: Don't forget to use StringBuilder!! if not, solution times out!!
        for (int queenColIdx : positions) {
            row = new StringBuilder();
            for (int idx = 0; idx < N; idx++) {
                if (idx == queenColIdx) { row.append("Q"); }
                else { row.append("."); }
            }
            curResult.add(row.toString());
        }
        results.add(curResult);
    }

    // Mark unavailable positions in the board.
    // Marking valid position & copying boards in each recursive call slows down execution.
    public static void markInvalidPositions(int queenRowIdx, int queenColIdx, List<int[]> board) {
        board.get(queenRowIdx)[queenColIdx] = -1;

        // It is sufficient to mark rows after queenRowIdx row.
        int offset, leftColIdx, rightColIdx;
        for (int rowIdx = queenRowIdx + 1; rowIdx < N; rowIdx++) {
            board.get(rowIdx)[queenColIdx] = -1;

            offset = rowIdx - queenRowIdx;
            leftColIdx = queenColIdx - offset;
            rightColIdx = queenColIdx + offset;
            if (leftColIdx >= 0) { board.get(rowIdx)[leftColIdx] = -1; }
            if (rightColIdx < N ) { board.get(rowIdx)[rightColIdx] = -1; }
        }
    }

    public static void putQueenInRow(int rowIdx, List<Integer> positions, List<int[]> board) {
        List<Integer> queenPositions;
        List<int[]> newBoard;

        if (rowIdx == 0) {
            for (int colIdx = 0; colIdx < N; colIdx++) {
                queenPositions = new ArrayList<Integer>();
                queenPositions.add(colIdx);

                newBoard = new ArrayList<int[]>();
                for (int rowCnt = 0; rowCnt < N; rowCnt++) {
                    newBoard.add(new int[N]);
                }

                markInvalidPositions(rowIdx, colIdx, newBoard);

                putQueenInRow(1, queenPositions, newBoard);
            }
        } else if (rowIdx == N) {
            generateBoard(positions);
        } else {
            for (int colIdx = 0; colIdx < N; colIdx++) {
                if (board.get(rowIdx)[colIdx] != -1) {
                    queenPositions = new ArrayList<Integer>(positions); // Clone the positions so far.
                    queenPositions.add(colIdx);

                    newBoard = new ArrayList<int[]>();
                    for (int rowCnt = 0; rowCnt < N; rowCnt++) {
                        newBoard.add(Arrays.copyOf(board.get(rowCnt), N)); // Clone the boards.
                    }
                    markInvalidPositions(rowIdx, colIdx, newBoard);
                    putQueenInRow(rowIdx+1, queenPositions, newBoard);
                }
            }
        }
    }

    // Function format for Leetcode online judge.
    public List<List<String>> solveNQueens(int n) {
        N = n;
        results = new ArrayList<List<String>>();

        putQueenInRow(0, null, null);

        return results;
    }

    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);
        N = sc.nextInt();
        results = new ArrayList<List<String>>();

        long startTime, stopTime;
        startTime = System.currentTimeMillis();
        putQueenInRow(0, null, null);
        stopTime = System.currentTimeMillis();
        System.out.println("NQueen solution #1 with board size of " + N + " took " + Long.toString(stopTime - startTime)  + "ms to run.");

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
