package trees;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void testValidBST() {
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));

        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
        Assert.assertTrue(sol.isValidBST(root));
    }

    @Test
    public void testInvalidBST() {
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));

        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
        Assert.assertFalse(sol.isValidBST(root));
    }

    @Test
    public void testSingleNode() {
        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
        Assert.assertTrue(sol.isValidBST(new TreeNode(1)));
    }

    @Test
    public void testNullTree() {
        ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
        Assert.assertTrue(sol.isValidBST(null));
    }
}
