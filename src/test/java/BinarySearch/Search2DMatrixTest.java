package BinarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Search2DMatrixTest {

    private final Search2DMatrix solution = new Search2DMatrix();

    @Test
    public void testFound() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        Assert.assertTrue(solution.searchMatrix(matrix, 3));
    }

    @Test
    public void testNotFound() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        Assert.assertFalse(solution.searchMatrix(matrix, 13));
    }

    @Test
    public void testSingleElement() {
        int[][] matrix = {{5}};
        Assert.assertTrue(solution.searchMatrix(matrix, 5));
    }

    @Test
    public void testSingleRow() {
        int[][] matrix = {{1, 2, 3, 4}};
        Assert.assertTrue(solution.searchMatrix(matrix, 4));
    }
}

