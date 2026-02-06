package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Problem: Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Problem: Find the length of the longest consecutive elements sequence in an array.
 */
public class LongConseqSequence {

    /**
     * MIND MAP:
     * Insert all elements into HashSet
     * → Identify sequence start (num - 1 not present)
     * → Expand sequence forward
     * → Track maximum length
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestConsecutive(int[] nums) {

        // Store all numbers for O(1) lookup
        Set<Integer> numberSet = new HashSet<>();

        for (int num : nums) {
            numberSet.add(num);
        }

        int longestSequenceLength = 0;

        // Iterate through original array
        for (int num : nums) {

            // Only start counting if this number is the beginning of a sequence
            if (!numberSet.contains(num - 1)) {

                int currentNumber = num;
                int currentSequenceLength = 1;

                // Expand the consecutive sequence
                while (numberSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentSequenceLength++;
                }

                // Update longest sequence length
                longestSequenceLength = Math.max(longestSequenceLength, currentSequenceLength);
            }
        }

        return longestSequenceLength;
    }
}
