package MassageSalonManagement.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validate {

    private static final String ID_REGEX = "^[BCE]\\d{3}$";
    private static final String NAME_REGEX = "^[a-zA-Z ]{4,30}$";
    private static final String WORD_REGEX = "^[a-zA-Z ]{4,30}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONENUMBER_REGEX = "^(\\+84|090|093)\\d{7}$";
    private static final String CLASSNAME_REGEX = "^C\\d{4}([GILHK])\\d$";
    private static final String LEVEL_REGEX = "^[a-zA-Z]{4,}$";
    private static final String IDENTIFICATION_CARD_REGEX = "^\\d{12}$";
    private static final String SALARY_REGEX = "^\\d{3}$";

    public static String validateEmail(Scanner scanner) {
        String email = null;
        boolean validFormat;
        do {
            System.out.println("Enter email: ");
            email = scanner.nextLine();
            validFormat = email.matches(EMAIL_REGEX);
            if (!validFormat) {
                System.out.println("Invalid email format");
            }
        } while (!validFormat);

        return email;
    }

    public static LocalDate validateDate(Scanner scanner) {
        LocalDate date = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter date (format dd/MM/yyyy): ");
            String temp = scanner.nextLine();
            try {
                date = LocalDate.parse(temp, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                validFormat = true;
            } catch (DateTimeException e) {
                System.out.println("Wrong format. Please enter the date in dd-MM-yyyy format.");
            }
        }
        return date;
    }

    public static String validateName(Scanner scanner) {
        String name = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter name: ");
            name = scanner.nextLine();
            validFormat = name.matches(NAME_REGEX);
            if (!validFormat) {
                System.out.println("Invalid name format");
            }
        }
        return name;
    }

    public static String validatePhoneNumber(Scanner scanner) {
        String phoneNumber = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter phone number: ");
            phoneNumber = scanner.nextLine();
            validFormat = phoneNumber.matches(PHONENUMBER_REGEX);
            if (!validFormat) {
                System.out.println("Invalid phone number format");
            }
        }
        return phoneNumber;
    }

    public static String validateId(Scanner scanner) {
        String id = null;
        boolean validFormat = false;
        while (!validFormat) {
            System.out.println("Enter id: ");
            id = scanner.nextLine();
            validFormat = id.matches(ID_REGEX);
            if (!validFormat) {
                System.out.println("Invalid id format. Must be C|B|E + XXX (X is number)");
            }
        }
        return id;
    }

    public static String validateIdCard(Scanner scanner) {
        String idCard = null;
        boolean validFormat = false;
        while (!validFormat) {
            System.out.println("Enter your identification card: ");
            idCard = scanner.nextLine();
            validFormat = idCard.matches(IDENTIFICATION_CARD_REGEX);
            if (!validFormat) {
                System.out.println("Invalid identification card format. Must be 12 numbers");
            }
        }
        return idCard;
    }

    public static String validateAcademicLevel(Scanner scanner) {
        String academicLevel = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter name: ");
            academicLevel = scanner.nextLine();
            validFormat = academicLevel.matches(WORD_REGEX);
            if (!validFormat) {
                System.out.println("Invalid academicLevel format");
            }
        }
        return academicLevel;
    }

    public static String validatePosition(Scanner scanner) {
        String position = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter name: ");
            position = scanner.nextLine();
            validFormat = position.matches(WORD_REGEX);
            if (!validFormat) {
                System.out.println("Invalid position format");
            }
        }
        return position;
    }

    public static String validateSalary(Scanner scanner) {
        String salary = null;
        boolean validFormat = false;

        while (!validFormat) {
            System.out.println("Enter salary: ");
            salary = scanner.nextLine();
            validFormat = salary.matches(SALARY_REGEX);
            if (!validFormat) {
                System.out.println("Invalid salary format. Must be more than 3 numbers");
            }
        }
        return salary;
    }
}
