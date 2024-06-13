package pro.sky.skyprospringtyulkovhw28;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class DepartmentServiceTest {

    private DepartmentServiceImpl departmentService;

    private EmployeeServiceImpl employeeService;

    private List<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov", 1, 10_000),
            new Employee("Petr", "Petrov", 1, 11_000),
            new Employee("Sergey", "Sergeev", 2, 12_000),
            new Employee("Semen", "Semenov", 2, 13_000));



    @BeforeEach
    public void setUp() {
        employeeService = Mockito.mock(EmployeeServiceImpl.class);
        departmentService = new DepartmentServiceImpl(employeeService);
    }

    @Test
    public void maxSalaryDepartmentTest() {

        when(employeeService.findAll()).thenReturn(employees);

        Employee employee = departmentService.findEmployeeWithMaxSalary(1);

        assertEquals(11_000, employee.getSalary());
    }

    @Test
    public void minSalaryDepartmentTest() {

        when(employeeService.findAll()).thenReturn(employees);

        Employee employee = departmentService.findEmployeeWithMinSalary(2);

        assertEquals(12_000, employee.getSalary());
    }

    @Test
    public void allEmployeesDepartmentTest() {

        when(employeeService.findAll()).thenReturn(employees);

        Collection<Employee> result = departmentService.findEmployeesByDepartment(1);

        assertEquals(2, result.size());

        assertNotNull(result);

    }

    @Test
    public void allEmployeesSortDepartmentTest() {
        when(employeeService.findAll()).thenReturn(employees);

        Map<Integer, List<Employee>> result = departmentService.findAllEmployeesByDepartment();

        assertEquals(2, result.size());

        assertNotNull(result);
    }

    @Test
    public void sumSalaryDepartmentTest() {

        when(employeeService.findAll()).thenReturn(employees);

        double result = departmentService.sumSalaryDepartment(1);

        assertEquals(21_000, result);

    }
}
