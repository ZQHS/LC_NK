package leetcode;

public class LeetCode1422 {
    public int maxScore(String s) {
        int sum = 0;

        if (s.charAt(0) == '0') {
            sum += 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum += 1;
            }
        }

        int max = sum;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                sum += 1;
            } else {
                sum -= 1;
            }
            max = Math.max(sum, max);
        }

        return max;
    }
}
