import java.util.HashMap;

public class LeetCode1742 {

    public static void main(String[] args) {
        new LeetCode1742().countBalls(5, 15);
    }

    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = compute(i);
            Integer n = map.getOrDefault(sum, 0);
            map.put(sum, n + 1);
        }
        return map.values().stream().max((x, y) -> x - y).get();
    }

    public int compute(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
