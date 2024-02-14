package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

// 反转链表前N个节点
public class ReverseGroupNList {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9};
        Node list = ListUtil.createList(arr);
        Node node = reverseKGroup(list, 2);
        ListUtil.printList(node);


    }

    public static Node reverseKGroup(Node head,int k) {
        if(head == null) {
            return null;
        }
        Node a = head;
        Node b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }

        Node newHead = reverse(a,b);
        a.next =  reverseKGroup(b,k);
        return newHead;
    }

    public static Node reverse(Node a,Node b) {
        Node pre = null,cur,next;
        cur = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
