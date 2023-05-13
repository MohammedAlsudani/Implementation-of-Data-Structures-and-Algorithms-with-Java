package Lists;


import java.util.ArrayList;

class SingleLinkedList {
    Node head;
    Node tail;
    int length;
    public SingleLinkedList(int value) {
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

    public ArrayList<Integer> getList() {
        ArrayList<Integer> arrays = new ArrayList<>();
        Node current = head;
        while (current != null) {
            arrays.add(current.value);
            current = current.next;
        }
        return arrays;
    }

    public void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current);
            current = current.next;
        }
    }

    /*     *     *
            \   /
              *      */
    public void insert(Integer index, Integer value) {
        if (index == 0) {
            this.prepend(value);
            return;
        }
        if (index >= this.length) {
            this.append(value);
        }
        Node newNode = new Node(value);
        Node leaderNode = this.traverseToIndex(index - 1);
        Node holdingNode = leaderNode.next;
        leaderNode.next = newNode;
        newNode.next = holdingNode;
        this.length++;
    }

    private Node traverseToIndex(int index) {
        int countIndex = 0;
        Node currentNode = this.head;
        while (currentNode != null && countIndex != index ){
            currentNode = currentNode.next;
            countIndex++;
        }
        return currentNode;
    }

    public void remove(Integer index){
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot remove from empty list");
        }
        if (index == 0) {
            this.head = this.head.next;
            this.length--;
            return;
        }
        Node leadNode = this.traverseToIndex(index-1);
        Node unWantedNode = leadNode.next;
        leadNode.next = unWantedNode.next;
        this.length--;
    }


    public int getSize() {
        return length;
    }

    public boolean isEmpty() {
        return length  < 1;
    }

    public ArrayList<Integer> reverse() {
        if (length == 0){
            return new ArrayList<>(this.head.value);
        }
        Node firstNode = this.head;
        this.tail = this.head;
        Node secondNode = firstNode.next;
        while (secondNode != null){
            Node tempNode = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = tempNode;
        }
        this.head.next = null;
        this.head = firstNode;
        return getList();
    }

    static class Node {
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
}
