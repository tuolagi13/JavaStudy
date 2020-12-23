package com.huangxw.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 热题HOT100:
 * 1.两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumTwoNum {

    //暴力枚举
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i+1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    //优化方法-哈希表
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
           if(hashTable.containsKey(target - nums[i]))
           {
               return new int[] {hashTable.get(target - nums[i]),i};
           }
            hashTable.put(nums[i],i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums = {3,4,3};
        int target = 6;

        int[] result = twoSum2(nums,target);
        System.out.println(Arrays.toString(result));
    }
}
