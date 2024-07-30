package ss16_IOTextFile.bai_tap;
import java.io.IOException;
import java.nio.file.*;

public class CopyFile {
    public static void main(String[] args) {
        Path source = Paths.get("scores.txt");
        Path destination = Paths.get("newFile.txt");

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
