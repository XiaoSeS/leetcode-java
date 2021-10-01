package com.nuaa.xiaose.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PascalsTriangle
 * @Date: 2021/10/01/ 17:08
 * @Author 萧瑟
 * @Description 0118
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class PascalsTriangle {

    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangles = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    current.add(pre.get(0));
                } else if (j == i) {
                    current.add(pre.get(pre.size() - 1));
                } else {
                    current.add(pre.get(j-1)+pre.get(j));
                }
            }
            triangles.add(current);
            pre=current;
        }
        return triangles;
    }
}
