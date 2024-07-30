package ss16_IOTextFile.thuc_hanh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileExample {
    public static void readFileExample(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }

            br.close();
            System.out.println(sum);
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFileExample("scores.txt");
    }
}
