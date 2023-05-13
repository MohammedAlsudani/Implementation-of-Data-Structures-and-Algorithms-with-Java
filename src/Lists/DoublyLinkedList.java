package Lists;

import java.util.ArrayList;
import java.util.Objects;

class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int length;
    public DoublyLinkedList(int value) {
        DoublyNode newNode = new DoublyNode(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        DoublyNode newNode = new DoublyNode(value);
        newNode.prev = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void prepend(int value) {
        DoublyNode newNode = new DoublyNode(value);
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
        this.length++;
    }

    public ArrayList<Integer> getList() {
        ArrayList<Integer> arrays = new ArrayList<>();
        DoublyNode current = this.head;
        while (current != null) {
            arrays.add(current.value);
            current = current.next;
        }
        return arrays;
    }


    public void printList() {
        DoublyNode current = this.head;
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
        DoublyNode newNode = new DoublyNode(value);
        DoublyNode leaderNode = this.traverseToIndex(index - 1);
        DoublyNode follower = leaderNode.next;
        leaderNode.next = newNode;
        newNode.prev = leaderNode;
        newNode.next = follower;
        follower.prev = newNode;
        this.length++;
    }

    private DoublyNode traverseToIndex(int index) {
        int countIndex = 0;
        DoublyNode currentNode = this.head;
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
        DoublyNode leadNode = this.traverseToIndex(index-1);
        DoublyNode unWantedNode = leadNode.next;
        leadNode.next = unWantedNode.next;
        this.length--;
    }


    public int getSize() {
        return length;
    }

    public boolean isEmpty() {
        return length  < 1;
    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head.toString() +
                ", tail=" + tail.toString() +
                ", length=" + length +
                '}';
    }

    static class DoublyNode {
        int value;
        DoublyNode next;
        DoublyNode prev;
        public DoublyNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return "DoublyNode{" +
                    "value=" + value +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
}





