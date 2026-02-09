package BinarySearch;

public class Search2DMatrix {

    /**
     * SEARCH IN 2D MATRIX — Mind Map
     *
     * Pattern:
     * - Binary Search on a virtual 1-D sorted array
     *
     * Why Binary Search Works:
     * - Each row is sorted in non-decreasing order.
     * - First element of a row is greater than the last element of the previous row.
     * - Therefore, the entire matrix behaves like a single sorted array of size m × n.
     *
     * Binary Search Flow:
     * - left  = 0
     * - right = m * n - 1
     * - mid   = left + (right - left) / 2   // prevents integer overflow
     *
     * -------- MOST IMPORTANT PART --------
     * 1D index → 2D matrix conversion:
     *
     * Let:
     *   n = number of columns
     *
     * Row calculation:
     *   row = mid / n
     *   - Division tells how many complete rows are passed.
     *
     * Column calculation:
     *   col = mid % n
     *   - Remainder gives position inside the row.
     *
     * Memory Trick:
     *   "Divide → ROW,  Modulo → COLUMN"
     *
     * Access element:
     *   value = matrix[row][col]
     *
     * Comparison:
     * - If value == target → return true
     * - If value < target  → search right half
     * - If value > target  → search left half
     *
     * Edge Cases:
     * - Empty matrix → return false
     * - Single element matrix → direct comparison
     *
     * Complexity:
     * - Time  : O(log(m × n))
     * - Space : O(1)
     *
     * Interview One-liner:
     * "Treat the matrix as a virtual sorted 1-D array and apply binary search,
     * converting index using row = mid/n and col = mid%n."
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert 1D index → 2D coordinates
            int row = mid / n;
            int col = mid % n;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
