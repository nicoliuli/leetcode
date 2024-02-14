package com.stx.leetcode.tree;

import com.stx.leetcode.common.TreeNode;
import com.stx.leetcode.common.TreeUtil;

import java.util.*;

public class TreeOrder {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node1 = new TreeNode(1,node3,node4);
        TreeNode node2 = new TreeNode(2,node5,node6);

        TreeNode root = new TreeNode(0,node1,node2);

        preOrder(root);
        invertTree(root);
        TreeUtil.printTree(root);

    }

    /**
     * leetocode226 翻转二叉树
     * @param root
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    /**
     * 最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }

    public static void zigzagLevelOrder(TreeNode root) {
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        result.add(list);
        queue.offer(list);
        int level = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> poll = queue.poll();
            // 存储一层的节点
            List<TreeNode> nodes = new ArrayList<>();
            for (TreeNode node : poll) {
                if(node.left != null) {
                    nodes.add(node.left);
                }
                if(node.right != null) {
                    nodes.add(node.right);
                }
            }
            if(poll != root && !nodes.isEmpty()) {
                if(level % 2 == 1) {
                    Collections.reverse(nodes);
                }
                queue.offer(nodes);
                level++;
            }
            result.add(nodes);
        }
        for (List<TreeNode> nodes : result) {
            for (TreeNode node : nodes) {
                System.out.println(node.data);
            }
        }
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            System.out.println(poll.data);
        }
    }

    public static void postOrder1(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            if(pop.left != null) {
                s1.push(pop.left);
            }
            if(pop.right != null) {
                s1.push(pop.right);
            }
            s2.push(pop);
        }

        while (!s2.isEmpty()) {
            System.out.println(s2.pop().data);
        }
    }

    public static void inOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.data);
            cur = pop.right;
        }
    }


    public static void preOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.data);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
}
