
public class LinkedList {

    // Shared scanner for all input
    Scanner sc = new Scanner(System.in);

    // Inner Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head node and size counter
    Node head;
    int count;

    // Constructor
    LinkedList() {
        head = null;
        count = 0;
    }

    // Insert at beginning
    void insertB() {
        System.out.print("Enter element: ");
        int val = sc.nextInt();
        Node newnode = new Node(val);

        if (head == null) {
            head = newnode;
        } else {
            newnode.next = head;
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
            head = newnode;
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newnode;
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
            newnode.next = head;
            head = newnode;
        } else {
            Node cp = head;
            for (int i = 1; i < pos - 1; i++) {
                cp = cp.next;
            }
            newnode.next = cp.next;
            cp.next = newnode;
        }
        count++;
    }

    // Delete from beginning
    void deleteB() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Deleted element: " + head.data);
        head = head.next;
        count--;
    }

    // Delete from end
    void deleteE() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head.next == null) {
            System.out.println("Deleted element: " + head.data);
            head = null;
        } else {
            Node prev = null;
            Node curr = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            System.out.println("Deleted element: " + curr.data);
            prev.next = null;
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
        }

        Node curr = head;
        for (int i = 1; i < pos - 1; i++) {
            curr = curr.next;
        }

        System.out.println("Deleted element: " + curr.next.data);
        curr.next = curr.next.next;
        count--;
    }

    // Display all elements
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }

    // Main method with menu
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display List");
            System.out.println("8. Exit");
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
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
