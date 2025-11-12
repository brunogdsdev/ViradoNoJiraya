package concurrency.blocking_queue;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarReq = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return 5.70;
            }
        });

        System.out.println(doing());
        Double response = dollarReq.get(3, TimeUnit.SECONDS);
        System.out.println("Response -> "+ response);
        executorService.shutdown();
    }
    
    
    private static int doing(){
        System.out.println(Thread.currentThread().getName());

        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

        return sum;
    }
}
