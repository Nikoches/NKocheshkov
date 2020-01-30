package SimpleBlockingQueueTest;

import NotifyQueue.Customer;
import NotifyQueue.Producer;
import NotifyQueue.SimpleBlockingQueue;
import org.junit.Test;

public class Test1 {
    SimpleBlockingQueue<Integer> ss = new SimpleBlockingQueue();
    Thread cust = new Thread(new Customer(ss));
    Thread prod = new Thread(new Producer(ss));

    @Test
    public void test1() throws InterruptedException {
        prod.start();
        cust.start();
        prod.join();
        cust.join();
    }

    @Test
    public void test2() {
        String ss = "Username = %s, email = %s";
        System.out.println(String.format(ss,"vova","vova@eban.en"));

    }
}
