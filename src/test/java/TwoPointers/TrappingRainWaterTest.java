package TwoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TrappingRainWaterTest {

    @Test
    public void testExample1() {
        TrappingRainWater sol = new TrappingRainWater();
        Assert.assertEquals(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
    }

    @Test
    public void testExample2() {
        TrappingRainWater sol = new TrappingRainWater();
        Assert.assertEquals(sol.trap(new int[]{4,2,0,3,2,5}), 9);
    }

    @Test
    public void testNoWater() {
        TrappingRainWater sol = new TrappingRainWater();
        Assert.assertEquals(sol.trap(new int[]{1,2,3,4}), 0);
    }

    @Test
    public void testSingleBar() {
        TrappingRainWater sol = new TrappingRainWater();
        Assert.assertEquals(sol.trap(new int[]{5}), 0);
    }
}

