package Lists;

import Lists.model.Employee;

import java.util.List;
import java.util.Vector;

public class VictorList {

    public static void main(String[] args) {
        Employee employee1 = new Employee("MO1","ZAEM1",1);
        Employee employee2 = new Employee("MO2","ZAEM2",2);
        Employee employee3 = new Employee("MO3","ZAEM3",3);
        Employee employee4 = new Employee("MO4","ZAEM4",4);
        Employee employee5 = new Employee("MO5","ZAEM5",5);

        List<Employee> employees = new Vector<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        for (Employee employee : employees) {
            System.out.print("employee = " + employee +"\n");
        }


    }
}
