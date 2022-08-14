import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            list.add(nums[i]);
            if ((sum * 2) > total) {
                break;
            }
        }
        return list;
    }

}
