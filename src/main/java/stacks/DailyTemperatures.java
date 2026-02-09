package stacks;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // Resolve previous colder days
            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            // push current index
            stack.push(i);
        }

        return result;
    }
}
