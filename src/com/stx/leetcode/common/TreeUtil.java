package com.stx.leetcode.common;

public class TreeUtil {



    public static void printTree(TreeNode root){
       preOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
