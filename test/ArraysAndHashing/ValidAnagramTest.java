package ArraysAndHashing;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidAnagramTest {

    private ValidAnagram validAnagram;

    /**
     * Initializes ValidAnagram object before each test case.
     */
    @BeforeMethod
    public void setup() {
        validAnagram = new ValidAnagram();
    }

    /**
     * Tests when both input strings are valid anagrams.
     * Example: "anagram" and "nagaram"
     * Expected Result: true
     */
    @Test
    public void testValidAnagram_ShouldReturnTrue() {

        String first = "anagram";
        String second = "nagaram";

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertTrue(result, "Expected strings to be valid anagrams");
    }

    /**
     * Tests when input strings are NOT anagrams.
     * Example: "rat" and "car"
     * Expected Result: false
     */
    @Test
    public void testInvalidAnagram_ShouldReturnFalse() {

        String first = "rat";
        String second = "car";

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertFalse(result, "Expected strings to NOT be anagrams");
    }

    /**
     * Tests when input strings have different lengths.
     * Example: "abc" and "ab"
     * Expected Result: false
     */
    @Test
    public void testDifferentLength_ShouldReturnFalse() {

        String first = "abc";
        String second = "ab";

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertFalse(result, "Strings with different lengths cannot be anagrams");
    }

    /**
     * Tests when both input strings are empty.
     * Expected Result: true (Empty strings are considered anagrams)
     */
    @Test
    public void testEmptyStrings_ShouldReturnTrue() {

        String first = "";
        String second = "";

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertTrue(result, "Empty strings should be considered anagrams");
    }

    /**
     * Tests when both input strings contain a single identical character.
     * Example: "a" and "a"
     * Expected Result: true
     */
    @Test
    public void testSingleCharacter_ShouldReturnTrue() {

        String first = "a";
        String second = "a";

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertTrue(result, "Single identical characters should be anagrams");
    }

    /**
     * Tests when input strings contain repeated characters with same frequency.
     * Example: "aabbcc" and "abcabc"
     * Expected Result: true
     */
    @Test
    public void testRepeatedCharacters_ShouldReturnTrue() {

        String first = "aabbcc";
        String second = "abcabc";

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertTrue(result, "Same character frequency should be anagrams");
    }

    /**
     * Tests case-insensitive anagram validation by converting inputs to lowercase.
     * Example: "Listen" and "Silent"
     * Expected Result: true
     */
    @Test
    public void testCaseInsensitiveInput_ShouldReturnTrue() {

        String first = "Listen".toLowerCase();
        String second = "Silent".toLowerCase();

        boolean result = validAnagram.isAnagram(first, second);

        Assert.assertTrue(result, "Lowercase converted strings should be anagrams");
    }
}
