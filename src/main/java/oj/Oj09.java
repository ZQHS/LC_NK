package oj;/*
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class Oj09 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int recordNum = Integer.valueOf(cin.nextLine());
        List<String> records = new ArrayList<>(recordNum);
        for (int i = 0; i < recordNum; i++) {
            records.add(cin.nextLine());
        }
        cin.close();
        String[][] results = getPhoneRecord(records);
        for (String[] result : results) {
            System.out.println(String.join(" ", Arrays.asList(result)));
        }
    }

    private static String[][] getPhoneRecord(List<String> records) {
        ArrayList<Pattern> whiteList = new ArrayList<>();
        ArrayList<String> callList = new ArrayList<>();
        HashMap<String, Integer[]> map = new HashMap<>();
        for (String record : records) {
            String[] s = record.split(" ");
            if (Objects.equals(s[0], "W")) {
                if (s[1].endsWith("*")) {
                    whiteList.add(Pattern.compile(s[1].substring(0, s[1].length() - 1) + ".*"));
                } else {
                    whiteList.add(Pattern.compile(s[1]));
                }
            } else if (Objects.equals(s[0], "C")) {
                if (!callList.contains(s[1])) {
                    callList.add(s[1]);
                }
                boolean flag = true;
                for (Pattern pattern : whiteList) {
                    if (pattern.matcher(s[1]).find(0)) {
                        Integer[] count = map.getOrDefault(s[1], new Integer[]{0, 0});
                        count[0] += 1;
                        map.put(s[1], count);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    Integer[] count = map.getOrDefault(s[1], new Integer[]{0, 0});
                    count[1] += 1;
                    map.put(s[1], count);
                }
            }
        }
        String[][] res = new String[callList.size()][3];

        for (int i = 0; i < callList.size(); ++i) {
            res[i][0] = callList.get(i);
            Integer[] count = map.get(callList.get(i));
            res[i][1] = String.valueOf(count[0]);
            res[i][2] = String.valueOf(count[1]);
        }

        return res;
    }
}
