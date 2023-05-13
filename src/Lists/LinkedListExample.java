package Lists;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.append(5);
        myLinkedList.append(16);
        myLinkedList.prepend(1);
        myLinkedList.printList();

    }
}

class Node {
    int value;
    Node next;
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

class LinkedList {
    Node head;
    Node tail;
    int length;
    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

