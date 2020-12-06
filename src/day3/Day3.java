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

        // Different slopes
        int[][] directions = {{1,1},{3,1},{5,1},{7,1},{1,2}};
        int initHorizontalPos = 0;

        // Part 1
        int numOfTreesPart1 = TreeCounter.countTrees(lines, initHorizontalPos, directions[1][0], directions[1][1]);
        System.out.println("Encountered trees Part 1: " + numOfTreesPart1);

        // Part 2
        int numOfTreesPart2[] = new int[directions.length];
        for (int i = 0; i<directions.length; i++) {
            numOfTreesPart2[i] = TreeCounter.countTrees(lines,initHorizontalPos,directions[i][0], directions[i][1]);
        }

        long product = 0;
        for (int i = 0; i<numOfTreesPart2.length; i++) {
            if (i == 0) product = numOfTreesPart2[i];
            else product *= numOfTreesPart2[i];
        }

        System.out.println("Product Part 2 = " + product);
    }

}
