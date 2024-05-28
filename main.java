public class Main {
    public static void main(String[] args) {
    
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);

        graph.addEdge(vertexA, vertexB, 1.0);
        graph.addEdge(vertexA, vertexC, 4.0);
        graph.addEdge(vertexB, vertexC, 2.0);
        graph.addEdge(vertexC, vertexD, 1.0);
        graph.addEdge(vertexB, vertexD, 5.0);

        System.out.println("Breadth-First Search:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, vertexA);
        bfs.execute();

        System.out.println("\nDijkstra's Algorithm:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, vertexA);
        dijkstra.execute();
    }
}
