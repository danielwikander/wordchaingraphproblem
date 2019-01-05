import java.util.*;

class Graph {
    //private LinkedList<Vertex> vertices;
    private HashMap<Vertex, LinkedList<Vertex>> verticesAndTheirEdges;

    Graph() {
        //vertices = new LinkedList<>();
        verticesAndTheirEdges = new HashMap<>();
    }

    public int widthFirstSearch(Vertex v1, Vertex v2) {
        // Skapar en lista av 'besökta' vertices.
        Map<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
        int depth = 0;
        //for (Vertex vertex : vertices) {
        //    visited.put(vertex, false);
        //}
        visited.replaceAll((key, val) -> false); // Snabbare?

        // Skapar en kö att iterera
        LinkedList<Vertex> queue = new LinkedList<Vertex>();

        // Lägger till root i visited och lägger i kön.
        visited.put(v1, true);
        queue.add(v1);

        // Medans kön har vertices, iterera igenom dess närliggande vertices.
        while (queue.size() != 0) {
            v1 = queue.poll();

            // Hämta näriggande vertices, markera dem som besökta och lägg till i kön.
            System.out.println(verticesAndTheirEdges.get(new Vertex("fzcde")));

            LinkedList<Vertex> adjescent = verticesAndTheirEdges.get(v1); // TODO: Varför nullpointerexception?
            while (adjescent != null && adjescent.peek() != null) {
                Vertex vertex = adjescent.pop();
                if (!visited.get(vertex)) {
                    visited.replace(vertex, true);
                    queue.add(vertex);

                    // Om v1 hittar v2, returnera djupet.
                    if (vertex.equals(v2)) {
                        return depth;
                    }
                }
                depth++; // TODO: Trött som fan, är denna på rätt plats?

            }
            //depth++; // TODO: Trött som fan, är denna på rätt plats?
        }
        return -1;
    }

    public void addVertexes(ArrayList<String> words) {
        for (String word : words) {
            Vertex wordVertex = new Vertex(word);// Create vertex from word
            addVertex(wordVertex);         // Add word to graph

            for (String word2 : words) {
                if (!word2.equals(word)) {

                    if (wordHasAllExceptFirstInCommon(word, word2)) {
                        Vertex word2Vertex = new Vertex(word2);
                        addEdge(wordVertex, word2Vertex);
                    }
                }
            }
        }
    }


    public static boolean wordHasAllExceptFirstInCommon(String word1, String word2) {
        int charsInCommon = 0;

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        for (int i = 1; i < w1.length; i++) {

            for (int j = 1; j < w2.length; j++) {

                if (w1[i] == w2[j]) {
                    charsInCommon++;
                    w2[j] = '\0'; // w2[j] som nullchar (använd)
                    break;
                }
            }
        }
        if (charsInCommon == w1.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void addVertex(Vertex v) {
        //vertices.add(v);
        verticesAndTheirEdges.put(v, new LinkedList<Vertex>());
    }

    public void addEdge(Vertex v1, Vertex v2) {
        LinkedList<Vertex> v1AdjacentVertices = verticesAndTheirEdges.get(v1);
        v1AdjacentVertices.add(v2);
        // verticesAndTheirEdges.replace(v1, v1AdjacentVertices); Necessary?
    }

    public HashMap<Vertex, LinkedList<Vertex>> getVerticesEdges() {
        return verticesAndTheirEdges;
    }

    public void printGraph() {
        System.out.println("All vertices in the graph are presented below.\n" +
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
/*
        for (Vertex vertex : vertices) {
//            System.out.println("Name of vertex: " + vertex.getName());
            System.out.println(vertex.getName());

           // System.out.println("Edges for this vertex: ");
            for (Vertex edge : verticesAndTheirEdges.get(vertex)) {
                System.out.println("    " + edge.getName());
            }
        }
        */
    }

}
