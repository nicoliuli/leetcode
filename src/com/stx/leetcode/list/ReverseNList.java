package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

// 反转链表前N个节点
public class ReverseNList {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8};
        Node list = ListUtil.createList(arr);

        Node node = reverseN(list, 2);
        ListUtil.printList(node);

    }

    public static Node reverseN(Node list,int n) {
        Node pre = null;
        Node head = list;
        Node cur = list;
        Node next = null;
        Node b = list;
        for (int i = 0;i<n;i++) {
            b = b.next;
        }

        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = next;

        return pre;
    }
}
