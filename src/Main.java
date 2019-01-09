import java.util.ArrayList;

public class Main {

    // TODO: Optimisering. Långsam vid 5757 ord.
    public static void main(String[] args) {

        // Create input / output controller
        IOController io = new IOController();
        Graph graph = new Graph();

        // Read user input
        io.readUserInput();

        // Add words from file to graph
        ArrayList<String> words = io.readWords();
        graph.addVertexes(words);

        graph.printGraph();
        ArrayList<Integer> output = io.readTestCase(graph);
        if (io.matchesExpectedOutput(output)) {
            System.out.println("Matches expected output.");
        } else {
            System.out.println("Doesn't match expected output.");
        }
    }
}
