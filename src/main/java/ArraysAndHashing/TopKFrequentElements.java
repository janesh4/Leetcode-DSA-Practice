package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode Problem: Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Problem: Return the k most frequent elements in an array.
 */
public class TopKFrequentElements {

    /**
     * MIND MAP:
     * Count frequency using HashMap
     * → Create frequency buckets (index = frequency)
     * → Place elements into buckets
     * → Traverse buckets from high to low
     * → Collect top K elements
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index represents frequency
        List<List<Integer>> frequencyBuckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            frequencyBuckets.add(new ArrayList<>());
        }

        // Step 3: Place numbers into their frequency buckets
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            frequencyBuckets.get(frequency).add(number);
        }

        // Step 4: Collect top K frequent elements from highest frequency
        int[] result = new int[k];
        int resultIndex = 0;

        for (int freq = frequencyBuckets.size() - 1; freq >= 0 && resultIndex < k; freq--) {

            for (int num : frequencyBuckets.get(freq)) {

                result[resultIndex++] = num;

                if (resultIndex == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
