package recursion;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

// Complexity
// Time: O(n + m)
// Space: O(n + m)
public class BinarySubtree {

    public static void main(String[] args) {

        /*
         * 			1
         * 		   / \
         * 		  2   3
         * 		 / \ / \
         * 		4  5 6  7
         */

        //that's the tree, that we are constructing here.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         * 			4
         * 		   / \
         * 		  5   6
         */
        Node root2 = new Node(4);
        root2.left = new Node(5);
        root2.right = new Node(6);

        System.out.println(checkSubtree(root, root.left));
        System.out.println(checkSubtree(root, root2));
    }

    private static boolean checkSubtree(Node tree, Node sub) {
        if (sub == null) return true;

        if (tree == null) return false;

        List<Integer> first = new ArrayList<>();
        inorder(tree, first);

        List<Integer> second = new ArrayList<>();
        inorder(sub, second);

        if (!listToString(first).contains(listToString(second))) {
            return false;
        }
        first.clear();
        second.clear();

        preorder(tree, first);
        preorder(sub, second);

        return listToString(first).contains(listToString(second));
    }

    private static String listToString(List<Integer> list) {
        return list.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    private static void inorder(Node node, List<Integer> list) {
        if (node == null) return;

        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }

    private static void preorder(Node node, List<Integer> list) {
        if (node == null) return;

        list.add(node.data);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}
