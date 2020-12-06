package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day4 {

    public static void main(String[] args) throws IOException {

        String path = "src\\day4\\data.txt";
        String passports;

        // Copy data.txt into a String
        Path data = Path.of(path);
        passports = Files.readString(data);

        

    }

}
