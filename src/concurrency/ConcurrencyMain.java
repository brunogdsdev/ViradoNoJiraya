package concurrency;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    private int count = 0;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock =  new ReentrantLock(true);


    void increment(){
        lock.lock();

        try{
            this.count++;
            atomicInteger.incrementAndGet();
        } finally {
            lock.unlock();
        }

    }



    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }


    public int getCount() {
        return count;
    }
}

public class ConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(r,"Thread1");
        Thread t2 = new Thread(r,"Thread1");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter.getAtomicInteger());
    }
}
