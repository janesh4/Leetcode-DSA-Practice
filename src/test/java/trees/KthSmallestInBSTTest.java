package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KthSmallestInBSTTest {

    /**
     * Tree:
     *        5
     *      /   \
     *     3     8
     *    / \   / \
     *   1   4 7   9
     */
    private TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n1, n4);

        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8, n7, n9);

        return new TreeNode(5, n3, n8);
    }

    @Test
    public void testKthSmallest() {
        KthSmallestInBST sol = new KthSmallestInBST();
        TreeNode root = buildTree();

        Assert.assertEquals(sol.kthSmallest(root, 1), 1);
        Assert.assertEquals(sol.kthSmallest(root, 3), 4);
        Assert.assertEquals(sol.kthSmallest(root, 5), 7);
    }

    @Test
    public void testSingleNode() {
        KthSmallestInBST sol = new KthSmallestInBST();
        Assert.assertEquals(sol.kthSmallest(new TreeNode(10), 1), 10);
    }
}