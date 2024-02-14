package com.stx.sort;

public class HeapSort {
    public static int arr[] = {1,7,9,5,4,3,9,8,10,19,15,0,1};
    //数组长度
    public static int len = arr.length;
    //堆中元素的有效元素 heapSize<=len
    public static int heapSize = len;
    public static void main(String[] args) {
        heapSort();
        print();
    }

    /**
     * 堆排序
     */
    public static void heapSort(){
        buildMaxHeap(); //构建大堆
        for(int i = len-1;i>=1;i--){
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            heapSize--;
            maxHeap(0);
        }
    }

    /**
     * 自底向上构建大堆
     */
    public static void buildMaxHeap(){
        int size = len / 2;
        for(int i = size;i>=0;i--){
            maxHeap(i);
        }
    }

    /**
     * i节点为根及子树是一个大堆
     * @param i
     */
    public static void maxHeap(int i){
        int l = left(i);
        int r = right(i);
        int index = i;
        if(l<heapSize && arr[l]>arr[index]){
            index = l;
        }
        if(r<heapSize && arr[r]>arr[index]){
            index = r;
        }
        if(index != i){
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
            //递归向下构建堆
            maxHeap(index);
        }
    }

    /**
     * 返回i节点的左孩子
     * @param i
     * @return
     */
    public static int left(int i){
        return 2*i;
    }

    /**
     * 返回i节点的右孩子
     * @param i
     * @return
     */
    public static int right(int i){
        return 2*i+1;
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
