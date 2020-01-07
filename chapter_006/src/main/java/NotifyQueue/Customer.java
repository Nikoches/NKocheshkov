package NotifyQueue;

public class Customer implements Runnable{
    private SimpleBlockingQueue queue;

    public Customer(SimpleBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            int x = queue.poll();
            System.out.println("Объекты получен = "+x);
        }
    }
}
