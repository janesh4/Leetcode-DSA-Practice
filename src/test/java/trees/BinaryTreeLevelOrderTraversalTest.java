package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeLevelOrderTraversalTest {

    /**
     * Tree:
     *        3
     *       / \
     *      9  20
     *         / \
     *        15  7
     *
     * Output: [[3], [9,20], [15,7]]
     */
    @Test
    public void testExampleTree() {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );

        Assert.assertEquals(sol.levelOrder(root), expected);
    }

    @Test
    public void testSingleNode() {
        BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );

        Assert.assertEquals(sol.levelOrder(new TreeNode(1)), expected);
    }

    @Test
    public void testNullTree() {
        BinaryTreeLevelOrderTraversal sol = new BinaryTreeLevelOrderTraversal();
        Assert.assertTrue(sol.levelOrder(null).isEmpty());
    }
}