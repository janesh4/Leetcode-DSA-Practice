package trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem: Validate Binary Search Tree
 * One-line: Determine whether a binary tree satisfies global BST ordering.
 * LeetCode: https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Core Idea:
 * Use BFS with value ranges inherited from ancestors.
 * Each node must lie strictly within (min, max).
 *
 * Mind Map:
 * Step 1: Root range = (-∞, +∞).
 * Step 2: For LEFT child → update MAX bound to parent value.
 * Step 3: For RIGHT child → update MIN bound to parent value.
 * Step 4: If any node violates its range → return false.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Common Pitfalls:
 * - Checking only parent-child relation instead of global range.
 * - Using int bounds → overflow risk.
 * - Allowing equality instead of strict inequality.
 */
public class ValidateBinarySearchTree {

    /**
     * Validates whether the given tree is a BST.
     *
     * @param root root of binary tree
     * @return true if valid BST, otherwise false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Queue<NodeRange> queue = new ArrayDeque<>();
        queue.offer(new NodeRange(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!queue.isEmpty()) {
            NodeRange current = queue.poll();
            TreeNode node = current.node;

            // Node must lie strictly within inherited (min, max) range
            if (!(current.min < node.val && node.val < current.max)) {
                return false;
            }

            if (node.left != null) {
                // LEFT subtree values must be < current node value
                // → tighten MAX bound to node.val
                queue.offer(new NodeRange(node.left, current.min, node.val));
            }

            if (node.right != null) {
                // RIGHT subtree values must be > current node value
                // → tighten MIN bound to node.val
                queue.offer(new NodeRange(node.right, node.val, current.max));
            }
        }

        return true;
    }

    /**
     * Helper structure storing node with its valid value range.
     */
    private static class NodeRange {
        TreeNode node;
        long min;
        long max;

        NodeRange(TreeNode node, long min, long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}