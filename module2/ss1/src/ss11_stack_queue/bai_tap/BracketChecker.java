package ss11_stack_queue.bai_tap;

import java.util.Stack;

public class BracketChecker {
    public static void main(String[] args) {
        String str = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        Stack<Character> bracketStack = new Stack<Character>();

        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bracketStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (bracketStack.isEmpty()) {
                    check = false;
                } else if (bracketStack.pop() != '(') {
                    check = false;
                }
            }
        }

        if(!bracketStack.isEmpty()) {
            check = false;
        }

        if (check) {
            System.out.println("Bracket check passed");
        } else {
            System.out.println("Bracket check failed");
        }

    }
}
