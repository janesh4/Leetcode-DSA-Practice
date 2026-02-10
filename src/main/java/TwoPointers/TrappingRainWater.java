package TwoPointers;

/**
 * Problem: Given elevation map heights, compute total trapped rain water.
 * LeetCode: https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     * Mind Map (Building Boundary Intuition):
     *
     * CORE RULE:
     * - Water at index i = min(leftMax, rightMax) − height[i]
     *
     * VISUAL:
     * - Left side → tall building (lMax)
     * - Right side → tall building (rMax)
     * - Current index → smaller building between boundaries
     *
     * TWO-POINTER OPTIMAL INSIGHT:
     * - Water depends on the SMALLER boundary.
     * - If lMax < rMax:
     *      → trapped water is limited by lMax
     *      → move left pointer inward.
     * - Else:
     *      → trapped water is limited by rMax
     *      → move right pointer inward.
     *
     * WHY THIS WORKS:
     * - The larger boundary cannot affect water until the smaller one changes.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;

        int lMax = height[l], rMax = height[r];
        int res = 0;

        while (l < r) {

            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }

        return res;
    }
}
