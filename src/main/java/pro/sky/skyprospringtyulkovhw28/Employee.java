package pro.sky.skyprospringtyulkovhw28;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.Random;

import static org.apache.tomcat.util.IntrospectionUtils.capitalize;

public class Employee {

    private String lastName;
    private String firstName;
    private int salary;
    private int departmentId;


    public Employee(String name, String surname) {
        Random random = new Random();

        this.firstName = capitalize(firstName);
        this.lastName = capitalize(lastName);
        this.salary = random.nextInt(10_000) + 1000;
        this.departmentId = random.nextInt(5) + 1;
    }

    public Employee(String lastName, int departmentId, int salary, String firstName) {
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
        this.firstName = firstName;
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
