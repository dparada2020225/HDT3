import java.io.*;
import java.util.*;

public class FileHandler {
    public static void generateRandomNumbers(String filePath, int amount) throws IOException {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < amount; i++) {
                writer.write(random.nextInt(10000) + "\n");
            }
        }
    }

    public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        return numbers;
    }
}