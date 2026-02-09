package LinkedList;

/**
 * Find the Duplicate Number.
 * LeetCode: https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Constraints:
 * - Must NOT modify the input array.
 * - Must use only O(1) extra space.
 *
 * Technique Used:
 * - Floyd’s Tortoise and Hare (Cycle Detection),
 *   treating array values as pointers similar to a linked list.
 */
public class FindTheDuplicateNumber {

    /**
     * Mind Map — Floyd Cycle Detection on Array
     *
     * Core Idea:
     * - Each index points to next index using nums[index].
     * - Since numbers are in range 1…n with n+1 elements,
     *   a cycle must exist → duplicate is cycle entry.
     *
     * Phase 1 — Detect intersection:
     * - slow moves 1 step  → slow = nums[slow]
     * - fast moves 2 steps → fast = nums[nums[fast]]
     * - Meeting point confirms cycle.
     *
     * Phase 2 — Find cycle entrance:
     * - Start slow2 from index 0.
     * - Move slow and slow2 one step at a time.
     * - Meeting point = duplicate number.
     *
     * Why O(1) space?
     * - Uses only pointer variables, no extra data structures.
     *
     * Mathematical Insight:
     * - Same proof as linked-list cycle entrance detection:
     *   distance(head→entry) == distance(meeting→entry).
     *
     * Complexity:
     * - Time  : O(n)
     * - Space : O(1)
     *
     * Interview One-liner:
     * "Model the array as a linked list and apply Floyd’s cycle detection
     * to find the cycle entrance, which is the duplicate number."
     */
    public int findDuplicate(int[] nums) {

        int slow = 0, fast = 0;

        // Phase 1: detect meeting point inside cycle
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        // Phase 2: find cycle entrance (duplicate)
        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) return slow;
        }
    }
}

