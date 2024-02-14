package com.stx.sort;

public class MergeSort {
    public static int arr[] = {2,4,7,8,9,4,5,1,2,3,6,8,7,8,54,4,2,58,47,5,8,4,2,5,0,0};
    public static void main(String[] args) {
        sort(0,arr.length-1);   //排序
        print();    //打印
    }

    //拆分
    public static void sort(int left,int right){
        if(left >= right)
            return;
        //递归终止条件，一个子数组只有一个或两个元素
        if(right-left==1){
            if(arr[left]>arr[right]){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
            return;
        }
        //递归分解
        int mid = (left + right)/2;
        sort(left,mid);
        sort(mid+1,right);
        //合并
        merge(left,mid,right);
    }
    //合并
    public static void merge(int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int k = 0;
        //开辟临时数组，合并两个有序子数组
        int temp[] = new int[right-left+1];
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }
        //将临时数组合并到原来数组中
        k = 0;
        for(i = left;i<=right;i++){
            arr[i] = temp[k++];
        }
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
