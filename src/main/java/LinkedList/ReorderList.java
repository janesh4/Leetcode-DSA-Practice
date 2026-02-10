package LinkedList;

/**
 * Problem: Reorder a linked list as L0 → Ln → L1 → Ln-1 → L2 → Ln-2 ...
 * LeetCode: https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    /**
     * Mind Map (Core Logics):
     *
     * LOGIC 1 — Reach Middle Using Two Pointers
     * - Move slow by 1 step and fast by 2 steps.
     * - When fast reaches end:
     *      → slow stands at END of first half.
     * - Ensures:
     *      even length → equal split
     *      odd length  → first half has one extra node
     *
     * LOGIC 2 — Reverse Second Half In-Place
     * - Iteratively redirect next pointers.
     * - prev always represents head of reversed portion.
     * - prev = null guarantees proper tail termination and avoids cycles.
     *
     * LOGIC 3 — Alternate Merge of Two Halves
     * - Interleave nodes from first half and reversed second half.
     * - Continue until second half is exhausted.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void reorderList(SinglyListNode head) {

        if (head == null || head.next == null) return;

        // STEP 1: Find middle
        SinglyListNode slow = head;
        SinglyListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Detach and reverse second half
        SinglyListNode second = slow.next;
        SinglyListNode prev = null;
        slow.next = null;

        while (second != null) {
            SinglyListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // STEP 3: Merge two halves
        SinglyListNode first = head;
        second = prev;

        while (second != null) {
            SinglyListNode tmp1 = first.next;
            SinglyListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
