package com.huangxw.datastructure;

import java.util.HashSet;
import java.util.List;

/**
 * 单向链表
 */
public class singlyLinkedList<T> {


    private static class Node<T> {
         T t;
         Node<T> next;

        public Node(T t,Node next) {
            this.t = t;
            this.next = next;
        }
        public Node (T t) {
            this(t,null);
        }
    }

    public Node<T> head;      //头节点
    public int size;       //链表元素个数

    public singlyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //链表头部增加元素
    public void addFirst(T t) {
        Node<T> node = new Node<T>(t);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    //链表中间插入元素
    public void add(T t,int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("index is error!");

        if(index == 0)
        {
            this.addFirst(t);
            return;
        }

        Node<T> preNode = this.head;
        for (int i = 0; i < index - 1; i++)
        {
            preNode = preNode.next;
        }
        Node<T> postNode = preNode.next;
        preNode.next = new Node<T>(t,postNode);
        this.size++;
    }

    //链表尾部增加元素
    public void addLast(T t) {
        this.add(t,this.size);
    }

    //删除链表元素
    public void remove(T t) {
        if( t == null)
            return;

        if(head !=null && head.t.equals(t))
        {
            head = head.next;
            this.size--;
        }

        Node<T> tmp = this.head;
        while(tmp != null && tmp.next != null)
        {
            if(tmp.next.t.equals(t))
            {
                this.size--;
                tmp.next = tmp.next.next;
            }
            else
                tmp = tmp.next;
        }
    }

    //单向链表去重
    public static void main(String[] args) {
        singlyLinkedList<Integer> list = new singlyLinkedList<>();
        list.add(1,0);
        list.add(2,1);
        list.add(3,2);
        list.add(2,3);
        System.out.println(list.size);

        HashSet<Integer> hashSet = new HashSet<>();
        Node<Integer> pre = list.head;
        Node<Integer> cur = list.head.next;
        hashSet.add(list.head.t);
        while(cur != null)
        {
            if(hashSet.contains(cur.t))
            {
                pre.next = cur.next;
                list.size--;
            }
            else
            {
                hashSet.add(cur.t);
                pre = cur;
            }
            cur = cur.next;
        }

        System.out.println(list.size);
    }
}
