package BinarySearch;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTest {

    private final BinarySearch solution = new BinarySearch();

    @Test
    public void testFoundMiddle() {
        Assert.assertEquals(solution.search(new int[]{1,2,3,4,5}, 3), 2);
    }

    @Test
    public void testFoundFirst() {
        Assert.assertEquals(solution.search(new int[]{1,2,3,4,5}, 1), 0);
    }

    @Test
    public void testFoundLast() {
        Assert.assertEquals(solution.search(new int[]{1,2,3,4,5}, 5), 4);
    }

    @Test
    public void testNotFound() {
        Assert.assertEquals(solution.search(new int[]{1,2,3,4,5}, 6), -1);
    }

    @Test
    public void testSingleElement() {
        Assert.assertEquals(solution.search(new int[]{10}, 10), 0);
    }
}

