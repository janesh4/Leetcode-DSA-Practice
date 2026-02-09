package LinkedList;


/**
 * Problem: Add two numbers represented by reversed linked lists and return the sum as a linked list.
 * LeetCode: https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    /**
     * Mind Map Logic:
     * - Traverse both lists together.
     * - Add digits + carry from previous step.
     * - New digit = sum % 10.
     * - New carry = sum / 10.
     * - Continue until l1, l2, and carry are all finished.
     * - Use dummy node to simplify result list building.
     *
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n)) for result list
     */
    public SinglyListNode addTwoNumbers(SinglyListNode l1, SinglyListNode l2) {

        SinglyListNode dummy = new SinglyListNode(0);
        SinglyListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;

            carry = sum / 10;     // tens place → next carry
            int digit = sum % 10; // ones place → current node value

            curr.next = new SinglyListNode(digit);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}

