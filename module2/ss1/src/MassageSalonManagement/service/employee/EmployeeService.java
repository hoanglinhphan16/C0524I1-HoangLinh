package MassageSalonManagement.service.employee;

import MassageSalonManagement.model.Employee;
import MassageSalonManagement.repository.employee.EmployeeRepo;
import MassageSalonManagement.repository.employee.IEmployeeRepo;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepo iEmployeeRepo = new EmployeeRepo();

    @Override
    public List<Employee> getAllEmployees() {
        return iEmployeeRepo.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        iEmployeeRepo.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        iEmployeeRepo.deleteEmployee(employee);
    }

    @Override
    public void updateEmployee(int index, Employee employee) {
        iEmployeeRepo.updateEmployee(index, employee);
    }
}
