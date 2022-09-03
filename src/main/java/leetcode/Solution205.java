package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution205 {
    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic2("0555", "1433"));
    }

    public boolean isIsomorphic2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        char[] map = new char[128];
        for (int i = 0; i < sc.length; i++) {
            if (map[sc[i]] == 0) {
                for (int j = 0; j < 128; j++) {

                    if (map[j] == tc[i]) {
                        return false;
                    }
                }
                map[sc[i]] = tc[i];
            } else {
                if (map[sc[i]] != tc[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), i);
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), i);
            }

            if (!Objects.equals(map1.get(s.charAt(i)), map2.get(t.charAt(i)))) {
                flag = false;
            }
        }

        return flag;
    }
}
