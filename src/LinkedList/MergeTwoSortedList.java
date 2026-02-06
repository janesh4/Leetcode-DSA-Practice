package LinkedList;

/**
 * LeetCode Problem: Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Problem: Merge two sorted linked lists and return a new sorted list.
 */
public class MergeTwoSortedList {

    /**
     * MIND MAP:
     * Create dummy node → Use current pointer
     * → Compare both list values
     * → Attach smaller node
     * → Move pointers forward
     * → Attach remaining list
     * → Return dummy.next
     *
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     */
    public SinglyListNode mergeTwoLists(SinglyListNode list1, SinglyListNode list2) {

        // Dummy node to simplify merge logic
        SinglyListNode dummyHead = new SinglyListNode(0);

        // Pointer to build merged list
        SinglyListNode current = dummyHead;

        // Merge while both lists have nodes
        while (list1 != null && list2 != null) {

            // Attach smaller value node
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            // Move merged list pointer
            current = current.next;
        }

        // Attach remaining nodes (only one list will be non-null)
        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        // Return merged list head
        return dummyHead.next;
    }
}
