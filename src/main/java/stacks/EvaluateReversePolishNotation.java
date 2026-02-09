package stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    
    /**
     * EVALUATE REVERSE POLISH NOTATION (RPN) — Mind Map
     *
     * Pattern:
     * - Stack-based expression evaluation
     *
     * Core Logic:
     * - Traverse tokens from left → right
     * - If token is a number → push onto stack
     * - If token is an operator (+, -, *, /):
     *      1. Pop b (second operand)
     *      2. Pop a (first operand)
     *      3. Compute result = a op b
     *      4. Push result back to stack
     * - Final answer → single value remaining in stack
     *
     * Critical Insight:
     * - Operand order matters for subtraction and division:
     *      a - b  ✅ correct
     *      b - a  ❌ incorrect
     *
     * Data Structure Choice:
     * - Use Stack<Integer> because evaluation is numeric
     *
     * Edge Cases:
     * - Single number → return directly
     * - Negative numbers handled via Integer.parseInt
     * - Division truncates toward zero (Java default)
     * - Valid RPN leaves exactly one element in stack
     *
     * Complexity:
     * - Time  : O(n)  → each token processed once
     * - Space : O(n)  → stack in worst case
     *
     * Interview One-liner:
     * "Use a stack to evaluate postfix expressions by pushing numbers and
     * applying operators on the last two operands in correct order."
     */

    public int evalRPN(String[] tokens) {

    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {

        if (token.equals("+")) {
            stack.push(stack.pop() + stack.pop());

        } else if (token.equals("-")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a - b);

        } else if (token.equals("*")) {
            stack.push(stack.pop() * stack.pop());

        } else if (token.equals("/")) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(a / b);

        } else {
            stack.push(Integer.parseInt(token));
        }
    }

    return stack.pop();
}


}
