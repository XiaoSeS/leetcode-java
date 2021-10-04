package com.nuaa.xiaose.array.easy;

/**
 * @Classname OnebitandTwobitCharacters
 * @Date: 2021/10/02/ 13:18
 * @Author 萧瑟
 * @Description 0717
 * <p>
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OnebitandTwobitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i > 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }
}
