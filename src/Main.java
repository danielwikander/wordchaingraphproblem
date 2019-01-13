import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Reads user input, selects which files to read and compare outcome to.
        IOController io = new IOController();
        io.readUserInput();
        ArrayList<String> words = io.readWords();

        // Create graph, add vertices and edges.
        Graph graph = new Graph();
        graph.addVertexes(words);
        //graph.printGraph();

        // Read testfile, do bfs and compare outcome.
        ArrayList<Integer> output = io.readTestCase(graph);
        if (io.matchesExpectedOutput(output)) {
            System.out.println("Matches expected output.");
        } else {
            System.out.println("Doesn't match expected output.");
        }
    }
}
