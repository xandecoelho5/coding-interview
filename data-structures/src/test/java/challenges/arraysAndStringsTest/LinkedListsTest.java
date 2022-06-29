package challenges.arraysAndStringsTest;

import challenges.linkedLists.LinkedListRemoveDuplicates;
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

}
