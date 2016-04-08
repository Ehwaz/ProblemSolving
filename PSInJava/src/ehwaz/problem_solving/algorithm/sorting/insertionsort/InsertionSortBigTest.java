package ehwaz.problem_solving.algorithm.sorting.insertionsort;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class InsertionSortBigTest {
    private FileInputStream istream;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Path outputFilePath;
    PrintStream original = System.out;
    long elapsedTime;

    private final String INPUT_FILE_PATH = "src/ehwaz/problem_solving/algorithm/sorting/testcases/len1000000_less5000_bigger-5000_input.txt";
    private final String OUTPUT_FILE_PATH = "src/ehwaz/problem_solving/algorithm/sorting/testcases/len1000000_less5000_bigger-5000_output.txt";

    @BeforeTest
    public void setUp() throws Exception {
        istream = new FileInputStream(INPUT_FILE_PATH);

        outputFilePath = Paths.get(OUTPUT_FILE_PATH);
        System.setOut(new PrintStream(outContent));
    }

    @AfterTest
    public void tearDown() throws Exception {
        // Tears down the fixture, for example, close a network connection.
        // This method is called after a test is executed.
        // Asserting in tearDown() is generally a bad idea.
        System.setOut(original);
        istream.close();

        // Print after stdout is restored.
        System.out.println("\nSolution took " + Long.toString(elapsedTime)  + "ms to run.");
    }

    @Test
    public void testSolveProb() throws Exception {
        long startTime, stopTime;
        startTime = System.currentTimeMillis();

        InsertionSort.runInsertionSort(istream);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        String answer = new String(Files.readAllBytes(outputFilePath)).trim();
        String result = outContent.toString().trim();
        answer = answer.replaceAll("\\r", "");  // Actually, there's no CR in answer string- at least not in HackerRank's.
        result = result.replaceAll("\\r", "");  // Remove carrige return from the result

        Assert.assertEquals(result, answer);
    }
}