package challenges.arraysAndStringsTest;

import challenges.linkedLists.LinkedListAdder;
import challenges.linkedLists.LinkedListRemoveDuplicates;
import data_structures.stack.Stack;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListsTest {


    @Test
    public void Duplicates() {
        // Challenge: Write a method that removes any duplicates from our Linked List.

        LinkedListRemoveDuplicates linkedList = new LinkedListRemoveDuplicates();
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(1); // duplication
        linkedList.addBack(4);
        linkedList.addBack(2); // duplication
        linkedList.addBack(1); // duplication
        linkedList.addBack(6);

        linkedList.removeDuplicates();

        Assert.assertEquals(4, linkedList.size());
    }

    @Test
    public void SumLists() {
        // Challenge: You have two numbers represented by a linked list.
        // Each node represents a single digit, in reverse order, such that the
        // 1's digit is at the head. Write a function that adds the two numbers
        // and returns the sum as a linked list.

        // Example
        // Input:  (8 -> 2 -> 5) + (4 -> 9 -> 2). That is 528 + 294.
        // Output: (2 -> 2 -> 8). That is 822.

        // Create our two numbers
        Stack first = new Stack();
        first.push(8);
        first.push(2);
        first.push(5);

        Stack second = new Stack();
        second.push(4);
        second.push(9);
        second.push(2);

        // Add them together
        LinkedListAdder adder = new LinkedListAdder();
        Stack sum = adder.sum(first, second);

        // Check the result
        Assert.assertEquals(3, sum.size());

        while(!sum.isEmpty()) {
            System.out.println(sum.pop());
        }
    }

}
