package concurrency.reentrant_lock;


import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock){
        this.name = name;
        this.lock = lock;
    }


    @Override
    public void run() {
        lock.lock();
        try{
            lock.tryLock(2, TimeUnit.SECONDS);
            if(lock.isHeldByCurrentThread()){
                System.out.printf("%s PEGOU O LOCK %n", Thread.currentThread().getName());
            }

            System.out.printf(" %d threads esperando na fila %n ", lock.getQueueLength());
            System.out.printf("%s vai esperar dois segundos %n", Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.printf("%s finalizou a espera %n", Thread.currentThread().getName());


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

            if(lock.isHeldByCurrentThread()){
                lock.unlock(); // se tentar dar unlock em uma thread que nao está segurando lock, vai dar erro
            }
        }
    }
}


public class ReentrantLockMain {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("Thread1", lock)).start();
        new Thread(new Worker("Thread2", lock)).start();
        new Thread(new Worker("Thread3", lock)).start();
        new Thread(new Worker("Thread4", lock)).start();
        new Thread(new Worker("Thread5", lock)).start();
        new Thread(new Worker("Thread6", lock)).start();
        new Thread(new Worker("Thread7", lock)).start();
        new Thread(new Worker("Thread8", lock)).start();
        new Thread(new Worker("Thread9", lock)).start();
        new Thread(new Worker("Thread0", lock)).start();
    }
}
