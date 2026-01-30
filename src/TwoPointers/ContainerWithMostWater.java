package TwoPointers;

/**
 * LeetCode Problem: Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Problem: Find two vertical lines that form a container holding the maximum water.
 */
public class ContainerWithMostWater {

    /**
     * MIND MAP:
     * Two pointers → Calculate area → Move smaller height pointer → Track max area
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxArea(int[] heights) {

        // Left and right pointers
        int left = 0;
        int right = heights.length - 1;

        // Stores maximum water area found
        int maxWater = 0;

        while (left < right) {

            // Width between two lines
            int width = right - left;

            // Height is limited by the shorter line
            int minHeight = Math.min(heights[left], heights[right]);

            // Calculate current container area
            int currentArea = minHeight * width;

            // Update maximum area
            maxWater = Math.max(maxWater, currentArea);

            // Move pointer with smaller height to maximize possible area
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
