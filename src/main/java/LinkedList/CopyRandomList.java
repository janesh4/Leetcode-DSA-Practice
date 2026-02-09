package LinkedList;

/**
 * Problem: Deep copy a linked list where each node has next and random pointer.
 * LeetCode: https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyRandomList {

    /**
     * Mind Map (O(1) Extra Space Interleaving Trick):
     *
     * Step 1: Insert copied nodes after each original node.
     *   A → B → C
     *   becomes
     *   A → A' → B → B' → C → C'
     *
     * Step 2: Assign random pointers for copied nodes.
     *   copied.random = original.random.next
     *   (because copied node is right after original)
     *
     * Step 3: Separate original and copied lists.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra (excluding output list)
     */
    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node curr = head;

        // STEP 1: Insert copied nodes after originals
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // STEP 2: Assign random pointers to copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // copied.random should point to COPY of random node
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // STEP 3: Separate original and copied lists
        curr = head;
        Node newHead = head.next;

        while (curr != null) {
            Node copy = curr.next;

            // restore original list
            curr.next = copy.next;

            // link copied list
            copy.next = (copy.next != null) ? copy.next.next : null;

            curr = curr.next;
        }

        return newHead;
    }
}
