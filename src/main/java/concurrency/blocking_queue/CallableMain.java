package concurrency.blocking_queue;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
//        Math.random(); // é syncronized, ou seja vai dar block na thread
        int count = ThreadLocalRandom.current().nextInt(1, 11);// nao é blocking

        for (int j = 0; j < count; j++) {
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        return String.format("%s finished %n", Thread.currentThread().getName(), count);
    }
}


public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable r = new RandomNumberCallable();
        ExecutorService e = Executors.newFixedThreadPool(2);

        Future<String> submit = e.submit(r);

        String s = submit.get();

        System.out.printf("TERMINANDO %s", s);
        e.shutdown();
    }
}
