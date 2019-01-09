import java.util.ArrayList;

public class Main {

    // TODO: Optimisering. Långsam vid 5757 ord.
    public static void main(String[] args) {
        // Read user input
        IOController io = new IOController();
        io.readUserInput();
        ArrayList<String> words = io.readWords();

        // Create graph and add words as Vertices and Edges
        Graph graph = new Graph();
        graph.addVertexes(words);
        //graph.printGraph();
        ArrayList<Integer> output = io.readTestCase(graph);
        if (io.matchesExpectedOutput(output)) {
            System.out.println("Matches expected output.");
        } else {
            System.out.println("Doesn't match expected output.");
        }
    }
}
