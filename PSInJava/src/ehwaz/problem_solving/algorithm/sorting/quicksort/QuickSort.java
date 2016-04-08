package ehwaz.problem_solving.algorithm.sorting.quicksort;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static ehwaz.problem_solving.util.printing.printArray;

/**
 * Created by Sangwook on 2016-04-07.
 */
public class QuickSort {
    static int partition(long[] ar, int start, int end) {
        int pivotIndex = end;
        long pivot = ar[pivotIndex];
        int smallerBorder = start-1;  // Start index of border is one ahead.

        long curVal;
        for (int i = start; i <= end-1; i++) {
            if (ar[i] <= pivot) {
                smallerBorder++;

                curVal = ar[i];
                ar[i] = ar[smallerBorder];
                ar[smallerBorder] = curVal;
            }
        }

        int borderIndex = smallerBorder+1;

        long temp = ar[borderIndex];
        ar[borderIndex] = pivot;
        ar[pivotIndex] = temp;

        return borderIndex;
    }

    public static void quickSort(long[] ar, int start, int end) {
        if (start < end) {
            int borderIndex = partition(ar, start, end);

            quickSort(ar, start, borderIndex-1);
            quickSort(ar, borderIndex+1, end);
        }
    }

    public static void runQuickSort(InputStream istream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
        int n = Integer.parseInt(reader.readLine());   // Java does not support arrays with more than 2^31−1 elements.
                                // The maximum consumption is 2 GiB of space for a byte[] array,
                                // or 16 GiB of space for a long[] array.
        String numbersInLongLine = reader.readLine();
        StringTokenizer st = new StringTokenizer(numbersInLongLine, " ");
        long[] ar = new long[n];
        int idx = 0;
        while(st.hasMoreTokens()) {
            ar[idx] = Long.parseLong(st.nextToken());
            idx++;
        }
        System.err.println("runQuickSort(): input reading finished.");

        quickSort(ar, 0, n-1);
        System.err.println("runQuickSort(): sorting finished.");

        printArray(ar);
    }

    public static void main(String[] args) {
        try {
            runQuickSort(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
