package LinkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for ReverseLinkedList.
 * Validates iterative pointer reversal of singly linked list.
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    /**
     * Initializes ReverseLinkedList instance before each test.
     */
    @BeforeMethod
    public void setup() {
        reverseLinkedList = new ReverseLinkedList();
    }

    /**
     * Tests standard linked list reversal.
     * Input: 1 -> 2 -> 3 -> 4
     * Expected Output: 4 -> 3 -> 2 -> 1
     */
    @Test
    public void testStandardList_ShouldReverseCorrectly() {

        SinglyListNode head = buildList(new int[]{1, 2, 3, 4});

        SinglyListNode reversed = reverseLinkedList.reverseList(head);

        Assert.assertEquals(convertToArray(reversed), new int[]{4, 3, 2, 1},
                "Standard list reversal failed");
    }

    /**
     * Tests single node linked list reversal.
     * Input: 5
     * Expected Output: 5
     */
    @Test
    public void testSingleNode_ShouldRemainSame() {

        SinglyListNode head = buildList(new int[]{5});

        SinglyListNode reversed = reverseLinkedList.reverseList(head);

        Assert.assertEquals(convertToArray(reversed), new int[]{5},
                "Single node reversal should return same node");
    }

    /**
     * Tests empty linked list reversal.
     * Input: null
     * Expected Output: null
     */
    @Test
    public void testEmptyList_ShouldReturnNull() {

        SinglyListNode reversed = reverseLinkedList.reverseList(null);

        Assert.assertNull(reversed, "Empty list reversal should return null");
    }

    /**
     * Tests two node linked list reversal.
     * Input: 1 -> 2
     * Expected Output: 2 -> 1
     */
    @Test
    public void testTwoNodes_ShouldReverseCorrectly() {

        SinglyListNode head = buildList(new int[]{1, 2});

        SinglyListNode reversed = reverseLinkedList.reverseList(head);

        Assert.assertEquals(convertToArray(reversed), new int[]{2, 1},
                "Two node list reversal failed");
    }

    // ---------------- HELPER METHODS ----------------

    /**
     * Builds a linked list from array input.
     */
    private SinglyListNode buildList(int[] values) {

        if (values.length == 0) {
            return null;
        }

        SinglyListNode head = new SinglyListNode(values[0]);
        SinglyListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new SinglyListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Converts linked list to array for easy assertion.
     */
    private int[] convertToArray(SinglyListNode head) {

        int length = 0;
        SinglyListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int[] result = new int[length];
        temp = head;
        int index = 0;

        while (temp != null) {
            result[index++] = temp.val;
            temp = temp.next;
        }

        return result;
    }
}