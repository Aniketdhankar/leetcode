package day7;

import java.util.Scanner;

class DoublyLinkedList {

    // Node definition
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    int count;

    // Constructor
    DoublyLinkedList() {
        head = null;
        count = 0;
    }

    // Insert at beginning
    void insertBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
        System.out.println(data + " inserted at beginning.");
    }

    // Insert at end
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        count++;
        System.out.println(data + " inserted at end.");
    }

    // Insert at specific position (1-based index)
    void insertAtPosition(int data, int pos) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            insertBeginning(data);
            return;
        }
        if (pos == count + 1) {
            insertEnd(data);
            return;
        }

        Node newNode = new Node(data);
        Node curr = head;

        for (int i = 1; i < pos - 1; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;

        count++;
        System.out.println(data + " inserted at position " + pos + ".");
    }

    // Delete from beginning
    void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted element: " + head.data);
        head = head.next;
        if (head != null)
            head.prev = null;
        count--;
    }

    // Delete from end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head.next == null) {
            System.out.println("Deleted element: " + head.data);
            head = null;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next; // reach last node
            }
            System.out.println("Deleted element: " + curr.data);
            curr.prev.next = null;
        }
        count--;
    }

    // Delete from specific position
    void deleteAtPosition(int pos) {
        if (pos < 1 || pos > count) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            deleteBeginning();
            return;
        }
        if (pos == count) {
            deleteEnd();
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

    // Display list
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Display reverse
    void displayReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next; // move to last

        System.out.print("Reverse: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    // Count of nodes
    void size() {
        System.out.println("Total nodes: " + count);
    }

    // Menu for testing
    void menu() {
        Scanner sc = new Scanner(System.in);
        int choice, data, pos;

        while (true) {
            System.out.println("\n1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Specific Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Specific Position");
            System.out.println("7. Display");
            System.out.println("8. Display Reverse");
            System.out.println("9. Count Nodes");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    insertBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    insertEnd(data);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    insertAtPosition(data, pos);
                    break;
                case 4:
                    deleteBeginning();
                    break;
                case 5:
                    deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    deleteAtPosition(pos);
                    break;
                case 7:
                    display();
                    break;
                case 8:
                    displayReverse();
                    break;
                case 9:
                    size();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

// Main class
public class MainDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.menu();
    }
}
