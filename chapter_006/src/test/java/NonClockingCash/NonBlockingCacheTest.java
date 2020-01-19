package NonClockingCash;

import NonBlockingCash.Base;
import NonBlockingCash.NonBlockingcache;
import NonBlockingCash.OptimisticException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;

public class NonBlockingCacheTest {
    @Test
    public void whenThrowException() throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    throw new RuntimeException("Throw Exception in Thread");
                }
        );
        thread.start();
        thread.join();
    }

    @Test
    public void whenThrowException1() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }

    @Test
    public void testCache() throws InterruptedException {
        NonBlockingcache cc = new NonBlockingcache();

        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    cc.add(new Base(0, 1, "Name1"));
                    try{
                        cc.update(new Base(14, 4, "Name44"), 0);
                    }catch (OptimisticException e){
                        ex.set(e);
                    }
                    cc.update(new Base(14, 4, "Name44"), 0);

                }
        );
        thread.start();
        thread.join();
        System.out.println(ex.get().getMessage());
        Assert.assertThat(ex.get().getMessage(), is("Versions do not match."));
    }
}
