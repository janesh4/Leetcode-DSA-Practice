package trees;

import java.util.Stack;

/**
 * Problem: Kth Smallest Element in a BST
 * One-line: Return the kth smallest value in a Binary Search Tree.
 * LeetCode: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Core Idea:
 * Inorder traversal of BST gives values in sorted ascending order.
 * Perform iterative inorder using stack and stop at kth visit.
 *
 * Mind Map:
 * Step 1: Traverse LEFT while pushing nodes to stack.
 * Step 2: Pop node → this is next smallest value.
 * Step 3: Decrement k; if k == 0 → answer found.
 * Step 4: Move to RIGHT subtree and repeat.
 *
 * Time Complexity: O(h + k)
 * Space Complexity: O(h)
 *
 * Common Pitfalls:
 * - Forgetting BST inorder gives sorted order.
 * - Traversing full tree instead of stopping at k.
 * - Using recursion without early stop.
 */
public class KthSmallestInBST {

    /**
     * Returns kth smallest value in BST.
     *
     * @param root root of BST
     * @param k kth position (1-indexed)
     * @return kth smallest value
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Step 1: go left as much as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Step 2: visit node
            curr = stack.pop();
            k--;

            if (k == 0) {
                return curr.val;
            }

            // Step 3: move to right subtree
            curr = curr.right;
        }

        return -1; // invalid k
    }
}