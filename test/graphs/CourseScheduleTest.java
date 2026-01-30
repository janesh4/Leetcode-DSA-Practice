package graphs;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for CourseSchedule.
 * Validates topological sort based course dependency resolution.
 */
public class CourseScheduleTest {

    private CourseSchedule courseSchedule;

    /**
     * Initializes CourseSchedule instance before each test.
     */
    @BeforeMethod
    public void setup() {
        courseSchedule = new CourseSchedule();
    }

    /**
     * Tests when all courses can be completed successfully.
     * Example:
     * numCourses = 2
     * prerequisites = [[1,0]]
     * Expected Result: true
     */
    @Test
    public void testValidSchedule_ShouldReturnTrue() {

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        Assert.assertTrue(result, "Expected course schedule to be valid");
    }

    /**
     * Tests when cyclic dependency exists.
     * Example:
     * numCourses = 2
     * prerequisites = [[1,0],[0,1]]
     * Expected Result: false
     */
    @Test
    public void testCyclicDependency_ShouldReturnFalse() {

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        Assert.assertFalse(result, "Expected course schedule to be invalid due to cycle");
    }

    /**
     * Tests when there are no prerequisites.
     * Example:
     * numCourses = 3
     * prerequisites = []
     * Expected Result: true
     */
    @Test
    public void testNoPrerequisites_ShouldReturnTrue() {

        int numCourses = 3;
        int[][] prerequisites = {};

        boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        Assert.assertTrue(result, "All courses should be completed when no prerequisites exist");
    }

    /**
     * Tests complex valid dependency graph.
     * Example:
     * numCourses = 4
     * prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Expected Result: true
     */
    @Test
    public void testComplexValidGraph_ShouldReturnTrue() {

        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        Assert.assertTrue(result, "Expected complex dependency graph to be valid");
    }

    /**
     * Tests self dependency case.
     * Example:
     * numCourses = 1
     * prerequisites = [[0,0]]
     * Expected Result: false
     */
    @Test
    public void testSelfDependency_ShouldReturnFalse() {

        int numCourses = 1;
        int[][] prerequisites = {{0, 0}};

        boolean result = courseSchedule.canFinish(numCourses, prerequisites);

        Assert.assertFalse(result, "Self dependency should result in invalid schedule");
    }
}
