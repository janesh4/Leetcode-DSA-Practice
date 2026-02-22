package DP_1D;


/**
 * LeetCode 746 – Min Cost Climbing Stairs
 *
 * Approach:
 * Bottom-up Dynamic Programming.
 *
 * dp[i] represents the minimum cost required to reach the top
 * starting from step i.
 *
 * Base cases:
 * - dp[n-1] = cost[n-1]
 * - dp[n-2] = cost[n-2]
 * These are already correct because from these steps we can
 * directly reach the top.
 *
 * Transition:
 * dp[i] = cost[i] + min(dp[i+1], dp[i+2])
 *
 * We start filling DP from index (n - 3) because it is the first
 * index where both dp[i+1] and dp[i+2] are valid and already computed.
 *
 * Final answer:
 * We can start from step 0 or step 1,
 * so result = min(dp[0], dp[1]).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)  (can be optimized to O(1))
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Create a copy so original input is not modified
        int[] dp = cost.clone();

        // Build DP from third-last step backwards
        for (int i = n - 3; i >= 0; i--) {
            dp[i] += Math.min(dp[i + 1], dp[i + 2]);
        }

        // Can start from step 0 or step 1
        return Math.min(dp[0], dp[1]);
    }

    // Optional: space-optimized O(1) version (good to mention in interview)
    public int minCostClimbingStairsOptimized(int[] cost) {
        int n = cost.length;

        int next1 = cost[n - 1]; // dp[i+1]
        int next2 = cost[n - 2]; // dp[i+2]

        for (int i = n - 3; i >= 0; i--) {
            int curr = cost[i] + Math.min(next1, next2);
            next1 = next2;
            next2 = curr;
        }

        return Math.min(next1, next2);
    }
}


