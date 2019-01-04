import java.util.*;

class GraphExp {
    private LinkedList<Vertex> vertices;
    private HashMap<Vertex, LinkedList<Vertex>> adjacentVertices;

    GraphExp() {
        vertices = new LinkedList<>();
        adjacentVertices = new HashMap<>();
    }

    void widthFirstSearch(Vertex v) {
        // Skapar en lista av 'besökta' vertices.
        Map<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
        for (Vertex vertex : vertices) {
            visited.put(vertex, false);
        }
        //visited.replaceAll((key, val) -> false); Snabbare?

        // Skapar en kö att iterera
        LinkedList<Vertex> queue = new LinkedList<Vertex>();

        // Lägger till root i visited och lägger i kön.
        visited.put(v, true);
        queue.add(v);

        // Medans kön har vertices, iterera igenom dess närliggande vertices.
        while (queue.size() != 0) {
            v = queue.poll();
            System.out.print(v.getName() + " ");

            // Hämta näriggande vertices, markera dem som besökta och lägg till i kön.
            LinkedList<Vertex> adjescent = adjacentVertices.get(v);
            while (adjescent.peek() != null) {
                Vertex vertex = adjescent.pop();
                if (!visited.get(vertex)) {
                    visited.replace(vertex, true);
                    queue.add(vertex);
                }
            }
        }
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
        adjacentVertices.put(v, new LinkedList<Vertex>());
    }

    public void addEdge(Vertex v1, Vertex v2) {
        LinkedList<Vertex> v1AdjacentVertices = adjacentVertices.get(v1);
        v1AdjacentVertices.add(v2);
        // adjacentVertices.replace(v1, v1AdjacentVertices); Necessary?
    }

    public void printGraph() {
        System.out.println("All vertices in the graph are presented below.\n" +
                "Their individual edges presented after a tab. \n" +
                "-----");
        LinkedList<Vertex> edges = new LinkedList<Vertex>();

        for (Vertex vertex : vertices) {
//            System.out.println("Name of vertex: " + vertex.getName());
            System.out.println(vertex.getName());

           // System.out.println("Edges for this vertex: ");
            for (Vertex edge : adjacentVertices.get(vertex)) {
                System.out.println("    " + edge.getName());
            }
        }
    }

}
