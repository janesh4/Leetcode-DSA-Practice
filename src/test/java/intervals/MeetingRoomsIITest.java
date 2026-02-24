package intervals;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MeetingRoomsIITest {

    private final MeetingRoomsII solution = new MeetingRoomsII();

    @Test
    public void testOverlappingMeetings() {
        List<Interval> intervals = Arrays.asList(
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        );

        int result = solution.minMeetingRooms(intervals);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testNonOverlappingMeetings() {
        List<Interval> intervals = Arrays.asList(
                new Interval(7, 10),
                new Interval(2, 4)
        );

        int result = solution.minMeetingRooms(intervals);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testFullyOverlappingMeetings() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 10),
                new Interval(2, 9),
                new Interval(3, 8)
        );

        int result = solution.minMeetingRooms(intervals);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void testEmptyInput() {
        int result = solution.minMeetingRooms(Arrays.asList());
        Assert.assertEquals(result, 0);
    }
}
