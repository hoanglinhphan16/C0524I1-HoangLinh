package ss11_stack_queue.bai_tap;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        str = str.toLowerCase();
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new ArrayDeque<Character>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }

        boolean isPalindrome = true;
       while (!queue.isEmpty()) {
           if (queue.poll() != stack.pop()) {
               isPalindrome = false;
           }
       }

        if (isPalindrome) {
            System.out.println("Is a palindrome: " + isPalindrome);
        } else {
            System.out.println("Isn't a palindrome: " + isPalindrome);
        }
    }
}
