package algorithms.graph;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import datastructures.GraphNode;

public class BFS {
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
        iterativeBFS(node0);

        int[][] adjMatrix = new int[4][4];
        adjMatrix[0] = new int[]{0,1,1,1};
        adjMatrix[1] = new int[]{1,0,0,1};
        adjMatrix[2] = new int[]{1,0,0,1};
        adjMatrix[3] = new int[]{1,1,1,0};
        iterativeBFS(0, adjMatrix);
    }

    public static void iterativeBFS(GraphNode node){
        Queue<GraphNode> frontier = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        frontier.add(node);
        visited.add(node);

        while(frontier.isEmpty() == false){
            GraphNode current = frontier.poll();
            System.out.println(current.val);

            for(GraphNode neighbor : current.neighbors)
                if(visited.contains(neighbor) == false){
                    frontier.add(neighbor);
                    visited.add(neighbor);
                }
        }
    }

    public static void iterativeBFS(int start, int[][] adjMatrix){
        Queue<Integer> frontier = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        frontier.add(start);
        visited.add(start);

        while(frontier.isEmpty() == false){
            int current = frontier.poll();
            System.out.println(current + "");
            
            // visiting current neighbors
            for(int neighbor = 0; neighbor < adjMatrix[current].length; neighbor++)
                if(adjMatrix[current][neighbor] == 1 && visited.contains(neighbor) == false){
                    frontier.add(neighbor);
                    visited.add(neighbor);
                }
        }
    }
}
