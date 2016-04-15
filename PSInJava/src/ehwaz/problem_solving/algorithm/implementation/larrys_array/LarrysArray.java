package ehwaz.problem_solving.algorithm.implementation.larrys_array;

import java.io.*;
import java.util.*;

/**
 * Created by Sangwook on 2016-04-15.
 */
public class LarrysArray {
    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);

        int test_num = sc.nextInt();
        int N;
        for (int test_cnt = 0; test_cnt < test_num; test_cnt++) {
            N = sc.nextInt();
            List<Integer> inputList = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                inputList.add(sc.nextInt());
            }

            for (int val = 1; val <= N-2; val++) {
                int idxNumToMove = inputList.indexOf(val);
                while(idxNumToMove > val-1) {
                    if (idxNumToMove == N-1) {
                        int temp = inputList.get(N-3);
                        inputList.set(N-3, inputList.get(N-2));
                        inputList.set(N-2, inputList.get(N-1));
                        inputList.set(N-1, temp);
                        idxNumToMove = N-2;
                    } else {
                        int temp = inputList.get(idxNumToMove-1);
                        inputList.set(idxNumToMove-1, inputList.get(idxNumToMove));
                        inputList.set(idxNumToMove, inputList.get(idxNumToMove+1));
                        inputList.set(idxNumToMove+1, temp);
                        idxNumToMove--;
                    }
                }
            }

            if (inputList.get(N-2) > inputList.get(N-1)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
