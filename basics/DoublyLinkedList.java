package dayy7;
import java.util.*;

public class DoublyLinkedList {

    Scanner sc = new Scanner(System.in);

    // Node structure
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head, tail;
    int count;

    // Constructor
    DoublyLinkedList() {
        head = tail = null;
        count = 0;
    }

    // Insert at beginning
    void insertB() {
        System.out.print("Enter element: ");
        int val = sc.nextInt();
        Node newnode = new Node(val);

        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        count++;
    }

    // Insert at end
    void insertE() {
        System.out.print("Enter element: ");
        int val = sc.nextInt();
        Node newnode = new Node(val);

        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
        count++;
    }

    // Insert at specific position
    void insertP() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position");
            return;
        }

        System.out.print("Enter element: ");
        int val = sc.nextInt();
        Node newnode = new Node(val);

        if (pos == 1) {
            insertB();
        } else if (pos == count + 1) {
            insertE();
        } else {
            Node curr = head;
            for (int i = 1; i < pos - 1; i++) {
                curr = curr.next;
            }
            newnode.next = curr.next;
            newnode.prev = curr;
            curr.next.prev = newnode;
            curr.next = newnode;
            count++;
        }
    }

    // Delete from beginning
    void deleteB() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Deleted element: " + head.data);

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        count--;
    }

    // Delete from end
    void deleteE() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Deleted element: " + tail.data);

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        count--;
    }

    // Delete from specific position
    void deleteP() {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        if (pos < 1 || pos > count) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            deleteB();
            return;
        } else if (pos == count) {
            deleteE();
            return;
        }

        Node curr = head;
        for (int i = 1; i < pos; i++) {
            curr = curr.next;
        }

        System.out.println("Deleted element: " + curr.data);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        count--;
    }

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node ptr = head;
        System.out.print("Forward: ");
        while (ptr != null) {
            System.out.print(ptr.data + " <-> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    // Display in reverse (optional)
    void displayReverse() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node ptr = tail;
        System.out.print("Reverse: ");
        while (ptr != null) {
            System.out.print(ptr.data + " <-> ");
            ptr = ptr.prev;
        }
        System.out.println("null");
    }

    // Main menu
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display (Forward)");
            System.out.println("8. Display (Reverse)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> list.insertB();
                case 2 -> list.insertE();
                case 3 -> list.insertP();
                case 4 -> list.deleteB();
                case 5 -> list.deleteE();
                case 6 -> list.deleteP();
                case 7 -> list.display();
                case 8 -> list.displayReverse();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 9);

        sc.close();
    }
}
