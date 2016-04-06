package ehwaz.problem_solving.ds.arrays.SparseArrays;

import java.util.*;

/**
 * Created by Sangwook on 2016-04-06.
 */
public class SparseArrays2 {
    public static void solveProb(Scanner sc) {
        int numOfStr = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> mapStrCnt = new HashMap<String, Integer>();
        for (int i = 0; i < numOfStr; i++) {
            String inputStr = sc.nextLine();
            if (mapStrCnt.containsKey(inputStr)) {
                int newCnt = mapStrCnt.get(inputStr) + 1;
                mapStrCnt.put(inputStr, newCnt);
            } else {
                mapStrCnt.put(inputStr, 1);
            }
        }

        int numOfQuery = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < numOfQuery; j++) {
            String query = sc.nextLine();
            if (mapStrCnt.containsKey(query)) {
                System.out.println(mapStrCnt.get(query));
            } else {
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solveProb(sc);
    }
}
