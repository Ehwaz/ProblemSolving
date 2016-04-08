package ehwaz.problem_solving.algorithm.sorting.countingsort;

import java.io.InputStream;
import java.util.Scanner;

import static ehwaz.problem_solving.util.printing.printArray;

/**
 * Created by Sangwook on 2016-04-08.
 */

public class CountingSort {
    static void countingSort(int[] inputArr) {
        int N = inputArr.length;
        int[] numberCount = new int[100];

        for (int cnt = 0; cnt < N; cnt++) {
            numberCount[inputArr[cnt]-1] += 1;
        }

        for (int cnt = 1; cnt < 100; cnt++) {
            numberCount[cnt] += numberCount[cnt-1];
        }

        int[] result = new int[N];
        for (int cnt = 0; cnt < N; cnt++) {
            int val = inputArr[cnt];
            int idx = numberCount[val-1]-1;
            numberCount[val-1] -= 1;
            result[idx] = val;
        }

        for (int cnt = 0; cnt < N; cnt++) {
            inputArr[cnt] = result[cnt];
        }
    }

    public static void runCountingSort(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int inputLen = sc.nextInt();
        sc.nextLine();

        int[] inputs = new int[inputLen];
        for (int cnt = 0; cnt < inputLen; cnt++) {
            inputs[cnt] = sc.nextInt();
        }

        countingSort(inputs);
        printArray(inputs);
    }

    public static void main(String[] args) {
        runCountingSort(System.in);
    }
}
