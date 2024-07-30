package ss17_binaryIO_serialization.thuc_hanh;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("output.txt");

        byte[] bytes = new byte[] {'H', 'o', 'a', 'n', 'g', 'L', 'i', 'n', 'h'};

        for (int i = 0; i < bytes.length; i++) {
            os.write(bytes[i]);
        }
        os.close();
    }
}




