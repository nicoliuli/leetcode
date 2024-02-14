package com.stx.test;

public class HeapSort {
    public static int arr[] = {1,7,9,5,4,3,9,8,10,19,15,0,1};
    public static int len = arr.length;
    public static int heapSize = len;

    public static void main(String[] args) {
        sort();
        print();
    }

    public static void  sort(){
       buildHeap();
       for(int i = len-1;i>=1;i--){
           int t = arr[0];
           arr[0] = arr[i];
           arr[i] = t;
           heapSize--;
           maxHeap(0);
       }
    }

    public static void buildHeap(){
        int size = len / 2;
        for(int i = size;i>=0;i--)
            maxHeap(i);
    }
    public static void maxHeap(int i){
        int left = left(i);
        int right = right(i);
        int index = i;
        if(left<heapSize && arr[left]>=arr[i]){
            index = left;
        }
        if(right<heapSize &&arr[right]>arr[index]){
            index = right;
        }

        if(index != i){
            int t = arr[i];
            arr[i] = arr[index];
            arr[index] = t;
            maxHeap(index);
        }
    }

    public static int left(int i){
        return i*2;
    }
    public static int right(int i){
        return i*2+1;
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
