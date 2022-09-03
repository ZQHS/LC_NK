package leetcode;

import java.util.*;

public class LeetCode636 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>() {{
            add("0:start:0");
            add("1:start:2");
            add("1:end:5");
            add("0:end:6");
        }};

        System.out.println(Arrays.toString(new LeetCode636().exclusiveTime(2, list)));
    }

    public int[] exclusiveTime2(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<int[]>();
        int[] res = new int[n];
        for (String log : logs) {
            int idx = Integer.parseInt(log.substring(0, log.indexOf(':')));
            String type = log.substring(log.indexOf(':') + 1, log.lastIndexOf(':'));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(':') + 1));
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            Integer id = Integer.valueOf(split[0]);
            String state = split[1];
            Integer timestamp = Integer.valueOf(split[2]);

            if (Objects.equals(state, "start")) {
                if (!stack.empty()) {
                    res[stack.peek()] += timestamp;
                }
                stack.push(id);
                res[id] -= timestamp;
            } else {
                res[id] += timestamp + 1;
                stack.pop();
                if (!stack.empty()) {
                    res[stack.peek()] -= timestamp + 1;
                }
            }
//            System.out.println(Arrays.toString(res));
        }
        return res;
    }
}
