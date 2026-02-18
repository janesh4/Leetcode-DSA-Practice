package greedy;

/**
 * Problem:
 * Given an array of non-negative integers nums, each element represents
 * the maximum jump length at that position.
 * Return the minimum number of jumps required to reach the last index.
 *
 * LeetCode:
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Approach:
 * Greedy BFS window expansion.
 *
 * Overall Time Complexity:
 * O(n), where n = length of nums.
 *
 * Overall Space Complexity:
 * O(1)
 */
public class JumpGameII {

    /**
     * Computes minimum jumps to reach last index.
     *
     * Mindmap:
     *  Maintain BFS window [l, r]
     *  For each window:
     *      find farthest reachable index
     *      shift window to next layer
     *      increment jump count
     *
     * Time Complexity:
     *  O(n) — each index processed once.
     *
     * Auxiliary Space:
     *  O(1)
     */
    public int jump(int[] nums) {

        int l = 0, r = 0;
        int jumps = 0;

        while (r < nums.length - 1) {
            int farthest = 0;

            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}
