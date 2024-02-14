package com.stx.leetcode.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringDemo {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int size = s.length();
        int len = 0;
        while (right < size) {
            String c = s.charAt(right) + "";
            right++;
            Integer count = window.get(c);
            if(count == null) {
                count = 0;
            }
            count++;
            window.put(c,count);
            while (count > 1) {
                String d = s.charAt(left)+"";
                left++;
                count--;
                Integer dc = window.get(d);
                if(dc != null && dc > 0) {
                    dc--;
                    window.put(d,dc);
                }
            }
            len = Math.max(len,right - left);
        }
        return len;
    }


}
