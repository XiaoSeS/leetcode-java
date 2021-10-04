package com.nuaa.xiaose.string.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Classname ValidParentheses
 * @Date: 2021/10/02/ 14:30
 * @Author 萧瑟
 * @Description 0020
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 */
public class ValidParentheses {
    HashMap<Character, Character> symbols = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (symbols.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek()!=symbols.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
