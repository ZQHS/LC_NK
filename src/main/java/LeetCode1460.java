import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1460 {
    public static void main(String[] args) {
        int[] i1 = {1, 2, 3, 4};
        int[] i2 = {2, 4, 1, 3};
        System.out.println(new LeetCode1460().canBeEqual(i1, i2));

    }

    public boolean canBeEqual(int[] target, int[] arr) {

        if (target.length != arr.length) {
            return false;
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < target.length; ++i) {
            Integer count1 = map1.getOrDefault(target[i], 0);
            map1.put(target[i], count1 + 1);
            Integer count2 = map2.getOrDefault(arr[i], 0);
            map2.put(arr[i], count2 + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.getOrDefault(entry.getKey(), -1) != entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);

    }
}
