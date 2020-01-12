package NotifyQueue;

import net.jcip.annotations.GuardedBy;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue {
    @GuardedBy("this")
    private Queue<Integer> queue = new LinkedList<>();
    private int size = 0;

    public synchronized void offer(Integer value) {
        while (size >= 3) {
            try {
                queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(value);
        size++;
        queue.notify();
    }

    public synchronized Integer poll() {
        while (size < 1) {
            try {
                queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size--;
        queue.notify();
        return queue.poll();
    }

    public int getsize() {
        return size;
    }

}
