package graphs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Island.
 * Validates DFS based island counting logic.
 */
public class IslandTest {

    private Island island;

    /**
     * Initializes Island instance before each test.
     */
    @BeforeMethod
    public void setup() {
        island = new Island();
    }

    /**
     * Tests grid with multiple islands.
     * Expected Output: 3
     */
    @Test
    public void testMultipleIslands_ShouldReturnCorrectCount() {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        int result = island.numIslands(grid);

        Assert.assertEquals(result, 3, "Incorrect island count");
    }

    /**
     * Tests grid with no land.
     * Expected Output: 0
     */
    @Test
    public void testNoIslands_ShouldReturnZero() {

        char[][] grid = {
                {'0','0'},
                {'0','0'}
        };

        int result = island.numIslands(grid);

        Assert.assertEquals(result, 0, "Expected zero islands");
    }

    /**
     * Tests grid with single island.
     * Expected Output: 1
     */
    @Test
    public void testSingleIsland_ShouldReturnOne() {

        char[][] grid = {
                {'1','1','1'},
                {'1','1','1'}
        };

        int result = island.numIslands(grid);

        Assert.assertEquals(result, 1, "Expected one island");
    }

    /**
     * Tests empty grid input.
     * Expected Output: 0
     */
    @Test
    public void testEmptyGrid_ShouldReturnZero() {

        char[][] grid = {};

        int result = island.numIslands(grid);

        Assert.assertEquals(result, 0, "Empty grid should return zero islands");
    }

    /**
     * Tests grid with diagonal land only (not connected).
     * Expected Output: 2
     */
    @Test
    public void testDiagonalIslands_ShouldReturnCorrectCount() {

        char[][] grid = {
                {'1','0'},
                {'0','1'}
        };

        int result = island.numIslands(grid);

        Assert.assertEquals(result, 2, "Diagonal islands should be counted separately");
    }
}
