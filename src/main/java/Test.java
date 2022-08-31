import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 1, 1, 1};
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.peek());
    }

    public <T> T majorityElement(T[] arr) {
        int n = arr.length;
        HashMap<T, Integer> map = new HashMap<>();
        for (T t : arr) {
            Integer count = map.getOrDefault(t, 0);
            map.put(t, count + 1);
            if ((count + 1) > (n / 2)) {
                return t;
            }
        }
        throw new NoSuchElementException();
    }
}
