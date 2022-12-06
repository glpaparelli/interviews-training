package problems.graph.medium;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import datastructures.GraphNode;
/*
 * > PROBLEM 133 (medium): Clone Graph
 *   Given a reference of a node in a connected undirected graph.
 *   Return a deep copy (clone) of the graph.
 *   Each node in the graph contains a value (int) and a list (List[Node])
 *   of its neighbors.
 * 
 *   For simplicity, each node's value is the same as the node's index (1-indexed). 
 *   For example, the first node with val == 1, the second node with val == 2, and so on. 
 *   The graph is represented in the test case using an adjacency list.
 * 
 *   An adjacency list is a collection of unordered lists used to represent a finite graph. 
 *   Each list describes the set of neighbors of a node in the graph.
 * 
 *   The given node will always be the first node with val = 1. 
 *   You must return the copy of the given node as a reference to the cloned graph.
 * 
 * > SOLUTION:
 *   - use a dfs to create a map visited: node value -> list of neighbors
 *   - create a map clonedNodes: node value -> GraphNode(value) 
 *   - at this point we cloned all the nodes, we have to set the edges
 *   - for every node value in clonedNode
 *      - retrieve the list of neighbor of that node in visited
 *      - for every neighbor
 *          - get the neighbor val
 *          - add to the clonedNode value the cloned node with the val of neighbor val
 */
public class CloneGraph {
    public static GraphNode solution(GraphNode node){
        Queue<GraphNode> frontier = new LinkedList<>();
        Map<Integer, List<GraphNode>> visited = new HashMap<>();
        frontier.add(node);
        visited.put(node.val, node.neighbors);

        while(frontier.isEmpty() == false){
            GraphNode current = frontier.poll();

            for(GraphNode neighbor : current.neighbors)
                if(visited.containsKey(neighbor.val) == false){
                    frontier.add(neighbor);
                    visited.put(neighbor.val, neighbor.neighbors);
                }
        }

        // at this point visited is a map: node value -> list of neighbors
        // now we create the new nodes using the values as keys
        Map<Integer, GraphNode> clonedNodes = new HashMap<>();
        for(Integer n : visited.keySet())
            clonedNodes.put(n, new GraphNode(n));

        // now the new nodes needs the neighbors and we can use the 
        // old vals to get the new nodes
        for(GraphNode cloned : clonedNodes.values())
            for(GraphNode neighbor : visited.get(cloned.val))
                cloned.neighbors.add(clonedNodes.get(neighbor.val));    
                
        return clonedNodes.get(node.val);
    }
}