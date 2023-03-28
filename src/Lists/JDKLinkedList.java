package Lists;

import Lists.model.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class JDKLinkedList {

    public static void main(String[] args) {
        Employee employee1 = new Employee("MO1","ZAEM1",1);
        Employee employee2 = new Employee("MO2","ZAEM2",2);
        Employee employee3 = new Employee("MO3","ZAEM3",3);
        Employee employee4 = new Employee("MO4","ZAEM4",4);
        Employee employee5 = new Employee("MO5","ZAEM5",5);

        LinkedList<Employee> employees = new LinkedList<>();
        employees.addFirst(employee1);
        employees.addFirst(employee2);
        employees.addFirst(employee3);
        employees.addLast(employee4);
        employees.addFirst(employee5);

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
