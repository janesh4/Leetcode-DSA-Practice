package ArraysAndHashing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Test class for TopKFrequentElements.
 * Validates bucket sort based frequency extraction logic.
 */
public class TopKFrequentElementsTest {

    private TopKFrequentElements topKFrequentElements;

    /**
     * Initializes TopKFrequentElements instance before each test.
     */
    @BeforeMethod
    public void setup() {
        topKFrequentElements = new TopKFrequentElements();
    }

    /**
     * Tests standard input case.
     * Example: [1,2,2,3,3,3], k = 2
     * Expected Output: [3,2]
     */
    @Test
    public void testStandardCase_ShouldReturnTopK() {

        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;

        int[] result = topKFrequentElements.topKFrequent(nums, k);

        Arrays.sort(result);
        Assert.assertEquals(result, new int[]{2, 3}, "Incorrect top K frequent elements");
    }

    /**
     * Tests when k = 1.
     * Example: [5,5,5,1]
     * Expected Output: [5]
     */
    @Test
    public void testSingleTopElement_ShouldReturnCorrectValue() {

        int[] nums = {5, 5, 5, 1};
        int k = 1;

        int[] result = topKFrequentElements.topKFrequent(nums, k);

        Assert.assertEquals(result[0], 5, "Incorrect top frequent element");
    }

    /**
     * Tests array with all unique elements.
     * Example: [1,2,3,4], k = 2
     * Expected Output: Any two elements
     */
    @Test
    public void testAllUniqueElements_ShouldReturnAnyK() {

        int[] nums = {1, 2, 3, 4};
        int k = 2;

        int[] result = topKFrequentElements.topKFrequent(nums, k);

        Assert.assertEquals(result.length, 2, "Expected result length should be k");
    }

    /**
     * Tests array with negative numbers.
     * Example: [-1,-1,2,2,2]
     * Expected Output: [2]
     */
    @Test
    public void testNegativeNumbers_ShouldWorkCorrectly() {

        int[] nums = {-1, -1, 2, 2, 2};
        int k = 1;

        int[] result = topKFrequentElements.topKFrequent(nums, k);

        Assert.assertEquals(result[0], 2, "Incorrect result with negative numbers");
    }
}
