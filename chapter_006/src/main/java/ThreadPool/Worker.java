package ThreadPool;

import NotifyQueue.SimpleBlockingQueue;

public class Worker extends Thread {
    private SimpleBlockingQueue<Runnable> queue;

    public Worker(SimpleBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Runnable task = queue.poll();
            if (task != null) {
                task.run();
            }
        }
    }
}
