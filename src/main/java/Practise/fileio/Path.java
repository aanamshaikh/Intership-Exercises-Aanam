package Practise.fileio;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Path {
    public static void main(String[] args) throws IOException {
        //Absolute
        File absolute = new File("D:\\internship\\exercises\\Intership-Exercises-Aanam\\src\\main\\resources\\pathPrac.txt");
        System.out.println("Absolute Path :");
        System.out.println("get Path: "+absolute.getPath());
        System.out.println("get Name: "+absolute.getName());
        System.out.println("is Absolute: "+absolute.isAbsolute());
        System.out.println("get Absolute Path: "+absolute.getAbsolutePath());
        System.out.println("get Canonical path: "+absolute.getCanonicalPath());
        System.out.println("get Parent: "+absolute.getParent());
        System.out.println("get Parent file: "+absolute.getParentFile());
        System.out.println("can read: "+absolute.canRead());
        System.out.println("Last Modified: "+new Date(absolute.lastModified()));
//        absolute.renameTo(new File("D:\\internship\\exercises\\Intership-Exercises-Aanam\\src\\main\\resources\\changed"));

        //Relative
        File relative = new File("src/main/resources/test1.txt");
        System.out.println("Relative Path :");
        System.out.println(relative.getPath());
        System.out.println(relative.getName());
        System.out.println("can read: "+relative.canRead());

    }
}
