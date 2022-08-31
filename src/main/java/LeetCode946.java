import java.util.Stack;

public class LeetCode946 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 3, 5, 1, 2};
        System.out.println(new LeetCode946().validateStackSequences(a, b));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i <= pushed.length && j < popped.length) {
            System.out.println(i);
            System.out.println(j);
            if (stack.isEmpty()) {
                stack.push(pushed[i++]);
            } else if (stack.peek() == popped[j]) {
                stack.pop();
                ++j;
            } else {
                if (i < pushed.length) {
                    stack.push(pushed[i]);
                }
                ++i;
            }
        }

        return i == pushed.length && j == popped.length;
    }
}
