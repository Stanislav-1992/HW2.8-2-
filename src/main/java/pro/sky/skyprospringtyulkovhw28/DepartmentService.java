package pro.sky.skyprospringtyulkovhw28;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findEmployeeWithMinSalary(int departmentId);

    Employee findEmployeeWithMaxSalary(int departmentId);

    Collection<Employee> findEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> findEmployeesByDepartment();

}
