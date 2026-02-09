package LinkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTheDuplicateNumberTest {

    private final FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

    @Test
    public void testExample1() {
        int[] nums = {1, 3, 4, 2, 2};
        Assert.assertEquals(solution.findDuplicate(nums), 2);
    }

    @Test
    public void testExample2() {
        int[] nums = {3, 1, 3, 4, 2};
        Assert.assertEquals(solution.findDuplicate(nums), 3);
    }

    @Test
    public void testAllSameDuplicate() {
        int[] nums = {2, 2, 2, 2, 2};
        Assert.assertEquals(solution.findDuplicate(nums), 2);
    }

    @Test
    public void testDuplicateAtStart() {
        int[] nums = {1, 1};
        Assert.assertEquals(solution.findDuplicate(nums), 1);
    }

    @Test
    public void testDuplicateAtEnd() {
        int[] nums = {1, 4, 6, 3, 2, 5, 6};
        Assert.assertEquals(solution.findDuplicate(nums), 6);
    }
}

