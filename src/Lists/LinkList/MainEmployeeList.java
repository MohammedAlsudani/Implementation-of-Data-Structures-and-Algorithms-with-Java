package Lists.LinkList;

import Lists.LinkList.EmployeeLinkedList;
import Lists.model.Employee;


public class MainEmployeeList {

    public static void main(String[] args) {
        Employee employee1 = new Employee("MO1","ZAEM1",1);
        Employee employee2 = new Employee("MO2","ZAEM2",2);
        Employee employee3 = new Employee("MO3","ZAEM3",3);
        Employee employee4 = new Employee("MO4","ZAEM4",4);
        Employee employee5 = new Employee("MO5","ZAEM5",5);

        EmployeeLinkedList employees = new EmployeeLinkedList();

        employees.addToFront(employee1);
        employees.addToFront(employee2);
        employees.addToFront(employee3);
        employees.addToFront(employee4);
        employees.addToFront(employee5);

        employees.printList();

        System.out.print("size = " + employees.getSize() + " is emtpy = " + employees.isEmpty());

        employees.removeFromFront();

        employees.printList();

        System.out.print("size = " + employees.getSize() + " is emtpy = " + employees.isEmpty());


        employees.removeFromFront();

        employees.printList();

        System.out.print("size = " + employees.getSize() + " is emtpy = " + employees.isEmpty());

    }
}
