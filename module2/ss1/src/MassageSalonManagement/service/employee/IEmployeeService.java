package MassageSalonManagement.service.employee;

import MassageSalonManagement.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(int index, Employee employee);
}
