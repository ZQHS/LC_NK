import java.util.ArrayList;

public class LeetCode14177 {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> nums = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                nums.add(chars[i]);
            } else {
                characters.add(chars[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();

        if (nums.size() == 0 && characters.size() == 0) {
            return "";
        } else if (Math.abs(nums.size() - characters.size()) > 1) {
            return "";
        } else if (nums.size() > characters.size()) {
            for (int i = 0; i < nums.size(); i++) {
                sb.append(nums.get(i));
                if (i < characters.size()) {
                    sb.append(characters.get(i));
                }
            }
        } else {
            for (int i = 0; i < characters.size(); i++) {
                sb.append(characters.get(i));
                if (i < nums.size()) {
                    sb.append(nums.get(i));
                }
            }
        }
        return sb.toString();
    }
}
