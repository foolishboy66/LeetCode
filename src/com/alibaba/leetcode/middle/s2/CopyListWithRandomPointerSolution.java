package com.alibaba.leetcode.middle.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 * 
 * Return a deep copy of the list.
 * 
 * Input: {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 
 * Explanation:
 * 
 * Node 1's value is 1, both of its next and random pointer points to Node 2. Node 2's value is 2, its next pointer
 * points to null and its random pointer points to itself.  
 * 
 * Note:
 * 
 * You must return the copy of the given head as a reference to the cloned list.
 * 
 * 
 * @author wang
 * @date 2019/08/03
 */
public class CopyListWithRandomPointerSolution {

    public static void main(String[] args) {

        Node2 head = new Node2();
        head.val = 1;

        Node2 n2 = new Node2();
        n2.val = 2;
        n2.random = n2;

        head.next = n2;
        head.random = n2;

        Node2 ans = new CopyListWithRandomPointerSolution().copyRandomList(head);
        System.out.println(ans);
    }

    /**
     * dfs
     * 
     * @param head
     * @return
     */
    public Node2 copyRandomList(Node2 head) {

        Map<Node2, Node2> map = new HashMap<>();

        return dfs(head, map);
    }

    private Node2 dfs(Node2 head, Map<Node2, Node2> map) {

        if (head == null) {
            return null;
        }

        if (!map.containsKey(head)) {
            Node2 node = new Node2();
            node.val = head.val;
            map.put(head, node);
            node.next = dfs(head.next, map);
            node.random = dfs(head.random, map);
            return node;
        }

        return map.get(head);
    }

}

class Node2 {
    public int val;
    public Node2 next;
    public Node2 random;

    public Node2() {}

    public Node2(int _val, Node2 _next, Node2 _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
