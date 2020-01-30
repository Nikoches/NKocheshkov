package NotifyQueue;

public class Customer implements Runnable {
    private SimpleBlockingQueue queue;

    public Customer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Объекты получен = " + queue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
