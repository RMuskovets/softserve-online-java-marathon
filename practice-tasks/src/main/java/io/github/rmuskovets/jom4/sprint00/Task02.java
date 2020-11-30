package io.github.rmuskovets.jom4.sprint00;

import java.util.Arrays;

class Employee_02 {
    public String fullName;
    public float salary;
}

public class Task02 {

    public static void main(String[] args) {
        Employee_02 emp1 = new Employee_02(),
                emp2 = new Employee_02();

        emp1.fullName = "RMuskovets";
        emp1.salary = 5000.0f;

        emp2.fullName = "Refear";
        emp2.salary = 1000.0f;

        Employee_02 employees[] = { emp1, emp2 };

        String empStrs[] = new String[2];

        for (int i = 0; i < 2; i++) {
            empStrs[i] = "{fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "}";
        }

        String employeesInfo = Arrays.asList(empStrs).toString();
    }
}
