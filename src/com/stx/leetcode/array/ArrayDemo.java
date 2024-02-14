package com.stx.leetcode.array;

public class ArrayDemo {
    public static void main(String[] args) {
        int a[] = {0,1,0,3,12};
        moveZeroes(a);
    }

    /**
     * leetcode283 移动零
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if(nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int num : nums) {
            System.out.println(num);
        }
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
