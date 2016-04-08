package ehwaz.problem_solving.algorithm.sorting.insertionsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static ehwaz.problem_solving.util.printing.printArray;

/**
 * Created by Sangwook on 2016-04-08.
 */
public class InsertionSort {

    static void insertionSort(long[] inputArr) {
        int subArraySize = 1; // Initial subarray with size 1 is sorted, without additional moves.

        long valToSort;
        int subArrayIdx;
        while (subArraySize < inputArr.length) {
            valToSort = inputArr[subArraySize];
            subArrayIdx = subArraySize - 1;

            while (subArrayIdx >= 0 && inputArr[subArrayIdx] > valToSort) {
                inputArr[subArrayIdx + 1] = inputArr[subArrayIdx];
                subArrayIdx--;
            }

            inputArr[subArrayIdx + 1] = valToSort;
            subArraySize++;
        }
    }

    public static void runInsertionSort(InputStream istream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
        int n = Integer.parseInt(reader.readLine());   // Java does not support arrays with more than 2^31−1 elements.
        // The maximum consumption is 2 GiB of space for a byte[] array,
        // or 16 GiB of space for a long[] array.
        String numbersInLongLine = reader.readLine();
        StringTokenizer st = new StringTokenizer(numbersInLongLine, " ");
        long[] inputs = new long[n];
        int idx = 0;
        while(st.hasMoreTokens()) {
            inputs[idx] = Long.parseLong(st.nextToken());
            idx++;
        }
        System.err.println("runInsertionSort(): input reading finished.");

        insertionSort(inputs);
        System.err.println("runInsertionSort(): sorting finished.");

        printArray(inputs);
    }

    public static void main(String[] args) {
        try {
            runInsertionSort(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
