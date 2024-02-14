package com.stx.leetcode.array;

import java.util.HashSet;
import java.util.Set;

// 最长无重复子串
public class MaxLenSubArr {


    public static void main(String[] args) {
        int array[] = {1,1,2,1,2,1,2,3,4,1};
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int len = array.length;
        Set<Integer> set = new HashSet<>();
        while (right < len){
            int num = array[right];
            if(set.contains(num)){
                int subLen = right - left;
                maxLen = subLen>maxLen?subLen:maxLen;
                left = right;
                set.clear();
                set.add(num);
                right++;
            }else {
                set.add(num);
                right++;
            }
        }
        // 最后一轮比较
        if(maxLen != 0){
            if(right - left > maxLen){
                maxLen = right - left;
            }
        }
        if(maxLen == 0){
            maxLen = len;
        }
        System.out.println(maxLen);

    }
}
