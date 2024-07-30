package ss16_IOTextFile.thuc_hanh;

import java.io.File;

public class TestFileJava {
    public static void main(String[] args) {
        File file = new File("../../Books/a");

        System.out.println("Does it exits " + file.exists());
        System.out.println("The file has " + file.length() + " bytes");
        System.out.println("Can it be read " + file.canRead());
        System.out.println("Can it be write " + file.canWrite());
        System.out.println("Is it a directory " + file.isDirectory());
        System.out.println("Is it a file " + file.isFile());
        System.out.println("Is is absolute " + file.isAbsolute());
        System.out.println("Is it hidden " + file.isHidden());
        System.out.println("Absolute path is " + file.getAbsolutePath());
        System.out.println("Last modified time is " + new java.util.Date(file.lastModified()));

        File f = new File("foo.txt");
        File dir = new File("Books");
        dir.mkdir();
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i < dirContents.length; i++) {
                System.out.println(dirContents[i]);
            }
        }

        System.out.println(dir.getAbsolutePath());

    }
}
