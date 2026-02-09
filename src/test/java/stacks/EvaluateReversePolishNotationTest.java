package stacks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EvaluateReversePolishNotationTest {

    private final EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

    @Test
    public void testExample1() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Assert.assertEquals(solution.evalRPN(tokens), 9);
    }

    @Test
    public void testExample2() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Assert.assertEquals(solution.evalRPN(tokens), 6);
    }

    @Test
    public void testLargeExpression() {
        String[] tokens = {
                "10","6","9","3","+","-11","*","/",
                "*","17","+","5","+"
        };
        Assert.assertEquals(solution.evalRPN(tokens), 22);
    }

    @Test
    public void testSingleNumber() {
        String[] tokens = {"42"};
        Assert.assertEquals(solution.evalRPN(tokens), 42);
    }

    @Test
    public void testNegativeDivision() {
        String[] tokens = {"7", "-3", "/"};
        Assert.assertEquals(solution.evalRPN(tokens), -2); // truncates toward zero
    }
}

