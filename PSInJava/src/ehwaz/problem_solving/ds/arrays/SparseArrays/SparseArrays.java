package ehwaz.problem_solving.ds.arrays.SparseArrays;

import java.util.*;

/**
 * Created by Sangwook on 2016-04-05.
 */
public class SparseArrays {
    public static int[] solveProb(String[] inputLines, int numOfStr, String[] queryLines, int numOfQuery) {
        int[] results = new int[numOfQuery];

        Map<String, Integer> mapStrCnt = new HashMap<String, Integer>();
        for (int i = 0; i < numOfStr; i++) {
            String inputStr = inputLines[i];
            int curCnt = (mapStrCnt.containsKey(inputStr)) ? mapStrCnt.get(inputStr) : 0;
            mapStrCnt.put(inputStr, curCnt + 1);
        }

        for (int j = 0; j < numOfQuery; j++) {
            String query = queryLines[j];
            if (mapStrCnt.containsKey(query)) {
                results[j] = mapStrCnt.get(query);
            } else {
                results[j] = 0;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfStr = sc.nextInt();
        sc.nextLine();
        String[] inputLines = new String[numOfStr];
        for (int i = 0; i < numOfStr; i++) {
            inputLines[i] = sc.nextLine();
        }

        int numOfQuery = sc.nextInt();
        sc.nextLine();
        String[] queryLines = new String[numOfQuery];
        for (int i = 0; i < numOfQuery; i++) {
            queryLines[i] = sc.nextLine();
        }

        int[] results = solveProb(inputLines, numOfStr, queryLines, numOfQuery);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
