package trees;

import java.util.Stack;

/**
 * LeetCode: https://leetcode.com/problems/invert-binary-tree/
 *
 * One-liner:
 * "Swap left and right child of every node in a binary tree using DFS."
 *
 * Mind Map:
 * Invert Binary Tree
 * ├── Base Case → root == null → return null
 * ├── Data Structure → Stack (DFS iterative)
 * ├── Process Each Node
 * │   ├── Pop node
 * │   ├── Swap left ↔ right
 * │   └── Push children if not null
 * └── Return original root after inversion
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return root;
    }
}