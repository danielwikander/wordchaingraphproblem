import java.util.*;

/**
 * Represents a digraph whose vertices are represented as words.
 * Edges are formed if vertex b has the last 4 letters in common with vertex a.
 */
class Graph {
    // Key: Name of vertex v, Value: List with edges for vertex v
    private HashMap<Vertex, LinkedList<Vertex>> verticesAndTheirEdges = new HashMap<>();

    /**
     * Returns an integer representing the distance between to vertices in the graph.
     * @param start The root for the search.
     * @param goal  The vertex to reach.
     * @return      Distance between start and goal as an integer. -1 if no path is found.
     */
    int bfs(Vertex start, Vertex goal) {
        // Create queue for holding upcoming vertices to check.
        Queue<Vertex> queue = new LinkedList<>();
        // Create list of vertices that have been checked.
        ArrayList<Vertex> visited = new ArrayList<>(verticesAndTheirEdges.size());

        // Create map for storing distance from start to each vertex.
        // Defaults to -1 (since we want to return -1 if no path can be found)
        HashMap<Vertex, Integer> distance = new HashMap<>();
        for (Map.Entry<Vertex, LinkedList<Vertex>> vertex : verticesAndTheirEdges.entrySet()) {
            distance.put(vertex.getKey(), -1);
        }
        distance.put(start, 0);

        // Add start vertex to queue to initiate search,
        // then add it to the 'visited' list so that we don't check it again.
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            // Take the first vertex from the queue.
            Vertex v = queue.remove();
            // Get all the vertexes edges.
            List<Vertex> neighbours = verticesAndTheirEdges.get(v);
            for (Vertex n : neighbours) {
                // If we haven't visited the neighboring vertex:
                if (n != null && !visited.contains(n)) {
                    // Save the neighbors distance as the previous vertex distance +1.
                    distance.put(n, distance.get(v) + 1);
                    // Add the vertex to the queue of upcoming vertices to check.
                    queue.add(n);
                    // Mark vertex as visited.
                    visited.add(n);
                }
            }
        }
        // Return the distance between start and goal vertices in the graph.
        return distance.get(goal);
    }


    /**
     * Converts a list of words into vertices and adds them to the graph.
     * Also adds edges for all vertices by calling wordHasAllExceptFirstInCommon()
     * for each vertex.
     * @param words The words to be added to the graph.
     */
    void addVertexes(ArrayList<String> words) {
        // Create vertices from words, and add them to graph
        for (String word : words) {
            Vertex wordVertex = new Vertex(word);
            addVertex(wordVertex);
        }

        // Go through the vertices and add edges where applicable.
        for (Map.Entry<Vertex, LinkedList<Vertex>> vertex : verticesAndTheirEdges.entrySet()) {
            for (Map.Entry<Vertex, LinkedList<Vertex>> vertex2 : verticesAndTheirEdges.entrySet()) {
                if (!vertex.getKey().getName().equals(vertex2.getKey().getName())) {
                    if (wordHasAllExceptFirstInCommon(vertex.getKey().getName(), vertex2.getKey().getName())) {
                        addEdge(vertex.getKey(), vertex2.getKey());
                    }
                }
            }
        }
    }


    /**
     * Checks if word2 has at least 4 characters in common with the last four characters in word1.
     * @param word1 Word to compare.
     * @param word2 Word to compare.
     * @return      True if word2 has at least 4 characters in common with the last four characters of word1.
     */
    private static boolean wordHasAllExceptFirstInCommon(String word1, String word2) {
        int charsInCommon = 0;

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for (int i = 1; i < w1.length; i++) {
            for (int j = 0; j < w2.length; j++) {
                if (w1[i] == w2[j]) {
                    charsInCommon++;
                    w2[j] = '\0'; // w2[j] som nullchar (använd)
                    break;
                }
            }
        }
        return (charsInCommon == w1.length - 1);
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex    The vertex to add.
     */
    private void addVertex(Vertex vertex) {
        if (!this.verticesAndTheirEdges.containsKey(vertex)) {
            this.verticesAndTheirEdges.put(vertex, new LinkedList<>());
        } else {
            System.out.println("Vertex already exists in map.");
        }
    }

    /**
     * Adds an edge to the graph.
     * @param v1 The originating vertex.
     * @param v2 The destination vertex.
     */
    private void addEdge(Vertex v1, Vertex v2) {
        LinkedList<Vertex> v1AdjacentVertices = verticesAndTheirEdges.get(v1);
        if (!v1AdjacentVertices.contains(v2)) {
            v1AdjacentVertices.add(v2);
        }
    }

    /**
     * Prints all vertices in the graph with their respective edges.
     */
    void printGraph() {
        System.out.println(
                "All vertices in the graph are presented below.\n" +
                        "Their individual edges presented after a tab. \n" +
                        "-------");

        for (Map.Entry<Vertex, LinkedList<Vertex>> entry : verticesAndTheirEdges.entrySet()) {
            LinkedList<Vertex> adj = entry.getValue();
            System.out.println("Vertex: " + entry.getKey().getName());
            for (Vertex v : adj) {
                System.out.println("        " + v.getName());
            }
        }
    }
}
