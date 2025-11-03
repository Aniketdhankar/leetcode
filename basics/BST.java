import java.util.*;

public class BST {

    // 🌱 Node structure
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root of the BST (kept private for encapsulation)
    private Node root;

    // 🧩 Insert function (recursive)
    Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Wrapper for user — starts insertion from the root
    void insert(int value) {
        root = insert(root, value);
    }

    // 🔍 Search function
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        else if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    // Wrapper for user — hides internal details
    boolean search(int key) {
        return search(root, key);
    }

    // ❌ Delete a node
    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Found node to delete

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children → replace with inorder successor
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }

    void delete(int key) {
        root = delete(root, key);
    }

    // 🔽 Find minimum node (used in delete)
    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // 🔼 Find maximum node
    Node findMax(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    void printMinMax() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        }
        System.out.println("Min value: " + findMin(root).data);
        System.out.println("Max value: " + findMax(root).data);
    }

    // 🌿 Traversals
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    void printTraversals() {
        System.out.print("\nInorder (sorted): ");
        inorder(root);
        System.out.print("\nPreorder: ");
        preorder(root);
        System.out.print("\nPostorder: ");
        postorder(root);
        System.out.println();
    }

    // 🌲 Print tree sideways (visual representation)
    void printTree() {
        System.out.println("\nTree structure (rotated 90°):");
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == null) return;
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) System.out.print("    ");
        System.out.println(node.data);
        printTree(node.left, level + 1);
    }

    // 🧠 Main method to test
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements to insert in BST: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
        int val = sc.nextInt();
        tree.insert(val);
            }


        tree.printTraversals();
        tree.printTree();
        tree.printMinMax();

        System.out.print("\nEnter value to search: ");
        int key = sc.nextInt();
        System.out.println(tree.search(key) ? "Found" : "Not found");

        System.out.print("Enter value to delete: ");
        int del = sc.nextInt();
        tree.delete(del);

        System.out.println("\nAfter deletion:");
        tree.printTraversals();
        tree.printTree();

        sc.close();
    }
}

/* 
🧠 Why do it this way?

Because:

1️⃣ You want to keep `root` private (encapsulation).
    → No need for the user to know about the internal Node structure.

2️⃣ You need a recursive function that takes a node (e.g. search, insert, delete).

3️⃣ It makes your API cleaner and safer:

    tree.search(7);   ✅ simple and user-friendly

instead of

    tree.search(tree.root, 7);   ❌ messy and breaks encapsulation

    Excellent question — and it’s a **very common confusion** when learning BST deletion.
Let’s break it down clearly 👇

---

### 🧩 In BST deletion (Case 3: Node with 2 children)

We have **two valid options** to replace the node’s value:

| Option                    | Replacement                          | Subtree Used  | Function              |
| ------------------------- | ------------------------------------ | ------------- | --------------------- |
| ✅ Inorder **Successor**   | Smallest value **greater** than node | Right subtree | `findMin(root.right)` |
| ✅ Inorder **Predecessor** | Largest value **smaller** than node  | Left subtree  | `findMax(root.left)`  |

---

### 🔍 Why we use `findMin(root.right)` for successor

Because:

* The **inorder successor** of a node is the **next node** in the **sorted order**.
* In a BST, all values in the right subtree are **greater** than the current node.
* So, the **smallest** value in the right subtree (found by `findMin`) is the **next larger value** — i.e., the successor.

That’s why:

```java
Node successor = findMin(root.right);
root.data = successor.data;
root.right = delete(root.right, successor.data);
```

works perfectly.

---

### 🔁 If you wanted to use **predecessor** instead

You can do the mirror logic:

```java
Node predecessor = findMax(root.left);
root.data = predecessor.data;
root.left = delete(root.left, predecessor.data);
```

Here,

* `findMax(root.left)` gives the **largest smaller** value (predecessor).
* You’d then delete that predecessor node from the **left subtree**.

---

### 🧠 Summary

| Concept               | Function                | Meaning            |
| --------------------- | ----------------------- | ------------------ |
| `findMin(root.right)` | Inorder **Successor**   | Next greater value |
| `findMax(root.left)`  | Inorder **Predecessor** | Next smaller value |

Both are valid — you just need to be consistent.

---



*/
