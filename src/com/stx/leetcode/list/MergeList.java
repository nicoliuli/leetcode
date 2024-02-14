package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

// 有序列表合并
public class MergeList {
    @Deprecated
    public static void main1(String[] args) {
        int []arr = {1,3,5,7,9};
        int []arr2 = {2,3,4,6,8,10};
        Node list1 = ListUtil.createList(arr);
        Node list2 = ListUtil.createList(arr2);

        List<Node> head = new ArrayList<>();
        Node p = list1;
        Node q = list2;

        while (p.next != null || q.next != null){
            if(p.data < q.data){
                head.add(p);
                p = p.next;

            }else {
                head.add(q);
                q = q.next;
            }
        }
        while (p != null){
            head.add(p);
            p = p.next;
        }

        while (q != null){
            head.add(q);
            q = q.next;
        }
        for (Node node : head) {
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 3, 4, 6, 8, 10};
        Node list1 = ListUtil.createList(arr);
        Node list2 = ListUtil.createList(arr2);
        Node p = list1;
        Node q = list2;
        Node k = null;
        // 确定k的第一个节点
        if(p.data < q.data) {
            k = p;
            p = p.next;
        }else {
            k = q;
            q = q.next;
        }
        // 保存头节点
        Node head = k;
        while (p != null && q != null) {
            if(p.data < q.data) {
                k.next = p;
                p = p.next;
            }else {
                k.next = q;
                q = q.next;
            }
            k = k.next;
        }
        while (p != null) {
            k.next = p;
            p = p.next;
            k = k.next;
        }
        while (q != null) {
            k.next = q;
            q = q.next;
            k = k.next;
        }

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
