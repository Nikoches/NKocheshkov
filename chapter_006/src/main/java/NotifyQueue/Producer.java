package NotifyQueue;

public class Producer implements Runnable {
    private SimpleBlockingQueue queue;
    private int counter = 0;
    public Producer(SimpleBlockingQueue queue) {
            this.queue = queue;
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            queue.offer(counter);
            counter++;
            i++;
            System.out.println("Объект добавлен =" + counter);
        }
    }


}
