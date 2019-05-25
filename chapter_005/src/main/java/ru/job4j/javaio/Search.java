package ru.job4j.javaio;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Search {
    public List<File> files(String parent, List<String> exts) {
        System.out.println(System.getProperty("java.io.tmpdir"));
        File file = new File(("C:\\Users\\User\\AppData\\Local\\Temp\\agent"));
        LinkedList<File> list1 = new LinkedList<>();
        LinkedList<File> list2 = new LinkedList<>();
        list1.add(file);
        while (!list1.isEmpty()) {
            File file1;
            file1 = list1.poll();
            if (file1.listFiles() != null) {
                list1.addAll(Arrays.asList(file1.listFiles()));
                for (File x : file1.listFiles()) {
                    if (x.isFile() && exts.contains(getFileExtension(x))) {
                        list2.add(x);
                    }
                }
            }
        }
        return list2;
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }
}
