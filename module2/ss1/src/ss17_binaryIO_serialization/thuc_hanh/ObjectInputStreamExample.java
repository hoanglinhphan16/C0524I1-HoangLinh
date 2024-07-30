package ss17_binaryIO_serialization.thuc_hanh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectInputStreamExample {
    public static void main(String[] args) throws IOException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("product.txt"))) {
            Product product = (Product) ois.readObject();
            System.out.println(product);

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("======================================================");

        File myfile = new File("output.txt");
        if (myfile.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output.txt"))) {
                List<Product> products = (List<Product>) ois.readObject();
                System.out.println("Success!");
                products.forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else System.out.println("File ko co gi thang ngu");



        System.out.println("========================================================");
    }
}
