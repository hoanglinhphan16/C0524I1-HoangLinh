package ss6_inheritance.thuc_hanh;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.p(10);
        a.p(10.0);
    }
}

class A extends B {
    public void p(double number) {
        System.out.println("class A " + number);
    }
}

class B {
    public void p(int number) {
        System.out.println("class B "+number * 2);
    }

}
