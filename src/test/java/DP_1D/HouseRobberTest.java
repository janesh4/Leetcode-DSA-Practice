package DP_1D;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit tests for HouseRobber DP solution.
 *
 * Coverage:
 * - Standard example cases
 * - Single house
 * - Two houses
 * - Empty array
 * - Large values
 */
public class HouseRobberTest {

    private HouseRobber houseRobber;

    /** Runs before each test */
    @BeforeMethod
    public void setUp() {
        houseRobber = new HouseRobber();
    }

    /** nums = [1,2,3,1] → 4 */
    @Test
    public void shouldReturnMaxLootForBasicCase() {
        int[] nums = {1, 2, 3, 1};
        Assert.assertEquals(houseRobber.rob(nums), 4);
    }

    /** nums = [2,7,9,3,1] → 12 */
    @Test
    public void shouldReturnMaxLootForLargerCase() {
        int[] nums = {2, 7, 9, 3, 1};
        Assert.assertEquals(houseRobber.rob(nums), 12);
    }

    /** Single house */
    @Test
    public void shouldHandleSingleHouse() {
        int[] nums = {5};
        Assert.assertEquals(houseRobber.rob(nums), 5);
    }

    /** Two houses → choose max */
    @Test
    public void shouldHandleTwoHouses() {
        int[] nums = {2, 10};
        Assert.assertEquals(houseRobber.rob(nums), 10);
    }

    /** Empty array → 0 */
    @Test
    public void shouldReturnZeroForEmptyArray() {
        int[] nums = {};
        Assert.assertEquals(houseRobber.rob(nums), 0);
    }
}
