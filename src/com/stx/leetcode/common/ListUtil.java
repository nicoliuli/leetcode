package com.stx.leetcode.common;

public class ListUtil {

    public static Node createList(int [] datas){

        Node head = new Node();
        Node node = head;
        node.data =  datas[0];
        for(int i = 1;i<datas.length;i++){
            Node a = new Node();
            a.data = datas[i];
            node.next = a;
            node = a;

        }
        return head;
    }

    public static void printList(Node node){
        if(node == null){
            return;
        }
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
