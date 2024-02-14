package com.stx.sort;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    //值域
    public int value;
    //左孩子
    public Node left;
    //右孩子
    public Node right;
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class BinaryTree{
    /**
     * 插入节点
     * @param root
     * @param node
     */
    public void insertNode(Node root,Node node){
        if(root == null){
            root = new Node(node.value);
            return;
        }
        Node x = root;
        Node p = x; //表示node要插入p后
        while(x != null){
            p = x;
            if(node.value < x.value){
                x = x.left; //向左
            }else if(node.value > x.value){
                x = x.right;    //向右
            }else{
                return;
            }
        }
        if(node.value < p.value){
            p.left = new Node(node.value);
        }else{
            p.right = new Node(node.value);
        }
    }

    /**
     * 先序遍历
     * @param node
     */
    public void preOrderTraval(Node node){
        if(node == null)
            return;
        System.out.print(node.value+",");
        preOrderTraval(node.left);
        preOrderTraval(node.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrderTravel(Node root){
        if(root == null)
            return;
        inOrderTravel(root.left);
        System.out.print(root.value+",");
        inOrderTravel(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrderTraval(Node root){
        if(root == null)
            return;
        postOrderTraval(root.left);
        postOrderTraval(root.right);
        System.out.print(root.value+",");
    }

    /**
     * 层序遍历
     * @param root
     */
    public void levelOrderTraval(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node head = queue.poll();
            System.out.print(head.value+",");
            Node left = head.left;
            Node right = head.right;
            if(left != null)
                queue.offer(left);
            if(right != null)
                queue.offer(right);
        }
    }
    /**
     * 返回最左（小）节点
     * @param node
     * @return
     */
    public Node getMin(Node node){
        if(node == null)
            return null;
        if(node.left==null)
            return node;
        return getMin(node.left);

    }

    /**
     * 返回最右（大）节点
     * @param node
     * @return
     */
    public Node getMax(Node node){
        if(node == null)
            return null;
        if(node.right==null)
            return node;
        return getMax(node.right);
    }

    /**
     * 搜索
     * @param root
     * @param node
     * @return
     */
    public Node search(Node root,Node node){
        if(root==null || node==null)
            return null;
        if(node.value < root.value){
            return search(root.left,node);
        }else if(node.value > root.value){
            return search(root.right,node);
        }else{
            return root;
        }
    }

    /**
     * 获取父节点
     * @param root
     * @param node
     * @return
     */
    public Node getParent(Node root,Node node){
        if(root==null || node==null)
            return null;
        if((root.left!=null && root.left.value==node.value)||(root.right!=null && root.right.value==node.value))
            return root;
        if(node.value<root.value)
            return getParent(root.left,node);
        else
            return getParent(root.right,node);
    }

    /**
     * 获得树深度
     * @param root
     * @return
     */
    public int getMaxDeepth(Node root){
        if(root==null)
            return 0;
        int leftDeepth = getMaxDeepth(root.left)+1;
        int rightDeepth = getMaxDeepth(root.right)+1;
        return leftDeepth>rightDeepth?leftDeepth:rightDeepth;
    }

    /**
     * 获取树的节点个数
     * @param root
     * @return
     */
    public int getTreeNodeCount(Node root){
        if(root == null)
            return 0;
        int leftTreeNodeCount = getTreeNodeCount(root.left);
        int rightTreeNodeCount = getTreeNodeCount(root.right);
        return leftTreeNodeCount+rightTreeNodeCount+1;
    }

    /**
     * 获取树叶子节点个数
     * @param root
     * @return
     */
    public int getTreeLeafNodeCount(Node root){
        if(root == null)
            return 0;
        //该节点是叶子节点
        if(root.left==null && root.right==null)
            return 1;
        return getTreeLeafNodeCount(root.left)+getTreeLeafNodeCount(root.right);
    }

    /**
     * 返回深度从1到deepth的节点总个数
     * @param root
     * @param deepth
     * @return
     */
    public int getDeepthAllNodeCount(Node root, int deepth){
        if(deepth <= 0 || root==null)
            return 0;
        return getDeepthAllNodeCount(root.left,deepth-1)+ getDeepthAllNodeCount(root.right,deepth-1)+1;
    }

    /**
     * 返回深度为deepth的节点个数
     * @param root
     * @param deepth
     * @return
     */
    public int getDeepthNodeCount(Node root, int deepth){
        if(deepth <= 0 || root==null)
            return 0;
        //这就是要求的那一行
        if(deepth == 1){
            return 1;
        }
        return getDeepthNodeCount(root.left,deepth-1)+ getDeepthNodeCount(root.right,deepth-1);
    }

    /**
     * 返回第level层节点个数
     * @param root
     * @param level
     * @return
     */
    public int getLevelNodeCount(Node root,int level){
        //找出深度deepth与层level之间的关系
        int maxDeepth = getMaxDeepth(root);
        int k = maxDeepth - level;
        return getDeepthNodeCount(root,k);
    }
    /**
     * 返回中序遍历时node的后继节点
     * @param root
     * @param node
     * @return
     */
    public Node getNext(Node root,Node node){
        //判断node节点是否存在
        Node exit = search(root,node);
        if(exit==null)
            return null;
        //如果node有右孩子，那么node的后继节点一定是getMin(node.right);
        if(exit.right!=null)
            return getMin(exit.right);
        //如果node是叶子节点，且是父节点的右孩子，那么一直沿着父节点向上找
        Node parent = getParent(root,exit);
        while(parent!=null && parent.right!=null && parent.right.value==exit.value){
            exit = parent;
            parent = getParent(root,parent);
        }
        return parent;
    }
    /**
     * 删除某一节点
     * @param root
     * @param node
     */
    public Node deleteNode(Node root,Node node){
        Node exit = search(root,node);
        //没有这个节点
        if(exit == null)
            return root;
        //是叶子节点
        if(exit.left==null && exit.right==null){
            Node parent = getParent(root,exit);
            if(parent.left!=null && parent.left.value==exit.value){
                parent.left = null;
            }else{
                parent.right = null;
            }
            return root;
        }
        //有孩子节点
        Node parent = getParent(root,node);
        if(parent == null){ //如果是根节点
            Node next = getNext(root,root);
            if(next == null){
                root = root.left;
                root.right = null;
                return root;
            }
            next.left = root.left;
            Node nextParent = getParent(root,next);
            if(nextParent != root){
                nextParent.left = next.right;
                next.right = root.right;
            }
            //返回根节点指针
            return next;
        }
        //如果要删除的节点是parent的左孩子
        if(parent.left!=null && parent.left.value == exit.value){
            if(exit.left!=null && exit.right==null){    //只有左孩子
                parent.left = exit.left;
            }else if(exit.right!=null &&exit.left==null){   //只有右孩子
                parent.left = exit.right;
            }else if(exit.left!=null && exit.right!=null){  //有左右孩子
                Node next = getNext(root,exit);
                if(next!=null){
                    next.left = exit.left;
                    Node nextParent = getParent(root,next);
                    if(exit != nextParent){
                        nextParent.left = next.right;
                        next.right = exit.right;
                    }
                    parent.left = next;
                }
            }
        }else{  //如果要删除的节点是parent的右孩子
            if(exit.left!=null && exit.right==null){    //只有左孩子
                parent.right = exit.left;
            }else if(exit.right!=null &&exit.left==null){   //只有右孩子
                parent.right = exit.right;
            }else if(exit.left!=null && exit.right!=null){  //有左右孩子
                Node next = getNext(root,exit);
                if(next!=null) {
                    next.left = exit.left;
                    Node nextParent = getParent(root, next);
                    if (exit != nextParent) {
                        nextParent.left = next.right;
                        next.right = exit.right;
                    }
                    parent.right = next;
                }
            }
        }
        exit = null;
        return root;
    }
}
public class Tree {
    public static void main(String[] args) {
        int arr[] = {50,40,30,45,20,35,43,47,80,70,60,75,90,85,100,55,65,57,53};
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(arr[0]);
        for(int i = 1;i<arr.length;i++){
            Node node = new Node(arr[i]);
            binaryTree.insertNode(root,node);
        }
        System.out.println(binaryTree.getTreeNodeCount(root));
    }
}
