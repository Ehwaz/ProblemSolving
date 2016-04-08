package ehwaz.problem_solving.algorithm.sorting.quicksort;

import groovy.json.internal.CharBuf;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.testng.Assert.*;

/**
 * Created by Sangwook on 2016-04-08.
 */
public class QuickSortTest {
    private FileInputStream istream;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Path outputFilePath;
    PrintStream original = System.out;
    long elapsedTime;

    private final String INPUT_FILE_PATH = "src/ehwaz/problem_solving/algorithm/sorting/testcases/len400_less1000_input.txt";
    private final String OUTPUT_FILE_PATH = "src/ehwaz/problem_solving/algorithm/sorting/testcases/len400_less1000_output.txt";

    @BeforeMethod
    public void setUp() throws Exception {
        istream = new FileInputStream(INPUT_FILE_PATH);

        outputFilePath = Paths.get(OUTPUT_FILE_PATH);
        System.setOut(new PrintStream(outContent));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.setOut(original);
        istream.close();

        // Print after stdout is restored.
        System.out.println("\nSolution took " + Long.toString(elapsedTime)  + "ms to run.");
    }

    @Test
    public void testRunQuickSort() throws Exception {
        long startTime, stopTime;
        startTime = System.currentTimeMillis();

        QuickSort.runQuickSort(istream);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        String answer = new String(Files.readAllBytes(outputFilePath)).trim();
        String result = outContent.toString().trim();
        answer = answer.replaceAll("\\r", "");  // Actually, there's no CR in answer string- at least not in HackerRank's.
        result = result.replaceAll("\\r", "");  // Remove carrige return from the result

        Assert.assertEquals(result, answer);
    }
}