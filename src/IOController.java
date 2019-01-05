import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOController {

    private File smallWordFile = new File("resources/ord14.txt");
    private File mediumWordFile = new File("resources/ord250.txt");
    private File largeWordFile = new File("resources/ord5757.txt");

    private File smallTestFile = new File("resources/testFall14.txt");
    private File mediumTestFile = new File("resources/testFall250.txt");
    private File largeTestFile = new File("resources/testFall5757.txt");

//    private File wordFile; // The chosen one
  //  private File testFile; // Test file for the chosen one

    private File wordFile = smallWordFile; // The chosen one
    private File testFile = smallTestFile; // Test file for the chosen one


    public void readUserInput() {

        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput = true;
        do {
            System.out.println("Välj ordmängdj:\n" +
                    "1: 14 ord\n" +
                    "2: 250 ord\n" +
                    "3: 5757 ord");

            input = scanner.nextLine();
            if (input.equals("1")) {
                wordFile = smallWordFile;
                testFile = smallTestFile;
            } else if (input.equals("2")) {
                wordFile = mediumWordFile;
                testFile = mediumTestFile;
            } else if (input.equals("3")) {
                wordFile = largeWordFile;
                testFile = largeTestFile;
            } else {
                System.out.println("Invalid input. Please type 1, 2 or 3.\n");
                validInput = false;
            }

        } while (!validInput);
    }

    /*public ArrayList<String> readWords() {
        if (wordFile !=null && testFile !=null) {

        } else {
            System.out.println("Please choose which files to read before attempting to read them..");
        }
        ArrayList words = null;
        if (choice == 1) {
            words = readWords(smallWordFile);
        } else if (choice == 2) {
            words = readWords(mediumWordFile);
        } else if (choice == 3) {
            words = readWords(largeWordFile);
        } else {
            System.out.println("Error: File could not be read.");
        }
        return words;
    } */

    public ArrayList<String> readWords() {
        if (wordFile != null && testFile != null) { // Checks if user has chosen which file to read.
            try {
                BufferedReader r =
                        new BufferedReader(new InputStreamReader(new FileInputStream(wordFile)));
                ArrayList<String> words = new ArrayList<String>();
                while (true) {
                    String word = r.readLine();
                    if (word == null) {
                        break;
                    }
                    assert word.length() == 5; // indatakoll, om man kör med assertions på
                    words.add(word);
                }
                System.out.println();
                // words.forEach(System.out::println); // Prints all words in file
                return words;
            } catch (IOException e) {
                System.out.println("Couldn't read file:" + wordFile.getAbsolutePath());
            }
        } else {
            System.out.println("Please choose which files to read before attempting to read them..");
        }
        return null;
    }

    public void readTestCase(Graph graph) {
        if (wordFile != null && testFile != null) { // Checks if user has chosen which file to read.
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
                    System.out.println(graph.widthFirstSearch(new Vertex(start), new Vertex(goal)));
                    // ... sök väg från start till goal här
                }
            } catch (IOException e) {
                System.out.println("Couldn't read file:" + testFile.getAbsolutePath());
            }
        } else {
            System.out.println("Please choose which files to read before attempting to read them..");
        }
    }

}
