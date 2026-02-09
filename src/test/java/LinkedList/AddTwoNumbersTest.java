package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersTest {

    private SinglyListNode build(int... values) {
        SinglyListNode dummy = new SinglyListNode(0);
        SinglyListNode curr = dummy;

        for (int v : values) {
            curr.next= new SinglyListNode(v);
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
    public void testExampleCase() {
        AddTwoNumbers solution = new AddTwoNumbers();

        SinglyListNode l1 = build(2, 4, 3);
        SinglyListNode l2 = build(5, 6, 4);

        int[] result = toArray(solution.addTwoNumbers(l1, l2));

        Assert.assertEquals(result, new int[]{7, 0, 8});
    }

    @Test
    public void testCarryOverflow() {
        AddTwoNumbers solution = new AddTwoNumbers();

        SinglyListNode l1 = build(9, 9, 9);
        SinglyListNode l2 = build(1);

        int[] result = toArray(solution.addTwoNumbers(l1, l2));

        Assert.assertEquals(result, new int[]{0, 0, 0, 1});
    }

    @Test
    public void testZeroCase() {
        AddTwoNumbers solution = new AddTwoNumbers();

        SinglyListNode l1 = build(0);
        SinglyListNode l2 = build(0);

        int[] result = toArray(solution.addTwoNumbers(l1, l2));

        Assert.assertEquals(result, new int[]{0});
    }
}

