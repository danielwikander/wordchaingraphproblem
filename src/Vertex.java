/**
 * Represents a vertex to use in a graph.
 */
public class Vertex {
    private String name;

    Vertex(String name) {
        this.name = name;
    }

    /**
     * Method is overridden in order for the vertex to be comparable by name.
     * @param obj   The vertex to compare.
     * @return      True if the name of the input vertex matches this one.
     */
    @Override
    public boolean equals(Object obj) {
        Vertex _obj = (Vertex) obj;
        return _obj.name.equals(name);
    }

    /**
     * Method is overridden in order for the vertex to be hashable by name.
     * @return      Returns a unique integer based on the vertexes name.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * @return The name of the vertex.
     */
    String getName() {
        return name;
    }

}
