package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test Mind Map:
 * InvertBinaryTreeTest
 * ├── Create sample tree
 * ├── Call invertTree()
 * └── Verify swapped structure using assertions
 */
public class InvertBinaryTreeTest {

    @Test
    public void testInvertTree() {

        /*
                4
               / \
              2   7
             / \ / \
            1  3 6  9
         */

        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode inverted = solution.invertTree(root);

        /*
                4
               / \
              7   2
             / \ / \
            9  6 3  1
         */

        Assert.assertEquals(inverted.left.val, 7);
        Assert.assertEquals(inverted.right.val, 2);

        Assert.assertEquals(inverted.left.left.val, 9);
        Assert.assertEquals(inverted.left.right.val, 6);

        Assert.assertEquals(inverted.right.left.val, 3);
        Assert.assertEquals(inverted.right.right.val, 1);
    }
}
