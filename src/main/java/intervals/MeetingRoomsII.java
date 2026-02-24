package intervals;

import java.util.*;

/**
 * LeetCode 253 - Meeting Rooms II
 * 
 * Problem:
 * Given an array of meeting time intervals consisting of start and end times,
 * return the minimum number of conference rooms required.
 * 
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {

    /**
     * Calculates the minimum number of meeting rooms required.
     *
     * 🧠 Mindmap to Solve:
     *
     * 1️⃣ Separate start times and end times
     * 2️⃣ Sort both arrays independently
     * 3️⃣ Use two pointers:
     *      - If next meeting starts before earliest ending meeting:
     *            -> Need new room (count++)
     *      - Else:
     *            -> Reuse room (count--, move end pointer)
     * 4️⃣ Track maximum rooms needed at any time
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     *
     * @param intervals list of meeting intervals
     * @return minimum number of meeting rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        int sz = intervals.size();
        int[] start = new int[sz];
        int[] end = new int[sz];

        for (int i = 0; i < sz; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0;
        int count = 0;
        int result = 0;

        while (s < sz) {

            if (start[s] < end[e]) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}