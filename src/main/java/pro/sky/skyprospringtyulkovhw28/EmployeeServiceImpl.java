package pro.sky.skyprospringtyulkovhw28;

import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import jakarta.annotation.PostConstruct;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private static final int EMPLOYEE_STORAGE_SIZE = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private final EmployeeService employeeService;

    public EmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    private void init() {
        add("Ivan", "Ivanov");
        add("Semen", "Semenov");
        add("Petr", "Petrov");
        add("Grigory", "Grigorev");
        add("Alexey", "Alexeev");
        add("Andrey", "Andreev");
        add("Alexandr", "Alexandrov");
        add("Dmitry", "Dmitriev");
        add("Ilya", "Ilin");
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullExeption();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedExeption();
        }

        employees.put(employee.getFullName(), employee);
        return employee;
    }
}