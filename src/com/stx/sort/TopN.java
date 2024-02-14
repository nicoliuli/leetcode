package com.stx.sort;

import java.util.Random;

public class TopN {

    public TopN(){
        System.out.println("TopN正在构建");
    }
    public static int LEN = 20;     //数组大小
    public static int N = LEN/2;    //堆大小
    public static int arrs[] = new int[LEN];
    public static int arr[] =  new int[N];   //堆

    //数组长度
    public static int len = arr.length;
    //堆中元素的有效元素 heapSize<=len
    public static int heapSize = len;
    public static void main(String[] args) {
        //初始化数组
        for(int i = 0;i<LEN;i++){
            arrs[i] = new Random().nextInt(1000);
        }
        for(int i = 0;i<N;i++){
            arr[i] = arrs[i];
        }
        //构建大顶堆
        buildMaxHeap();

        for(int i = N;i < LEN;i++){
            //如果比堆顶元素小，交换两个数的位置，并重新调整堆结构
            if(arrs[i] < arr[0]){
                int t = arrs[i];
                arrs[i] = arr[0];
                arr[0] = t;
                maxHeap(0);
            }
        }
        //修改原数组
        for(int i = 0;i<N;i++){
            arrs[i] = arr[i];
        }

        print();
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
        for(int a:arrs){
            System.out.print(a+",");
        }
        System.out.println();
    }

    public void hello(){
        System.out.println("hello");
    }
}