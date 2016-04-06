package ehwaz.problem_solving.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Sangwook on 2016-04-06.
 */
public class Solution {
    public static void solveProb(Scanner sc) {
        int testNum = Integer.parseInt(sc.nextLine());

        for (int testCnt = 0; testCnt < testNum; testCnt++) {
            int nTimes = Integer.parseInt(sc.nextLine());

            for (int cnt = 0; cnt < nTimes; cnt++) {
                System.out.println("Hello world!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solveProb(sc);
    }
}
