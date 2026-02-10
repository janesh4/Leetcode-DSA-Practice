package LinkedList;

/**
 * Problem: Remove the Nth node from the end of a singly linked list.
 * LeetCode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    /**
     * Mind Map (Two Pointer Technique):
     *
     * 1. Use dummy node to handle edge case of removing head.
     * Why dummy?
     * - Without dummy, left would land ON the node to delete.
     * - Dummy shifts left one step back, enabling uniform deletion
     *   including the case where head itself must be removed.
     * 2. Move right pointer n steps ahead.
     * 3. Move left and right together until right reaches null.
     * 4. left.next will be the node to delete.
     * 5. Skip that node → left.next = left.next.next.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public SinglyListNode removeNthFromEnd(SinglyListNode head, int n) {

        SinglyListNode dummy = new SinglyListNode(0, head);
        SinglyListNode left = dummy;
        SinglyListNode right = head;

        // Move right pointer n steps ahead
        while (n > 0) {
            right = right.next;
            n--;
        }

        // Move both pointers until right reaches end
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Delete nth node from end
        left.next = left.next.next;

        return dummy.next;
    }
}
