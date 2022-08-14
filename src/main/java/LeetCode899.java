import java.util.Arrays;

public class LeetCode899 {
    public static void main(String[] args) {
    }

    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k > 1) {
            Arrays.sort(chars);
            return new String(chars);
        } else {
            String min = s;
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = 0; i < chars.length; i++) {
                char head = stringBuilder.charAt(0);
                String next = stringBuilder.deleteCharAt(0).append(head).toString();
                if (next.compareTo(min) < 0) {
                    min = next;
                }
            }
            return min;
        }
    }
}
