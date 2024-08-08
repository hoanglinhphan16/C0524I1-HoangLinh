package MassageSalonManagement.repository.employee;

import MassageSalonManagement.model.Employee;
import MassageSalonManagement.util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private static List<Employee> employees = new ArrayList<Employee>();
    private static final String PATH = "E:\\Codegym\\module2\\ss1\\src\\MassageSalonManagement\\data\\employees.csv";
    private static Employee employeeInstance = new Employee();

    static {
        employees = FileHandler.readFile(employeeInstance, PATH);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        FileHandler.writeFile(employee, PATH, true);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
        FileHandler.writeListToFile(employees, PATH, true);
    }

    @Override
    public void updateEmployee(int index, Employee employee) {
        employees.set(index, employee);
        FileHandler.writeListToFile(employees, PATH, true);
    }
}
