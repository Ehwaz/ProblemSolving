package ehwaz.problem_solving.ds.heap.basicusage;

import java.io.*;
import java.util.*;

/**
 * Created by Sangwook on 2016-04-13.
 */
public class BasicUsage {
    // Ref: When to use Prioirty

    public static void runUsingTreeSet(InputStream istream) {
        Scanner sc = new Scanner(istream);

        TreeSet<Integer> heap = new TreeSet<Integer>();

        String inputTemp;
        String[] inputs;
        int queryNum = sc.nextInt();
        sc.nextLine();
        for (int cnt = 0; cnt < queryNum; cnt++) {
            inputTemp = sc.nextLine();
            inputs = inputTemp.split(" ");
            if (inputs.length == 2) {
                switch (Integer.parseInt(inputs[0])) {
                    case 1:
                        heap.add(Integer.parseInt(inputs[1]));
                        break;
                    case 2:
                        heap.remove(Integer.parseInt(inputs[1]));
                        break;
                    default:
                        throw new RuntimeException("WTF??");
                }
            } else if (inputs.length == 1) {
                System.out.println(heap.first());
            } else {
                throw new RuntimeException("WTF??");
            }
        }
    }

    public static void runUsingPriorityQueue(InputStream istream) {
        Scanner sc = new Scanner(istream);

        Queue<Integer> heap = new PriorityQueue<Integer>();

        String inputTemp;
        String[] inputs;
        int queryNum = sc.nextInt();
        sc.nextLine();
        for (int cnt = 0; cnt < queryNum; cnt++) {
            inputTemp = sc.nextLine();
            inputs = inputTemp.split(" ");
            if (inputs.length == 2) {
                switch (Integer.parseInt(inputs[0])) {
                    case 1:
                        heap.add(Integer.parseInt(inputs[1]));
                        break;
                    case 2:
                        heap.remove(Integer.parseInt(inputs[1]));
                        break;
                    default:
                        throw new RuntimeException("WTF??");
                }
            } else if (inputs.length == 1) {
                System.out.println(heap.peek());
            } else {
                throw new RuntimeException("WTF??");
            }
        }
    }

    public static void main(String[] args) {
        runUsingPriorityQueue(System.in);
    }
}
