package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    /**
     * VALID PARENTHESES — Mind Map
     *
     * Pattern:
     * - Stack + HashMap for bracket matching
     *
     * Core Logic:
     * - Traverse string left → right
     * - Opening bracket → push to stack
     * - Closing bracket →
     *      1. Stack must not be empty
     *      2. Pop top element
     *      3. Check closing→opening match using map
     * - Final check → stack must be empty
     *
     * Edge Cases:
     * - Empty string → valid
     * - Starts with closing bracket → invalid
     * - Odd length string → invalid
     * - Remaining stack elements → invalid
     *
     * Complexity:
     * - Time  : O(n)
     * - Space : O(n)
     *
     * Interview One-liner:
     * "Use a stack to track openings and a map for closing-to-opening validation;
     * mismatch or non-empty stack means invalid."
     */
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        Stack<Character> stacks = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!bracketMap.containsKey(c)) {
                stacks.push(c);
            } else {
                if (!stacks.empty()) {
                    char popedChar = stacks.pop();
                    if (!bracketMap.get(c).equals(popedChar)) {
                        return false;

                    }
                }
            }

        }
        return stacks.isEmpty();

    }

}
