package challenges.linkedLists;

import data_structures.linkedLists.LinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedListRemoveDuplicates extends LinkedList {

    public void removeDuplicates() {
        removeDuplicates(head);
    }

    private void removeDuplicates(Node current) {
        // Create a hash table to store the unique values.
        // Then delete the duplicate as soon as we detect it while walking the list.
        // Algorithm is O(n).

        HashSet<Integer> uniques = new HashSet<>();
        Node previous = null;

        while (current != null) {
            if (uniques.contains(current.data)) {
                previous.next = current.next; // skip this duplicate
            } else {
                uniques.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    // My Solution
    public void removeDuplicates2() {
        List<Integer> list = new ArrayList<>();

        Node current = head;
        Node aux;

        while (current != null) {
            if (!list.contains(current.data)) {
                list.add(current.data);
                current = current.next;
            } else {
                aux = current.next;
                deleteNode(current);
                current = aux;
            }
        }
    }

    private void deleteNode(Node node) {

        if (head == null) {
            return;
        }

        if (head == node) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next == node) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }
}
