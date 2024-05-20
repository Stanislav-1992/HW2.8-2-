package pro.sky.skyprospringtyulkovhw28;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

public class Employee {

    private String lastName;
    private String firstName;
    private int salary;
    private int departmentId;

    public Employee(String lastName, String firstName, int salary, int departmentId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String surname) {
        this.lastName = surname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartmentId(int department) {
        this.departmentId = departmentId;
    }

    @JsonIgnore
    public String getFullName() {
        return (firstName + " " + lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName;
    }
}
