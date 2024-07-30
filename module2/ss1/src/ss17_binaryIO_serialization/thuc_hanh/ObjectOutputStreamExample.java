package ss17_binaryIO_serialization.thuc_hanh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = null;
        List<Product> products = new ArrayList<Product>();

        try {
            oos = new ObjectOutputStream(new FileOutputStream("output.txt"));
            Product product = new Product(1, "Iphone 12", 280000, "New");
            Product product1 = new Product(1, "Iphone 12", 280000, "New");
            Product product2 = new Product(1, "Iphone 12", 280000, "New");
            Product product3 = new Product(1, "Iphone 12", 280000, "New");

            products.add(product);
            products.add(product1);
            products.add(product2);
            products.add(product3);

            oos.writeObject(products);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }
        System.out.println("Success!");
    }
}
