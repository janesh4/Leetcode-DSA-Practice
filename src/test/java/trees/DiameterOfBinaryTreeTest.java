package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DiameterOfBinaryTreeTest {

    /**
     * Builds tree:
     *
     *        1
     *         \
     *          2
     *         / \
     *        3   4
     *       /
     *      5
     *
     * Diameter = 3 edges (5 → 3 → 2 → 4)
     */
    private TreeNode buildExampleTree() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3, n5, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, n3, n4);
        TreeNode n1 = new TreeNode(1, null, n2);
        return n1;
    }

    @Test
    public void testExampleTree() {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        Assert.assertEquals(sol.diameterOfBinaryTree(buildExampleTree()), 3);
    }

    @Test
    public void testSingleNode() {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        Assert.assertEquals(sol.diameterOfBinaryTree(new TreeNode(1)), 0);
    }

    @Test
    public void testNullTree() {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        Assert.assertEquals(sol.diameterOfBinaryTree(null), 0);
    }

    /**
     * Skewed tree: 1 → 2 → 3 → 4
     * Diameter = 3
     */
    @Test
    public void testSkewedTree() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n4, null);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode n1 = new TreeNode(1, n2, null);

        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        Assert.assertEquals(sol.diameterOfBinaryTree(n1), 3);
    }
}
