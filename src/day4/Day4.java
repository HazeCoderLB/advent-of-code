package day4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Day4 {

    public static void main(String[] args) throws IOException {

        // Copy data.txt into a String array
        Path path = Path.of("src\\day4\\data.txt");
        String[] passports_ugly = Files.readString(path, StandardCharsets.UTF_8).split("\r\n\r\n");

        // Format the passport into one line each and split into the fields
        String[][] passports = new String[passports_ugly.length][8];
        for (int i = 0; i < passports.length; i++) {
            passports[i] = String.join(" ", passports_ugly[i].split("\r\n")).split(" ");
        }

        // Check for validation
        int validPassports = 0;
        Set<String> allFields = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid");
        Set<String> requiredFields = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        for (String[] passport : passports) {
            Map<String, String> fields = new HashMap<>();
            for (String field : passport) {
                String[] keyAndValue = field.split(":");
                fields.put(keyAndValue[0], keyAndValue[1]);
            }

            if (fields.keySet().equals(requiredFields) || fields.keySet().equals(allFields)) {
                validPassports++;
            }
        }

        // Print answer
        System.out.println("Valid Passwords Part 1: " + validPassports);

    }

}
