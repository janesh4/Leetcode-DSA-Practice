package LinkedList;

/**
 * LeetCode Problem: Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * Problem: Detect if a linked list contains a cycle.
 */
public class LinkedListCycleDetection {

    /**
     * MIND MAP:
     * Initialize slow and fast pointers
     * → Move slow by 1 step
     * → Move fast by 2 steps
     * → If pointers meet → cycle exists
     * → If fast reaches null → no cycle
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean hasCycle(SinglyListNode head) {

        // Initialize slow and fast pointers
        SinglyListNode slow = head;
        SinglyListNode fast = head;

        // Traverse list using two pointers
        while (fast != null && fast.next != null) {

            slow = slow.next;           // Move slow pointer by 1
            fast = fast.next.next;     // Move fast pointer by 2

            // If pointers meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast pointer reached null => no cycle
        return false;
    }
}
