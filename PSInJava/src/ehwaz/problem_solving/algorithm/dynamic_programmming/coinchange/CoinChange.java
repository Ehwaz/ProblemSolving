package ehwaz.problem_solving.algorithm.dynamic_programmming.coinchange;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Sangwook on 2016-04-09.
 */
public class CoinChange {
    static long solveProb(int[] coin_list, int val_max_coin, int value) {
        // subProb[i][j]: number of cases using 1st ~ (j+1)th coins to pay (i+1) $
        long[][] subProb = new long[value+1][val_max_coin];

        for (int j = 0; j < val_max_coin; j++) {
            subProb[0][j] = 1;   // When there is nothing to pay, there is 1 way to pay.
        }

        // From 1 ~ value $,
        for (int i = 1; i < value+1; i++) {
            // When we can use 1st ~ (val_max_coin)th coin
            for (int j = 0; j < val_max_coin; j++) {
                long solWithJthCoinAndLowerVal = 0;
                int lowerVal = i - coin_list[j];
                if (lowerVal >= 0) {
                    solWithJthCoinAndLowerVal = subProb[lowerVal][j];
                }

                long solWithoutJthCoin = 0;
                if (j >= 1) {
                    solWithoutJthCoin = subProb[i][j-1];
                }
                subProb[i][j] = solWithJthCoinAndLowerVal + solWithoutJthCoin;
            }
        }

        return subProb[value][val_max_coin - 1];
    }

    static void runSolution(InputStream istream) {
        Scanner sc = new Scanner(istream);

        int value = sc.nextInt();
        int val_max_coin = sc.nextInt();
        int[] coin_list = new int[val_max_coin];

        for (int coin_cnt = 0; coin_cnt < val_max_coin; coin_cnt++) {
            coin_list[coin_cnt] = sc.nextInt();
        }

        long result = solveProb(coin_list, val_max_coin, value);
        System.out.println(result);
    }

    public static void main(String[] args) {
        runSolution(System.in);
    }
}
