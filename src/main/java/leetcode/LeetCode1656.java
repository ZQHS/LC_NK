package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode1656 {
    public static void main(String[] args) {
        System.out.println("11");
    }
}

class OrderedStream {
    private int max = 0;
    private int index = 0;
    private HashMap<Integer, String> map = new HashMap<>();

    public OrderedStream(int n) {
        max = n;
        index = 1;
    }

    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);
        LinkedList<String> list = new LinkedList<>();
        for (int i = index; i <= max; i++) {
            if (map.containsKey(i)) {
                list.add(map.get(i));
            } else {
                index = i;
                break;
            }
        }
        return list;
    }
}