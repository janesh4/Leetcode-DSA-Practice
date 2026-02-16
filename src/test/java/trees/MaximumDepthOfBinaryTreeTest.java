package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test Mind Map:
 * MaximumDepthOfBinaryTreeTest
 * ├── Create sample tree
 * ├── Call maxDepth()
 * └── Verify returned depth
 */
public class MaximumDepthOfBinaryTreeTest {

    @Test
    public void testMaxDepth() {

        /*
                3
               / \
              9  20
                 / \
                15  7
         Depth = 3
         */

        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        int depth = solution.maxDepth(root);

        Assert.assertEquals(depth, 3);
    }

    @Test
    public void testEmptyTree() {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        Assert.assertEquals(solution.maxDepth(null), 0);
    }
}
