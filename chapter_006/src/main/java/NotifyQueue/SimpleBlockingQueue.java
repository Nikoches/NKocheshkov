package NotifyQueue;

import net.jcip.annotations.GuardedBy;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue<E> {
    @GuardedBy("this")
    private Queue<E> queue = new LinkedList<>();
    private int size;
    private int offset=3;
    public SimpleBlockingQueue(int offset) {
        this.offset = offset;
    }
    public SimpleBlockingQueue(){

    }
    public synchronized void offer(E value)  {
        while (size >= offset) {
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

    public synchronized E poll() throws InterruptedException {
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

    public synchronized int getsize() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }
}
