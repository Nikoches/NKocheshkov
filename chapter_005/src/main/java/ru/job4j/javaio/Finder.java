package ru.job4j.javaio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Finder {
    public static void main(String[] args) {
        Finder ss =  new Finder(new ArgsFinder(args));
        ss.init();
    }
    private ArgsFinder arg;

    public Finder(ArgsFinder ar) {
        arg = ar;
    }

    public void init() {
        if (arg.gettype().equals("-f")) {
            findOnFullname();
        } else if (arg.gettype().equals("-m")) {
            findOnMask();
        }
    }

    private List<File> findOnMask() {
        File file = new File((arg.directory()));
        LinkedList<File> list1 = new LinkedList<>();
        LinkedList<File> list2 = new LinkedList<>();
        list1.add(file);
        while (!list1.isEmpty()) {
            File file1;
            file1 = list1.poll();
            if (file1.listFiles() != null) {
                list1.addAll(Arrays.asList(file1.listFiles()));
                for (File x : file1.listFiles()) {
                    if (x.isFile() && x.getName().contains(arg.getName())) {
                        list2.add(x);
                    }
                }
            }
        }
        writeResult(list2);
        return list2;
    }

    private File findOnFullname() {
        File file = new File((arg.directory()));
        File finded = null;
        LinkedList<File> list1 = new LinkedList<>();
        list1.add(file);
        while (!list1.isEmpty()) {
            File file1;
            file1 = list1.poll();
            if (file1.listFiles() != null) {
                list1.addAll(Arrays.asList(file1.listFiles()));
                for (File x : file1.listFiles()) {
                    if (x.isFile() && x.getName().equals(arg.getName())) {
                        finded = x;
                        break;
                    }
                }
            }
        }
        writeResult(finded);
        return finded;

    }

    private void writeResult(File file) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(arg.output()))) {
            out.println(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeResult(List<File> filelist) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(arg.output()))) {
            for (File x : filelist) {
                out.println(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
