package com.nuaa.xiaose.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PascalsTriangle2
 * @Date: 2021/10/01/ 17:28
 * @Author 萧瑟
 * @Description 0119
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class PascalsTriangle2 {

    public static void main(String[] args) {
        getRow(3);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        List<Integer> current =null;
        for (int i = 0; i < rowIndex+1; i++) {
            current=new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    current.add(pre.get(0));
                } else if (j == i) {
                    current.add(pre.get(pre.size() - 1));
                } else {
                    current.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre=current;
        }
        return current;
    }
}
