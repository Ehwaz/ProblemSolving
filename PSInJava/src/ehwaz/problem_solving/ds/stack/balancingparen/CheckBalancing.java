package ehwaz.problem_solving.ds.stack.balancingparen;

import java.io.InputStream;
import java.util.*;

/**
 * Created by Sangwook on 2016-04-10.
 */
public class CheckBalancing {
    private static void solveProb(String test) {
        Stack<Character> valueStack = new Stack<Character>();
        char matchingVal, value;

        for (int idx = 0; idx < test.length(); idx++) {
            value = test.charAt(idx);
            switch(value) {
                case '(':
                case '{':
                case '[':
                    valueStack.push(value);
                    break;
                case ')':
                    if ( valueStack.empty() ) {
                        System.out.println("NO"); return;
                    }
                    matchingVal = valueStack.pop();
                    if (matchingVal != '(') { System.out.println("NO"); return; }
                    break;
                case '}':
                    if ( valueStack.empty() ) {
                        System.out.println("NO"); return;
                    }
                    matchingVal = valueStack.pop();
                    if (matchingVal != '{') { System.out.println("NO"); return; }
                    break;
                case ']':
                    if ( valueStack.empty() ) {
                        System.out.println("NO"); return;
                    }
                    matchingVal = valueStack.pop();
                    if (matchingVal != '[') { System.out.println("NO"); return; }
                    break;
            }
        }

        if (valueStack.empty() == false) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

    public static void runProb(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int testNum = sc.nextInt();
        sc.nextLine();

        for (int testCnt = 0; testCnt < testNum; testCnt++) {
            String test = sc.nextLine();
            solveProb(test);
        }
    }

    public static void main(String[] args) {
        runProb(System.in);
    }
}
