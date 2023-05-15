package Lists.LinkList;


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

    /**
     * Reverses the order of elements in the linked list and returns the reversed list as an ArrayList.
     *
     * @return ArrayList<Integer> representing the reversed list.
     */
    public ArrayList<Integer> reverse() {
        // If the list is empty, return a new ArrayList with the value of the head node.
        if (length == 0){
            return new ArrayList<>(this.head.value);
        }
        // Assign the current head node to the firstNode variable.
        Node firstNode = this.head;
        // Update the tail node to point to the head node.
        this.tail = this.head;
        // Get the next node after the firstNode and assign it to the secondNode variable.
        Node secondNode = firstNode.next;
        // Iterate through the remaining nodes in the list to reverse the connections.
        while (secondNode != null){
            // Store the next node after the secondNode in a temporary variable.
            Node tempNode = secondNode.next;
            // Reverse the link direction between secondNode and firstNode.
            secondNode.next = firstNode;
            // Update the firstNode to become the secondNode.
            firstNode = secondNode;
            // Update the secondNode to become the next node after it.
            secondNode = tempNode;
        }
        // Set the next pointer of the new head node to null, effectively terminating the list.
        this.head.next = null;
        // Update the head node to be the reversed firstNode.
        this.head = firstNode;
        // Return the reversed list as an ArrayList by calling the getList() method.
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
