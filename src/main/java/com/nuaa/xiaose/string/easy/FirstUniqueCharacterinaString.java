package com.nuaa.xiaose.string.easy;

import java.util.HashMap;

/**
 * @author: xiaose
 * @time: 2021/10/5 10:41
 * @description: 0387
 *
 *
 */
public class FirstUniqueCharacterinaString {

    /**
     * hash 表
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer num = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i),num+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组计数
     * @param s
     * @return
     */
    public int firstUniqCharS1(String s) {
        int[] arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)-'a']==1) {
                return i;
            }
        }
        return -1;
    }
}
