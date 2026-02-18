package greedy;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit tests for JumpGameII greedy BFS solution.
 *
 * Coverage:
 * - Standard examples
 * - Single element
 * - Already reachable in one jump
 * - Larger ranges
 */
public class JumpGameIITest {

    private JumpGameII jumpGame;

    @BeforeMethod
    public void setUp() {
        jumpGame = new JumpGameII();
    }

    /** nums = [2,3,1,1,4] → 2 */
    @Test
    public void shouldReturnMinJumpsForBasicCase() {
        int[] nums = {2, 3, 1, 1, 4};
        Assert.assertEquals(jumpGame.jump(nums), 2);
    }

    /** nums = [2,3,0,1,4] → 2 */
    @Test
    public void shouldHandleZeroInsideArray() {
        int[] nums = {2, 3, 0, 1, 4};
        Assert.assertEquals(jumpGame.jump(nums), 2);
    }

    /** Single element → 0 jumps needed */
    @Test
    public void shouldReturnZeroForSingleElement() {
        int[] nums = {0};
        Assert.assertEquals(jumpGame.jump(nums), 0);
    }

    /** Direct large jump */
    @Test
    public void shouldReturnOneWhenDirectJumpPossible() {
        int[] nums = {10, 1, 1, 1};
        Assert.assertEquals(jumpGame.jump(nums), 1);
    }

    /** Minimal increasing path */
    @Test
    public void shouldHandleSequentialOnes() {
        int[] nums = {1, 1, 1, 1};
        Assert.assertEquals(jumpGame.jump(nums), 3);
    }
}
