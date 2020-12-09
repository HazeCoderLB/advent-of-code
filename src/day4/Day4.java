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
        int validPassportsPart1 = 0;
        int validPassportsPart2 = 0;
        Set<String> requiredFields = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        for (String[] passport : passports) {
            Map<String, String> fields = new HashMap<>();
            for (String field : passport) {
                String[] keyAndValue = field.split(":");
                fields.put(keyAndValue[0], keyAndValue[1]);
            }

            if (fields.keySet().containsAll(requiredFields)) {
                validPassportsPart1++;

                // Part 2
                int byr = Integer.valueOf(fields.get("byr"));
                boolean byrValid = byr >= 1920 && byr <= 2002;

                int iyr = Integer.valueOf(fields.get("iyr"));
                boolean iyrValid = iyr >= 2010 && iyr <= 2020;

                int eyr = Integer.valueOf(fields.get("eyr"));
                boolean eyrValid = eyr >= 2020 && eyr <= 2030;

                String hgt = fields.get("hgt");
                int hgtValue = 0;
                String hgtUnit = hgt.substring(hgt.length() - 2);
                boolean hgtValid1 = hgt.matches("[0-9]{2,3}[a-z]{2}");
                if (hgtValid1) hgtValue = Integer.valueOf(hgt.substring(0, hgt.length() - 2));
                boolean hgtValid2 = false;
                if (hgtUnit.equals("cm") && hgtValue >= 150 && hgtValue <= 193) hgtValid2 = true;
                else if (hgtUnit.equals("in") && hgtValue >= 59 && hgtValue <= 76) hgtValid2 = true;
                boolean hgtValid = hgtValid1 && hgtValid2;

                String hcl = fields.get("hcl");
                boolean hclValid = hcl.matches("^[#][0-9a-f]{6}$");

                String ecl = fields.get("ecl");
                boolean eclValid = ecl.matches("amb|blu|brn|gry|grn|hzl|oth");

                String pid = fields.get("pid");
                boolean pidValid = pid.matches("[0-9]{9}");

                if (byrValid && iyrValid && eyrValid && hgtValid && hclValid && eclValid && pidValid) {
                    validPassportsPart2++;
                }
            }

        }

        // Print answers
        System.out.println("Valid Passports Part 1: " + validPassportsPart1);
        System.out.println("Valid Passports Part 2: " + validPassportsPart2);

    }

}
