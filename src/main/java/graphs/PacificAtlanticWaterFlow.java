package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Problem: Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Problem: Find grid cells from which water can flow to both Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {

    /**
     * MIND MAP:
     *
     * Understand flow rule:
     * Cell can flow to ocean if neighbor height <= current height
     *
     * Reverse thinking:
     * Instead of flowing water outward,
     * Start DFS from oceans and move inward (reverse flow)
     *
     * Setup:
     * Create Pacific visited matrix
     * Create Atlantic visited matrix
     *
     * Pacific DFS:
     * Start from top row + left column
     *
     * Atlantic DFS:
     * Start from bottom row + right column
     *
     * DFS traversal rule:
     * Move only to neighbor cells with height >= current cell
     *
     * Why reverse condition:
     * Ensures water can flow back to ocean in forward direction
     *
     * Mark reachable cells:
     * Mark visited during DFS traversal
     *
     * Final result:
     * Take intersection of Pacific and Atlantic visited cells
     *
     * Time Complexity: O(R * C)
     * Space Complexity: O(R * C)
     */
    public List<int[]> pacificAtlantic(int[][] heights) {

        List<int[]> result = new ArrayList<>();

        // Edge case: empty input
        if (heights == null || heights.length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // Start DFS from Pacific Ocean borders (top row + left column)
        for (int row = 0; row < rows; row++) {
            dfs(heights, pacificReachable, row, 0);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, pacificReachable, 0, col);
        }

        // Start DFS from Atlantic Ocean borders (bottom row + right column)
        for (int row = 0; row < rows; row++) {
            dfs(heights, atlanticReachable, row, cols - 1);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, atlanticReachable, rows - 1, col);
        }

        // Find cells reachable from both oceans
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (pacificReachable[row][col] && atlanticReachable[row][col]) {
                    result.add(new int[]{row, col});
                }
            }
        }

        return result;
    }

    /**
     * DFS traversal that marks reachable cells based on height condition.
     */
    private void dfs(int[][] heights, boolean[][] visited, int row, int col) {

        // Stop if already visited
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        int[][] directions = {
                {1, 0},   // Down
                {-1, 0},  // Up
                {0, 1},   // Right
                {0, -1}   // Left
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Boundary check
            if (newRow < 0 || newCol < 0 ||
                    newRow >= heights.length || newCol >= heights[0].length) {
                continue;
            }

            // Reverse flow condition (move only to higher or equal height)
            if (heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }
}
