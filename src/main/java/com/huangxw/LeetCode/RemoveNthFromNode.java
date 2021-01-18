package com.huangxw.LeetCode;

/**
 * 热题HOT100:
 * 10.删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例 1：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {
    }
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveNthFromNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode right = head;
        int tmp = 1;
        //n的数值范围为1 - 链表长度
        while(true)
        {
            if(tmp < n)
            {
                right = right.next;
                tmp++;
            }
            else if(tmp == n)
            {
               if(right.next == null)
               {
                   left.next = left.next.next;
                   break;
               }
               else
               {
                   left = left.next;
                   right = right.next;
               }
            }
        }
        
         return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next =  new ListNode(3);
        node.next.next.next =  new ListNode(4);
        node.next.next.next.next =  new ListNode(5);
        
        ListNode result = new RemoveNthFromNode().removeNthFromEnd(node,3);
        System.out.println(result);
        
    }
}
