package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int res = 1;
        int tmp = pairs[0][1];

        for (int i = 1; i < pairs.length; ++i) {
            if (pairs[i][0] > tmp) {
                tmp = pairs[i][1];
                ++res;
            }
        }
        return res;
    }

}
