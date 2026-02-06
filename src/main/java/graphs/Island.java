package graphs;

import java.util.Stack;

/**
 * LeetCode Problem: Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * Problem: Count the number of connected islands (groups of '1's) in a 2D grid.
 */
public class Island {

    /**
     * MIND MAP:
     * Input validation → Traverse grid
     * → If land ('1') found
     * → Start DFS flood fill
     * → Boundary + water check
     * → Mark current cell visited ('0')
     * → Explore 4 directions (up, down, left, right)
     * → Continue until island fully sunk
     * → Increment island count
     * → Continue grid traversal
     *
     * Time Complexity: O(R * C)
     * Space Complexity: O(R * C)
     */
    public int numIslands(char[][] grid) {

        // Edge case: Empty grid
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Traverse each cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // Found new island
                if (grid[row][col] == '1') {

                    // Flood fill to mark entire island
                    performDFS(grid, row, col);

                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    /**
     * Performs iterative DFS to mark connected land cells as visited.
     */
    private void performDFS(char[][] grid, int startRow, int startCol) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startRow, startCol});

        while (!stack.isEmpty()) {

            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];

            // Boundary and water check
            if (row < 0 || col < 0 ||
                    row >= grid.length || col >= grid[0].length ||
                    grid[row][col] == '0') {
                continue;
            }

            // Mark cell as visited (sink the island)
            grid[row][col] = '0';

            // Explore all 4 directions
            stack.push(new int[]{row + 1, col}); // Down
            stack.push(new int[]{row - 1, col}); // Up
            stack.push(new int[]{row, col + 1}); // Right
            stack.push(new int[]{row, col - 1}); // Left
        }
    }
}
