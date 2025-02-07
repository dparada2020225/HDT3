import java.io.*;
import java.util.*;

public class FileHandler {

    public static void generateRandomNumbersCSV(String filePath, int amount) throws IOException {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < amount; i++) {
                writer.append(String.valueOf(random.nextInt(10000))).append("\n");
            }
        }
    }

    public static List<Integer> readNumbersFromCSV(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        return numbers;
    }

    public static void writeNumbersToCSV(String filePath, Integer[] numbers) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Integer number : numbers) {
                writer.append(String.valueOf(number)).append("\n");
            }
        }
    }
}
