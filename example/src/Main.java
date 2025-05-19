public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 5);
        graph.addEdge(a, c, 3);
        graph.addEdge(b, d, 2);
        graph.addEdge(c, d, 7);
        graph.addEdge(d, e, 1);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, a);
        System.out.println("BFS путь от A до E: " + bfs.pathTo(e));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, a);
        System.out.println("Дейкстра путь от A до E: " + dijkstra.pathTo(e));
        System.out.println("Расстояние от A до E: " + dijkstra.distTo(e));
    }
}
