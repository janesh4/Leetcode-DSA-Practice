package DP_1D;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit tests for CoinChange dynamic programming solution.
 *
 * Coverage:
 * - Basic valid case
 * - Impossible amount
 * - Zero amount
 * - Single coin denomination
 * - Large denomination skipping
 */
public class CoinChangeTest {

    private CoinChange coinChange;

    /** Runs before each test */
    @BeforeMethod
    public void setUp() {
        coinChange = new CoinChange();
    }

    /** coins = [1,5,10], amount = 12 → expected 3 */
    @Test
    public void shouldReturnMinimumCoinsForValidAmount() {
        int[] coins = {1, 5, 10};
        int result = coinChange.coinChange(coins, 12);

        Assert.assertEquals(result, 3,
                "Minimum coins for amount 12 should be 3");
    }

    /** Impossible case: coins = [2], amount = 3 → -1 */
    @Test
    public void shouldReturnMinusOneWhenAmountNotPossible() {
        int[] coins = {2};
        int result = coinChange.coinChange(coins, 3);

        Assert.assertEquals(result, -1,
                "Amount cannot be formed, should return -1");
    }

    /** Edge case: amount = 0 → 0 coins needed */
    @Test
    public void shouldReturnZeroWhenAmountIsZero() {
        int[] coins = {1, 2, 5};
        int result = coinChange.coinChange(coins, 0);

        Assert.assertEquals(result, 0,
                "Zero amount should require zero coins");
    }

    /** Single denomination exact match */
    @Test
    public void shouldHandleSingleCoinExactMatch() {
        int[] coins = {7};
        int result = coinChange.coinChange(coins, 14);

        Assert.assertEquals(result, 2);
    }

    /** Large coin values ignored when greater than amount */
    @Test
    public void shouldIgnoreCoinsGreaterThanAmount() {
        int[] coins = {10, 20, 50};
        int result = coinChange.coinChange(coins, 5);

        Assert.assertEquals(result, -1);
    }
}
