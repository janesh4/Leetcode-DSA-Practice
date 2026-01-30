package ArraysAndHashing;

/**
 * LeetCode: https://leetcode.com/problems/valid-anagram/
 *
 * Problem: Check if two strings are anagrams (same characters with same frequency).
 */
public class ValidAnagram {

    /**
     * MIND MAP:
     * Length check → Frequency array → Single pass count diff → Verify all zero.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isAnagram(String first, String second) {

        // Quick rejection: Different lengths cannot be anagrams
        if (first.length() != second.length()) {
            return false;
        }

        // Frequency array for lowercase English letters (a-z)
        int[] frequency = new int[26];

        // Count characters from both strings in single pass
        for (int i = 0; i < first.length(); i++) {
            frequency[first.charAt(i) - 'a']++;   // Increment for first string
            frequency[second.charAt(i) - 'a']--; // Decrement for second string
        }

        // Verify all frequencies are zero
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

