package trees;

/**
 * Problem: Lowest Common Ancestor in a Binary Search Tree
 * One-line: Find the lowest node that has both given nodes in its subtree.
 * LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Core Idea:
 * Use BST ordering property:
 *   - If both nodes are smaller → move left.
 *   - If both nodes are larger  → move right.
 *   - Otherwise current node is the split point → LCA.
 *
 * Mind Map:
 * Step 1: Start from root.
 * Step 2: Compare p and q values with current node.
 * Step 3: Move left/right if both lie on same side.
 * Step 4: If split occurs OR one equals current → return current.
 *
 * Time Complexity: O(h) where h = tree height.
 * Space Complexity: O(1) iterative.
 *
 * Common Pitfalls:
 * - Treating BST like normal binary tree.
 * - Traversing entire tree instead of single path.
 * - Missing case where current node equals p or q.
 */
public class LowestCommonAncestorBST {

    /**
     * Returns the lowest common ancestor of nodes p and q in a BST.
     *
     * @param root root of BST
     * @param p first node
     * @param q second node
     * @return LCA node
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }

        return null;
    }
}