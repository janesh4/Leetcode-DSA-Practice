package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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



    /**
     * Returns k most frequent elements using a Min Heap.
     *
     * 🧠 Mindmap to Solve:
     *
     * 1️⃣ Count frequency using HashMap
     *      num → frequency
     *
     * 2️⃣ Use Min Heap of size k
     *      Store: [frequency, number]
     *
     * 3️⃣ Iterate over map entries:
     *      - Push into heap
     *      - If heap size > k → remove smallest frequency
     *
     * 4️⃣ Heap now contains top k frequent elements
     *
     * 5️⃣ Extract elements from heap into result array
     *
     * Why Min Heap?
     * - Keeps smallest frequency at top
     * - Removes unnecessary elements
     * - Maintains only k largest frequencies
     *
     * @param nums input array
     * @param k number of top frequent elements
     * @return array of k most frequent elements
     */
    public int[] topKFrequentHeap(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Min Heap based on frequency
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Maintain heap of size k
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});

            if (minHeap.size() > k) {
                minHeap.poll();  // remove smallest frequency
            }
        }

        // Step 3: Extract result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[1];
        }

        return res;
    }
}
