package com.huangxw.LeetCode;

/**
 * 热题HOT100:
 * 7.盛最多水的容器
 * 
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * 
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 
 * 输入：[4,3,2,1,4]
 * 输出：16 
 * 
 * 提示：
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class MaxArea {
    
    //双指针法
    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(right >= left)
        {
            int tmp = (right - left) * Math.min(height[left],height[right]);
            if(tmp > res)
                res = tmp;
            if(height[left] >= height[right])
                right--;
            else
                left++;
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        int[] b = new int[]{1,1};
        System.out.println(maxArea(b));
    }
}
