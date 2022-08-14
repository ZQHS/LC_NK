import java.util.HashMap;

public class LeetCode2342 {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, nums[i]);
            } else {
                int n = map.get(sum) + nums[i];
                if (n > max) {
                    max = n;
                }
                if (nums[i] > map.get(sum)) {
                    map.put(sum, nums[i]);
                }
            }
        }
        return max;
    }
}
