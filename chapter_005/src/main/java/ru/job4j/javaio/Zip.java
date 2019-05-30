package ru.job4j.javaio;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void main(String[] args) {
        Args arg = new Args(args);
        Zip zipper = new Zip();
        zipper.pack(zipper.seekBy(arg.exclude(), arg.directory()), new File(arg.output()));
    }

    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File x : sources) {
                zip.putNextEntry(new ZipEntry(x.getPath().substring(11)));
                System.out.println(x.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<File> seekBy(String ext, String directory) {
        File file = new File((directory));
        LinkedList<File> list1 = new LinkedList<>();
        LinkedList<File> list2 = new LinkedList<>();
        list1.add(file);
        while (!list1.isEmpty()) {
            File file1;
            file1 = list1.poll();
            if (file1.listFiles() != null) {
                list1.addAll(Arrays.asList(file1.listFiles()));
                for (File x : file1.listFiles()) {
                    if (!x.isFile() && ext.contains(getFileExtension(x))) {
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
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}

