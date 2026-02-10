package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ReorderListTest {

    private SinglyListNode build(int... values) {
        SinglyListNode dummy = new SinglyListNode(0);
        SinglyListNode curr = dummy;

        for (int v : values) {
            curr.next = new SinglyListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private int[] toArray(SinglyListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void testOddLength() {
        ReorderList sol = new ReorderList();

        SinglyListNode head = build(1, 2, 3, 4, 5);
        sol.reorderList(head);

        Assert.assertEquals(toArray(head), new int[]{1, 5, 2, 4, 3});
    }

    @Test
    public void testEvenLength() {
        ReorderList sol = new ReorderList();

        SinglyListNode head = build(1, 2, 3, 4);
        sol.reorderList(head);

        Assert.assertEquals(toArray(head), new int[]{1, 4, 2, 3});
    }

    @Test
    public void testSingleNode() {
        ReorderList sol = new ReorderList();

        SinglyListNode head = build(1);
        sol.reorderList(head);

        Assert.assertEquals(toArray(head), new int[]{1});
    }
}

