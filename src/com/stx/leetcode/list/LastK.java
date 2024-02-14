package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

// 链表中倒数第k个节点
public class LastK {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9};
        Node list = ListUtil.createList(arr);
        int k = 3;
        Node fast = list;
        Node slow = list;
        for(int i = 0;i<k;i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(slow.data);
    }
}
