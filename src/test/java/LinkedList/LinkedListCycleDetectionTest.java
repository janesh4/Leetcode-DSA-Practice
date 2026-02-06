package LinkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Test class for LinkedListCycleDetection.
 * Validates Floyd's cycle detection algorithm.
 */
public class LinkedListCycleDetectionTest {

    private LinkedListCycleDetection cycleDetection;

    /**
     * Initializes LinkedListCycleDetection instance before each test.
     */
    @BeforeMethod
    public void setup() {
        cycleDetection = new LinkedListCycleDetection();
    }

    /**
     * Tests linked list with cycle.
     * Input: 1 -> 2 -> 3 -> 4 -> back to 2
     * Expected Output: true
     */
    @Test
    public void testListWithCycle_ShouldReturnTrue() {

        SinglyListNode head = buildCyclicList();

        boolean result = cycleDetection.hasCycle(head);

        Assert.assertTrue(result, "Cycle was expected but not detected");
    }

    /**
     * Tests linked list without cycle.
     * Input: 1 -> 2 -> 3 -> 4
     * Expected Output: false
     */
    @Test
    public void testListWithoutCycle_ShouldReturnFalse() {

        SinglyListNode head = buildList(new int[]{1, 2, 3, 4});

        boolean result = cycleDetection.hasCycle(head);

        Assert.assertFalse(result, "Cycle detected incorrectly");
    }

    /**
     * Tests single node without cycle.
     * Input: 1
     * Expected Output: false
     */
    @Test
    public void testSingleNodeWithoutCycle_ShouldReturnFalse() {

        SinglyListNode head = new SinglyListNode(1);

        boolean result = cycleDetection.hasCycle(head);

        Assert.assertFalse(result, "Single node should not have a cycle");
    }

    /**
     * Tests single node with self cycle.
     * Input: 1 -> back to itself
     * Expected Output: true
     */
    @Test
    public void testSingleNodeWithCycle_ShouldReturnTrue() {

        SinglyListNode head = new SinglyListNode(1);
        head.next = head;

        boolean result = cycleDetection.hasCycle(head);

        Assert.assertTrue(result, "Self cycle should be detected");
    }

    // ---------------- HELPER METHODS ----------------

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

    private SinglyListNode buildCyclicList() {

        SinglyListNode node1 = new SinglyListNode(1);
        SinglyListNode node2 = new SinglyListNode(2);
        SinglyListNode node3 = new SinglyListNode(3);
        SinglyListNode node4 = new SinglyListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create cycle: point last node to node2
        node4.next = node2;

        return node1;
    }
}

