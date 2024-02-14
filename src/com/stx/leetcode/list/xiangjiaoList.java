package com.stx.leetcode.list;

import com.stx.leetcode.common.ListUtil;
import com.stx.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

// 相交链表
public class xiangjiaoList {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int len1 = list1.size();
        int len2 = list2.size();
        int k = len1 > len2?len1-len2:len2-len1;
        if(len1 > len2){
            for (int i = 0;i<k;i++){
               // list1 = list1.next;
            }
        }else {
            for (int i = 0;i<k;i++){
                // list2 = list2.next;
            }
        }

        while (list1 != null && list2 != null){
            // list = list1.next;
            // list2 = list2.next;
            if(list1 == list2){
                // 这是交点

                // 沿着交点遍历，就是长度
            }

        }




    }
}
