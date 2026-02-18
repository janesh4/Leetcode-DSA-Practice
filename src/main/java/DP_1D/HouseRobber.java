package DP_1D;

/**
 * Problem:
 * You are given an integer array nums representing the amount of money
 * at each house. Adjacent houses cannot be robbed.
 * Return the maximum amount of money you can rob without alerting police.
 *
 * LeetCode:
 * https://leetcode.com/problems/house-robber/
 *
 * Approach:
 * 1D Dynamic Programming with space optimization.
 *
 * Overall Time Complexity:
 * O(n), where n = number of houses.
 *
 * Overall Space Complexity:
 * O(1), using two variables instead of DP array.
 */
public class HouseRobber {

    /**
     * Computes maximum money that can be robbed.
     *
     * Mindmap:
     *  rob1 → max till house i-2
     *  rob2 → max till house i-1
     *
     *  For each house:
     *      choose max of:
     *          rob current house → num + rob1
     *          skip current house → rob2
     *
     *  Update sliding window:
     *      rob1 = rob2
     *      rob2 = result
     *
     * Time Complexity:
     *  O(n)
     *
     * Auxiliary Space:
     *  O(1)
     */
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
