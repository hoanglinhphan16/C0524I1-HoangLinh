package ss15_exception.thuc_hanh;

public class Example {
//    Throw:
//            + Nằm bên trong hàm/phương thức.
//            + Dùng để trả về một exception được xác định.
//            + Nếu là checked exception thì cần đi chung với throws.
//            + Nếu là unchecked exception thì không cần đi chung với throws.
//            + Theo sau throw là duy nhất một instance ngoại lệ.
//    Throws:
//            + Nằm ngay sau phần khai báo tên hàm/phương thức.
//            + Dùng để thông báo sự tồn tại của exception trong phương thức đó.
//            + Throws có thể khai báo nhiều exception.


    public static void main(String[] args) {
        try {
            setAge(-1);
        }catch (IllegalArgumentException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }

    public static void setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        System.out.println("Age is set to: " + age);
    }
}
