package MassageSalonManagement.controller;

import MassageSalonManagement.model.Employee;
import MassageSalonManagement.service.employee.EmployeeService;
import MassageSalonManagement.util.FileHandler;
import MassageSalonManagement.util.Validate;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    Scanner scanner = new Scanner(System.in);
    private static EmployeeService employeeService = new EmployeeService();

    public void displayAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void displayEmployeeFunc() {
        int choice = -1;
        do {
            System.out.println("Employees Management: \n" +
                    "1. Display employees \n" +
                    "2. Add\n" +
                    "3. Edit\n" +
                    "4. Delete\n" +
                    "5. Sort \n" +
                    "6. Back to main menu");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("List employees");
                        displayAllEmployees();
                        break;
                    case 2:
                        System.out.println("Add new employee");
                        addEmployee();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        System.out.println("Sort list employee\n" +
                                "1. Sort by name\n" +
                                "2. Sort by id\n" +
                                "3. Back");

                        int choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
                            case 1:
                                sortByName();
                                break;
                            case 2:
                                sortById();
                                break;
                            case 3:
                                return;
                        }
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice");
            }
        } while (true);
    }

    public void addEmployee() {
        boolean isExist;
        String id;

        do {
            id = Validate.validateId(scanner);
            isExist = findById(id);
            if (isExist) {
                System.out.println("Employee already exists");
            }
        } while (isExist);
        Employee newEmployee = scanInputOfEmployee(id);
        employeeService.addEmployee(newEmployee);
    }

    public Employee scanInputOfEmployee(String id) {
        String name = Validate.validateName(scanner);

        LocalDate birthDate = Validate.validateDate(scanner);

        String idCard = Validate.validateIdCard(scanner);

        String email = Validate.validateEmail(scanner);

        String phoneNumber = Validate.validatePhoneNumber(scanner);

        String academicLevel = Validate.validateAcademicLevel(scanner);

        String position = Validate.validatePosition(scanner);

        String salary = Validate.validateSalary(scanner);

        return new Employee(id, name, birthDate, idCard, email, phoneNumber, academicLevel, position, salary);
    }

    public boolean findById(String id) {
        if (id == null) {
            System.out.println("Enter ID");
            id = scanner.nextLine();
        }
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.println(employee);
                return true;
            }
        }
        return false;
    }

    public void deleteEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        boolean isExist;
        String id = Validate.validateId(scanner);
        isExist = findById(id);
        if (isExist) {
            for (Employee employee : employees) {
                if (employee.getId().equals(id)) {
                    employeeService.deleteEmployee(employee);
                    break;
                }
            }
        } else System.out.println("Employee not found");
    }

    public void updateEmployee() {
        List<Employee> employees = employeeService.getAllEmployees();
        int index = -1;
        boolean isExist;
        String id = Validate.validateId(scanner);
        isExist = findById(id);
        if (isExist) {
            for (Employee employee : employees) {
                if (employee.getId().equals(id)) {
                    index = employees.indexOf(employee);
                    Employee newEmployee = scanInputOfEmployee(id);
                    employeeService.updateEmployee(index, newEmployee);
                    break;
                }
            }
        } else System.out.println("Wrong ID");
    }

    public void sortById() {
        List<Employee> employees = employeeService.getAllEmployees();
        employees.sort((c1,c2) -> c1.getId().compareTo(c2.getId()));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void sortByName() {
        List<Employee> employees = employeeService.getAllEmployees();
        employees.sort((c1,c2) -> c1.getName().compareTo(c2.getName()));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
