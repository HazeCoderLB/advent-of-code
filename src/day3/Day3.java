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

        // Get lines of data.txt
        long lineCount;
        Path path = Path.of("src\\day3\\data.txt");
        try (Stream<String> stream = Files.lines(path)) {
            lineCount = stream.count();
        }

        String[] inputs = new String[(int) lineCount];

        // Get inputs from data.txt
        try {
            File myFile = new File("src\\day3\\data.txt");
            Scanner myReader = new Scanner(myFile);
            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}
