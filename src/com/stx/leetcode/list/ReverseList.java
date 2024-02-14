package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

// 反转链表
public class ReverseList {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5};
        Node list = ListUtil.createList(arr);

        Node pre = null;
        Node cur = list;
        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListUtil.printList(pre);

    }
}
