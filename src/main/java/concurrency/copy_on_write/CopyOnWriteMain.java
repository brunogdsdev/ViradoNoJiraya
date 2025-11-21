package concurrency.copy_on_write;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteMain {
    public static void main(String[] args) {
        List<Integer> list =  new CopyOnWriteArrayList<>();
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }

        Runnable r1 = () -> {
            Iterator<Integer> iterator = list.iterator();
            try{
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Runnable r2 = () -> {
            for (int i = 0; i < 500; i++) {
                System.out.printf("%s removed %d%n", Thread.currentThread().getName(), i);
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
