package trees;

import java.util.*;

/**
 * Problem: Binary Tree Level Order Traversal
 * One-line: Return level-by-level traversal of a binary tree.
 * LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Core Idea:
 * Use Breadth-First Search (BFS) with a queue.
 * Process nodes level-by-level using queue size.
 *
 * Mind Map:
 * Step 1: If root is null → return empty list.
 * Step 2: Push root into queue.
 * Step 3: While queue not empty:
 *         - Get current level size.
 *         - Process exactly that many nodes.
 *         - Add children to queue.
 * Step 4: Store each level result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Common Pitfalls:
 * - Forgetting level size loop → mixes levels.
 * - Using DFS instead of BFS.
 * - Not handling null root.
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Returns level-order traversal of the tree.
     *
     * @param root root of binary tree
     * @return list of levels
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }
}