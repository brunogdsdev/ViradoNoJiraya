package concurrency.blocking_queue;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolMain {
    private static final ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(format)+ " beep");
        };

//        s.schedule(r, 5, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = s.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS); // o tempo é contado a partir do momento que está wake up
//        ScheduledFuture<?> scheduledFuture = s.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS); // o tempo é contínuo, contado até quando está dormindo

        s.schedule(() -> {
            System.out.println("Cancelando schedule");
            scheduledFuture.cancel(false);
            s.shutdown();
        }, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        beeper();
    }
}
