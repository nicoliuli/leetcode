package com.stx.test;

public class MergeSort {
    public static int arr[] = {2,4,7,8,9,4,5,1,2,3,6,8,7,8,54,4,2,58,47,5,8,4,2,5,0,0};
    public static void main(String[] args) {
        sort(0,arr.length-1);
        print();    //打印
    }

    public static void sort(int left,int right){
        if(left >= right)
            return;
        if(right - left == 1){
            if(arr[left]>arr[right]){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        int mid = (left+right)/2;
        sort(left,mid);
        sort(mid+1,right);
        merge(left,mid,right);
    }

    public static void merge(int left,int mid,int right){
        int temp[] = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=right){
            if(arr[i]<arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=right)
            temp[k++] = arr[j++];
        k = 0;
        for(i = left;i<=right;i++)
            arr[i] = temp[k++];

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
