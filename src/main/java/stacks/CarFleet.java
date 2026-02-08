package stacks;

import java.util.Arrays;

public class CarFleet {
    /**
     * CAR FLEET — Mind Map
     *
     * Pattern:
     * - Greedy + Sorting by position
     *
     * Core Insight:
     * - Cars cannot overtake
     * - Only time to reach target matters
     * - Process cars from closest → farthest
     *
     * Steps:
     * 1. Compute time = (target - position) / speed
     * 2. Sort cars by position in descending order
     * 3. Traverse once:
     *      - If currentTime > maxTimeAhead → new fleet
     *      - Else → merges with fleet ahead
     *
     * Why Greedy Works:
     * - Fleet speed determined by slowest car ahead
     * - No movement simulation needed
     *
     * Edge Cases:
     * - Single car → 1 fleet
     * - Same arrival time → merge
     * - Empty input → 0 fleets
     *
     * Complexity:
     * - Time  : O(n log n) due to sorting
     * - Space : O(1)
     *
     * Interview One-liner:
     * "Sort by position and greedily count fleets using slowest arrival time ahead,
     * avoiding full simulation."
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int numberOfCars = position.length;

        double[][] cars = new double[numberOfCars][2];

        for (int i = 0; i < numberOfCars; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i] ) / speed[i];
        }
        
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        double maxTime = 0;
        int fleets = 0; 

        for (int i = 0; i < numberOfCars; i ++) {
            if (cars[i][1] > maxTime) {
                fleets ++;
                maxTime = cars[i][1];
            }
        }

        return fleets;
    }

}
