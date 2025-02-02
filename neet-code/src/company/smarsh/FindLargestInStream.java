package company.smarsh;

import java.io.*;
import java.util.Random;

public class FindLargestInStream {

    /*
        To find the largest number among a million numbers, the approach depends on the constraints:

        Low RAM Size (Streaming Approach)

        If you can't load all numbers into memory at once (e.g., due to low RAM),
        you can process the numbers one at a time or in small chunks from a file.

    */

    public static void main(String[] args) {
        String filePath = "numbers.txt";
        int numberOfNumbers = 1000000; // 1 million
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < numberOfNumbers; i++) {
                int number = random.nextInt(1000000); // Generate a random number up to 1,000,000
                writer.write(String.valueOf(number));
                writer.newLine();
            }
            System.out.println("File created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }


        try {
            int max = findLargestInStream(filePath);
            System.out.println("Largest number is: " + max);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static int findLargestInStream(String filePath) throws IOException {
        int max = Integer.MIN_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }
}
