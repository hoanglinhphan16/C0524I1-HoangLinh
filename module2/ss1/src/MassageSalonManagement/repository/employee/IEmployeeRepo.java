package MassageSalonManagement.repository.employee;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.model.Employee;

import java.util.List;

public interface IEmployeeRepo {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(int index, Employee employee);
}
