import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        // Create input / output controller
        IOController io = new IOController();
        Graph graph = new Graph();

        // Read user input
        //io.readUserInput();
        //int userChoice = 1;

        // Add words from file to graph
        ArrayList<String> words = io.readWords();
        graph.addVertexes(words);

        graph.printGraph();
        io.readTestCase(graph);

        //System.out.println(graph.widthFirstSearch("fzcde", "bcdez"));

    }


    public static boolean wordHasFourInCommon(String word1, String word2) {
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
}
