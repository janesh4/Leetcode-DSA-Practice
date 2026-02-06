package SlidingWindow;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for LongestSubstringWithoutRepeating.
 * Validates sliding window based substring logic.
 */
public class LongestSubstringWithoutRepeatingTest {

    private LongestSubstringWithoutRepeating longestSubstring;

    /**
     * Initializes LongestSubstringWithoutRepeating instance before each test.
     */
    @BeforeMethod
    public void setup() {
        longestSubstring = new LongestSubstringWithoutRepeating();
    }

    /**
     * Tests standard input case.
     * Example: "abcabcbb"
     * Expected Output: 3 ("abc")
     */
    @Test
    public void testStandardCase_ShouldReturnCorrectLength() {

        String input = "abcabcbb";

        int result = longestSubstring.lengthOfLongestSubstring(input);

        Assert.assertEquals(result, 3, "Incorrect longest substring length");
    }

    /**
     * Tests input with all repeating characters.
     * Example: "bbbbb"
     * Expected Output: 1
     */
    @Test
    public void testAllRepeatingCharacters_ShouldReturnOne() {

        String input = "bbbbb";

        int result = longestSubstring.lengthOfLongestSubstring(input);

        Assert.assertEquals(result, 1, "All repeating characters should return length 1");
    }

    /**
     * Tests input with mixed repeating pattern.
     * Example: "pwwkew"
     * Expected Output: 3 ("wke")
     */
    @Test
    public void testMixedRepeatingPattern_ShouldReturnCorrectLength() {

        String input = "pwwkew";

        int result = longestSubstring.lengthOfLongestSubstring(input);

        Assert.assertEquals(result, 3, "Incorrect sliding window calculation");
    }

    /**
     * Tests empty string input.
     * Expected Output: 0
     */
    @Test
    public void testEmptyString_ShouldReturnZero() {

        String input = "";

        int result = longestSubstring.lengthOfLongestSubstring(input);

        Assert.assertEquals(result, 0, "Empty input should return 0");
    }

    /**
     * Tests string with single character.
     * Expected Output: 1
     */
    @Test
    public void testSingleCharacter_ShouldReturnOne() {

        String input = "a";

        int result = longestSubstring.lengthOfLongestSubstring(input);

        Assert.assertEquals(result, 1, "Single character input should return 1");
    }

    /**
     * Tests string with spaces.
     * Example: "a b c a"
     * Expected Output: 3 ("a b" or "b c")
     */
    @Test
    public void testStringWithSpaces_ShouldReturnCorrectLength() {

        String input = "a b c a";

        int result = longestSubstring.lengthOfLongestSubstring(input);

        Assert.assertEquals(result, 3, "Spaces should be treated as valid characters");
    }
}

