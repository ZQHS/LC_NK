package oj;/*
 * Copyright (c) Huawei Technologies Co., Ltd.  All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Oj07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int start = cin.nextInt();
        int end = cin.nextInt();
        cin.close();

        System.out.println(getNormalDeviceNum(start, end));
    }

    // 待实现函数，在此函数中填入答题代码
    private static int getNormalDeviceNum(int start, int end) {
        Pattern p1 = Pattern.compile(".*4.*");
        Pattern p2 = Pattern.compile(".*18.*");
        int res = 0;
        for (int i = start; i <= end; ++i) {
            Matcher m1 = p1.matcher(String.valueOf(i));
            Matcher m2 = p2.matcher(String.valueOf(i));
            if (!(m1.find() || m2.find())) {
                ++res;
            }
        }
        return res;
    }
}
