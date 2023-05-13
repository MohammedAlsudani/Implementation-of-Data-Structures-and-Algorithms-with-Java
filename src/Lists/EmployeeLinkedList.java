package Lists;

import Lists.model.Employee;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }


    public void removeFromFront(){
        if (isEmpty()){
            return;
        }

        EmployeeNode removeNode = head;
        head = head.getNext();
        removeNode.setNext(null);
        size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size  < 1;
    }

    public void printList() {
        EmployeeNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}
