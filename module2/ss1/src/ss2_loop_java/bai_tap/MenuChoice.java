package ss2_loop_java.bai_tap;

import java.util.Scanner;

public class MenuChoice {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("* * * * * *");
                    }
                    break;
                case 2:
                    System.out.println("Draw the triangle");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 5; i >= 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Draw isosceles triangle! Type the height you want:");
                    int height = input.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 1; j < height - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= (2 * i + 1); j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

            }
        }
    }
}
