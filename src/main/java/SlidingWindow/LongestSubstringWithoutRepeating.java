package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Problem: Find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeating {

    /**
     * MIND MAP:
     * Initialize sliding window → Expand right pointer
     * → If duplicate found → Shrink left pointer
     * → Maintain unique characters set
     * → Update max window size
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int lengthOfLongestSubstring(String input) {

        // Left pointer of sliding window
        int left = 0;

        // Tracks maximum length found
        int maxLength = 0;

        // Stores unique characters inside current window
        Set<Character> uniqueCharacters = new HashSet<>();

        // Right pointer expands the window
        for (int right = 0; right < input.length(); right++) {

            char currentChar = input.charAt(right);

            // Shrink window until duplicate is removed
            while (uniqueCharacters.contains(currentChar)) {
                uniqueCharacters.remove(input.charAt(left));
                left++;
            }

            // Add current character to window
            uniqueCharacters.add(currentChar);

            // Update maximum window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
