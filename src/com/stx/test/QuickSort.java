package com.stx.test;

public class QuickSort {
    public static int arr[] = {2,4,7,8,9,4,5,1,2,3,6,8,7,8,54,4,2,58,47,5,8,4,2,5,-1,0};
    public static void main(String[] args) {
       sort(0,arr.length-1);
       print();
    }

    public static void sort(int left,int right){
        if(left >= right)
            return;
        int i = left;
        int j = right;
        int temp = arr[left];
        while(true){
            while(i<j && arr[j]>=temp)
                j--;
            while(i<j && arr[i]<=temp)
                i++;
            if(i>=j)
                break;
            if(i != j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        sort(left,i-1);
        sort(i+1,right);
    }
    /**
     * 打印
     */
    public  static void print(){
        for(int a:arr){
            System.out.print(a+",");
        }
        System.out.println();
    }
}
