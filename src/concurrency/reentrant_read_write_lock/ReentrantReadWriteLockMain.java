package concurrency.reentrant_read_write_lock;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
    private final Map<String, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rwl;

    public MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value){
        rwl.writeLock().lock();
        try{
            if(rwl.isWriteLocked()){
                System.out.printf("%s obteve o WRITE LOCK %n", Thread.currentThread().getName());
            }

            Thread.sleep(500);
            map.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwl.writeLock().unlock();
        }
    }


    public Set<String> allKeys(){

        rwl.readLock().lock();
        try{
            return map.keySet();
        }finally {
            rwl.readLock().unlock();
        }
    }
}


public class ReentrantReadWriteLockMain {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        MapReadWrite map = new MapReadWrite(rwl);

        Runnable r = () -> {
            for (int i = 0; i < 20; i++) {
                map.put(String.valueOf(i), String.valueOf(i*10));

            }
        };

        Runnable r2 = () -> {
            if(rwl.isWriteLocked()){ //  se alguem escrevendo, ninguem pode ler
                System.out.println("WRITE LOCKED");
            }

            rwl.readLock().lock();
            System.out.println("READ LOCK LIBERADO");
            try{
                System.out.println(Thread.currentThread().getName()+ " => "+ map.allKeys());
            }finally {
                rwl.readLock().unlock();
            }
        };


        new Thread(r).start();
        new Thread(r2).start();

    }
}
