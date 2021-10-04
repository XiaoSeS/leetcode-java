package com.nuaa.xiaose.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname toInteger
 * @Date: 2021/10/02/ 14:17
 * @Author 萧瑟
 * @Description 0013
 *
 *  罗马数字到阿拉伯数字
 */
public class RomantoInteger {

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = symbolValues.get(s.charAt(i));
            if (i + 1 < s.length() && symbolValues.get(s.charAt(i + 1)) > value) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

}
