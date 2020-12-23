package com.huangxw.LeetCode;

import reactor.core.publisher.Mono;

/**
 * 热题HOT100:
 * 2.两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNum {

    public static class ListNode {
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

     //有问题，超过int最大值时会报错
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        int i = 0;
        while(l1 != null )
        {
            n1 += l1.val*Math.pow(10,i);
            i++;
            l1 = l1.next;
        }
        System.out.println(n1);

        i=0;
        while(l2 != null )
        {
            n2 += l2.val*Math.pow(10,i);
            i++;
            l2 = l2.next;
        }
        System.out.println(n2);

        int sum = n1 + n2;
        String sumStr = sum + "";
        ListNode head = null;
        ListNode tail = null;
        for (int j = sumStr.length() - 1; j >= 0; j--)
        {
            if(head == null)
            {
                head = tail = new ListNode(Integer.parseInt(sumStr.substring(j,j+1)));
            }
            else
            {
                tail.next = new ListNode(Integer.parseInt(sumStr.substring(j,j+1)));
                tail = tail.next;
            }
        }
        return head;
    }

    //优化方法
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        
        while(l1 != null || l2 != null)
        {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
                
            if(head == null)
                head = tail = new ListNode(sum % 10);
            else
            {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry > 0)
            tail.next = new ListNode(carry);
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode result = addTwoNumbers2(l1,l2);
        System.out.println(result);

    }
}
