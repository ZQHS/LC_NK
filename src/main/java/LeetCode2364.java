import java.util.HashMap;

public class LeetCode2364 {
    public static void main(String[] args) {
        int[] ints = new int[]{4, 1, 3, 3};
        System.out.println(new LeetCode2364().countBadPairs(ints));
    }

    public long countBadPairs(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] - i;
            Integer sum = map.getOrDefault(tmp, 0);
            res += i - sum;
            map.put(tmp, sum + 1);
        }

        return res;
    }


}
