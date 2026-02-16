package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LowestCommonAncestorBSTTest {

    /**
     * Tree:
     *        5
     *      /   \
     *     3     8
     *    / \   / \
     *   1   4 7   9
     *    \
     *     2
     */
    private TreeNode buildTree() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1, null, n2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n1, n4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8, n7, n9);
        return new TreeNode(5, n3, n8);
    }

    /**
     * LCA of 3 and 8 → 5
     */
    @Test
    public void testRootSplit() {
        TreeNode root = buildTree();
        LowestCommonAncestorBST sol = new LowestCommonAncestorBST();

        TreeNode p = root.left;   // 3
        TreeNode q = root.right;  // 8

        Assert.assertEquals(sol.lowestCommonAncestor(root, p, q).val, 5);
    }

    /**
     * LCA of 3 and 4 → 3 (ancestor case)
     */
    @Test
    public void testAncestorCase() {
        TreeNode root = buildTree();
        LowestCommonAncestorBST sol = new LowestCommonAncestorBST();

        TreeNode p = root.left;        // 3
        TreeNode q = root.left.right;  // 4

        Assert.assertEquals(sol.lowestCommonAncestor(root, p, q).val, 3);
    }

    /**
     * Single node tree
     */
    @Test
    public void testSingleNode() {
        TreeNode root = new TreeNode(1);
        LowestCommonAncestorBST sol = new LowestCommonAncestorBST();

        Assert.assertEquals(sol.lowestCommonAncestor(root, root, root).val, 1);
    }
}