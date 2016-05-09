package ehwaz.problem_solving.algorithm.implementation.top_k_freq;

import java.io.*;
import java.util.*;

/**
 * Created by Sangwook on 2016-05-09.
 */

// Assuming that the number of values are all different from each other.
public class TopKFreqElem {
    // O(N logN): Count, sort and get to K values.
    public static void solution1(int K, List<Integer> values) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int newCount;
        for (int i : values) {
            newCount = countMap.getOrDefault(i, 0) + 1;
            countMap.put(i, newCount);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(countMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> (o2.getValue() - o1.getValue()));   // Sort in descending order

        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : entryList.subList(0, K)) {
            result.add(entry.getKey());
        }

        System.out.println(result);
    }

    // O(N logK): Count, put entry in size K priority queue.
    // Ref: https://leetcode.com/discuss/100704/java-straightforward-o-n-n-k-lg-k-solution
    public static void solution2(int K, List<Integer> values) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int newCount;
        for (int i : values) {
            newCount = countMap.getOrDefault(i, 0) + 1;
            countMap.put(i, newCount);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                ((o1, o2) -> o1.getValue() - o2.getValue())    // PriorityQueue in ascending order
        );
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > K) { pq.poll(); }   // (when queue size > K, remove the least count entry.)
        }

        List<Integer> result = new ArrayList<Integer>();
        while (pq.isEmpty() == false) {
            result.add(0, pq.poll().getKey());  // Prepend values to the result.
        }
        System.out.println(result);
    }

    // O(N): Using Bucket Sort.
    // Ref: https://leetcode.com/discuss/100581/java-o-n-solution-bucket-sort
    public static void solution3(int K, List<Integer> values) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int newCount;
        for (int i : values) {
            newCount = countMap.getOrDefault(i, 0) + 1;
            countMap.put(i, newCount);
        }

        int maxFreq = Collections.max(countMap.values()) + 1;
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(maxFreq);
        for (int i = 0; i < maxFreq; i++) {
            bucket.add(new ArrayList<Integer>());
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int freq = maxFreq - 1; freq >= 0 && result.size() < K; freq--) {
            result.addAll(bucket.get(freq));
        }
        System.out.println(result);
    }

    public static void runSolution1(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int K = Integer.parseInt(sc.nextLine());
        List<Integer> inputList = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()) {
            inputList.add(Integer.parseInt(st.nextToken()));
        }

        solution1(K, inputList);
    }

    public static void runSolution2(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int K = Integer.parseInt(sc.nextLine());
        List<Integer> inputList = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()) {
            inputList.add(Integer.parseInt(st.nextToken()));
        }

        solution2(K, inputList);
    }

    public static void runSolution3(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int K = Integer.parseInt(sc.nextLine());
        List<Integer> inputList = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        while (st.hasMoreTokens()) {
            inputList.add(Integer.parseInt(st.nextToken()));
        }

        solution3(K, inputList);
    }

    public static void main(String[] args) {
        runSolution1(System.in);
    }
}
