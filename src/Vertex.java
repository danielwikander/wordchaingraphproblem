public class Vertex {
    private String name;

    Vertex(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;

        Vertex _obj = (Vertex) obj;
        return _obj.name == name;
    }

    public String getName() {
        return name;
    }

}
