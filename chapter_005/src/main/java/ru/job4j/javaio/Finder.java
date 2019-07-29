package ru.job4j.javaio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class Finder {
    private ArgsFinder arg;
    private HashMap<String, Supplier<List<File>>> mymap;
    public Finder(ArgsFinder ar) {
        arg = ar;
        mymap.put("-f", this::findOnFullname);
        mymap.put("-m", this::findOnMask);
    }

    public static void main(String[] args) throws Exception {
        Finder ss = new Finder(new ArgsFinder(args));
        ss.init();
    }

    public void init() throws Exception {
       //writeResult(mymap.get(arg.gettype()).get());
    }

    private List<File> findOnMask() {
        File file = new File((arg.getKey("-d")));
        LinkedList<File> list1 = new LinkedList<>();
        LinkedList<File> list2 = new LinkedList<>();
        list1.add(file);
        while (!list1.isEmpty()) {
            File file1;
            file1 = list1.poll();
            if (file1.listFiles() != null) {
                list1.addAll(Arrays.asList(file1.listFiles()));
                for (File x : file1.listFiles()) {
                    if (x.isFile() && x.getName().contains(arg.getKey("-n"))) {
                        list2.add(x);
                    }
                }
            }
        }
        writeResult(list2);
        return list2;
    }

    private List<File> findOnFullname() {
        LinkedList<File> list2 = new LinkedList<>();
        File file = new File((arg.getKey("-d")));
        LinkedList<File> list1 = new LinkedList<>();
        list1.add(file);
        while (!list1.isEmpty()) {
            File file1;
            file1 = list1.poll();
            if (file1.listFiles() != null) {
                list1.addAll(Arrays.asList(file1.listFiles()));
                for (File x : file1.listFiles()) {
                    if (x.isFile() && x.getName().equals(arg.getKey("-n"))) {
                        list2.add(x);
                        break;
                    }
                }
            }
        }
        return list2;

    }

    private void writeResult(List<File> filelist) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(arg.getKey("-o")))) {
            for (File x : filelist) {
                out.println(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
