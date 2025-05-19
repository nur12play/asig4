import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final WeightedGraph<T> graph;
    private final Map<Vertex<T>, Double> distTo;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        this.graph = graph;
        this.distTo = new HashMap<>();

        for (Vertex<T> vertex : graph.allVertices()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        dijkstra();
    }

    private void dijkstra() {
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(
                Comparator.comparingDouble(v -> distTo.getOrDefault(v, Double.POSITIVE_INFINITY))
        );

        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();

            if (marked.contains(current)) continue;
            marked.add(current);

            for (Map.Entry<Vertex<T>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = entry.getKey();
                double weight = entry.getValue(); // Исправлена опечатка
                double newDist = distTo.get(current) + weight;

                if (newDist < distTo.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    public double distTo(Vertex<T> v) {
        return distTo.getOrDefault(v, Double.POSITIVE_INFINITY);
    }
}