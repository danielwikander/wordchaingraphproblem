public class Vertex {
    private String name;

    Vertex(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Vertex _obj = (Vertex) obj;
        return _obj.name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

}
