package com.alibaba.leetcode.middle.s2;

import java.util.LinkedList;
import java.util.Queue;

import com.alibaba.leetcode.struct.Node;

/**
 * 116. Populating Next Right Pointers in Each Node
 * 
 * 116. 填充每个节点的下一个右侧节点指针
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The
 * binary tree has the following definition:
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each next pointer to point to its next right
 * node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Input:
 * {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * 
 * Output:
 * {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * 
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point
 * to its next right node, just like in Figure B.
 * 
 * 
 * 
 * @author wang
 * @date 2019/07/29
 */
public class PopulatingNextRightPointersInEachNodeSolution {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(new PopulatingNextRightPointersInEachNodeSolution().connect(root));
    }

    /**
     * 同层序遍历的方法
     * 
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node n = q.poll();
                if (pre != null) {
                    pre.next = n;
                }
                pre = n;
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }

        }

        return root;
    }
}
