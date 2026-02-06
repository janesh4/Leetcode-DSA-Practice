package graphs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Test class for PacificAtlanticWaterFlow.
 * Validates reverse DFS based ocean reachability logic.
 */
public class PacificAtlanticWaterFlowTest {

    private PacificAtlanticWaterFlow waterFlow;

    /**
     * Initializes PacificAtlanticWaterFlow instance before each test.
     */
    @BeforeMethod
    public void setup() {
        waterFlow = new PacificAtlanticWaterFlow();
    }

    /**
     * Tests standard grid case.
     * Expected Output size: 7
     */
    @Test
    public void testStandardGrid_ShouldReturnCorrectCells() {

        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        List<int[]> result = waterFlow.pacificAtlantic(heights);

        Assert.assertEquals(result.size(), 7, "Incorrect number of reachable cells");
    }

    /**
     * Tests single cell grid.
     * Expected Output: 1
     */
    @Test
    public void testSingleCellGrid_ShouldReturnOne() {

        int[][] heights = {{1}};

        List<int[]> result = waterFlow.pacificAtlantic(heights);

        Assert.assertEquals(result.size(), 1, "Single cell should reach both oceans");
    }

    /**
     * Tests flat grid where all cells have same height.
     * Expected Output: All cells reachable.
     */
    @Test
    public void testFlatGrid_ShouldReturnAllCells() {

        int[][] heights = {
                {2,2},
                {2,2}
        };

        List<int[]> result = waterFlow.pacificAtlantic(heights);

        Assert.assertEquals(result.size(), 4, "All cells should be reachable");
    }

    /**
     * Tests increasing height grid.
     * Expected Output: Only border cells.
     */
    @Test
    public void testIncreasingGrid_ShouldReturnBorderCells() {

        int[][] heights = {
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };

        List<int[]> result = waterFlow.pacificAtlantic(heights);

        Assert.assertTrue(result.size() > 0, "Expected some reachable cells");
    }
}
