package threads;


class ThreadExample02 extends Thread{
    String c;

    public ThreadExample02(String c){
        this.c = c;
    }

    @Override
    public void run(){
        System.out.println();
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 1000; i++){
            System.out.print(this.c);
            if(i % 100 == 0){
                System.out.println();
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class RunnableExample02 implements Runnable{
    String c;

    public RunnableExample02(String c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 1000; i++){
            System.out.print(this.c);
            if(i % 100 == 0){
                System.out.println();
            }
        }
        Thread.yield();
    }
}

public class ThreadMain02 {
    public static void main(String[] args) throws InterruptedException {
//        // EXEMPLO 1
//        Thread t1 = new Thread(new Runnable(){
//            @Override
//            public void run(){
//
//            }
//        });
//
//        // EXEMPLO 2
//        new Thread(() -> {
//        }).start();
//
//        // EXEMPLO 3
//        Thread t2 = new Thread(() -> {
//        });
//
//        // EXEMPLO 4
//        Runnable run = () -> {
//        };
//        new Thread(run);


        Thread t1 = new Thread(new RunnableExample02("KA"));
        Thread t2 = new Thread(new RunnableExample02("ME"));

        t1.start();
        t1.join(); // faz a thread main aguradar a t1 terminar para só entao prosseguir na t2;
        t2.start();



    }
}
