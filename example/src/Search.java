import java.util.*;

public abstract class Search<T> {
    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public Search(Vertex<T> source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> v) {
        return marked.contains(v);
    }

    public List<Vertex<T>> pathTo(Vertex<T> vertex) {
        if (!hasPathTo(vertex)) return null;

        LinkedList<Vertex<T>> path = new LinkedList<>();
        for (Vertex<T> v = vertex; !v.equals(source); v = edgeTo.get(v)) {
            path.addFirst(v);
        }
        path.addFirst(source);
        return path;
    }
}

