package DP_1D;

import java.util.Arrays;

/**
 * Problem:
 * Given an integer array coins representing coin denominations and an integer amount,
 * return the fewest number of coins needed to make up that amount.
 * If the amount cannot be made up, return -1.
 *
 * LeetCode:
 * https://leetcode.com/problems/coin-change/
 *
 * Approach:
 * Bottom-up Dynamic Programming.
 *
 * dp[i] = minimum coins required to make amount i.
 *
 * Transition:
 * dp[i] = min(dp[i], dp[i - coin] + 1) for all coins <= i
 *
 * Time Complexity:
 * O(amount × number_of_coins)
 *
 * Space Complexity:
 * O(amount)
 */
public class CoinChange {

    /**
     * Returns minimum number of coins needed to form the given amount.
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Initialize with impossible large value
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // Base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
