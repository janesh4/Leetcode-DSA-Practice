package stacks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarFleetTest {

    private final CarFleet solution = new CarFleet();

    @Test
    public void testExampleCase() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        int result = solution.carFleet(target, position, speed);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testSingleCar() {
        int target = 10;
        int[] position = {3};
        int[] speed = {3};

        int result = solution.carFleet(target, position, speed);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testNoFleetMerge() {
        int target = 10;
        int[] position = {1, 4, 7};
        int[] speed = {1, 1, 1};

        int result = solution.carFleet(target, position, speed);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testAllMergeIntoOneFleet() {
        int target = 10;
        int[] position = {0, 2, 4};
        int[] speed = {4, 2, 1};

        int result = solution.carFleet(target, position, speed);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testEmptyInput() {
        int target = 10;
        int[] position = {};
        int[] speed = {};

        int result = solution.carFleet(target, position, speed);
        Assert.assertEquals(result, 0);
    }
}
