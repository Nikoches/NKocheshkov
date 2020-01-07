package NotifyQueue;

import net.jcip.annotations.GuardedBy;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleBlockingQueue {
    @GuardedBy("this")
    private Queue<Integer> queue = new LinkedList<>();
    private int size;

    public synchronized void offer(Integer value) {
        while (queue.size() >= 3) {
            try {
                queue.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(value);
        System.out.println("Объект добавлен =" + value);
        size++;
        queue.notify();
    }

    public synchronized Integer poll() {
        while (queue.size() < 1) {
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
