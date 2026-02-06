package ArraysAndHashing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lombok.extern.slf4j.Slf4j;



/**
 * Test class for LongConseqSequence.
 * Validates longest consecutive sequence logic using HashSet.
 */
@Slf4j
public class LongConseqSequenceTest {

    private LongConseqSequence longConseqSequence;

    /**
     * Initializes LongConseqSequence instance before each test.
     */
    @BeforeMethod
    public void setup() {
        longConseqSequence = new LongConseqSequence();
    }

    /**
     * Tests standard input case.
     * Example: [2,20,4,10,3,4,5]
     * Expected Output: 4 (sequence: 2,3,4,5)
     */
    @Test
    public void testStandardCase_ShouldReturnCorrectLength() {

        int[] nums = {2, 20, 4, 10, 3, 4, 5};

        int result = longConseqSequence.longestConsecutive(nums);

        Assert.assertEquals(result, 4, "Incorrect longest consecutive sequence length");
    }

    /**
     * Tests empty input array.
     * Expected Output: 0
     */
    @Test
    public void testEmptyArray_ShouldReturnZero() {

        int[] nums = {};

        int result = longConseqSequence.longestConsecutive(nums);

        Assert.assertEquals(result, 0, "Empty array should return 0");
    }

    /**
     * Tests array with single element.
     * Expected Output: 1
     */
    @Test
    public void testSingleElement_ShouldReturnOne() {

        int[] nums = {7};

        int result = longConseqSequence.longestConsecutive(nums);

        log.info("Result for single element test: {}", result);

        Assert.assertEquals(result, 1, "Single element should return sequence length 1");
    }

    /**
     * Tests array with duplicate values.
     * Example: [1,2,2,3]
     * Expected Output: 3
     */
    @Test
    public void testDuplicateValues_ShouldReturnCorrectLength() {

        int[] nums = {1, 2, 2, 3};

        int result = longConseqSequence.longestConsecutive(nums);

        Assert.assertEquals(result, 3, "Duplicate values should not affect sequence length");
    }

    /**
     * Tests array with no consecutive numbers.
     * Example: [10,5,20]
     * Expected Output: 1
     */
    @Test
    public void testNoConsecutiveNumbers_ShouldReturnOne() {

        int[] nums = {10, 5, 20};

        int result = longConseqSequence.longestConsecutive(nums);

        Assert.assertEquals(result, 1, "No consecutive numbers should return 1");
    }

    /**
     * Tests array with negative numbers.
     * Example: [-1,0,1,2]
     * Expected Output: 4
     */
    @Test
    public void testNegativeNumbers_ShouldReturnCorrectLength() {

        int[] nums = {-1, 0, 1, 2};

        int result = longConseqSequence.longestConsecutive(nums);

        Assert.assertEquals(result, 4, "Negative numbers should be handled correctly");
    }
}
