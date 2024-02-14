package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

// 删除重复的节点
public class DelDoubleNode {
    public static void main(String[] args) {
        int []arr = {1,1,2,2,3,3,3,4,5,6,6,7,7};
        Node list = ListUtil.createList(arr);

        Node slow = list;
        Node fast = list.next;
        while (fast != null){
            if(fast.data == slow.data){
                fast = fast.next;
                if(fast == null){
                    slow.next = null;
                }
            }else {
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            }
        }
        ListUtil.printList(list);
    }
}
