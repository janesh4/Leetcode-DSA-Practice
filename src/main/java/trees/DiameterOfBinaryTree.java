package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Problem: Diameter of Binary Tree
 * One-line: Find the longest path between any two nodes in a binary tree.
 * LeetCode: https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Core Idea:
 * Perform iterative post-order traversal using stack.
 * Each node computes:
 *   height   = 1 + max(leftHeight, rightHeight)
 *   diameter = max(leftHeight + rightHeight, childDiameters)
 *
 * Mind Map:
 * Step 1: Push root and traverse to left-most using stack.
 * Step 2: Do not process node until both children exist in map.
 * Step 3: Leaf uses null → [height=0, diameter=0] base case.
 * Step 4: Pop node, compute height and diameter bottom-up.
 * Step 5: Continue until root; root diameter is final answer.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 *
 * Common Pitfalls:
 * - Returning diameter instead of height to parent.
 * - Using sum for height instead of max(left, right).
 * - Checking diameter only at root instead of all nodes.
 */
class DiameterOfBinaryTree {

    /**
     * Returns the diameter (number of edges in longest path).
     * Uses stack + hashmap to simulate post-order DFS iteratively.
     *
     * @param root root of binary tree
     * @return diameter of tree in number of edges
     */
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Map<TreeNode, int[]> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        // Base case: null node → height = 0, diameter = 0
        map.put(null, new int[]{0, 0});
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // Traverse left subtree if not processed
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);

            // Traverse right subtree if not processed
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);

            // Process node after children (post-order)
            } else {
                node = stack.pop();

                int[] leftData = map.get(node.left);
                int[] rightData = map.get(node.right);

                int leftHeight = leftData[0];
                int rightHeight = rightData[0];

                // Correct height calculation → take max
                int height = 1 + Math.max(leftHeight, rightHeight);

                int leftDiameter = leftData[1];
                int rightDiameter = rightData[1];

                // Diameter can be:
                // 1) Path through current node
                // 2) Best diameter in left subtree
                // 3) Best diameter in right subtree
                int diameter = Math.max(
                        leftHeight + rightHeight,
                        Math.max(leftDiameter, rightDiameter)
                );

                map.put(node, new int[]{height, diameter});
            }
        }

        return map.get(root)[1];
    }
}