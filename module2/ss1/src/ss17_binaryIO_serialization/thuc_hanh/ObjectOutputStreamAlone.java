package ss17_binaryIO_serialization.thuc_hanh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamAlone {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("product.txt"));
            Product product = new Product(1, "Truck", 15000, "Shit truck");
            oos.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
