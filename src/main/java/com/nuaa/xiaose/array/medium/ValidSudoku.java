package com.nuaa.xiaose.array.medium;

/**
 * @Classname ValidSudoku
 * @Date: 2021/10/04/ 9:42
 * @Author 萧瑟
 * @Description  0036
 *
 * 请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[][] row=new int[9][10];
        int[][] col=new int[9][10];
        int[][] box=new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.') {
                    continue;
                }
                int num=board[i][j] -'0';
                if (row[i][num]==1) {
                    return false;
                }
                if (col[j][num]==1) {
                    return false;
                }
                if (box[j/3+(i/3)*3][num]==1) {
                    return false;
                }
                row[i][num]=1;
                col[j][num]=1;
                box[j/3+(i/3)*3][num]=1;
            }
        }
        return true;
    }
}
