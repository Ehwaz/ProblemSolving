package ehwaz.problem_solving.algorithm.dynamic_programmming.fibonaccimodified.testcases;

import ehwaz.problem_solving.algorithm.dynamic_programmming.fibonaccimodified.FibonacciModified;
import ehwaz.problem_solving.template.Solution;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class FibonacciModifiedTest {

    ///////////// Test-specific codes: you only need to modify these lines. /////////////////
    Consumer<InputStream> SOLUTION_TO_TEST = istream -> FibonacciModified.runSolution(istream);    // Requires Java 8
    private final int numOfTestCases = 3;
    private final String[] INPUT_FILE_PATHS = {
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/fibonaccimodified/testcases/input03.txt",
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/fibonaccimodified/testcases/input04.txt",
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/fibonaccimodified/testcases/input06.txt",
    };
    private final String[] OUTPUT_FILE_PATHS = {
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/fibonaccimodified/testcases/output03.txt",
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/fibonaccimodified/testcases/output04.txt",
            "src/ehwaz/problem_solving/algorithm/dynamic_programmming/fibonaccimodified/testcases/output06.txt",
    };

    @Test private void runTestCase1() throws Exception {   runTest(0, SOLUTION_TO_TEST);   }
    @Test private void runTestCase2() throws Exception {   runTest(1, SOLUTION_TO_TEST);   }
    @Test private void runTestCase3() throws Exception {   runTest(2, SOLUTION_TO_TEST);   }
    /////////////////////////////////////////////////////////////////////////////////////////


    private FileInputStream istream;
    private ByteArrayOutputStream outContent;
    private Path outputFilePath;
    private long[] runningTimes = new long[numOfTestCases];
    PrintStream original = System.out;

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