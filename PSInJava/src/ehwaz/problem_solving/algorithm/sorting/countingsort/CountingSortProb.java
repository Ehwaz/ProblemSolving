package ehwaz.problem_solving.algorithm.sorting.countingsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Sangwook on 2016-04-08.
 */

class WordFreq {
    int freq;
    String word;

    WordFreq(int freq, String word) {
        this.freq = freq;
        this.word = word;
    }
}

public class CountingSortProb {
    public static void solveProb(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int N = sc.nextInt();
        sc.nextLine();

        WordFreq[] wordFreqList = new WordFreq[N];
        int[] numberCount = new int[100];
        StringTokenizer st;
        int freqVal;
        String word;

        for (int cnt = 0; cnt < N; cnt++) {
            st = new StringTokenizer(sc.nextLine(), " ");
            freqVal = Integer.parseInt(st.nextToken());
            word = st.nextToken();
            wordFreqList[cnt] = new WordFreq(freqVal, word);
            numberCount[freqVal] += 1;
        }

        for (int cnt = 1; cnt < 100; cnt++) {
            numberCount[cnt] += numberCount[cnt-1];
        }

        String[] result = new String[N];
        int val, idx;
        for (int cnt = N-1; cnt >= 0; cnt--) {
            val = wordFreqList[cnt].freq;
            idx = numberCount[val];
            numberCount[val] -= 1;
            result[idx-1] = (cnt < N/2) ? "-" : wordFreqList[cnt].word;
        }

        // Use String builder!!
        StringBuilder RESULT = new StringBuilder();
        for (String word1 : result) {
            RESULT.append(word1 + " ");
            //RESULT2 += word1 + " ";
        }
        System.out.println(RESULT.toString());

        /*
        String RESULT2 = "";
        for (String word1 : result) {
            RESULT2 += word1 + " ";
        }
        System.out.println(RESULT2);
        */
    }

    public static void solveProb2(InputStream istream) {
        BufferedReader in = new BufferedReader(new InputStreamReader(istream));
        try {
            int n = Integer.parseInt(in.readLine());
            StringBuilder[] map = new StringBuilder[100];
            for (int i = 0; i < 100; i++) {
                map[i] = new StringBuilder();
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer tok = new StringTokenizer(in.readLine());
                int v = Integer.parseInt(tok.nextToken());
                String s = tok.nextToken();
                map[v].append(i < n / 2 ? "-" : s).append(" ");
            }

            StringBuilder finalResult = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                finalResult.append(map[i]);
            }
            System.out.println(finalResult.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        solveProb2(System.in);
    }
}
