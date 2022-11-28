package algorithms.graph;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import datastructures.GraphNode;

public class DFS {
    public static void main(String[] args) {
        /*
         *          0 
         *        / | \
         *       1  |  2
         *        \ | /
         *          3
         */
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        node0.neighbors.addAll(List.of(node1, node2, node3));
        node1.neighbors.addAll(List.of(node0, node3));
        node2.neighbors.addAll(List.of(node0, node3));
        node3.neighbors.addAll(List.of(node1, node2, node0));
        iterativeDFS(node1);

        int[][] adjMatrix = new int[4][4];
        adjMatrix[0] = new int[]{0,1,1,1};
        adjMatrix[1] = new int[]{1,0,0,1};
        adjMatrix[2] = new int[]{1,0,0,1};
        adjMatrix[3] = new int[]{1,1,1,0};
        iterativeDFS(1, adjMatrix);
    }

    // TODO recusive may be wrong: to check
    public static void recursiveDFS(GraphNode node){
        recursiveDFS(node, new HashSet<>());
    }
    private static void recursiveDFS(GraphNode node, Set<GraphNode> visited){
        visited.add(node);
        System.out.println(node.val);
        for(GraphNode neighbor : node.neighbors)
            if(visited.contains(neighbor) == false)
                recursiveDFS(neighbor, visited);
    }

    public static void iterativeDFS(GraphNode node){
        Stack<GraphNode> frontier = new Stack<>();
        Set<GraphNode> visited = new HashSet<>();
        frontier.push(node);
        visited.add(node);

        while(frontier.isEmpty() == false){
            GraphNode current = frontier.pop();
            System.out.println(current.val);

            for(GraphNode neighbor : current.neighbors)
                if(visited.contains(neighbor) == false){
                    frontier.push(neighbor);
                    visited.add(neighbor);
                } 
        }
    }

    /*
     * the adjacency matrix is a way to represent a graph. 
     * adjMatrix[i][j] == 1 represent that there is a single edge between the vertices i 
     * and j. If adjMatrix[i][j] == 0 there is no edge between the nodes i and j
     * 
     * Advantages of Adjacency Matrix:
     * - Adjacency matrix representation of the graph is very simple to implement
     * - Adding or removing time of an edge can be done in O(1) time. 
     *   Same time is required to check if there is an edge between two vertices 
     * - It is very convenient and simple to programme 
     * 
     * Disadvantages of Adjacency Matrix:
     * - It consumes a huge amount of memory for storing big graphs
     * - It requires huge efforts for adding or removing a vertex. If you are constructing
     *   a graph in dynamic structure, the adjacency matrix is quite slow for big graphs
    */

    // TODO: recursive may be wrong
    public static void recursiveDFS(int start, int[][]adjMatrix){
        boolean[] visited = new boolean[adjMatrix[0].length];
        Arrays.fill(visited, false);
        recursiveDFS(start, adjMatrix, visited);
    }
    private static void recursiveDFS(int start, int[][] adjMatrix, boolean[] visited){
        System.out.println(start + "");

        visited[start] = true;

        for(int i = 0; i < adjMatrix[start].length; i++){
            if(adjMatrix[start][i] == 1 && visited[i] == false)
                recursiveDFS(i, adjMatrix, visited);
        }
    }

    public static void iterativeDFS(int start, int[][] adjMatrix){
        Stack<Integer> frontier = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        
        frontier.push(start);
        visited.add(start);

        while(frontier.isEmpty() == false){
            int current = frontier.pop();
            System.out.println(current + "");

            // visiting current neighbors
            for(int neighbor = 0; neighbor < adjMatrix[current].length; neighbor++)
                if(adjMatrix[current][neighbor] == 1 && visited.contains(neighbor) == false){
                    frontier.push(neighbor);
                    visited.add(neighbor);
                }    
        }
    }
}
