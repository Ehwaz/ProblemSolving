package ehwaz.problem_solving.algorithm.dynamic_programmming.minimumedit;

import java.util.*;
import java.io.*;

/**
 * Created by Sangwook on 2016-04-16.
 */
public class MinEditDist {
    private static String objString;
    private static String givenString;

    static int[][] memoization;

    private static int getMovesToChange(int idxToObjStr, int idxToGivenStr) {
        int returnValue;
        if (idxToObjStr == -1) { return idxToGivenStr+1; } // if there's no given string, remove all from given string.
        else if (idxToGivenStr == -1) { return idxToObjStr+1; } // if there's no obj string, add all char in obj string.
        else {
            if (memoization[idxToObjStr][idxToGivenStr] != -1) {
                return memoization[idxToObjStr][idxToGivenStr];
            } else {
                if (objString.charAt(idxToObjStr) == givenString.charAt(idxToGivenStr)) {
                    // If characters are same, move to next characters.
                    returnValue = getMovesToChange(idxToObjStr-1, idxToGivenStr-1);
                } else {
                    List<Integer> minMoveCandidates = new ArrayList<Integer>();
                    // Insert a char from obj string.
                    minMoveCandidates.add(getMovesToChange(idxToObjStr-1, idxToGivenStr) + 1);
                    // Remove a char from given string.
                    minMoveCandidates.add(getMovesToChange(idxToObjStr, idxToGivenStr-1) + 1);
                    // Replace a char in given string with a char in objective string.
                    minMoveCandidates.add(getMovesToChange(idxToObjStr-1, idxToGivenStr-1) + 1);
                    returnValue = Collections.min(minMoveCandidates);
                }
            }
        }

        memoization[idxToObjStr][idxToGivenStr] = returnValue;
        return returnValue;
    }

    public static void solveProb(InputStream istream) {
        Scanner sc = new Scanner(istream);

        objString = sc.nextLine();
        givenString = sc.nextLine();
        int lenObjString = objString.length();
        int lenGivenString = givenString.length();

        memoization = new int[lenObjString][lenGivenString];
        for (int i = 0; i < lenObjString; i++) {
            for (int j = 0; j < lenGivenString; j++) {
                memoization[i][j] = -1;     // Initialize memoization array.
            }
        }

        int result = getMovesToChange(objString.length()-1, givenString.length()-1);
        System.out.println(result);
    }


    public static void main(String[] args) {
        solveProb(System.in);
    }

}
