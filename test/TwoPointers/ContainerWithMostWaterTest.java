package TwoPointers;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for ContainerWithMostWater.
 * Validates two-pointer based max water container solution.
 */
public class ContainerWithMostWaterTest {

    private ContainerWithMostWater containerWithMostWater;

    /**
     * Initializes ContainerWithMostWater instance before each test.
     */
    @BeforeMethod
    public void setup() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    /**
     * Tests standard input case with multiple heights.
     * Example: [1,8,6,2,5,4,8,3,7]
     * Expected Output: 49
     */
    @Test
    public void testStandardCase_ShouldReturnMaxArea() {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = containerWithMostWater.maxArea(heights);

        Assert.assertEquals(result, 49, "Maximum water area calculation is incorrect");
    }

    /**
     * Tests minimum valid input with only two heights.
     * Example: [1,1]
     * Expected Output: 1
     */
    @Test
    public void testMinimumInput_ShouldReturnArea() {

        int[] heights = {1, 1};

        int result = containerWithMostWater.maxArea(heights);

        Assert.assertEquals(result, 1, "Minimum input case failed");
    }

    /**
     * Tests when all heights are same.
     * Example: [5,5,5,5]
     * Expected Output: 15
     */
    @Test
    public void testSameHeightValues_ShouldReturnCorrectArea() {

        int[] heights = {5, 5, 5, 5};

        int result = containerWithMostWater.maxArea(heights);

        Assert.assertEquals(result, 15, "Same height case calculation failed");
    }

    /**
     * Tests when heights are in increasing order.
     * Example: [1,2,3,4,5]
     * Expected Output: 6
     */
    @Test
    public void testIncreasingOrderHeights_ShouldReturnCorrectArea() {

        int[] heights = {1, 2, 3, 4, 5};

        int result = containerWithMostWater.maxArea(heights);

        Assert.assertEquals(result, 6, "Increasing order case failed");
    }

    /**
     * Tests when heights are in decreasing order.
     * Example: [5,4,3,2,1]
     * Expected Output: 6
     */
    @Test
    public void testDecreasingOrderHeights_ShouldReturnCorrectArea() {

        int[] heights = {5, 4, 3, 2, 1};

        int result = containerWithMostWater.maxArea(heights);

        Assert.assertEquals(result, 6, "Decreasing order case failed");
    }

    /**
     * Tests when array contains zero height values.
     * Example: [0,2,0,4]
     * Expected Output: 4
     */
    @Test
    public void testZeroHeightValues_ShouldReturnCorrectArea() {

        int[] heights = {0, 2, 0, 4};

        int result = containerWithMostWater.maxArea(heights);

        Assert.assertEquals(result, 4, "Zero height case failed");
    }
}
