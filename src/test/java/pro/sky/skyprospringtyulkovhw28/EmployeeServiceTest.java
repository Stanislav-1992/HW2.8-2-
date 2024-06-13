package pro.sky.skyprospringtyulkovhw28;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Collection;


import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private final Employee testEmployee = new  Employee("Иван", "Иванов", 4_000, 5);
    private final Employee badTestEmployee  = new Employee("Иван1977", "Иванов", 4_111, 6);


    @Test
    public void addTest() {

        assertEquals(testEmployee, employeeService.add(testEmployee.getFirstName(), testEmployee.getLastName(), testEmployee.getSalary(), testEmployee.getDepartmentId()));
    }

    @Test
    public void deleteTest() {

        employeeService.add(testEmployee.getFirstName(), testEmployee.getLastName(), testEmployee.getSalary(), testEmployee.getDepartmentId());
        assertEquals(employeeService.remove("Иван", "Иванов"), testEmployee);
    }

    @Test
    public void searchTest() {

        employeeService.add(testEmployee.getFirstName(), testEmployee.getLastName(),
                    testEmployee.getSalary(), testEmployee.getDepartmentId());
        assertEquals(employeeService.find("Иван", "Иванов"), testEmployee);
    }

    @Test
    public void EmployeeAlreadyAddedExceptionTest() {

        employeeService.add(testEmployee.getFirstName(), testEmployee.getLastName(),
                    testEmployee.getSalary(), testEmployee.getDepartmentId());
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(testEmployee.getFirstName(),
                testEmployee.getLastName(), testEmployee.getSalary(), testEmployee.getDepartmentId()));
    }

    @Test
    public void EmployeeNotFoundExceptionTest() {

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("Иван", "Иванов"));
    }

    @Test
    public void InvalidInputExceptionTest() {

        assertThrows(InvalidEmployeeDataException.class, () -> employeeService.add(badTestEmployee.getFirstName(),
                badTestEmployee.getLastName(), badTestEmployee.getSalary(), badTestEmployee.getDepartmentId()));
    }

    @Test
    public void showAllEmployeesTest() {

        employeeService.add(testEmployee.getFirstName(), testEmployee.getLastName(),
                    testEmployee.getSalary(), testEmployee.getDepartmentId());
        Collection<Employee> employees = employeeService.findAll();

        assertNotNull(employees);
    }

}