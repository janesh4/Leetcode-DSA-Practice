package SlidingWindow;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for PermutationInString using Lombok @Slf4j logging.
 */
@Slf4j
public class PermutationInStringTest {

    private PermutationInString solution;

    /** Initialize before each test */
    @BeforeMethod
    public void setup() {
        log.info("Setting up PermutationInString test instance");
        solution = new PermutationInString();
    }

    /** Standard example case */
    @Test
    public void testExampleCase_ShouldReturnTrue() {

        String s1 = "abc";
        String s2 = "lecabee";

        log.info("Running testExampleCase with s1={}, s2={}", s1, s2);

        boolean result = solution.checkInclusion(s1, s2);

        log.info("Result obtained: {}", result);

        Assert.assertTrue(result, "Expected permutation to exist in s2");
    }

    /** No permutation exists */
    @Test
    public void testNoPermutation_ShouldReturnFalse() {

        String s1 = "ab";
        String s2 = "eidboaoo";

        log.info("Running testNoPermutation with s1={}, s2={}", s1, s2);

        boolean result = solution.checkInclusion(s1, s2);

        log.info("Result obtained: {}", result);

        Assert.assertFalse(result, "Permutation should not exist in s2");
    }
}
