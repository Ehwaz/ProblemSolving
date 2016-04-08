package ehwaz.problem_solving.algorithm.sorting.testcases;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static ehwaz.problem_solving.algorithm.sorting.quicksort.QuickSort.quickSort;
/**
 * Created by Sangwook on 2016-04-08.
 */
public class GetBaseResult {
    private static final String TESTCASE_DIR_PATH = "src/ehwaz/problem_solving/algorithm/sorting/testcases/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("InputFileName? :");
        String inputFileName = sc.nextLine();

        try {
            String inputFilePath = TESTCASE_DIR_PATH + inputFileName;
            String outputFilePath = TESTCASE_DIR_PATH + inputFileName.replaceFirst("input", "output");
            BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFilePath));

            int n = Integer.parseInt(inputFileReader.readLine());
            String numberInLongLine = inputFileReader.readLine();

            StringTokenizer st = new StringTokenizer(numberInLongLine);
            long[] ar = new long[n];
            int idx = 0;
            while(st.hasMoreTokens()) {
                ar[idx] = Long.parseLong(st.nextToken());
                idx++;
            }
            System.out.println("Input reading done.");

            // XXX: in-place version of QuickSort is not stable.
            //      If you need stable sorted result, use another sorting algorithm.(ex. MergeSort)
            quickSort(ar, 0, n-1);
            System.out.println("Sorting done.");

            for(int i = 0;i < n; i++){
                outputFileWriter.write(Long.toString(ar[i]));
                if (i != n-1) {
                    outputFileWriter.write(" ");
                }
            }
            outputFileWriter.close();
            System.out.println("Result written to output file.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
