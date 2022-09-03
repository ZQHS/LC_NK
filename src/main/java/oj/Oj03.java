package oj;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class Oj03 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int nValue = cin.nextInt();
        int mValue = cin.nextInt();
        cin.nextLine();
        String[] strings = new String[mValue];
        for (int i = 0; i < mValue; i++) {
            strings[i] = cin.nextLine();
        }
        cin.close();

        char[] results = getNTimesCharacter(nValue, strings);

        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            if (i == 0) {
                System.out.print(results[i]);
            } else {
                System.out.print(" " + results[i]);
            }
        }
        System.out.print("]");
    }

    // 待实现函数，在此函数中填入答题代码
    private static char[] getNTimesCharacter(int nValue, String[] strings) {
        if (strings.length == 0) {
            return new char[0];
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : strings[0].toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        map.entrySet().removeIf(next -> next.getValue() < nValue);
        map.replaceAll((k, v) -> 0);

        for (int i = 1; i < strings.length; i++) {
            for (char c : strings[i].toCharArray()) {
                if (map.containsKey(c)) {
                    Integer count = map.get(c);
                    map.put(c, count + 1);
                }
            }

            map.entrySet().removeIf(next -> next.getValue() < nValue);
            map.replaceAll((k, v) -> 0);
        }

        char[] res = new char[map.size()];

        Iterator<Character> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            for (int i = 0; iterator.hasNext(); ++i) {
                res[i] = iterator.next();
            }
        }
        Arrays.sort(res);

        return res;

    }


}
