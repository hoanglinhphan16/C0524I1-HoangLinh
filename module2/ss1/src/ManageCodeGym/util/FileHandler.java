package ManageCodeGym.util;

import ManageCodeGym.model.Student;
import ManageCodeGym.model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler<E> {
//    private final String filePath;
//    private final CSVConvertible<T> converter;
//
//    public FileHandler(String filePath, CSVConvertible<T> converter) {
//        this.filePath = filePath;
//        this.converter = converter;
//    }
//
//    public List<T> readFromFile() {
//        List<T> items = new ArrayList<>();
//        try {
//            List<String> lines = Files.readAllLines(Paths.get(filePath));
//            for (String line : lines) {
//                items.add(converter.fromCSVRow(line));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return items;
//    }

    public static <E> void writeListToFile(List<E> elements, String path, boolean writeMode) {
        if (elements.isEmpty()) {
            System.out.println("List is empty. Nothing to write.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, writeMode))) {
            // Write data
            for (E element : elements) {
                if (element instanceof Student) {
                    bw.write(((Student) element).toCSVRow());
                    bw.newLine();
                } else if (element instanceof Teacher) {
                    bw.write(((Teacher) element).toCSVRow());
                    bw.newLine();
                }
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public static <E> void writeToFile(E e, String path, boolean writeMode) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, writeMode))) {
            if (e instanceof Student) {
                bw.write(((Student) e).toCSVRow());
                bw.newLine();
            } else if (e instanceof Teacher) {
                bw.write(((Teacher) e).toCSVRow());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static <E> List<E> readFromFile(E e, String path) {
        List<E> elements = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (e instanceof Student) {
                    Student student = Student.fromCSVRow(line);
                    elements.add((E) student);
                } else if (e instanceof Teacher) {
                    Teacher teacher = Teacher.fromCSVRow(line);
                    elements.add((E) teacher);
                }
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
        return elements;
    }

    //                String[] data = line.split(",");
//                int id = Integer.parseInt(data[0]);
//                String name = data[1];
//                LocalDate birthDate = LocalDate.parse(data[2]);
//                String email = data[3];
//                String phoneNumber = data[4];
//                E element = null;
//                if (e instanceof Teacher) {
//                    String level = data[5];
//                    element = (E) new Teacher(id, name, birthDate, email, phoneNumber, level);
//                } else if (e instanceof Student) {
//                    String className = data[5];
//                    element = (E) new Student(id, name, birthDate, email, phoneNumber, className);
//                }
//
//                if (element != null) {
//                    elements.add(element);
//                }

//    public void writeToFile(List<T> items) {
//        List<String> lines = items.stream()
//                .map(converter::toCSVRow)
//                .collect(Collectors.toList());
//        try {
//            Files.write(Paths.get(filePath), lines);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void writeItemToFile(T item) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
//            writer.write(converter.toCSVRow(item));
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public interface CSVConvertible<T> {
        T fromCSVRow(String row);

        String toCSVRow(T item);
    }
}
