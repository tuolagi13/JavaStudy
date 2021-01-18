package com.huangxw.LeetCode;
import java.util.*;

/**
 * 热题HOT100:
 * 9.电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射与电话按键相同，注意1不对应任何字母。
 *
 * 示例 1：
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明：
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombination {
    //1. 没有字母
    //2. abc
    //3. def
    //4. ghi
    //5. jkl
    //6. mno
    //7. pqrs
    //8. tuv
    //9. wxyz
    
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    //路径
    private StringBuilder sb = new StringBuilder();
    
    //结果集
    private List<String> res = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return res;
        
        backtrack(digits,0);
        return res;
    }
    
    //回溯函数(递归)
    public void backtrack(String digits,int index) {
        if(sb.length() == digits.length())
        {
            res.add(sb.toString());
            return;
        }
        
        String val = map[digits.charAt(index) - '2'];
        for(char ch : val.toCharArray())
        {
            sb.append(ch);
            backtrack(digits,index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    
    public static void main(String[] args) {
        String a = "2346";
        System.out.println(Arrays.toString(new LetterCombination().letterCombinations(a).toArray()));
        
    }
}
