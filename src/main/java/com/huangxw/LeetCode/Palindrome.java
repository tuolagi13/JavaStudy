package com.huangxw.LeetCode;

/**
 * 热题HOT100:
 * 5.最长回文子串
 * 
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Palindrome {
    //方法1：暴力解法
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        //枚举所有长度大于1的子串 charArray[i...j]
        for (int i = 0; i < len - 1; i++) 
        {
            for (int j = i+1; j < len; j++) 
            {
                if(j - i + 1 > maxLen && validPalindromic(charArray,i,j))
                {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
    //验证s[left...right]是否位回文串
    public static boolean validPalindromic(char[] charArray,int left,int right) {
        while (left < right)
        {
            if(charArray[left] != charArray[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    
    //方法2：动态规划 对于一个子串，如果它是回文串，并且长度大于2，那么首尾字母去掉后，它仍然是回文串。
    public static String longestPalindrome2(String s) {
        //特判
        int len = s.length();
        if(len < 2)
            return s;
        
        int maxLen = 1;
        int begin = 0;
        //dp[i][j]表示s[i,j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
    
        for (int i = 0; i < len; i++) 
        {
            dp[i][i] = true;    
        }
    
        for (int j = 1; j < len; j++) 
        {
            for (int i = 0; i < j; i++) 
            {
                if(charArray[i] != charArray[j])
                    dp[i][j] = false;
                else
                {
                    if(j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }
                //只要dp[i][j]=true成立，就代表子串s[i..j]是回文，此时记录回文长度和起始位置
                if(dp[i][j] && j-i+1 > maxLen)
                {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }
}
