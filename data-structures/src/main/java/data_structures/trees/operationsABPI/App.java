package data_structures.trees.operationsABPI;

import java.util.Scanner;

class BST {

    static class Node {
        char key;
        String value;
        Node left, right;

        public Node(char key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }
    }

    Node root;
    String printValue = "";

    public BST() {
        root = null;
    }

    public String find(char key) {
        Node node = find(root, key);

        return node == null ? null : node.value;
    }

    private Node find(Node node, char key) {
        if (node == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }

    public void insert(char key, String value) {
        root = insertItem(root, key, value);
    }

    public Node insertItem(Node node, char key, String value) {

        if (node == null) {
            node = new Node(key, value);
            return node;
        }

        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        }

        if (key > node.key) {
            node.right = insertItem(node.right, key, value);
        }

        return node;
    }

    public void printInOrderTraversal() {
        printValue = "";
        inOrderTraversal(root);
        printValueWithoutSpace();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            printValue += node.key + " ";
            inOrderTraversal(node.right);
        }
    }

    public void printPreOrderTraversal() {
        printValue = "";
        preOrderTraversal(root);
        printValueWithoutSpace();
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            printValue += node.key + " ";
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void printPostOrderTraversal() {
        printValue = "";
        postOrderTraversal(root);
        printValueWithoutSpace();
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            printValue += node.key + " ";
        }
    }

    private void printValueWithoutSpace() {
        System.out.println(printValue.substring(0, printValue.length() - 1));
    }
}

public class App {

    static BST bst = new BST();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            validateInput(sc.nextLine());
        }
    }

    static void validateInput(String input) {
        if (input.equals("INFIXA")) {
            bst.printInOrderTraversal();
        } else if (input.equals("PREFIXA")) {
            bst.printPreOrderTraversal();
        } else if (input.equals("POSFIXA")) {
            bst.printPostOrderTraversal();
        } else if (!input.equals("")) {
            String op = input.split(" ")[0];
            char key = input.split(" ")[1].charAt(0);

            if (op.equals("I")) {
                bst.insert(key, String.valueOf(key));
            } else if (op.equals("P")) {
                System.out.println(bst.find(key) == null ? "nao existe" : (key + " existe"));
            }
        }
    }
}
