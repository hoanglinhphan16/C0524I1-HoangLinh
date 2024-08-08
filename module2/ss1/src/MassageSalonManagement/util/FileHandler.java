package MassageSalonManagement.util;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.model.Customer;
import MassageSalonManagement.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static <E> List<E> readFile(E e,String path) {
        List<E> list = new ArrayList<E>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine())!= null) {
                if (e instanceof Customer) {
                    Customer customer = Customer.fromCSVRow(line);
                    list.add((E) customer);
                } else if (e instanceof Employee) {
                    Employee employee = Employee.fromCSVRow(line);
                    list.add((E) employee);
                } else if (e instanceof Booking) {
                    Booking booking = Booking.fromCSVRow(line);
                    list.add((E) booking);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static <E> void writeFile(E e, String path, boolean writeMode) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, writeMode))) {
            if (e instanceof Customer) {
                bw.write(((Customer) e).toCSVRow());
                bw.newLine();
            } else if (e instanceof Employee) {
                bw.write(((Employee) e).toCSVRow());
                bw.newLine();
            } else if (e instanceof Booking) {
                bw.write(((Booking) e).toCSVRow());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <E> void writeListToFile(List<E> list, String path, boolean writeMode) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, writeMode))) {
            for (E e : list) {
                if (e instanceof Customer) {
                    bw.write(((Customer) e).toCSVRow());
                    bw.newLine();
                } else if (e instanceof Employee) {
                    bw.write(((Employee) e).toCSVRow());
                    bw.newLine();
                } else if (e instanceof Booking) {
                    bw.write(((Booking) e).toCSVRow());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
