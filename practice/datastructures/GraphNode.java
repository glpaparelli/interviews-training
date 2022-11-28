package datastructures;
import java.util.ArrayList;
import java.util.List;
/*
 * simple definition of a singly linked list, leetcode fluff
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        this.val = 0;
        this.neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
