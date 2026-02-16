package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BalancedBinaryTreeTest {

    /**
     * Balanced tree:
     *        1
     *       / \
     *      2   3
     */
    @Test
    public void testBalancedTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        BalancedBinaryTree sol = new BalancedBinaryTree();
        Assert.assertTrue(sol.isBalanced(root));
    }

    /**
     * Unbalanced tree:
     * 1 → 2 → 3 → 4
     */
    @Test
    public void testUnbalancedTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                null),
                        null),
                null);

        BalancedBinaryTree sol = new BalancedBinaryTree();
        Assert.assertFalse(sol.isBalanced(root));
    }

    /**
     * Single node tree → balanced
     */
    @Test
    public void testSingleNode() {
        BalancedBinaryTree sol = new BalancedBinaryTree();
        Assert.assertTrue(sol.isBalanced(new TreeNode(1)));
    }

    /**
     * Null tree → balanced
     */
    @Test
    public void testNullTree() {
        BalancedBinaryTree sol = new BalancedBinaryTree();
        Assert.assertTrue(sol.isBalanced(null));
    }

    /**
     * Slightly deeper balanced tree
     *        1
     *       / \
     *      2   3
     *     /
     *    4
     */
    @Test
    public void testDeepBalancedTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3));

        BalancedBinaryTree sol = new BalancedBinaryTree();
        Assert.assertTrue(sol.isBalanced(root));
    }
}