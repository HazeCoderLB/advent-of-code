package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) {

        List<Integer> inputs = new ArrayList<>();

        // Get inputs from data.txt
        try {
            File myFile = new File("src\\day1\\data.txt");
            Scanner myReader = new Scanner(myFile);
            int i = 0;
            while (myReader.hasNextLine()) {
                inputs.add(Integer.valueOf(myReader.nextLine()));
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Part 1:
        for (int posNumber1 = 0; posNumber1 < inputs.size(); posNumber1++) {
            for (int posNumber2 = posNumber1 + 1; posNumber2 < inputs.size(); posNumber2++) {

                int sum = inputs.get(posNumber1) + inputs.get(posNumber2);
                if (sum == 2020) {

                    int number1 = inputs.get(posNumber1);
                    int number2 = inputs.get(posNumber2);

                    int answer = number1 * number2;
                    System.out.println("Answer Part 1: " + answer);
                }

            }
        }

        // Part 2:
        for (int posNumber1 = 0; posNumber1 < inputs.size() - 1; posNumber1++) {
            for (int posNumber2 = posNumber1 + 1; posNumber2 < inputs.size(); posNumber2++) {
                for (int posNumber3 = posNumber2 + 1; posNumber3 < inputs.size(); posNumber3++) {

                    int sum = inputs.get(posNumber1) + inputs.get(posNumber2) + inputs.get(posNumber3);
                    if (sum == 2020) {

                        int number1 = inputs.get(posNumber1);
                        int number2 = inputs.get(posNumber2);
                        int number3 = inputs.get(posNumber3);

                        int answer = number1 * number2 * number3;
                        System.out.println("Answer Part 2: " + answer);
                    }

                }
            }
        }

    }

}