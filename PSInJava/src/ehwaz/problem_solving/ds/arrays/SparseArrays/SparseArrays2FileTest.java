package ehwaz.problem_solving.ds.arrays.SparseArrays;

import org.testng.annotations.*;
import org.testng.Assert;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;


/**
 * Created by Sangwook on 2016-04-06.
 */
public class SparseArrays2FileTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Scanner isc;
    private Path outputFilePath;
    PrintStream original = System.out;

    private final String INPUT_FILE_PATH = "src/ehwaz/problem_solving/ds/arrays/SparseArrays/input08.txt";
    private final String OUTPUT_FILE_PATH = "src/ehwaz/problem_solving/ds/arrays/SparseArrays/output08.txt";

    @BeforeTest
    public void setUp() throws Exception {
        File inputFile = new File(INPUT_FILE_PATH);
        isc = new Scanner(inputFile);

        outputFilePath = Paths.get(OUTPUT_FILE_PATH);
        System.setOut(new PrintStream(outContent));
    }

    @AfterTest
    public void tearDown() throws Exception {
        // Tears down the fixture, for example, close a network connection.
        // This method is called after a test is executed.
        // Asserting in tearDown() is generally a bad idea.

        System.setOut(original);        // Restore original stdout

        isc.close();
    }

    @Test
    public void testSolveProb() throws Exception {
        SparseArrays2.solveProb(isc);

        String answer = new String(Files.readAllBytes(outputFilePath)).trim();
        String result = outContent.toString().trim();
        answer = answer.replaceAll("\\r", "");  // Actually, there's no CR in answer string- at least not in HackerRank's.
        result = result.replaceAll("\\r", "");  // Remove carrige return from the result

        Assert.assertEquals(result, answer);
    }
}