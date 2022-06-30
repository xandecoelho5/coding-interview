package challenges.linkedLists;

import data_structures.stack.Stack;

public class LinkedListAdder {

    // Add numbers contained within two LinkedLists
    public Stack sum(Stack first, Stack second) {
        // Convert
        int num1 = convertFrom(first);
        int num2 = convertFrom(second);

        // Add
        int sum = num1 + num2;

        // Put back into LinkedList form
        return convertTo(sum);
    }

    private int convertFrom(Stack stack) {
        // Pop the numbers off the stack and build them up into a string, then an int
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int num = stack.pop();
            sb.append(num);
        }

        return Integer.parseInt(sb.toString());
    }

    private Stack convertTo(int number) {
        // Because we need them in reverse order, store them here first,
        // they flip to reverse order after

        Stack forward = new Stack();
        Stack backward = new Stack();

        // Keep slicing off the digits by dividing by 10 and pushing the remainder
        while (number > 0) {
            forward.push(number % 10);
            number = number / 10;
        }

        // Now put flip them over so they are reversed
        while (!forward.isEmpty()) {
            backward.push(forward.pop());
        }

        return backward;
    }

    // My solution
    public Stack sum2(Stack first, Stack Second) {
        Stack stack = new Stack();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while (!first.isEmpty()) {
            num1.append(first.pop());
            num2.append(Second.pop());
        }

        int res = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());

        String s = new StringBuilder(String.valueOf(res)).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            stack.push(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return stack;
    }
}

