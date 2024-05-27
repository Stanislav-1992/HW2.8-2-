package pro.sky.skyprospringtyulkovhw28;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();


    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        String key = buildKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedExeption();
        }
        if (employees.size() >= EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullExeption();
        }
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        employees.put(key, employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundExeption();
        }
        return employees.remove(key);
    }

    public Employee find(String firstName, String lastName) {
        String key = buildKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundExeption();
        }
        return employees.get(key);
    }

    public Collection<Employee> findAll() {
        return employees.values();
    }

    public String buildKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}