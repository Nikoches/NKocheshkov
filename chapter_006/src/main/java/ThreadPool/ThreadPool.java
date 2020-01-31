package ThreadPool;

import NotifyQueue.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool implements Runnable {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private int size;

    public ThreadPool(boolean t) {
        size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            threads.add(new Worker(tasks));
        }
    }

    public void work() {
        for (Thread x : threads) {
            x.start();
        }
    }

    public void shutdown() {
        for (Thread x : threads) {
            x.interrupt();
        }
    }

//    public void setTasks() {
//        SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(21);
//        int i = 0;
//        while (i < 20) {
//            int finalI = i;
//            tasks.offer(() -> System.out.println("work number =" + finalI + "done"));
//            i++;
//        }
//        this.tasks = tasks;
//    }

    @Override
    public void run() {
        work();
    }
}
