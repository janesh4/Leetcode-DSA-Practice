package stacks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DailyTemperaturesTest {

    private final DailyTemperatures solution = new DailyTemperatures();

    @Test
    public void testExampleCase() {
        int[] input = {73,74,75,71,69,72,76,73};
        int[] expected = {1,1,4,2,1,1,0,0};

        Assert.assertEquals(solution.dailyTemperatures(input), expected);
    }

    @Test
    public void testStrictlyIncreasing() {
        int[] input = {30,40,50,60};
        int[] expected = {1,1,1,0};

        Assert.assertEquals(solution.dailyTemperatures(input), expected);
    }

    @Test
    public void testStrictlyDecreasing() {
        int[] input = {60,50,40,30};
        int[] expected = {0,0,0,0};

        Assert.assertEquals(solution.dailyTemperatures(input), expected);
    }

    @Test
    public void testSingleElement() {
        int[] input = {70};
        int[] expected = {0};

        Assert.assertEquals(solution.dailyTemperatures(input), expected);
    }
}

