package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CopyRandomListTest {

    private Node buildExample() {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        return n1;
    }

    /**
     * Validates deep copy:
     * - Different node references
     * - Same values
     * - Random pointers mapped correctly
     */
    private boolean isDeepCopy(Node original, Node copy) {
        while (original != null && copy != null) {

            // must not be same object
            if (original == copy) return false;

            // values must match
            if (original.val != copy.val) return false;

            // random null consistency
            if ((original.random == null) != (copy.random == null)) return false;

            // random values must match (but different objects)
            if (original.random != null &&
                    original.random.val != copy.random.val) return false;

            original = original.next;
            copy = copy.next;
        }

        return original == null && copy == null;
    }

    @Test
    public void testDeepCopyExample() {
        CopyRandomList solution = new CopyRandomList();

        Node head = buildExample();
        Node copied = solution.copyRandomList(head);

        Assert.assertTrue(isDeepCopy(head, copied));
    }

    @Test
    public void testNullInput() {
        CopyRandomList solution = new CopyRandomList();
        Assert.assertNull(solution.copyRandomList(null));
    }
}
