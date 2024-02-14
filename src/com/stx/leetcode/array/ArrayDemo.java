package com.stx.leetcode.array;

public class ArrayDemo {
    public static void main(String[] args) {
        int a[] = {5,7,7,8,8,10};
        int[] ints = searchRange(a, 8);
        System.out.println(ints[0] + ":" + ints[1]);
    }

    public int removeElement(int[] nums, int val) {
        int right = 0;
        int left = 0;
        for (right = 0;right<nums.length;right++) {
            if(nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;

    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int idx = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                idx = mid;
                break;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
            if(nums[mid] > target) {
                right = mid;
            }
        }
        if(idx == -1) {
            int ret[] = {-1,-1};
            return ret;
        }
        int start = 0;
        int end = 0;
        for(int i = idx;i>=0;i--) {
            if(nums[i] == target) {
                start = i;
            }else {
                break;
            }
        }
        for (int i = idx;i<nums.length;i++) {
            if(nums[i] == target) {
                end = i;
            }else {
                break;
            }
        }
        return new int[]{start,end};

    }
}
