package ss12_map_tree.bai_tap;

import java.util.LinkedList;
import java.util.List;

public class ProductManager {
    private int id;
    private String name;
    private long price;
    public static List<ProductManager> list = new LinkedList<ProductManager>();

    static {
        ProductManager p = new ProductManager(1, "Car", 3000);
        ProductManager p2 = new ProductManager(2, "Boat", 6000);
        ProductManager p3 = new ProductManager(3, "Computer", 9000);

        list.add(p);
        list.add(p2);
        list.add(p3);
    }

    public ProductManager() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductManager(int id, String name, long price) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public List<ProductManager> findAll() {
        return list;
    }

    public void add(ProductManager product) {
        list.add(product);
    }

    public void update(int index, ProductManager product) {
        list.set(index, product);
    }

    public void remove(ProductManager product) {
        list.remove(product);
    }

    public void searchProduct(String name) {
        for (ProductManager product : list) {
            if (product.getName().toLowerCase().contains(name)) {
                System.out.println(product);
            }
        }
    }

    public void sortById() {
        List<ProductManager> newList = list;
        newList.sort((a, b) -> a.getId() - b.getId());
        newList.forEach(System.out::println);
    }

    public void sortByName() {
        List<ProductManager> newList = list;
        newList.sort((a, b) -> a.getName().compareTo(b.getName()));
        newList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
