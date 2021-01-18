package com.huangxw.LeetCode;
/**
 * 热题HOT100:
 * 12.合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 1->2->4 + 1->3->4
 * 输出: 1->1->2->3->4->4
 *
 * 示例 2：
 * 输入: [] + []
 * 输出: []
 *
 * 示例 3：
 * 输入: [] + [0]
 * 输出: [0]
 * 
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */


public class MergeTwoList {
    //递归法
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        
        ListNode res = new MergeTwoList().mergeTwoLists(l1,l2);
        System.out.println(res);
        
    }
}
