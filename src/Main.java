import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        IOController io = new IOController();
        int userChoice = io.readUserInput();
        //int userChoice = 1;

        ArrayList<String> words = io.readWords(userChoice);

        GraphExp graph = new GraphExp();

        // Check for edges and add to edges
        for (String word : words) {
            Vertex wordVertex = new Vertex(word);// Create vertex from word
            graph.addVertex(wordVertex);         // Add word to graph

            for (String word2 : words) {
                if (!word2.equals(word)) {

                    if (wordHasFourInCommon(word, word2)) {
                        Vertex word2Vertex = new Vertex(word2);
                        graph.addEdge(wordVertex, word2Vertex);
                    }
                }

            }
        }
        graph.printGraph();

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
