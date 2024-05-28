import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        super(graph, start);
    }

    @Override
    public void execute() {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Vertex<V> vertex : graph.getVertices()) {
            if (vertex.equals(start)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.MAX_VALUE);
            }
            queue.add(vertex);
        }

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Edge<V> edge : graph.getEdges(current)) {
                Vertex<V> neighbor = edge.getDest();
                double newDist = distances.get(current) + edge.getWeight();
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previousVertices.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        for (Map.Entry<Vertex<V>, Double> entry : distances.entrySet()) {
            System.out.println("Distance to " + entry.getKey().getData() + " is " + entry.getValue());
        }
    }
}
