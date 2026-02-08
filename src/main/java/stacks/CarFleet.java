package stacks;

import java.util.Arrays;

public class CarFleet {

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
