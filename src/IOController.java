import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles input and output for the program.
 * Has functions for reading files and user input.
 */
class IOController {

    private File smallWordFile = new File("resources/ord14.txt"),
                mediumWordFile = new File("resources/ord250.txt"),
                 largeWordFile = new File("resources/ord5757.txt"),
                 smallTestFile = new File("resources/testFall14.txt"),
                mediumTestFile = new File("resources/testFall250.txt"),
                 largeTestFile = new File("resources/testFall5757.txt"),
       smallExpectedOutputFile = new File("resources/forvantatOutput14.txt"),
      mediumExpectedOutputFile = new File("resources/forvantatOutput250.txt"),
       largeExpectedOutputFile = new File("resources/forvantatOutput5757.txt"),
                      wordFile, // The chosen one
                      testFile, // Test file for the chosen one
            expectedOutputFile; // Expected outcome for the chosen one


    /**
     * Reads user input, and selects what files to use accordingly.
     */
    void readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput = false;
        do {
            System.out.println(
                    "Välj ordmängd:\n" +
                    "1: 14 ord     \n" +
                    "2: 250 ord    \n" +
                    "3: 5757 ord     ");

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    wordFile = smallWordFile;
                    testFile = smallTestFile;
                    expectedOutputFile = smallExpectedOutputFile;
                    validInput = true;
                    break;
                case "2":
                    wordFile = mediumWordFile;
                    testFile = mediumTestFile;
                    expectedOutputFile = mediumExpectedOutputFile;
                    validInput = true;
                    break;
                case "3":
                    wordFile = largeWordFile;
                    testFile = largeTestFile;
                    expectedOutputFile = largeExpectedOutputFile;
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input. Please type 1, 2 or 3.\n");
                    break;
            }
        } while (!validInput);
    }

    /**
     * Checks if the programs output matches the expected output from the selected files.
     * @param output    The programs output.
     * @return          True if the programs output matches the values in the expectedOutputFile.
     */
    boolean matchesExpectedOutput(ArrayList<Integer> output) {
        int correctValues = 0;
        try {
            BufferedReader r =
                    new BufferedReader(new InputStreamReader(new FileInputStream(expectedOutputFile)));
            for (Integer anOutput : output) {

                String value = r.readLine();
                if (value == null) {
                    break;
                }
                int v = Integer.parseInt(value);
                if (v == anOutput) {
                    correctValues++;
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't read file:" + expectedOutputFile.getAbsolutePath());
        }
        return (correctValues == output.size());
    }

    /**
     * Reads the words from the selected word file.
     * @return  ArrayList of words from the selected file.
     */
    ArrayList<String> readWords() {
        if (wordFile != null && testFile != null) { // Checks if user has chosen which file to read.
            try {
                BufferedReader r =
                        new BufferedReader(new InputStreamReader(new FileInputStream(wordFile)));
                ArrayList<String> words = new ArrayList<>();
                while (true) {
                    String word = r.readLine();
                    if (word == null) {
                        break;
                    }
                    assert word.length() == 5;
                    words.add(word);
                }
                System.out.println();
                return words;
            } catch (IOException e) {
                System.out.println("Couldn't read file:" + wordFile.getAbsolutePath());
            }
        } else {
            System.out.println("Please choose which files to read before attempting to read them..");
        }
        return null;
    }

    /**
     * Reads the testcase from the test file.
     * For each pair of words from the testfile, the function
     * calls a breadth first search between the words in the graph
     * and saves the output in an arraylist.
     * @param graph The graph to read.
     * @return      Arraylist of distances between the words from the file.
     */
    ArrayList<Integer> readTestCase(Graph graph) {
        if (wordFile != null && testFile != null && expectedOutputFile != null) { // Checks if user has chosen which file to read.
            ArrayList<Integer> outputValues = new ArrayList<>();
            try {
                BufferedReader r =
                        new BufferedReader(new InputStreamReader(new FileInputStream(testFile)));
                while (true) {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    assert line.length() == 11; // indatakoll, om man kör med assertions på
                    String start = line.substring(0, 5);
                    String goal = line.substring(6, 11);
                    // ... sök väg från start till goal här
                    outputValues.add(graph.bfs(new Vertex(start), new Vertex(goal)));
                }
                System.out.println("Distance between the selected vertices:");
                for (Integer value:outputValues) {
                    System.out.println(value);
                }
                return outputValues;
            } catch (IOException e) {
                System.out.println("Couldn't read file:" + testFile.getAbsolutePath());
            }
        } else {
            System.out.println("Please choose which files to read before attempting to read them..");
        }
        return null;
    }
}
