package ss15_exception.thuc_hanh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoThrowsExample {

    public static void main(String[] args) {
        try {
            readFile("example.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Caught an exception123: " + e.getMessage());
        }
    }

    // Phương thức không khai báo `throws FileNotFoundException`
    public static void readFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);  // Lỗi biên dịch xảy ra ở đây

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}