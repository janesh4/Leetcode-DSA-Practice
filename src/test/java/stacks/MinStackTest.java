package stacks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinStackTest {

    @Test
    public void testBasicOperations() {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);

        Assert.assertEquals(minStack.getMin(), 3);
        Assert.assertEquals(minStack.top(), 7);

        minStack.pop();
        Assert.assertEquals(minStack.getMin(), 3);

        minStack.pop();
        Assert.assertEquals(minStack.getMin(), 5);
    }

    @Test
    public void testSingleElement() {
        MinStack minStack = new MinStack();

        minStack.push(10);
        Assert.assertEquals(minStack.getMin(), 10);
        Assert.assertEquals(minStack.top(), 10);
    }

    @Test
    public void testIncreasingOrder() {
        MinStack minStack = new MinStack();

        minStack.push(1);
        minStack.push(2);
        minStack.push(3);

        Assert.assertEquals(minStack.getMin(), 1);
    }
}
