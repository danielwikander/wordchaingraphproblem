import java.util.*;
import java.util.stream.Collectors;

/**
 * Representerar en graf.
 */
/*public class Graph {
    private int V; // Number of vertices in graph.
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjacentVertices;

    public Graph(int v) {
        this.V = v;
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjacentVertices= new HashMap<>();
    }

    public boolean addVertex(String name) {
        return vertices.add(new Vertex(name));
    }

    public boolean addVertex(Vertex v) {
        return vertices.add(v);
    }

    public boolean removeVertex(String name) {
        return vertices.remove(new Vertex(name));
    }

    public boolean removeVertex(Vertex v) {
        return vertices.remove(v);
    }


    public boolean addEdge(Edge e) {
        if (!edges.add(e)) return false;

        adjacentVertices.putIfAbsent(e.v1, new HashSet<>());
        adjacentVertices.putIfAbsent(e.v2, new HashSet<>());

        adjacentVertices.get(e.v1).add(e);
        adjacentVertices.get(e.v2).add(e);

        return true;
    }

    public boolean addEdge(String name1, String name2) {
        return addEdge(new Edge(new Vertex(name1),
                new Vertex(name2)));
    }

    public boolean removeEdge(Edge e) {
        if (!edges.remove(e)) return false;
        Set<Edge> edgesOfV1 = adjacentVertices.get(e.v1);
        Set<Edge> edgesOfV2 = adjacentVertices.get(e.v2);

        if (edgesOfV1 != null) edgesOfV1.remove(e);
        if (edgesOfV2 != null) edgesOfV2.remove(e);

        return true;
    }

    public boolean removeEdge(String name1, String name2) {
        return removeEdge(new Edge(new Vertex(name1),
                new Vertex(name2)));
    }

    void widthFirstSearch(String root) {
        // Skapa map över besökta noder.
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        for (Vertex vertex: vertices) {
            visited.put(vertex.getName(), false);
        }

        LinkedList<String> queue = new LinkedList<String>();

        // Markera noden som besökt och köa.
        visited.put(root,true);
        queue.add(root);

        while (queue.size() != 0) {
            // Dequeue a vertex and print
            root = queue.poll();
            System.out.print(root + " ");

            Set edges = adjacentVertices.get(root);


        }
    }


    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjacentVertices[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public Set<Vertex> getAdjVertices(Vertex v) {
        return adjacentVertices.get(v).stream()
                .map(e -> e.v1.equals(v) ? e.v2 : e.v1)
                .collect(Collectors.toSet());
    }

}
*/

