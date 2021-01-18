package com.huangxw.LeetCode;

import java.util.*;

/**
 * 热题HOT100:
 * 11.有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *  1.左括号必须用相同类型的右括号闭合。
 *  2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1：
 * 输入: "()"
 * 输出: true
 * 
 * 示例 2：
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3：
 * 输入: "([)]"
 * 输出: false
 */
public class ValidBracket {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1)
            return false;
        
        if(s.isEmpty()) return true;
        
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < n; i++) 
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                list.add(map.get(s.charAt(i)));
            else
            {
                if(list.size() > 0 && s.charAt(i) == list.get(list.size() - 1))
                {
                    list.remove(list.size() - 1);
                }
                else
                    return false;
            }
        }
        if(list.size() == 0) return true;
        else return false;
    }
    
    public static void main(String[] args) {
        String s = "){";
        System.out.println(new ValidBracket().isValid(s));
        
    }
}
