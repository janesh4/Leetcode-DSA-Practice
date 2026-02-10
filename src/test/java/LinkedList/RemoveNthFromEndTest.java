package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEndTest {

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
    public void testRemoveMiddle() {
        RemoveNthFromEnd sol = new RemoveNthFromEnd();

        SinglyListNode head = build(1, 2, 3, 4, 5);
        int[] result = toArray(sol.removeNthFromEnd(head, 2));

        Assert.assertEquals(result, new int[]{1, 2, 3, 5});
    }

    @Test
    public void testRemoveHead() {
        RemoveNthFromEnd sol = new RemoveNthFromEnd();

        SinglyListNode head = build(1);
        int[] result = toArray(sol.removeNthFromEnd(head, 1));

        Assert.assertEquals(result, new int[]{});
    }

    @Test
    public void testRemoveFirstFromTwo() {
        RemoveNthFromEnd sol = new RemoveNthFromEnd();

        SinglyListNode head = build(1, 2);
        int[] result = toArray(sol.removeNthFromEnd(head, 2));

        Assert.assertEquals(result, new int[]{2});
    }
}

