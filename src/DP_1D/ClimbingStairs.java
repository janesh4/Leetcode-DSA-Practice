package DP_1D;

/**
 * LeetCode Problem: Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * Problem: Return the number of distinct ways to climb to the top using 1 or 2 steps.
 */
public class ClimbingStairs {

    /**
     * MIND MAP:
     * Handle base cases (n <= 2)
     * → Initialize dp for step1 and step2
     * → Iterate from step 3 to n
     * → Current = previous + previousToPrevious
     * → Shift pointers forward
     * → Return result
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int climbStairs(int n) {

        // Base cases
        if (n <= 2) {
            return n;
        }

        // Ways to reach step 1
        int previousToPreviousStep = 1;

        // Ways to reach step 2
        int previousStep = 2;

        // Build solution bottom-up from step 3
        for (int currentStep = 3; currentStep <= n; currentStep++) {

            // Current step ways = sum of previous two steps
            int currentWays = previousStep + previousToPreviousStep;

            // Shift window forward
            previousToPreviousStep = previousStep;
            previousStep = currentWays;
        }

        // Final result stored in previousStep
        return previousStep;
    }
}
