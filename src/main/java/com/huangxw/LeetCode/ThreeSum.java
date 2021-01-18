package com.huangxw.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 热题HOT100:
 * 8.三数之和
 * 
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *  
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length <= 2) return ans;
    
        Arrays.sort(nums); // O(nlogn)
        for (int i = 0; i < nums.length - 2; i++) //O(n^2) 
        {
            if(nums[i] > 0) break; //第一个数大于0，后面的都比他大，肯定不成立了
            if(i > 0 && nums[i] == nums[i-1]) continue; //去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while(left < right)
            {
                if(nums[left] + nums[right] == target)
                {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
    
                    //增加left，减小right，但是不能重复
                    //比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++;right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--; 
                }
                else if(nums[left] + nums[right] < target)
                {
                    left++;
                }
                else //nums[left] + nums[right] > target
                {
                    right--;
                }

            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(threeSum(a).toArray()));
        
    }
}
