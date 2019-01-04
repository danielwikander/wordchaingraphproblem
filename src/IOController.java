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

    public int readUserInput() {

        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput = true;
        do {
            System.out.println("Välj ordmängd:\n" +
                    "1: 14 ord\n" +
                    "2: 250 ord\n" +
                    "3: 5757 ord");

            input = scanner.nextLine();
            if (input.equals("1")|| input.equals("2") || input.equals("3")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Invalid input. Please type 1, 2 or 3.\n");
                validInput = false;
            }

        } while (!validInput);
        return 0;
    }

    public ArrayList<String> readWords(int choice) {
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
    }

    public ArrayList<String> readWords(File file) {
        try {
            BufferedReader r =
                    new BufferedReader(new InputStreamReader(new FileInputStream(file)));
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
            System.out.println("Couldn't read file:" + file.getAbsolutePath());
        }
        return null;
    }

    public void readTestCase(File file) throws IOException {
        try {
            BufferedReader r =
                    new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (true) {
                String line = r.readLine();
                if (line == null) {
                    break;
                }
                assert line.length() == 11; // indatakoll, om man kör med assertions på
                String start = line.substring(0, 5);
                String goal = line.substring(6, 11);
                // ... sök väg från start till goal här
            }
        } catch (IOException e) {
            System.out.println("Couldn't read file:" + file.getAbsolutePath());
        }
    }

}
