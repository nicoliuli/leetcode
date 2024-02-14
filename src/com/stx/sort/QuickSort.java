package com.stx.sort;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {2,4,7,8,9,4,5,1,2,3,6,8,7,8,54,4,2,58,47,5,8,4,2,5,-1,0};
        quicksort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a+",");
        }
    }



    public static  void quicksort(int arr[],int left,int right){
        if(left > right)
            return;
        int i = left;
        int j = right;
        int temp = arr[left];
        while(true){
            while(i<j && arr[j]>=temp)  //顺序很重要，要先从右边开始找
                j--;
            while(i<j && arr[i]<=temp)
                i++;
            if(i>=j)
                break;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quicksort(arr,left,i-1);

        quicksort(arr,i+1,right);
    }
}
