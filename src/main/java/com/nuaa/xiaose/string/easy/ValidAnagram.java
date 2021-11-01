package com.nuaa.xiaose.string.easy;

/**
 * @author: xiaose
 * @time: 2021/10/5 11:36
 * @description: 0242
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        int[] arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)-'a']--;
            if (arr[t.charAt(i)-'a']==-1) {
                return false;
            }
        }
        return true;
    }
}
