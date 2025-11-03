import java.util.*;

public class BinaryTree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    BinaryTree() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the root node value: ");
        int value = sc.nextInt();
        root = new Node(value);
        buildTree(root, sc);
        sc.close(); // optional: close scanner when done
    }

    void buildTree(Node node, Scanner sc) {
        System.out.print("Do you want to enter in left of " + node.data + "? (true/false): ");
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.print("Enter the value: ");
            int value = sc.nextInt();
            node.left = new Node(value);
            buildTree(node.left, sc);
        }

        System.out.print("Do you want to enter in right of " + node.data + "? (true/false): ");
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.print("Enter the value: ");
            int value = sc.nextInt();
            node.right = new Node(value);
            buildTree(node.right, sc);
        }
    }

    void preorder(Node node) { // root left right
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node) { // left root right
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void postorder(Node node) { // left right root
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    void min(Node root) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        System.out.println("Min value is: " + curr.data);
    }

    void max(Node root) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        Node curr = root;
        while (curr.right != null) { // ✅ fixed condition
            curr = curr.right;
        }
        System.out.println("Max value is: " + curr.data);
    }

    // Optional helper to call traversals easily
    void printTraversals() {
        System.out.println("\nPreorder: ");
        preorder(root);
        System.out.println("\nInorder: ");
        inorder(root);
        System.out.println("\nPostorder: ");
        postorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.printTraversals();
        tree.min(tree.root);
        tree.max(tree.root);
    }
}
