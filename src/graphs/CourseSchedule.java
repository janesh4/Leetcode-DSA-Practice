package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode Problem: Course Schedule
 * https://leetcode.com/problems/course-schedule/
 *
 * Problem: Determine if all courses can be finished given prerequisite dependencies.
 */
public class CourseSchedule {

    /**
     * MIND MAP:
     *  * Build adjacency list → Compute indegree array
     *  → Push zero indegree nodes into queue
     *  → BFS process (pop → reduce neighbors indegree)
     *  → Push newly zero indegree nodes
     *  → Count processed nodes → Compare with total courses
     *
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency list to represent course dependency graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Array to store indegree (number of prerequisites) for each course
        int[] indegree = new int[numCourses];

        // Build graph and indegree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dependency = prerequisite[1];

            graph.get(dependency).add(course);
            indegree[course]++;
        }

        // Queue for BFS (stores courses with zero prerequisites)
        Queue<Integer> queue = new LinkedList<>();

        // Add all courses with no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Count of courses that can be completed
        int completedCourses = 0;

        // Perform BFS Topological Sort
        while (!queue.isEmpty()) {

            int currentCourse = queue.poll();
            completedCourses++;

            // Reduce indegree of dependent courses
            for (int neighborCourse : graph.get(currentCourse)) {

                indegree[neighborCourse]--;

                // If no prerequisites left, add to queue
                if (indegree[neighborCourse] == 0) {
                    queue.offer(neighborCourse);
                }
            }
        }

        // If all courses are processed, schedule is possible
        return completedCourses == numCourses;
    }
}
