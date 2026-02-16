package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem: Balanced Binary Tree
 * One-line: Check whether for every node the height difference between
 * left and right subtree is at most 1.
 * LeetCode: https://leetcode.com/problems/balanced-binary-tree/
 *
 * Core Idea:
 * Use iterative post-order traversal (same structural pattern as Diameter).
 * Compute subtree heights bottom-up using stack + map.
 * Return early as soon as imbalance is detected.
 *
 * Mind Map:
 * Step 1: Push root and traverse left-most using stack.
 * Step 2: Do not process node until children are already in map.
 * Step 3: Leaf uses null → height = 0 base case.
 * Step 4: While processing node:
 *         - Get left and right heights.
 *         - If |left - right| > 1 → return false immediately.
 * Step 5: Otherwise store height = 1 + max(left, right).
 * Step 6: If traversal completes → tree is balanced.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Common Pitfalls:
 * - Recomputing height separately → O(n²).
 * - Checking balance only at root.
 * - Forgetting post-order requirement.
 * - Not returning early after detecting imbalance.
 */
public class BalancedBinaryTree {

    /**
     * Determines whether the binary tree is height-balanced.
     *
     * @param root root of binary tree
     * @return true if balanced, otherwise false
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        // base case: null node height = 0
        map.put(null, 0);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);

            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);

            } else {
                node = stack.pop();

                int left = map.get(node.left);
                int right = map.get(node.right);

                // EARLY EXIT on imbalance
                if (Math.abs(left - right) > 1) {
                    return false;
                }

                map.put(node, 1 + Math.max(left, right));
            }
        }

        return true;
    }
}