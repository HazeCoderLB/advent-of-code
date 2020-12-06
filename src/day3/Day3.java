package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day3 {

    public static void main(String[] args) throws IOException {

        String path = "src\\day3\\data.txt";

        // Get lines of data.txt
        long lineCount;
        try (Stream<String> stream = Files.lines(Path.of(path))) {
            lineCount = stream.count();
        }

        // Initialize a String array
        String[] lines = new String[(int) lineCount];

        // Get every line from data.txt and store them in an array
        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            for (int i = 0; i < lines.length; i++) {
                lines[i] = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Get the number of encountered trees (Part 1)
        char tree = '#';
        int treeCounter = 0;
        int lineLength = lines[0].length();
        int horizontalPos = 0;
        int headRight = 3;
        int headDown = 1;

        for (int i = headDown; i<lines.length; i+=headDown) {
            if (horizontalPos < lineLength-headRight) {
                horizontalPos += headRight;
            } else {
                horizontalPos = horizontalPos - lineLength + headRight;
            }

            char position = lines[i].toCharArray()[horizontalPos];

            if (position == tree) treeCounter++;
        }

        System.out.println("Encountered trees: " + treeCounter);
    }

}
