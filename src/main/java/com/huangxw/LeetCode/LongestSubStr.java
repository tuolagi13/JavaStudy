package com.huangxw.LeetCode;

import org.redisson.misc.Hash;

import java.util.*;

/**
 * 热题HOT100:
 * 3.无重复字符串的最长子串
 * 
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3 
 *  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 *  示例 3:
 * 输入: s = "pwwkew"
 *  输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *  示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class LongestSubStr {
    //递归方法，执行用时、内存消耗都较长
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(s.length() == 0)
            return 0;
        String[] tmp = s.split("");
        
        
        List<Integer> result = new ArrayList<>();
        
        result = myFunc(tmp,0,result);
        Collections.sort(result);
        return result.get(result.size() - 1);
    }
    
    public static List<Integer> myFunc(String[] tmp,int size,List<Integer> result) {
        HashSet<String> set = new HashSet<>();
        int possible = 0;
        for (int i = size; i < tmp.length; i++)
        {
            if(!set.contains(tmp[i]))
            {
                set.add(tmp[i]);
                possible++;
            }
            else
            {
                size = i - set.size() + 1;
                result.add(possible);
                myFunc(tmp,size,result);
                break;
            }
        }
        result.add(possible);
        return result;
    }
    
    
    //优化 使用滑动窗口 （左指针、右指针）
    public static int lengthOfLongestSubstring2(String s) {
       Set<Character> occ = new HashSet<>();
       int n = s.length();
       // 右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
       int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) 
        {
            if(i != 0)
                occ.remove(s.charAt(i - 1));
            
            while(rk + 1 < n && !occ.contains(s.charAt(rk + 1)))
            {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans,rk -i + 1);
        }
       return ans;
    }
    
    public static void main(String[] args) {
        String a = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(a));
    }
}
