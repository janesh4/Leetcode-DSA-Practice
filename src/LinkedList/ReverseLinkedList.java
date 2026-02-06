package LinkedList;

/**
 * LeetCode Problem: Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Problem: Reverse a singly linked list and return the new head.
 */
public class ReverseLinkedList {

    /**
     * MIND MAP:
     * Initialize prev = null, curr = head
     * → Store next node
     * → Reverse current node pointer
     * → Move prev forward
     * → Move curr forward
     * → Return prev as new head
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public SinglyListNode reverseList(SinglyListNode head) {

        // Edge case: empty list
        if (head == null) {
            return null;
        }

        SinglyListNode current = head;
        SinglyListNode previous = null;

        // Iterate through the list and reverse links
        while (current != null) {

            // Save next node
            SinglyListNode nextNode = current.next;

            // Reverse pointer
            current.next = previous;

            // Move pointers forward
            previous = current;
            current = nextNode;
        }

        // Previous becomes new head
        return previous;
    }
}
