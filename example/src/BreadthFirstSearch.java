import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    private final WeightedGraph<T> graph;

    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        this.graph = graph;
        bfs(source);
    }

    private void bfs(Vertex<T> start) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();

            for (Vertex<T> neighbor : graph.getAdjacentVertices(current).keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current); // Сохраняем путь
                    queue.add(neighbor);
                }
            }
        }
    }
}