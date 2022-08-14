import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Solution290 {
    public static void main(String[] args) {
        Solution290 solution290 = new Solution290();
        boolean flag= solution290.wordPattern(
                "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t");

        System.out.println(flag);
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        String[] strs = s.split(" ");


        if (strs.length!=pattern.length()) {
            return false;
        }

        boolean flag = true;

        for (int i = 0; i <pattern.length() ; i++) {
            if (!map1.containsKey(pattern.charAt(i))) {
                map1.put(pattern.charAt(i), i);

            }

            if (!map2.containsKey(strs[i])) {
                map2.put(strs[i], i);

            }

            if (!Objects.equals(map1.get(pattern.charAt(i)), map2.get(strs[i]))) {

             flag = false;
            }
        }

        return flag;
    }
}
