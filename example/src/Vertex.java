import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        if (data == null) throw new NullPointerException();
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<T> vertex, double weight) {
        adjacentVertices.put(vertex, weight);
    }

    public T data() {
        return data;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return data.equals(vertex.data);
    }

    @Override
    public int hashCode(){
        return  data != null ?  data.hashCode() : 0;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}
