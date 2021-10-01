package com.nuaa.xiaose.array.easy;

/**
 * @Classname PlusOne
 * @Date: 2021/10/01/ 16:25
 * @Author 萧瑟
 * @Description 0066
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] num = new int[]{9,9};
        plusOne(num);
    }

    /**
     *  直接判断就行了
     *  最后直接赋值为 10000...
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]==9) {
                digits[i]=0;
            }else {
                digits[i]++;
                return digits;
            }
        }
        //如果所有位都是进位，则长度+1
        digits= new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
