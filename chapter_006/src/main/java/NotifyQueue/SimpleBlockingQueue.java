package NotifyQueue;

import net.jcip.annotations.GuardedBy;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue<E> {
    @GuardedBy("this")
    private Queue<E> queue = new LinkedList<>();
    private int size = 0;

    public synchronized void offer(E value) {
        while (size >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(value);
        size++;
        notify();
    }

    public synchronized E poll() {
        while (size < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size--;
        notify();
        return queue.poll();
    }

    public int getsize() {
        return size;
    }

}
