package NotifyQueue;

public class Producer implements Runnable {
    private SimpleBlockingQueue queue;
    private int counter=0;
    public Producer(SimpleBlockingQueue queue) {
            this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            queue.offer(counter);
            counter++;
        }
    }


}
