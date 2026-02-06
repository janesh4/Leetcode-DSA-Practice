package LinkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for MergeTwoSortedList.
 * Validates merging of two sorted linked lists.
 */
public class MergeTwoSortedListTest {

    private MergeTwoSortedList mergeTwoSortedList;

    /**
     * Initializes MergeTwoSortedList instance before each test.
     */
    @BeforeMethod
    public void setup() {
        mergeTwoSortedList = new MergeTwoSortedList();
    }

    /**
     * Tests merging two normal sorted lists.
     * Input:
     * List1: 1 -> 2 -> 4
     * List2: 1 -> 3 -> 4
     * Expected Output:
     * 1 -> 1 -> 2 -> 3 -> 4 -> 4
     */
    @Test
    public void testStandardMerge_ShouldMergeCorrectly() {

        SinglyListNode list1 = buildList(new int[]{1, 2, 4});
        SinglyListNode list2 = buildList(new int[]{1, 3, 4});

        SinglyListNode merged = mergeTwoSortedList.mergeTwoLists(list1, list2);

        Assert.assertEquals(convertToArray(merged),
                new int[]{1, 1, 2, 3, 4, 4},
                "Standard merge failed");
    }

    /**
     * Tests when first list is empty.
     * Input:
     * List1: null
     * List2: 1 -> 2
     * Expected Output:
     * 1 -> 2
     */
    @Test
    public void testFirstListEmpty_ShouldReturnSecondList() {

        SinglyListNode list2 = buildList(new int[]{1, 2});

        SinglyListNode merged = mergeTwoSortedList.mergeTwoLists(null, list2);

        Assert.assertEquals(convertToArray(merged),
                new int[]{1, 2},
                "Merge with empty first list failed");
    }

    /**
     * Tests when second list is empty.
     * Input:
     * List1: 3 -> 5
     * List2: null
     * Expected Output:
     * 3 -> 5
     */
    @Test
    public void testSecondListEmpty_ShouldReturnFirstList() {

        SinglyListNode list1 = buildList(new int[]{3, 5});

        SinglyListNode merged = mergeTwoSortedList.mergeTwoLists(list1, null);

        Assert.assertEquals(convertToArray(merged),
                new int[]{3, 5},
                "Merge with empty second list failed");
    }

    /**
     * Tests merging single node lists.
     * Input:
     * List1: 2
     * List2: 1
     * Expected Output:
     * 1 -> 2
     */
    @Test
    public void testSingleNodeLists_ShouldMergeCorrectly() {

        SinglyListNode list1 = buildList(new int[]{2});
        SinglyListNode list2 = buildList(new int[]{1});

        SinglyListNode merged = mergeTwoSortedList.mergeTwoLists(list1, list2);

        Assert.assertEquals(convertToArray(merged),
                new int[]{1, 2},
                "Single node merge failed");
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

