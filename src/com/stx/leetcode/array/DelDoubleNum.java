package com.stx.leetcode.array;

public class DelDoubleNum {


    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,3,4,5,6,6,7,7};
        int slow = 0;
        int fast = 1;
        int len = arr.length;
        while (fast < len){
            if(arr[slow] == arr[fast]){
                fast++;
            }else {
                slow++;
                arr[slow] = arr[fast];
                fast++;
            }
            // fast++;
        }

        for(int i = 0;i<=slow;i++){
            System.out.println(arr[i]);
        }
    }
}
