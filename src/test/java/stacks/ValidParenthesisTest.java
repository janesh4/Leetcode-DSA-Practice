package stacks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidParenthesisTest {

    private final ValidParenthesis solution = new ValidParenthesis();

    @Test
    public void testValidSimple() {
        Assert.assertTrue(solution.isValid("()"));
    }

    @Test
    public void testValidMixed() {
        Assert.assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    public void testValidNested() {
        Assert.assertTrue(solution.isValid("{[()]}"));
    }

    @Test
    public void testInvalidWrongOrder() {
        Assert.assertFalse(solution.isValid("(]"));
    }

    @Test
    public void testInvalidCrossed() {
        Assert.assertFalse(solution.isValid("([)]"));
    }

    @Test
    public void testInvalidExtraOpening() {
        Assert.assertFalse(solution.isValid("((("));
    }

    @Test
    public void testInvalidExtraClosing() {
        Assert.assertFalse(solution.isValid(")))"));
    }

    @Test
    public void testEmptyString() {
        Assert.assertTrue(solution.isValid(""));
    }

    @Test
    public void testSingleCharacter() {
        Assert.assertFalse(solution.isValid("("));
    }
}
