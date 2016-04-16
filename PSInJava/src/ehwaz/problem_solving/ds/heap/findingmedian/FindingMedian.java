package ehwaz.problem_solving.ds.heap.findingmedian;

import java.util.*;
import java.io.*;

/**
 * Created by Sangwook on 2016-04-13.
 */
public class FindingMedian {
    public static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int inputNum = Integer.parseInt(sc.nextLine());

        Queue<Integer> lowerHalf = new PriorityQueue<Integer>(inputNum, Collections.reverseOrder());
        Queue<Integer> biggerHalf = new PriorityQueue<Integer>(inputNum);

        int input;
        int leftBiggest, rightSmallest;
        for (int inputCnt = 0; inputCnt < inputNum; inputCnt++) {
            input = Integer.parseInt(sc.nextLine());

            if (inputCnt == 0) {
                lowerHalf.add(input);
            } else if (inputCnt == 1) {
                int before = lowerHalf.peek();
                if (input >= before) {
                    biggerHalf.add(input);
                } else {
                    biggerHalf.add(lowerHalf.poll());
                    lowerHalf.add(input);
                }
            } else {
                leftBiggest = lowerHalf.peek();
                rightSmallest = biggerHalf.peek();
                if ( (input < leftBiggest) || (leftBiggest <= input && input < rightSmallest) ) {
                    lowerHalf.add(input);
                } else if (rightSmallest <= input) {
                    biggerHalf.add(input);
                }
            }

            // Balance 2 heaps
            int diff = lowerHalf.size() - biggerHalf.size();
            if (diff == 2) {
                biggerHalf.add(lowerHalf.poll());
            } else if (diff == -2) {
                lowerHalf.add(biggerHalf.poll());
            }

            // Calculate median
            float median = 0;
            if ((inputCnt+1) == 1) {
                median = (float)lowerHalf.peek();
            } else {
                if ((inputCnt+1) % 2 == 0) {
                    if (lowerHalf.isEmpty() == false) {
                        median += (float)lowerHalf.peek();
                    }
                    if (biggerHalf.isEmpty() == false) {
                        median += (float)biggerHalf.peek();
                    }
                    median /= 2;
                } else {
                    if (lowerHalf.size() > biggerHalf.size()) {
                        median = (float)lowerHalf.peek();
                    } else {
                        median = (float)biggerHalf.peek();
                    }
                }
            }

            System.out.println(median);
        }
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
