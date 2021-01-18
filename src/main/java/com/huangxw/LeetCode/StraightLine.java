package com.huangxw.LeetCode;
/**
 * LeetCode
 * 1232.缀点成线
 *
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
 * 其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回true，否则请返回 false。
 * 
 * 示例：
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 
 * 提示：
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */
public class StraightLine {
    
    public boolean checkStraightLine(int[][] coordinates) {
        //将coordinates[0][0]、coordinates[0][1]移到坐标原点
        //直线方程式为：Ax + By = 0;
        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) 
        {
            coordinates[i][0] = coordinates[i][0] - deltaX;
            coordinates[i][1] = coordinates[i][1] -deltaY;
        }
        int A = coordinates[1][1];
        int B = -coordinates[1][0];
    
        for (int i = 2; i < n; i++) 
        {
            if(A*coordinates[i][0] + B*coordinates[i][1] != 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(new StraightLine().checkStraightLine(test));
    }
}
