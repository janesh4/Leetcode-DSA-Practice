package SlidingWindow;

/**
 * LeetCode Problem: Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Problem:
 * Return true if s2 contains a permutation of s1 as a substring.
 */
public class PermutationInString {

    /**
     * MIND MAP:
     *
     * Understanding:
     * - Need substring of s2 having same character frequency as s1
     * - Order does NOT matter → frequency comparison needed
     *
     * Approach (Sliding Window):
     * - Create frequency array for s1
     * - Maintain sliding window of size = s1.length in s2
     * - Update window frequency while moving right
     * - Compare both frequency arrays
     * - If equal → permutation exists → return true
     *
     * Complexity:
     * Time: O(N)  (single pass over s2)
     * Space: O(1) (26 lowercase letters)
     */
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] targetFreq = new int[26];
        int[] windowFreq = new int[26];

        // Build frequency for s1
        for (char c : s1.toCharArray()) {
            targetFreq[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            // Add current char to window
            windowFreq[s2.charAt(right) - 'a']++;

            // Remove char leaving the window
            if (right >= windowSize) {
                windowFreq[s2.charAt(right - windowSize) - 'a']--;
            }

            // Compare frequency arrays
            if (matches(targetFreq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    /** Helper method to compare two frequency arrays */
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
