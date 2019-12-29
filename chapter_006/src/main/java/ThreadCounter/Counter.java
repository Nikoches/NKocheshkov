package ThreadCounter;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Counter {
    @GuardedBy("this")
    private int value;

    public synchronized void  increment() {
        this.value++;
    }
    public int get() {
        return this.value;
    }

}
