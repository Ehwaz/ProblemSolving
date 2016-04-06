package ehwaz.problem_solving.ds.arrays.SparseArrays;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Sangwook on 2016-04-06.
 */
public class SparseArraysFileTest {
    String[] inputLines;
    int numOfStr;
    String[] queryLines;
    int numOfQuery;

    @BeforeMethod
    public void setUp() throws Exception {
        String workingDirPath = Paths.get("").toAbsolutePath().toString();
        File file = new File("src/ehwaz/problem_solving/ds/arrays/SparseArrays/input08.txt");
        Scanner sc = new Scanner(file);

        numOfStr = sc.nextInt();
        sc.nextLine();
        inputLines = new String[numOfStr];
        for (int i = 0; i < numOfStr; i++) {
            inputLines[i] = sc.nextLine();
        }

        numOfQuery = sc.nextInt();
        sc.nextLine();
        queryLines = new String[numOfQuery];
        for (int i = 0; i < numOfQuery; i++) {
            queryLines[i] = sc.nextLine();
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {    }

    @Test
    public void testSolveProb() throws Exception {
        int[] result = SparseArrays.solveProb(inputLines, numOfStr, queryLines, numOfQuery);

        File file = new File("src/ehwaz/problem_solving/ds/arrays/SparseArrays/output08.txt");
        Scanner sc = new Scanner(file);
        int[] answer = new int[numOfQuery];
        for (int cnt=0; cnt < numOfQuery; cnt++) {
            answer[cnt] = Integer.parseInt(sc.nextLine());
        }
        Assert.assertEquals(result, answer);
    }
}