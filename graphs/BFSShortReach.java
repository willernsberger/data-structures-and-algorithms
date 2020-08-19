import java.util.*;
import java.util.Queue; 
import java.util.LinkedList;

//Algoritms & Data Structures challenge at: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
//A Breadth First Traversal to calculate the minimum number of edges to each node from a given starting node.
//Could be further optimized.

class Graph{
    int start;
    HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
}

class Node{
    int id;
    int distance;
    boolean visited;
    ArrayList<Edge> edges = new ArrayList<Edge>();
    
    public Node(int id){
        this.id = id;
        this.distance = -1;
        this.visited = false;
    }
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
}

class Edge{
    int source;
    int destination;
    int weight = 6;
    
    public Edge(int source, int destination){
        this.source = source;
        this.destination = destination;
    }
}

public class BFSShortReach {
    private static int queries;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        queries = scanner.nextInt();
        for(int q = 0; q < queries; q++){
            Graph graph = populateGraph(scanner);
            evaluateDistances(graph);
            printOutput(graph);
        }
    }

    //populate the Graph with Nodes and Edges
    public static Graph populateGraph(Scanner scanner){
        Graph graph = new Graph();
        int nodeCount = scanner.nextInt();
        //create Nodes and add them to the Graph
        for (int n = 0; n < nodeCount; n++){
            Node node = new Node(n+1);
            graph.nodes.put(Integer.valueOf(node.id), node);
        }
        //create Edges and add them to the Nodes
        int edgeCount = scanner.nextInt();
        for (int e = 0; e < edgeCount; e++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if(u != v){
                graph.nodes.get(Integer.valueOf(u)).addEdge(new Edge(u, v));
                graph.nodes.get(Integer.valueOf(v)).addEdge(new Edge(v, u)); 
            }

        }
        graph.start = scanner.nextInt();
        return graph;
    }

    //evaluate the distances
    public static void evaluateDistances(Graph graph){
        Queue<Node> queue = new LinkedList<Node>();
        Node start = graph.nodes.get(Integer.valueOf(graph.start));
        start.distance = 0;
        queue.add(start);
        while(queue.peek() != null){
            Node node = queue.remove();
            node.visited = true;
            for(Edge e : node.edges){
                Node adjacent = graph.nodes.get(e.destination);
                if(adjacent.visited == false){
                    adjacent.distance = node.distance + 6;
                    queue.add(adjacent);
                }
            }
        }       
    }

    //print the output
    public static void printOutput(Graph graph){
        String s = new String();
        for(Node n : graph.nodes.values()){
            if (n.id != graph.start){
                s = s.concat(String.valueOf(n.distance));
                s = s.concat(" ");
            }
        }
        s = s.trim();
        System.out.println(s);         
    }

}
