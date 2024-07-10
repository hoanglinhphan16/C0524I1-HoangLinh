package ss4_OOP.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap a");
        double a = sc.nextDouble();
        System.out.println("Nhap b");
        double b = sc.nextDouble();
        System.out.println("Nhap c");
        double c = sc.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a,b,c);

        double delta = quadraticEquation.getDiscriminant();

        if (delta > 0) {
            System.out.println("x1 = " + quadraticEquation.getRoot1() + " x2 = " + quadraticEquation.getRoot2());
        } else if (delta == 0) {
            System.out.println("pt co 1 nghiem x =" + quadraticEquation.getRoot1());
        } else System.out.println("Pt vo nghiem");
    }
}
