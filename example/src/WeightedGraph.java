import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private final Map<T, Vertex<T>> vertices = new HashMap<>();

    public void addVertex(Vertex<T> v) {
        if (!vertices.containsKey(v.data())) {
            vertices.put(v.data(), v);
        }
    }

    public void addEdge(Vertex<T> v, Vertex<T> w, double weight) {
        addVertex(v);
        addVertex(w);
        v.addAdjacentVertex(w, weight);
        w.addAdjacentVertex(v, weight);
    }

    public Set<Vertex<T>> allVertices() {
        return new HashSet<>(vertices.values());
    }

    public Map<Vertex<T>, Double> getAdjacentVertices(Vertex<T> v) {
        return v.getAdjacentVertices();
    }

    public Double getWeight(Vertex<T> v, Vertex<T> w) {
        return v.getAdjacentVertices().getOrDefault(w, Double.POSITIVE_INFINITY);
    }

    public Vertex<T> getVertex(T data) {
        return vertices.get(data);
    }
}