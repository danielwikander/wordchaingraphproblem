import java.util.*;

class Graph {
    // Key: Namn på vertex v, Value: Lista med Edges för vertex v
    private HashMap<Vertex, LinkedList<Vertex>> verticesAndTheirEdges = new HashMap<>();

    int bfs(Vertex start, Vertex goal) {
        int depth = 0;
        Queue<Vertex> queue = new LinkedList<Vertex>();
        ArrayList<Vertex> visited = new ArrayList<Vertex>();

        // Distance stuff
        HashMap<Vertex, Integer> distance = new HashMap<>();
        for (Map.Entry<Vertex, LinkedList<Vertex>> vertex : verticesAndTheirEdges.entrySet()) {
            distance.put(vertex.getKey(), Integer.MAX_VALUE);
        }
        distance.put(start, 0);

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            //System.out.println(v.getName());
            //if (v.equals(goal)) {
            //    return depth;
            //}
            List<Vertex> neighbours = verticesAndTheirEdges.get(v);
            for (Vertex n : neighbours) {
                if (n != null && !visited.contains(n)) {

                    distance.put(n, distance.get(v) + 1);
                    queue.add(n);
                    visited.add(n);
                    //if (n.equals(goal)) {
                    //    return ++depth;
                    //}
                }
            }
            //depth++;
        }
        if(distance.get(goal) == Integer.MAX_VALUE) {
            return -1;
        }
        return distance.get(goal);
        //return -1;
    }

    void addVertexes(ArrayList<String> words) {
        for (String word : words) {
            Vertex wordVertex = new Vertex(word); // Create vertex from word
            addVertex(wordVertex);                // Add word to graph
        }

        for (Map.Entry<Vertex, LinkedList<Vertex>> vertex : verticesAndTheirEdges.entrySet()) {

            for (Map.Entry<Vertex, LinkedList<Vertex>> vertex2 : verticesAndTheirEdges.entrySet()) {
                if (!vertex.getKey().getName().equals(vertex2.getKey().getName())) {

                    if (wordHasAllExceptFirstInCommon(vertex.getKey().getName(), vertex2.getKey().getName())) {
                        //Vertex word2Vertex = new Vertex(word2);
                        addEdge(vertex.getKey(), vertex2.getKey());
                    }
                }
            }
        }
    }

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

    private void addVertex(Vertex vertex) {
        //vertices.add(v);
        if (!this.verticesAndTheirEdges.containsKey(vertex)) {
            this.verticesAndTheirEdges.put(vertex, new LinkedList<Vertex>());
        } else {
            System.out.println("Vertex already exists in map.");
        }
    }

    private void addEdge(Vertex v1, Vertex v2) {
        LinkedList<Vertex> v1AdjacentVertices = verticesAndTheirEdges.get(v1);
        if (!v1AdjacentVertices.contains(v2)) {
            v1AdjacentVertices.add(v2);
        }
        // verticesAndTheirEdges.replace(v1, v1AdjacentVertices); Necessary?
    }

    public HashMap<Vertex, LinkedList<Vertex>> getVerticesEdges() {
        return verticesAndTheirEdges;
    }

    void printGraph() {
        System.out.println(
                "All vertices in the graph are presented below.\n" +
                        "Their individual edges presented after a tab. \n" +
                        "-------");
        LinkedList<Vertex> edges = new LinkedList<Vertex>();

        for (Map.Entry<Vertex, LinkedList<Vertex>> entry : verticesAndTheirEdges.entrySet()) {
            LinkedList<Vertex> adj = entry.getValue();
            System.out.println("Vertex: " + entry.getKey().getName());
            for (Vertex v : adj) {
                System.out.println("        " + v.getName());
            }
        }
    }
}
