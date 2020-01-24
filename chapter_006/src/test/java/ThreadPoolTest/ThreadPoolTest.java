package ThreadPoolTest;

import ThreadPool.ThreadPool;
import org.junit.jupiter.api.Test;

public class ThreadPoolTest {
    @Test
    public void test1() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(true);

        Thread main2 = new Thread(threadPool);
        main2.join();
        main2.start();
    }
}
