package trees;

import java.util.Stack;


public class MaximumDepthOfBinaryTree {

    public class Pair<U, V> {
    U first;
    V second;

    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

}   
    public int maxDepth(TreeNode root) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        
        int res = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.first;
            int depth = pair.second;


            if (node != null) {
                res = Math.max(res, depth);

                stack.push(new Pair(node.left, depth + 1));
                stack.push(new Pair(node.right, depth + 1));
            }

        }

        return res;
    }
}
