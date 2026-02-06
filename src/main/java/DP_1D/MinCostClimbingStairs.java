package DP_1D;

/**
 * LeetCode Problem: Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * Problem: Return the minimum cost to reach the top of the staircase.
 */
public class MinCostClimbingStairs {

    /**
     * MIND MAP:
     *
     * Problem Understanding:
     * - cost[i] = cost to step on stair i
     * - You can start from step 0 OR step 1
     * - TOP is beyond last index (no cost at top)
     *
     * DP Meaning:
     * dp[i] = minimum cost to reach TOP starting from step i
     *
     * Transition:
     * From step i you can go:
     * - to i+1 (1 step)
     * - to i+2 (2 steps)
     *
     * So:
     * dp[i] = cost[i] + min(dp[i+1], dp[i+2])
     *
     * Direction:
     * Build DP from bottom (near TOP) backwards
     *
     * Final Answer:
     * You can start from step 0 OR step 1
     * → return min(dp[0], dp[1])
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int minCostClimbingStairs(int[] cost) {

        return 0;
    }
}
