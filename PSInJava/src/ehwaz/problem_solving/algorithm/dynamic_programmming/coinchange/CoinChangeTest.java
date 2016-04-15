package ehwaz.problem_solving.algorithm.dynamic_programmming.coinchange;

import ehwaz.problem_solving.template.Solution;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.function.*;

public class CoinChangeTest {
    Consumer<InputStream> SOLUTION_TO_TEST = istream -> CoinChange.runSolution(istream);
    private final int numOfTestCases = 2;
    private final String[] INPUT_FILE_PATHS = {
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/coinchange/input09.txt",
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/coinchange/input15.txt"
    };
    private final String[] OUTPUT_FILE_PATHS = {
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/coinchange/output09.txt",
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/coinchange/output15.txt"
    };

    @Test
    public void runTestCase1() throws Exception {   runTest(0, SOLUTION_TO_TEST);   }
    @Test
    public void runTestCase2() throws Exception {   runTest(1, SOLUTION_TO_TEST);   }


    private FileInputStream istream;
    private ByteArrayOutputStream outContent;
    private Path outputFilePath;
    PrintStream original = System.out;
    long elapsedTime;
    private long[] runningTimes = new long[numOfTestCases];

    @AfterClass
    // The annotated method will be run after all the test methods in the current class have been run.
    public void printRunningTimes() {
        // Print after stdout is restored. During tests, stdout is directed to ByteArrayOutputStream.
        for (int i = 0; i < numOfTestCases; i++) {
            System.out.println("Test case #" + (i+1) + " took " + Long.toString(runningTimes[i])  + "ms to run.");
        }
    }

    public void runTest(int testIdx, Consumer<InputStream> solutionToTest) throws Exception {
        long startTime, stopTime;
        outContent =  new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        istream = new FileInputStream(INPUT_FILE_PATHS[testIdx]);
        outputFilePath = Paths.get(OUTPUT_FILE_PATHS[testIdx]);

        startTime = System.currentTimeMillis();
        solutionToTest.accept(istream);
        stopTime = System.currentTimeMillis();
        runningTimes[testIdx] = stopTime - startTime;

        String answer = new String(Files.readAllBytes(outputFilePath)).trim();
        String result = outContent.toString().trim();
        answer = answer.replaceAll("\\r", "");  // Actually, there's no CR in answer string- at least not in HackerRank's.
        result = result.replaceAll("\\r", "");  // Remove carrige return from the result

        Assert.assertEquals(result, answer, "Test case #" + (testIdx+1) + " is failed.");

        istream.close();
        outContent.close();

        System.setOut(original);
    }
}