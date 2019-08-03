package com.alibaba.leetcode.middle.s2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in
 * the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * 
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * 
 * Explanation: Node 1's value is 1, and it has two neighbors: Node 2 and 4. Node 2's value is 2, and it has two
 * neighbors: Node 1 and 3. Node 3's value is 3, and it has two neighbors: Node 2 and 4. Node 4's value is 4, and it has
 * two neighbors: Node 1 and 3.  
 * 
 * Note:
 * 
 * The number of nodes will be between 1 and 100. The undirected graph is a simple graph, which means no repeated edges
 * and no self-loops in the graph. Since the graph is undirected, if node p has node q as neighbor, then node q must
 * have node p as neighbor too. You must return the copy of the given node as a reference to the cloned graph.
 * 
 * 
 * @author wang
 * @date 2019/08/02
 */
public class CloneGraphSolution {

    public static void main(String[] args) {

        Node node = new Node(1, new ArrayList<>());
        System.out.println(new CloneGraphSolution().cloneGraph(node));
    }

    public Node cloneGraph(Node node) {

        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    /**
     * dfs遍历无向图
     * 
     * @param node
     * @param map
     * @return
     */
    private Node dfs(Node node, Map<Node, Node> map) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        if (node.neighbors != null) {
            for (Node n : node.neighbors) {
                newNode.neighbors.add(dfs(n, map));
            }
        }

        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
