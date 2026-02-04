package DP_1D;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for ClimbingStairs.
 * Validates dynamic programming solution for staircase problem.
 */
public class ClimbingStairsTest {

    private ClimbingStairs climbingStairs;

    /**
     * Initializes ClimbingStairs instance before each test.
     */
    @BeforeMethod
    public void setup() {
        climbingStairs = new ClimbingStairs();
    }

    /**
     * Tests minimum input case.
     * Input: n = 1
     * Expected Output: 1
     */
    @Test
    public void testOneStep_ShouldReturnOne() {

        int result = climbingStairs.climbStairs(1);

        Assert.assertEquals(result, 1, "Incorrect result for n = 1");
    }

    /**
     * Tests second base case.
     * Input: n = 2
     * Expected Output: 2
     */
    @Test
    public void testTwoSteps_ShouldReturnTwo() {

        int result = climbingStairs.climbStairs(2);

        Assert.assertEquals(result, 2, "Incorrect result for n = 2");
    }

    /**
     * Tests standard input case.
     * Input: n = 3
     * Expected Output: 3
     */
    @Test
    public void testThreeSteps_ShouldReturnThree() {

        int result = climbingStairs.climbStairs(3);

        Assert.assertEquals(result, 3, "Incorrect result for n = 3");
    }

    /**
     * Tests larger input case.
     * Input: n = 5
     * Expected Output: 8
     */
    @Test
    public void testFiveSteps_ShouldReturnEight() {

        int result = climbingStairs.climbStairs(5);

        Assert.assertEquals(result, 8, "Incorrect result for n = 5");
    }

    /**
     * Tests bigger value for performance correctness.
     * Input: n = 10
     * Expected Output: 89
     */
    @Test
    public void testTenSteps_ShouldReturnCorrectValue() {

        int result = climbingStairs.climbStairs(10);

        Assert.assertEquals(result, 89, "Incorrect result for n = 10");
    }
}
