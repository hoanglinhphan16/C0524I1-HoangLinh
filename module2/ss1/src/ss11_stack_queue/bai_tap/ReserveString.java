package ss11_stack_queue.bai_tap;

import java.util.Stack;

public class ReserveString {
    public static void main(String[] args) {
        String str = "Hoanglinh";
        Stack<Character> stack = new Stack<>();
        Stack<Character> newStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            newStack.push(stack.pop());
        }

        System.out.println(newStack);
    }
}
