package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

// 环形链表
public class huanxingList {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5};
        Node list = ListUtil.createList(arr);
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return;
            }
        }

    }
}
