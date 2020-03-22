package Bomberman;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Lock lock = new ReentrantLock();

    public boolean setlock(){
        return lock.tryLock();
    }
    public void unlock() {
        if(!lock.tryLock()){
            lock.unlock();
        }
    }
}
